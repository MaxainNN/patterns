package io.mkalugin.singleton;

public class Singleton {
    public static void main(String[] args) {
        ConnectionPool pool1 = ConnectionPool.get();
        ConnectionPool pool2 = ConnectionPool.get();
        ConnectionPool pool3 = ConnectionPool.get();

        System.out.println("Pool Instance Validation:");
        System.out.println("pool1 identityHashCode: " + System.identityHashCode(pool1));
        System.out.println("pool2 identityHashCode: " + System.identityHashCode(pool2));
        System.out.println("pool3 identityHashCode: " + System.identityHashCode(pool3));
        System.out.println("All instances are the same: " +
                (System.identityHashCode(pool1) == System.identityHashCode(pool2) &&
                        System.identityHashCode(pool2) == System.identityHashCode(pool3)));

        System.out.println("DAO Operations:");
        UserDao userDao = new UserDao();
        OrderDao orderDao = new OrderDao();
        userDao.getUser();
        System.out.println();
        orderDao.getOrder();
        System.out.println();
        orderDao.createOrder();
        System.out.println();

        System.out.println("Final Validation:");
        System.out.println("UserDao use pool ID: " + ConnectionPool.get().getInstanceId());
        System.out.println("OrderDao use pool ID: " + ConnectionPool.get().getInstanceId());
        System.out.println("Pool access ID: " + System.identityHashCode(ConnectionPool.get()));
    }
}
