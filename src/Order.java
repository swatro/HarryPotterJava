import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Sets.newHashSet;

public class Order  {
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int TWO = 2;

    private final List<Book> books;

    public Order(List<Book> books) {
        this.books = books;
    }

    public int getNumberOBooksInOrder() {
        return books.size();
    }

    private Set<Title> getSetOfUniqueBooks(List<Book> bookList){
        Set<Title> uniqueBookTitles = newHashSet();
        uniqueBookTitles.addAll(bookList.stream().map(Book::getTitle).collect(Collectors.toList()));
        return uniqueBookTitles;
    }

    public List<Discount> getDiscounts() {
        List<Book> tempBooks = newArrayList(books);
        List<Discount> discounts = newArrayList();

        while (!tempBooks.isEmpty()){
            Set<Title> setOfUniqueBooks = getSetOfUniqueBooks(tempBooks);
            discounts.add(new Discount(setOfUniqueBooks.size()));
            if (shouldOptimizeDiscounts(discounts, setOfUniqueBooks.size())){
                updateDiscountsToBeBetterForCustomer(discounts, setOfUniqueBooks.size());
            }
            for (Title title : setOfUniqueBooks){
                tempBooks.remove(new Book(title));
            }
        }

        return discounts;
    }

    private boolean shouldOptimizeDiscounts(List<Discount> discounts, int sizeOfMostRecentAddedDiscount) {
        return sizeOfMostRecentAddedDiscount < FOUR && discounts.contains(new Discount(FIVE));
    }

    private void updateDiscountsToBeBetterForCustomer(List<Discount> discounts, int sizeOfMostRecentAddedDiscount) {
        int newSizeForDiscount = Math.floorDiv(FIVE + sizeOfMostRecentAddedDiscount, TWO);
        discounts.remove(new Discount(FIVE));
        discounts.remove(new Discount(sizeOfMostRecentAddedDiscount));
        discounts.add(new Discount(newSizeForDiscount));
        discounts.add(new Discount(newSizeForDiscount));
    }
}
