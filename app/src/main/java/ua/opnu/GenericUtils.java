package ua.opnu;

import java.util.Arrays;

public class GenericUtils {

    // ===============================
    // Узагальнений filter()
    // ===============================
    public static <T> T[] filter(T[] input, Predicate<T> p) {

        // Буфер, як у вимозі (через Object)
        T[] buffer = (T[]) new Object[input.length];

        int counter = 0;

        for (T element : input) {
            if (p.test(element)) {
                buffer[counter] = element;
                counter++;
            }
        }

        // Створюємо фінальний масив ТОГО Ж типу, що і вхідний
        @SuppressWarnings("unchecked")
        T[] result = (T[]) java.lang.reflect.Array.newInstance(
                input.getClass().getComponentType(),  // тип елементів, наприклад Integer.class
                counter                                // довжина результату
        );

        System.arraycopy(buffer, 0, result, 0, counter);
        return result;
    }

    // ===============================
    // Узагальнений contains()
    // ===============================
    public static <T extends Comparable<T>, V extends T> boolean contains(T[] array, V element) {

        for (T value : array) {
            if (value.compareTo(element) == 0) {
                return true;
            }
        }

        return false;
    }
}
