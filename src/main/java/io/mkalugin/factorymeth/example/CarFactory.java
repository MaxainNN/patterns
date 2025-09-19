package io.mkalugin.factorymeth.example;

public class CarFactory extends MotorVehicleFactory {
    @Override
    protected MotorVehicle createMotorVehicle() {
        return new Car();
    }
}
