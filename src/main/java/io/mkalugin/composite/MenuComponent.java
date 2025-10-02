package io.mkalugin.composite;

/**
 * Интерфейс для компонентов меню.
 * Определяет метод print для отображения компонента с заданным отступом.
 */
public interface MenuComponent {

    /**
     * Выводит компонент меню с указанным отступом
     * @param indent отступ для форматирования вывода
     */
    void print(String indent);
}
