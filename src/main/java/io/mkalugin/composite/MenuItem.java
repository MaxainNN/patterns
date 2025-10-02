package io.mkalugin.composite;

/**
 * Класс, представляющий отдельный пункт меню (лист в композитной структуре).
 * Содержит название и цену пункта меню.
 */
public class MenuItem implements MenuComponent{

    private String name;
    private double price;

    /**
     * Конструктор пункта меню
     * @param name название пункта меню
     * @param price цена пункта меню
     */
    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Выводит пункт меню с отступом
     * @param indent отступ для форматирования
     */
    @Override
    public void print(String indent) {
        System.out.println(indent + "• " + name + " - $" + price);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
