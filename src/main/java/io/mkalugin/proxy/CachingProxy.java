package io.mkalugin.proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * Прокси-класс с кэшированием для HTTP-сервиса.
 * Перехватывает вызовы и возвращает данные из кэша при повторных запросах.
 */
public class CachingProxy implements HttpService{
    private final HttpService realService;
    private final Map<String, String> cache;

    /**
     * Конструктор прокси-сервиса
     * @param realService реальный HTTP-сервис для делегирования запросов
     */
    public CachingProxy(HttpService realService) {
        this.realService = realService;
        this.cache = new HashMap<>();
    }

    /**
     * Выполняет GET запрос с кэшированием результатов.
     * При первом запросе URL данные загружаются из реального сервиса и сохраняются в кэш.
     * При повторных запросах того же URL данные возвращаются из кэша мгновенно.
     *
     * @param url URL для запроса
     * @return тело ответа из кэша или из реального сервиса
     */
    @Override
    public String get(String url) {
        if (cache.containsKey(url)) {
            System.out.println("Возвращаем данные из кэша для: " + url);
            return cache.get(url);
        }

        String response = realService.get(url);

        cache.put(url, response);
        System.out.println("Данные сохранены в кэш для: " + url);

        return response;
    }
}
