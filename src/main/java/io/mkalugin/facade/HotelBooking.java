package io.mkalugin.facade;

/**
 * Подсистема для бронирования отелей
 */
public class HotelBooking {

     /**
     * Бронирует отель
     * @param city город
     * @param checkInDate дата заезда
     * @param checkOutDate дата выезда
     * @return номер бронирования
     */
    public String book(String city, String checkInDate, String checkOutDate) {
        System.out.println("🏨 Бронирование отеля в " + city + " с " + checkInDate + " по " + checkOutDate);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        String bookingNumber = "HOTEL-" + System.currentTimeMillis();
        System.out.println("✅ Отель забронирован. Номер: " + bookingNumber);
        return bookingNumber;
    }

    /**
     * Отменяет бронирование отеля
     * @param bookingNumber номер бронирования
     */
    public void cancel(String bookingNumber) {
        System.out.println("🏨 Отмена брони отеля № " + bookingNumber);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("✅ Бронирование отеля отменено");
    }
}
