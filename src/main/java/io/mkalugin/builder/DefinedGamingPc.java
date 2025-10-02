package io.mkalugin.builder;

/**
 * Конкретная реализация игрового компьютера.
 * Наследует абстрактный класс GamingPC и предоставляет конкретную реализацию
 * метода получения описания конфигурации.
 */
public class DefinedGamingPc extends GamingPC{

    /**
     * Защищенный конструктор, вызывающий конструктор родительского класса.
     *
     * @param builder построитель с настроенными параметрами
     */
    protected DefinedGamingPc(Builder<?> builder) {
        super(builder);
    }

    /**
     * Возвращает детальное описание конфигурации игрового ПК.
     * Форматирует информацию о всех компонентах в читаемом виде.
     *
     * @return строковое описание конфигурации ПК
     */
    @Override
    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append("Gaming PC Config:\n");
        sb.append("CPU: ").append(cpu).append("\n");
        sb.append("GPU: ").append(gpu).append("\n");
        sb.append("RAM: ").append(ram != null ? ram + " GB" : "not specified").append("\n");
        sb.append("SSD: ").append(ssd != null ? ssd + " GB" : "not specified").append("\n");
        sb.append("Liquid cooling: ").append(liquidCooling ? "yes" : "no").append("\n");
        sb.append("RGB lighting: ").append(rgbLighting ? "yes" : "no");
        return sb.toString();
    }

    /**
     * Конкретная реализация строителя для DefinedGamingPc.
     * Обеспечивает создание экземпляров DefinedGamingPc.
     */
    public static class DefinedBuilder extends Builder<DefinedBuilder> {

        /**
         * Создает объект DefinedGamingPc на основе текущей конфигурации строителя.
         * В реальном приложении здесь можно добавить валидацию обязательных полей.
         *
         * @return созданный объект DefinedGamingPc
         */
        @Override
        public GamingPC build() {
            return new DefinedGamingPc(this);
        }

        /**
         * Возвращает текущий экземпляр строителя.
         * Реализация метода self() для обеспечения type safety.
         *
         * @return текущий экземпляр DefinedBuilder
         */
        @Override
        protected DefinedBuilder self() {
            return this;
        }
    }

    /**
     * Статический фабричный метод для получения экземпляра строителя.
     * Упрощает создание строителя: DefinedGamingPc.builder()
     *
     * @return новый экземпляр DefinedBuilder
     */
    public static DefinedBuilder builder() {
        return new DefinedBuilder();
    }
}
