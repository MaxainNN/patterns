package io.mkalugin.bridge;

public class Blue implements Color{

    @Override
    public String apply(String shape) {
        return "Синий " + shape;
    }
}
