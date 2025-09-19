package io.mkalugin.singleton;

public class UserDao {

    public void getUser(){
        ConnectionPool pool = ConnectionPool.get();
        String connection = pool.getConnection();
        System.out.println("UserDao with connection: " + connection);
        System.out.println("UserDao with instance id : " + pool.getInstanceId());
    }
}
