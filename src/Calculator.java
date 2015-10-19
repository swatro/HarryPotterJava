import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Calculator {

    private final Order order;

    public Calculator(Order order) {
        this.order = order;

    }

    public String calculateTotal() {
        BigDecimal totalCost = new BigDecimal(order.getNumberOBooksInOrder()).multiply(FakeDatabase.COST_OF_ONE_BOOK);
        totalCost = totalCost.subtract(calculateDiscount());

        return totalCost.setScale(2, RoundingMode.HALF_UP).toString();
    }

    private BigDecimal calculateDiscount() {
        List<Discount> discounts = order.getDiscounts();
        BigDecimal totalDiscount = BigDecimal.ZERO;

        for (Discount discount : discounts){
            BigDecimal totalCostForDiscountedItems = new BigDecimal(discount.getNumberOfBooks()).multiply(FakeDatabase.COST_OF_ONE_BOOK);
            BigDecimal discountPercent = new FakeDatabase().getDiscountForNumberOfUniqueBooks(discount.getNumberOfBooks());
            BigDecimal discountAmount = discountPercent.multiply(totalCostForDiscountedItems);
            totalDiscount = totalDiscount.add(discountAmount);
        }

        return totalDiscount;
    }


}
