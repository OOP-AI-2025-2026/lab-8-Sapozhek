package ua.opnu;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // ============================
        // Завдання 1: MyOptional<T>
        // ============================
        System.out.println("=== Завдання 1: MyOptional ===");

        // 1. Порожнє значення (немає по-батькові)
        MyOptional<String> middleName = new MyOptional<>();
        System.out.println(middleName); // MyOptional[empty]
        System.out.println("isPresent: " + middleName.isPresent()); // false
        System.out.println("isEmpty: " + middleName.isEmpty()); // true
        System.out.println("orElse: " + middleName.orElse("немає")); // "немає"

        // 2. Заповнене значення (логін користувача)
        MyOptional<String> username = new MyOptional<>("admin");
        System.out.println(username); // MyOptional[value=admin]
        System.out.println("isPresent: " + username.isPresent()); // true
        System.out.println("isEmpty: " + username.isEmpty()); // false
        System.out.println("get(): " + username.get()); // "admin"
        System.out.println("orElse: " + username.orElse("guest")); // "admin"

        // 3. Перевірка, що get() на порожньому об’єкті кидає IllegalStateException
        try {
            String test = middleName.get();
            System.out.println("unexpected: " + test);
        } catch (IllegalStateException ex) {
            System.out.println("Очікуваний виняток: " + ex.getMessage());
        }

        // 4. Перевірка, що конструктор не приймає null
        try {
            MyOptional<String> broken = new MyOptional<>(null);
            System.out.println("unexpected: " + broken);
        } catch (IllegalArgumentException ex) {
            System.out.println("Правильно не дозволив null: " + ex.getMessage());
        }

        System.out.println();


        // ============================
        // Завдання 2: BookData + Comparable
        // ============================
        System.out.println("=== Завдання 2: BookData і Comparable ===");

        // Припустимо, що рейтинг = total / reviews
        // Наприклад: 450 / 100 = 4.5; 380 / 80 = 4.75; 200 / 50 = 4.0
        BookData book1 = new BookData("Clean Code", "Robert C. Martin", 100, 450.0);   // 4.5
        BookData book2 = new BookData("Effective Java", "Joshua Bloch", 80, 380.0);    // 4.75
        BookData book3 = new BookData("Java Puzzlers", "Joshua Bloch", 50, 200.0);     // 4.0

        BookData[] books = {book1, book2, book3};

        System.out.println("До сортування:");
        for (BookData b : books) {
            System.out.println(b);
        }

        Arrays.sort(books); // має використати compareTo()

        System.out.println("\nПісля сортування (від найвищого рейтингу до нижчого):");
        for (BookData b : books) {
            System.out.println(b);
        }

        System.out.println();


        // ============================
        // Завдання 3: Printer.printArray()
        // ============================
        System.out.println("=== Завдання 3: Printer.printArray() ===");

        Printer myPrinter = new Printer();
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};

        System.out.println("Масив цілих:");
        myPrinter.printArray(intArray);

        System.out.println("Масив рядків:");
        myPrinter.printArray(stringArray);

        System.out.println();


        // ============================
        // Завдання 4: Узагальнений filter()
        // ============================
        System.out.println("=== Завдання 4: Generic filter() ===");

        Integer[] numbers = {1, 2, 3, 4, 5, 6};
        // фільтруємо лише парні числа
        Integer[] evenNumbers = GenericUtils.filter(numbers, n -> n % 2 == 0);

        System.out.println("Початковий масив: " + Arrays.toString(numbers));
        System.out.println("Парні елементи: " + Arrays.toString(evenNumbers));

        String[] words = {"cat", "dog", "elephant", "ant"};
        // фільтруємо слова довжиною більше 3 символів
        String[] longWords = GenericUtils.filter(words, w -> w.length() > 3);

        System.out.println("Початковий масив слів: " + Arrays.toString(words));
        System.out.println("Слова довші за 3 символи: " + Arrays.toString(longWords));

        System.out.println();


        // ============================
        // Завдання 5: Узагальнений contains()
        // ============================
        System.out.println("=== Завдання 5: Generic contains() ===");

        String[] animals = {"cat", "dog", "bird"};
        boolean hasCat = GenericUtils.contains(animals, "cat");
        boolean hasCow = GenericUtils.contains(animals, "cow");

        System.out.println("Масив тварин: " + Arrays.toString(animals));
        System.out.println("Містить 'cat': " + hasCat);
        System.out.println("Містить 'cow': " + hasCow);

        Integer[] nums = {10, 20, 30, 40};
        boolean has20 = GenericUtils.contains(nums, 20);
        boolean has25 = GenericUtils.contains(nums, 25);

        System.out.println("Масив чисел: " + Arrays.toString(nums));
        System.out.println("Містить 20: " + has20);
        System.out.println("Містить 25: " + has25);

        System.out.println();


        // ============================
        // Завдання 6: GenericTwoTuple та GenericThreeTuple
        // ============================
        System.out.println("=== Завдання 6: Кортежі (tuples) ===");

        // Приклад з GenericTwoTuple
        GenericTwoTuple<String, Integer> userAge =
                new GenericTwoTuple<>("Іра", 19);
        System.out.println("GenericTwoTuple: " + userAge);

        // Приклад з GenericThreeTuple (використовує GenericTwoTuple всередині)
        GenericThreeTuple<String, String, Integer> bookInfo =
                new GenericThreeTuple<>("Гаррі Поттер", "Джоан Роулінг", 500);
        System.out.println("GenericThreeTuple: " + bookInfo);

        // Демонстрація доступу до елементів через гетери
        System.out.println("Назва книги: " + bookInfo.getFirst());
        System.out.println("Автор: " + bookInfo.getSecond());
        System.out.println("Кількість сторінок: " + bookInfo.three);

        System.out.println("\n=== Кінець демонстрації лабораторної 8 ===");
    }
}
