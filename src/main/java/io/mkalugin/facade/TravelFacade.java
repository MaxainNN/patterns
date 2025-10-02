package io.mkalugin.facade;

/**
 * Фасад для системы бронирования путешествий.
 * Предоставляет упрощенный интерфейс для сложной системы бронирования.
 */
public class TravelFacade {
    private FlightBooking flightBooking;
    private HotelBooking hotelBooking;
    private CarRental carRental;
    private String flightBookingNumber;
    private String hotelBookingNumber;
    private String carBookingNumber;

    public TravelFacade() {
        this.flightBooking = new FlightBooking();
        this.hotelBooking = new HotelBooking();
        this.carRental = new CarRental();
    }

    /**
     * Планирует полную поездку, бронируя все необходимые услуги
     * @param destination пункт назначения
     * @param travelDate дата путешествия
     * @param returnDate дата возвращения
     * @param carType тип автомобиля для аренды
     * @return true если все бронирования успешны
     */
    public boolean planTrip(String destination, String travelDate, String returnDate, String carType) {
        System.out.println("🎯 НАЧАЛО ПЛАНИРОВАНИЯ ПОЕЗДКИ В " + destination.toUpperCase());
        System.out.println("=========================================");

        try {
            flightBookingNumber = flightBooking.book(destination, travelDate);
            hotelBookingNumber = hotelBooking.book(destination, travelDate, returnDate);
            carBookingNumber = carRental.book(destination, travelDate, returnDate, carType);

            System.out.println("=========================================");
            System.out.println("🎉 ПОЕЗДКА УСПЕШНО ЗАПЛАНИРОВАНА!");
            System.out.println("📍 Направление: " + destination);
            System.out.println("📅 Даты: " + travelDate + " - " + returnDate);
            System.out.println("🚗 Автомобиль: " + carType);
            return true;
        } catch (Exception e) {
            System.out.println("❌ Ошибка при планировании поездки: " + e.getMessage());
            return false;
        }
    }

    /**
     * Отменяет всю запланированную поездку
     * @param reason причина отмены
     */
    public void cancelTrip(String reason) {
        System.out.println("\n⚠️  ОТМЕНА ПОЕЗДКИ");
        System.out.println("=========================================");
        System.out.println("📝 Причина: " + reason);
        System.out.println("=========================================");

        if (carBookingNumber != null) {
            carRental.cancel(carBookingNumber);
            carBookingNumber = null;
        }
        if (hotelBookingNumber != null) {
            hotelBooking.cancel(hotelBookingNumber);
            hotelBookingNumber = null;
        }
        if (flightBookingNumber != null) {
            flightBooking.cancel(flightBookingNumber);
            flightBookingNumber = null;
        }
        System.out.println("=========================================");
        System.out.println("✅ ВСЕ БРОНИРОВАНИЯ УСПЕШНО ОТМЕНЕНЫ");
    }
}
