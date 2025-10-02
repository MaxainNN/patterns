package io.mkalugin.builder;

public abstract class Builder<T extends Builder<T>> {
    private String cpu;
    private String gpu;

    private Integer ram;
    private Integer ssd;
    private Boolean liquidCooling = false;
    private Boolean rgbLighting = false;

    public T cpu(String cpu) {
        this.cpu = cpu;
        return self();
    }

    public T gpu(String gpu) {
        this.gpu = gpu;
        return self();
    }

    public T ram(Integer ram) {
        this.ram = ram;
        return self();
    }

    public T ssd(Integer ssd) {
        this.ssd = ssd;
        return self();
    }

    public T liquidCooling(Boolean liquidCooling) {
        this.liquidCooling = liquidCooling;
        return self();
    }

    public T rgbLighting(Boolean rgbLighting) {
        this.rgbLighting = rgbLighting;
        return self();
    }

    public abstract GamingPC build();

    protected abstract T self();
}
