import java.math.BigDecimal;
import java.util.HashMap;

import static com.google.common.collect.Maps.newHashMap;

public class FakeDatabase {

    private static final BigDecimal DISCOUNT_FOR_TWO_BOOKS = new BigDecimal(.05);
    private static final BigDecimal DISCOUNT_FOR_THREE_BOOKS = new BigDecimal(.1);
    private static final BigDecimal DISCOUNT_FOR_FOUR_BOOKS = new BigDecimal(.2);
    private static final BigDecimal DISCOUNT_FOR_FIVE_BOOKS = new BigDecimal(.25);

    public static final BigDecimal COST_OF_ONE_BOOK = new BigDecimal(8);

    private static HashMap<Integer, BigDecimal> discountMap() {
        HashMap<Integer, BigDecimal> discountMap = newHashMap();
        discountMap.put(1, BigDecimal.ZERO);
        discountMap.put(2, DISCOUNT_FOR_TWO_BOOKS);
        discountMap.put(3, DISCOUNT_FOR_THREE_BOOKS);
        discountMap.put(4, DISCOUNT_FOR_FOUR_BOOKS);
        discountMap.put(5, DISCOUNT_FOR_FIVE_BOOKS);
        return discountMap;
    }

    public BigDecimal getDiscountForNumberOfUniqueBooks(int numberOfDifferentBooks) {
        return discountMap().get(numberOfDifferentBooks);
    }
}
