package singleton;

import io.mkalugin.singleton.ConnectionPool;
import org.junit.jupiter.api.*;

import java.lang.reflect.Constructor;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ConnectionPoolTest {

    @Test
    @Order(1)
    @DisplayName("Should return same instance on multiple calls")
    void shouldReturnSameInstance() {
        ConnectionPool instance1 = ConnectionPool.get();
        ConnectionPool instance2 = ConnectionPool.get();

        assertNotNull(instance1, "Instance should not be null");
        assertSame(instance1, instance2, "Instances should be the same");
    }

    @Test
    @Order(2)
    @DisplayName("Should return different connections on each call")
    void shouldReturnDifferentConnections() {
        ConnectionPool pool = ConnectionPool.get();
        String connection1 = pool.getConnection();
        String connection2 = pool.getConnection();

        assertNotNull(connection1, "Connection should not be null");
        assertNotEquals(connection1, connection2,
                "Connections should be different");
    }

    @Test
    @Order(3)
    @DisplayName("Constructor should be private")
    void constructorShouldBePrivate() {
        Constructor<?>[] constructors = ConnectionPool.class.getDeclaredConstructors();
        assertEquals(1, constructors.length,
                "Should have only one constructor");

        Constructor<?> constructor = constructors[0];
        assertFalse(constructor.canAccess(null),
                "Constructor should be private");
    }

    @Test
    @Order(4)
    @DisplayName("Should be thread-safe")
    void shouldBeThreadSafe() throws InterruptedException {
        int threads = 10;
        ExecutorService executor = Executors.newFixedThreadPool(threads);
        AtomicReference<ConnectionPool> firstInstance = new AtomicReference<>();
        CountDownLatch latch = new CountDownLatch(threads);

        for (int i = 0; i < threads; i++) {
            executor.submit(() -> {
                ConnectionPool instance = ConnectionPool.get();
                if (firstInstance.get() == null) {
                    firstInstance.set(instance);
                } else {
                    assertSame(firstInstance.get(), instance,
                            "All threads should get same instance");
                }
                latch.countDown();
            });
        }

        latch.await();
        executor.shutdown();
    }
}
