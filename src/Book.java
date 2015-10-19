
public class Book {
    private Title title;

    public Book(Title title) {
        this.title = title;
    }

    public Title getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return title == book.title;

    }
}
