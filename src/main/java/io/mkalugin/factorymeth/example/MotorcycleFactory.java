package io.mkalugin.factorymeth.example;

public class MotorcycleFactory extends MotorVehicleFactory{
    @Override
    protected MotorVehicle createMotorVehicle() {
        return new  Motorcycle();
    }
}
