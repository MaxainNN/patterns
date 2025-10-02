package io.mkalugin.bridge;

/**
 * Конкретная абстракция - круг
 */
public class Circle extends Shape{
    private double radius;

    public Circle(Color color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public void draw() {
        String shapeDescription = "круг (радиус: " + radius + ")";
        String result = color.apply(shapeDescription);
        System.out.println("🎨 Рисуем: " + result);
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
