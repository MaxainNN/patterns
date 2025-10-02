package io.mkalugin.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс, представляющий составное меню (композит в композитной структуре).
 * Содержит список других компонентов меню (как MenuItem, так и Menu).
 */
public class Menu implements MenuComponent{

    private String name;
    private List<MenuComponent> components;

    public Menu(String name) {
        this.name = name;
        this.components = new ArrayList<>();
    }

    /**
     * Добавляет компонент в меню
     * @param component компонент для добавления
     */
    public void add(MenuComponent component) {
        components.add(component);
    }

    /**
     * Удаляет компонент из меню
     * @param component компонент для удаления
     */
    public void remove(MenuComponent component) {
        components.remove(component);
    }

    /**
     * Возвращает список компонентов меню
     * @return список компонентов
     */
    public List<MenuComponent> getComponents() {
        return components;
    }

    /**
     * Выводит меню и все его подкомпоненты с отступами
     * @param indent отступ для форматирования
     */
    @Override
    public void print(String indent) {
        System.out.println(indent + "📁 " + name);
        for (MenuComponent component : components) {
            component.print(indent + "  ");
        }
    }

    /**
     * Подсчитывает общее количество пунктов в меню (рекурсивно)
     * @return общее количество пунктов меню
     */
    public int countItems() {
        int count = 0;
        for (MenuComponent component : components) {
            if (component instanceof MenuItem) {
                count++;
            } else if (component instanceof Menu) {
                count += ((Menu) component).countItems();
            }
        }
        return count;
    }
}
