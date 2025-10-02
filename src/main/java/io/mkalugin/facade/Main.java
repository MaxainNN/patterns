package io.mkalugin.facade;

public class Main {
    public static void main(String[] args) {
        TravelFacade travelFacade = new TravelFacade();

        System.out.println("=== ПЛАНИРОВАНИЕ ПУТЕШЕСТВИЯ В ПАРИЖ ===");

        boolean success = travelFacade.planTrip(
                "Париж",
                "2025-09-23",
                "2025-09-29",
                "Средний класс"
        );

        if (success) {
            System.out.println("\n⏰ Проходит несколько дней...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            System.out.println("\n💼 Руководство не подтвердило отпуск в запрошенные даты!");
            travelFacade.cancelTrip("Отпуск не подтвержден руководством");
        }

        System.out.println("\n\n=== ПЛАНИРОВАНИЕ ПУТЕШЕСТВИЯ В РИМ ===");

        success = travelFacade.planTrip(
                "Рим",
                "2025-10-01",
                "2025-10-07",
                "Эконом класс"
        );

        if (success) {
            System.out.println("\n🎊 На этот раз отпуск подтвержден! Готовимся к поездке в Рим!");
        }
    }
}
