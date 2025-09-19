package io.mkalugin.abstfactory.example;

public class SkyAnimal extends Animal {
    SkyAnimal(AnimalType type, AnimalEra era, String name) {
        super(type, era, name);
    }

    @Override
    void create() {
        System.out.println("Creating SkyAnimal");
    }
}
