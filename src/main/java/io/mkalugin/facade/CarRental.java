package io.mkalugin.facade;

/**
 * Подсистема для аренды автомобилей
 */
public class CarRental {

    /**
     * Бронирует автомобиль
     * @param city город аренды
     * @param startDate дата начала аренды
     * @param endDate дата окончания аренды
     * @param carType тип автомобиля
     * @return номер бронирования
     */
    public String book(String city, String startDate, String endDate, String carType) {
        System.out.println("🚗 Бронирование автомобиля " + carType + " в " + city + " с " + startDate + " по " + endDate);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        String bookingNumber = "CAR-" + System.currentTimeMillis();
        System.out.println("✅ Автомобиль забронирован. Номер: " + bookingNumber);
        return bookingNumber;
    }

    /**
     * Отменяет бронирование автомобиля
     * @param bookingNumber номер бронирования
     */
    public void cancel(String bookingNumber) {
        System.out.println("🚗 Отмена аренды автомобиля № " + bookingNumber);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("✅ Аренда автомобиля отменена");
    }
}
