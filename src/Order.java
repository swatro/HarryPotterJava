import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Sets.newHashSet;

public class Order  {
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
            for (Title title : setOfUniqueBooks){
                tempBooks.remove(new Book(title));
            }
        }

        return discounts;
    }
}
