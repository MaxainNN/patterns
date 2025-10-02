package io.mkalugin.bridge;

public class Main {
    public static void main(String[] args) {
        Color red = new Red();
        Color blue = new Blue();
        Color green = new Green();

        System.out.println("Комбинации: ");
        Shape redCircle = new Circle(red, 5.0);
        Shape blueSquare = new Square(blue, 4.0);
        Shape greenCircle = new Circle(green, 3.0);
        Shape redTriangle = new Triangle(red, 6.0, 4.0);
        redCircle.draw();
        blueSquare.draw();
        greenCircle.draw();
        redTriangle.draw();

        System.out.println("\nСмена цвета: ");
        Shape shape = new Circle(red, 7.0);
        shape.draw();
        shape.setColor(blue);
        shape.draw();
        shape.setColor(green);
        shape.draw();

        System.out.println("\nСвойства фигур: ");
        Circle circle = new Circle(red, 5.0);
        Square square = new Square(blue, 4.0);
        Triangle triangle = new Triangle(green, 6.0, 4.0);

        circle.draw();
        System.out.println("Площадь круга: " + circle.calculateArea());

        square.draw();
        System.out.println("Площадь квадрата: " + square.calculateArea());
        System.out.println("Периметр квадрата: " + square.calculatePerimeter());

        triangle.draw();
        System.out.println("Площадь треугольника: " + triangle.calculateArea());

        System.out.println("\nМассив фигур: ");

        Shape[] shapes = {
                new Circle(red, 2.0),
                new Square(blue, 3.0),
                new Triangle(green, 4.0, 3.0),
                new Circle(blue, 1.5),
                new Square(red, 2.5)
        };

        for (Shape s : shapes) {
            s.draw();
        }

        System.out.println("\nГибкость: ");

        Color purple = new Color() {
            @Override
            public String apply(String shape) {
                return " Фиолетовый " + shape;
            }
        };

        Shape purpleSquare = new Square(purple, 5.0);
        purpleSquare.draw();

        Color gold = new Color() {
            @Override
            public String apply(String shape) {
                return " Золотой " + shape;
            }
        };

        Shape goldCircle = new Circle(gold, 6.0);
        goldCircle.draw();
    }
}
