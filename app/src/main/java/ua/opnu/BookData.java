package ua.opnu;

public class BookData implements Comparable<BookData> {

    private String title;
    private String author;
    private int reviews;
    private double total;

    public BookData(String title, String author, int reviews, double total) {
        this.title = title;
        this.author = author;
        this.reviews = reviews;
        this.total = total;
    }

    public double getRating() {
        if (reviews == 0) return 0.0;
        return total / reviews;
    }

    @Override
    public int compareTo(BookData other) {
        double r1 = this.getRating();
        double r2 = other.getRating();

        // Якщо рейтинг this вищий — тоді this має бути "меншим" (тобто стояти раніше)
        if (r1 > r2) {
            return -1; // this менший
        } else if (r1 < r2) {
            return 1; // this більший
        }

        // Якщо рейтинги рівні — порівнюємо за назвою
        return this.title.compareTo(other.title);
    }

    @Override
    public String toString() {
        return title + " (" + author + "), рейтинг: " + getRating();
    }
}
