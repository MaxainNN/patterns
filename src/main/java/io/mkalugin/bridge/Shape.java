package io.mkalugin.bridge;

/**
 * Абстракция - фигура, содержащая ссылку на реализацию цвета
 */
public abstract class Shape {
    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    /**
     * Абстрактный метод для отрисовки фигуры
     */
    public abstract void draw();

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
