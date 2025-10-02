package io.mkalugin.proxy;

/**
 * Реальная реализация HTTP-сервиса, эмулирующая сетевые запросы.
 * Имитирует задержки сети с помощью Thread.sleep.
 */
public class RealHttpService implements HttpService{

    /**
     * Эмулирует выполнение HTTP GET запроса с задержкой 1 секунда.
     * @param url URL для запроса
     * @return строка с эмулированным содержимым страницы
     */
    @Override
    public String get(String url) {
        try {
            System.out.println("Выполнение реального HTTP запроса к: " + url);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Запрос был прерван", e);
        }

        return "Содержимое страницы " + url + " (загружено в: " + System.currentTimeMillis() + ")";
    }
}
