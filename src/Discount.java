
public class Discount {

    private final int numberOfBooks;

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public Discount(int numberOfUniqueBooks) {
        this.numberOfBooks = numberOfUniqueBooks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Discount discount = (Discount) o;

        return numberOfBooks == discount.numberOfBooks;

    }
}
