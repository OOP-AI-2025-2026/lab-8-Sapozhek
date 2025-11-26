package ua.opnu;

public class MyOptional<T> {

    private T value;
    private boolean present;

    // Порожній конструктор
    public MyOptional() {
        this.present = false;
        this.value = null;
    }

    // Конструктор з value
    public MyOptional(T value) {
        if (value == null) {
            throw new IllegalArgumentException("MyOptional не приймає null");
        }
        this.value = value;
        this.present = true;
    }

    // Чи є значення
    public boolean isPresent() {
        return present;
    }

    // Чи пусто
    public boolean isEmpty() {
        return !present;
    }

    // Повернути значення або викинути помилку
    public T get() {
        if (!present) {
            throw new IllegalStateException("Значення відсутнє");
        }
        return value;
    }

    // Повернути значення або дефолт
    public T orElse(T defaultValue) {
        return present ? value : defaultValue;
    }

    @Override
    public String toString() {
        if (present) {
            return "MyOptional[value=" + value + "]";
        } else {
            return "MyOptional[empty]";
        }
    }
}
