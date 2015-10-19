import org.junit.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class OrderTest {

    @Test
    public void shouldHaveOneDiscount() throws Exception {
        Order order = new Order(newArrayList(new Book(Title.BOOK_ONE), new Book(Title.BOOK_TWO)));

        assertThat(order.getDiscounts().get(0).getNumberOfBooks(), is(2));
    }

    @Test
    public void shouldHaveTwoDiscounts() throws Exception {
        Order order = new Order(newArrayList(new Book(Title.Book_FIVE),
                                             new Book(Title.BOOK_FOUR),
                                             new Book(Title.Book_FIVE),
                                             new Book(Title.BOOK_FOUR),
                                              new Book(Title.BOOK_TWO)));

        assertThat(order.getDiscounts().size(), is(2));
    }
}