package io.mkalugin.bridge;

/**
 * Интерфейс цвета - определяет цвет кисти
 */
public interface Color {

    /**
     * Применяет цвет к фигуре
     * @param shape название фигуры
     * @return строка с описанием окрашенной фигуры
     */
    String apply(String shape);
}
