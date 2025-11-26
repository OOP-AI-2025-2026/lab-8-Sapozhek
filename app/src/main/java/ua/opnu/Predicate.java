package ua.opnu;

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T value);
}
