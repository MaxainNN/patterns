package io.mkalugin.bridge;

public class Green implements Color{
    @Override
    public String apply(String shape) {
        return "Зеленый " + shape;
    }
}
