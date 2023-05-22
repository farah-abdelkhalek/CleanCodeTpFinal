package Billing;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class ReceiptGenerator {

    public static Receipt generateReceipt(List<Products> productList) {
        double totalTax = calculateTotalTax(productList);
        double totalPriceWithTax = calculateTotalPriceWithTax(productList, totalTax);

        totalTax = roundTaxAmount(totalTax);

        return new Receipt(productList, totalTax, totalPriceWithTax);
    }

    private static double calculateTotalTax(List<Products> productList) {
        double totalTax = 0;

        for (Products product : productList) {
            double taxAmount = product.getTaxAmount();
            totalTax += taxAmount;
        }

        return totalTax;
    }

    private static double calculateTotalPriceWithTax(List<Products> productList, double totalTax) {
        double totalPriceWithTax = 0;

        for (Products product : productList) {
            double price = product.getPrice();
            totalPriceWithTax += price;
        }

        return totalPriceWithTax + totalTax;
    }

    private static double roundTaxAmount(double taxAmount) {
        BigDecimal roundedAmount = new BigDecimal(taxAmount).setScale(2, RoundingMode.UP);
        double roundedTaxAmount = roundedAmount.doubleValue();

        double remainder = roundedTaxAmount % 0.05;
        if (remainder > 0) {
            roundedTaxAmount += (0.05 - remainder);
        }

        return roundedTaxAmount;
    }
}
