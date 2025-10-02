package io.mkalugin.composite;

public class Main {
    public static void main(String[] args) {
        Menu fileMenu = new Menu("File");
        fileMenu.add(new MenuItem("New", 0.0));
        fileMenu.add(new MenuItem("Open", 0.0));
        fileMenu.add(new MenuItem("Exit", 0.0));

        Menu editMenu = new Menu("Edit");
        editMenu.add(new MenuItem("Copy", 0.0));
        editMenu.add(new MenuItem("Paste", 0.0));

        Menu mainMenu = new Menu("Main Menu");
        mainMenu.add(fileMenu);
        mainMenu.add(editMenu);

        System.out.println("=== СТРУКТУРА МЕНЮ ===");
        mainMenu.print("");

        int totalItems = mainMenu.countItems();
        System.out.println("\n=== СТАТИСТИКА ===");
        System.out.println("Общее количество пунктов меню: " + totalItems);

        System.out.println("\n=== ДЕТАЛЬНАЯ СТАТИСТИКА ===");
        System.out.println("Пунктов в меню 'File': " + fileMenu.countItems());
        System.out.println("Пунктов в меню 'Edit': " + editMenu.countItems());

        System.out.println("\n=== РАСШИРЕННАЯ СТРУКТУРА ===");
        Menu advancedEditMenu = new Menu("Edit");
        advancedEditMenu.add(new MenuItem("Copy", 0.0));
        advancedEditMenu.add(new MenuItem("Paste", 0.0));

        Menu findMenu = new Menu("Find");
        findMenu.add(new MenuItem("Find...", 0.0));
        findMenu.add(new MenuItem("Replace...", 0.0));
        advancedEditMenu.add(findMenu);

        Menu advancedMainMenu = new Menu("Advanced Main Menu");
        advancedMainMenu.add(fileMenu);
        advancedMainMenu.add(advancedEditMenu);

        advancedMainMenu.print("");
        System.out.println("\nОбщее количество пунктов в расширенном меню: " + advancedMainMenu.countItems());
    }
}
