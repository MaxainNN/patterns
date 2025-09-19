package io.mkalugin.singleton;

public class OrderDao {

    public void getOrder(){
        ConnectionPool pool = ConnectionPool.get();
        String connection = pool.getConnection();
        System.out.println("OrderDao with connection: " + connection);
        System.out.println("OrderDao instance id : " + pool.getInstanceId());
    }

    public void createOrder(){
        ConnectionPool pool = ConnectionPool.get();
        String connection = pool.getConnection();
        System.out.println("OrderDao with connection: " + connection);
        System.out.println("OrderDao instance id: " + pool.getInstanceId());
    }
}
