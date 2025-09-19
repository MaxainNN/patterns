package io.mkalugin.factorymeth.example;

public class Car implements MotorVehicle{
    @Override
    public void build() {
        System.out.println("Build Car.");
    }
}
