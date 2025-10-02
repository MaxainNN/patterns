package io.mkalugin.bridge;

public class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(Color color, double base, double height) {
        super(color);
        this.base = base;
        this.height = height;
    }

    @Override
    public void draw() {
        String shapeDescription = "треугольник (основание: " + base + ", высота: " + height + ")";
        String result = color.apply(shapeDescription);
        System.out.println("🎨 Рисуем: " + result);
    }

    /**
     * Вычисляет площадь треугольника
     * @return площадь треугольника
     */
    public double calculateArea() {
        return 0.5 * base * height;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
