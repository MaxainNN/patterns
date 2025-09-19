package io.mkalugin.abstfactory.example;

public abstract class Animal {
    AnimalType type;
    AnimalEra era;
    String name;

    Animal(AnimalType type, AnimalEra era, String name) {
        this.type = type;
        this.era = era;
        this.name = name;
    }

    abstract void create();
}
