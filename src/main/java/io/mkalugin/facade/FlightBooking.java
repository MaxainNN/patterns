package io.mkalugin.facade;

/**
 * Подсистема для бронирования авиабилетов
 */
public class FlightBooking {

    /**
     * Бронирует авиабилет
     * @param destination пункт назначения
     * @param date дата вылета
     * @return номер бронирования
     */
    public String book(String destination, String date) {
        System.out.println("🛫 Бронирование авиабилета в " + destination + " на " + date);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        String bookingNumber = "FLIGHT-" + System.currentTimeMillis();
        System.out.println("✅ Авиабилет забронирован. Номер: " + bookingNumber);
        return bookingNumber;
    }

    /**
     * Отменяет бронирование авиабилета
     * @param bookingNumber номер бронирования
     */
    public void cancel(String bookingNumber) {
        System.out.println("🛫 Отмена авиабилета № " + bookingNumber);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("✅ Бронирование авиабилета отменено");
    }
}
