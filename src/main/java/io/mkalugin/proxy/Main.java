package io.mkalugin.proxy;

public class Main {
    public static void main(String[] args) {
        HttpService realService = new RealHttpService();
        HttpService cachingService = new CachingProxy(realService);

        System.out.println("Первый вызов \"https://example.com\"");
        long startTime1 = System.currentTimeMillis();
        String response1 = cachingService.get("https://example.com");
        long endTime1 = System.currentTimeMillis();
        System.out.println("Ответ: " + response1);
        System.out.println("Время выполнения: " + (endTime1 - startTime1) + " мс");

        System.out.println("\nВторой вызов \"https://example.com\"");
        long startTime2 = System.currentTimeMillis();
        String response2 = cachingService.get("https://example.com");
        long endTime2 = System.currentTimeMillis();
        System.out.println("Ответ: " + response2);
        System.out.println("Время выполнения: " + (endTime2 - startTime2) + " мс");
    }
}
