package io.mkalugin.proxy;

/**
 * Интерфейс для HTTP-сервиса, предоставляющий метод для выполнения GET-запросов.
 */
public interface HttpService {

    /**
     * Выполняет HTTP GET запрос по указанному URL
     * @param url URL для запроса
     * @return тело ответа в виде строки
     */
    String get(String url);
}
