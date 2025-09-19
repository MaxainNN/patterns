package singleton;

import io.mkalugin.singleton.ConnectionPool;
import org.junit.jupiter.api.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ConnectionPoolTest {

    @AfterEach
    void setUp() {
        resetSingleton();
    }

    private void resetSingleton() {
        try {
            Field instanceField = ConnectionPool.class.getDeclaredField("INSTANCE");
            instanceField.setAccessible(true);

            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(instanceField, instanceField.getModifiers() & ~Modifier.FINAL);

            instanceField.set(null, null);
        } catch (Exception e) {
            throw new RuntimeException("Failed to reset singleton", e);
        }
    }

    @Test
    @Order(1)
    @DisplayName("Should return same instance on multiple calls")
    void shouldReturnSameInstance() {
        ConnectionPool instance1 = ConnectionPool.get();
        ConnectionPool instance2 = ConnectionPool.get();
        ConnectionPool instance3 = ConnectionPool.get();

        assertNotNull(instance1, "Instance should not be null");
        assertSame(instance1, instance2, "Instances should be the same");
        assertSame(instance2, instance3, "Instances should be the same");
        assertSame(instance1, instance3, "Instances should be the same");
    }

    @Test
    @Order(2)
    @DisplayName("Should have same identity hash code for all instances")
    void shouldHaveSameIdentityHashCode() {
        ConnectionPool instance1 = ConnectionPool.get();
        ConnectionPool instance2 = ConnectionPool.get();
        ConnectionPool instance3 = ConnectionPool.get();

        int hash1 = System.identityHashCode(instance1);
        int hash2 = System.identityHashCode(instance2);
        int hash3 = System.identityHashCode(instance3);

        assertEquals(hash1, hash2, "Hash codes should be equal");
        assertEquals(hash2, hash3, "Hash codes should be equal");
        assertEquals(hash1, hash3, "Hash codes should be equal");
    }

    @Test
    @Order(3)
    @DisplayName("Should return different connections on each call")
    void shouldReturnDifferentConnections() {
        ConnectionPool pool = ConnectionPool.get();

        String connection1 = pool.getConnection();
        String connection2 = pool.getConnection();
        String connection3 = pool.getConnection();

        assertNotNull(connection1, "Connection should not be null");
        assertNotNull(connection2, "Connection should not be null");
        assertNotNull(connection3, "Connection should not be null");

        assertNotEquals(connection1, connection2, "Connections should be different");
        assertNotEquals(connection2, connection3, "Connections should be different");
        assertNotEquals(connection1, connection3, "Connections should be different");

        assertTrue(connection1.startsWith("conn-"), "Connection should start with 'conn-'");
        assertTrue(connection2.startsWith("conn-"), "Connection should start with 'conn-'");
        assertTrue(connection3.startsWith("conn-"), "Connection should start with 'conn-'");
    }

    @Test
    @Order(4)
    @DisplayName("Should have valid UUID in connection string")
    void shouldHaveValidUUIDInConnection() {
        ConnectionPool pool = ConnectionPool.get();

        String connection = pool.getConnection();
        String uuidPart = connection.substring(5); // Remove "conn-" prefix

        assertDoesNotThrow(() -> {
            UUID uuid = UUID.fromString(uuidPart);
            assertNotNull(uuid, "UUID should be valid");
        }, "Connection should contain valid UUID");
    }

    @Test
    @Order(5)
    @DisplayName("Constructor should be private and prevent instantiation")
    void constructorShouldBePrivate() {
        Constructor<?>[] constructors = ConnectionPool.class.getDeclaredConstructors();

        assertEquals(1, constructors.length, "Should have only one constructor");

        Constructor<?> constructor = constructors[0];
        assertFalse(constructor.isAccessible(), "Constructor should not be accessible");

        constructor.setAccessible(true);
        assertThrows(InvocationTargetException.class, () -> {
            constructor.newInstance();
        }, "Should not be able to create instance via reflection");
    }

    @Test
    @Order(6)
    @DisplayName("Should be thread-safe in multithreaded environment")
    void shouldBeThreadSafe() throws InterruptedException{
        int numberOfThreads = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        Set<ConnectionPool> instances = ConcurrentHashMap.newKeySet();
        Set<Integer> hashCodes = ConcurrentHashMap.newKeySet();

        List<Callable<Void>> tasks = new ArrayList<>();
        for (int i = 0; i < numberOfThreads; i++) {
            tasks.add(() -> {
                ConnectionPool instance = ConnectionPool.get();
                instances.add(instance);
                hashCodes.add(System.identityHashCode(instance));
                return null;
            });
        }

        executorService.invokeAll(tasks);
        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.SECONDS);

        assertEquals(1, instances.size(), "Should have only one instance across all threads");
        assertEquals(1, hashCodes.size(), "Should have only one hash code across all threads");
    }
}
