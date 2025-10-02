package io.mkalugin.bridge;

/**
 * Конкретная абстракция - квадрат
 */
public class Square extends Shape{
    private double side;

    public Square(Color color, double side) {
        super(color);
        this.side = side;
    }

    @Override
    public void draw() {
        String shapeDescription = "квадрат (сторона: " + side + ")";
        String result = color.apply(shapeDescription);
        System.out.println("🎨 Рисуем: " + result);
    }

    /**
     * Вычисляет площадь квадрата
     * @return площадь квадрата
     */
    public double calculateArea() {
        return side * side;
    }

    /**
     * Вычисляет периметр квадрата
     * @return периметр квадрата
     */
    public double calculatePerimeter() {
        return 4 * side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
}
