package io.mkalugin.builder;

/**
 * Абстрактный класс, представляющий игровой компьютер.
 * Класс является неизменяемым (immutable) - все поля объявлены как final.
 * Содержит основные компоненты игрового ПК: процессор, видеокарту, оперативную память,
 * SSD, информацию о жидкостном охлаждении и RGB-подсветке.
 */
public abstract class GamingPC {
    protected final String cpu;
    protected final String gpu;
    protected final Integer ram;
    protected final Integer ssd;
    protected final Boolean liquidCooling;
    protected final Boolean rgbLighting;

    /**
     * Защищенный конструктор для инициализации полей из Builder'а.
     * Используется шаблон "Parameter Object" через Builder.
     *
     * @param builder билдер объекта, содержащий все необходимые параметры
     */
    protected GamingPC(Builder<?> builder) {
        this.cpu = builder.cpu;
        this.gpu = builder.gpu;
        this.ram = builder.ram;
        this.ssd = builder.ssd;
        this.liquidCooling = builder.liquidCooling;
        this.rgbLighting = builder.rgbLighting;
    }

    /**
     * Абстрактный метод для получения описания конфигурации ПК.
     * Каждая конкретная реализация может форматировать описание по-своему.
     *
     * @return строковое описание конфигурации игрового ПК
     */
    public abstract String getDescription();

    /**
     * Абстрактный строитель (Builder) для создания объектов GamingPC.
     * Реализует шаблон "Строитель" с fluent interface.
     * Использует рекурсивные дженерики для обеспечения type safety.
     *
     * @param <T> конкретный тип строителя (self-type)
     */
    public abstract static class Builder<T extends Builder<T>> {
        private String cpu;
        private String gpu;

        private Integer ram;
        private Integer ssd;
        private Boolean liquidCooling = false;
        private Boolean rgbLighting = false;

        public T cpu(String cpu) {
            this.cpu = cpu;
            return self();
        }

        public T gpu(String gpu) {
            this.gpu = gpu;
            return self();
        }

        public T ram(Integer ram) {
            this.ram = ram;
            return self();
        }

        public T ssd(Integer ssd) {
            this.ssd = ssd;
            return self();
        }

        public T liquidCooling(Boolean liquidCooling) {
            this.liquidCooling = liquidCooling;
            return self();
        }

        public T rgbLighting(Boolean rgbLighting) {
            this.rgbLighting = rgbLighting;
            return self();
        }

        /**
         * Создает и возвращает объект GamingPC на основе текущей конфигурации.
         * Должен быть реализован в конкретных строителях.
         *
         * @return созданный объект GamingPC
         * @throws IllegalStateException если не установлены обязательные параметры
         */
        public abstract GamingPC build();

        /**
         * Возвращает текущий экземпляр строителя.
         * Используется для обеспечения type safety в цепочках вызовов.
         *
         * @return текущий экземпляр строителя
         */
        protected abstract T self();
    }
}
