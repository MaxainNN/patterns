package io.mkalugin.singleton;

import java.util.UUID;

public class ConnectionPool {

    private ConnectionPool() {
        System.out.println("Init ConnectionPool with id = " + System.identityHashCode(this));
    }

    private static class Holder {
        private static ConnectionPool INSTANCE = new ConnectionPool();
    }

    public static ConnectionPool get() {
        return Holder.INSTANCE;
    }

    public static String getConnection() {
        return "conn-" + UUID.randomUUID().toString();
    }

    public int getInstanceId() {
        return System.identityHashCode(this);
    }
}
