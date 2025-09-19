package io.mkalugin.factorymeth.example;

public class FutureVehicleElectricCar implements ElectricVehicle {
    @Override
    public void build() {
        System.out.println("Future vehicle electric car");
    }
}
