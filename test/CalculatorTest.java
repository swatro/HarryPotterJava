import org.junit.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CalculatorTest {

    @Test
    public void shouldCostEightEurosForABook() throws Exception {
        Calculator calculator = new Calculator(new Order(newArrayList(new Book(Title.BOOK_ONE))));

        String eightEuros = "9.00";
        assertThat(calculator.calculateTotal(), is(eightEuros));
    }

    @Test
    public void shouldCostSixteenEurosForTwoOfTheSameBook() throws Exception {
        List<Book> books = newArrayList(new Book(Title.BOOK_ONE), new Book(Title.BOOK_ONE));
        Calculator calculator = new Calculator(new Order(books));

        String sixteenEuros = "16.00";
        assertThat(calculator.calculateTotal(), is(sixteenEuros));

    }

    @Test
    public void shouldGetFivePercentDiscountOnBuyingTwoDifferentBooks() throws Exception {
        List<Book> books = newArrayList(new Book(Title.BOOK_ONE), new Book(Title.BOOK_TWO));
        Calculator calculator = new Calculator(new Order(books));

        String discountedPrice = "15.20";
        assertThat(calculator.calculateTotal(), is(discountedPrice));

    }

    @Test
    public void shouldGiveTenPercentDiscountForBuyingThreeDifferentBooks() throws Exception {
        List<Book> books = newArrayList(new Book(Title.BOOK_ONE),
                                        new Book(Title.BOOK_TWO),
                                        new Book(Title.BOOK_THREE));
        Calculator calculator = new Calculator(new Order(books));

        String discountedPrice = "21.60";
        assertThat(calculator.calculateTotal(), is(discountedPrice));
    }

    @Test
    public void shouldGiveATwentyPercentDiscountForBuyingFourDifferentBooks() throws Exception {
        List<Book> books = newArrayList(new Book(Title.BOOK_ONE),
                new Book(Title.BOOK_TWO),
                new Book(Title.BOOK_THREE),
                new Book(Title.BOOK_FOUR));
        Calculator calculator = new Calculator(new Order(books));

        String discountedPrice = "25.60";
        assertThat(calculator.calculateTotal(), is(discountedPrice));
    }

    @Test
    public void shouldGiveATwentyFivePercentDiscountForBuyingAllFiveBooks() throws Exception {
        List<Book> books = newArrayList(new Book(Title.BOOK_ONE),
                new Book(Title.BOOK_TWO),
                new Book(Title.BOOK_THREE),
                new Book(Title.BOOK_FOUR),
                new Book(Title.Book_FIVE));
        Calculator calculator = new Calculator(new Order(books));

        String discountedPrice = "30.00";
        assertThat(calculator.calculateTotal(), is(discountedPrice));
    }

    @Test
    public void shouldOnlyGiveDiscountsOnBooksThatFormASet() throws Exception {
        List<Book> books = newArrayList(new Book(Title.BOOK_ONE),
                new Book(Title.BOOK_TWO),
                new Book(Title.BOOK_ONE));
        Calculator calculator = new Calculator(new Order(books));

        String discountedPrice = "23.20";
        assertThat(calculator.calculateTotal(), is(discountedPrice));
    }

    @Test
    public void shouldGiveTwoDifferentDiscountsWhenThereAreMultipleSetsOfBooks() throws Exception {
        List<Book> books = newArrayList(new Book(Title.BOOK_ONE),
                new Book(Title.BOOK_TWO),
                new Book(Title.BOOK_ONE),
                new Book(Title.BOOK_TWO),
                new Book(Title.BOOK_THREE));
        Calculator calculator = new Calculator(new Order(books));

        String discountedPrice = "36.80";
        assertThat(calculator.calculateTotal(), is(discountedPrice));
    }

    @Test
    public void sampleTest() throws Exception {
        List<Book> books = newArrayList(new Book(Title.BOOK_ONE),
                new Book(Title.BOOK_ONE),
                new Book(Title.BOOK_TWO),
                new Book(Title.BOOK_TWO),
                new Book(Title.BOOK_THREE),
                new Book(Title.BOOK_THREE),
                new Book(Title.BOOK_FOUR),
                new Book(Title.Book_FIVE));
        Calculator calculator = new Calculator(new Order(books));

        String discountedPrice = "51.20";
        assertThat(calculator.calculateTotal(), is(discountedPrice));
    }

    @Test
    public void shouldOptimizeOrderForThreeDiscounts() throws Exception {
        List<Book> books = newArrayList(
                new Book(Title.BOOK_ONE),
                new Book(Title.BOOK_ONE),
                new Book(Title.BOOK_ONE),
                new Book(Title.BOOK_TWO),
                new Book(Title.BOOK_TWO),
                new Book(Title.BOOK_THREE),
                new Book(Title.BOOK_THREE),
                new Book(Title.BOOK_FOUR),
                new Book(Title.BOOK_FOUR),
                new Book(Title.Book_FIVE));
        Calculator calculator = new Calculator(new Order(books));

        String discountedPrice = "68.80";
        assertThat(calculator.calculateTotal(), is(discountedPrice));

    }
}
