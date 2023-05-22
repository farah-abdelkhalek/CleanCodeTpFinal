package Billing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Receipt {
    private List<Products> listOfProducts;
    private Map<Products, Integer> productCountMap;
    private double totalTax;
    private double totalPriceWithTax;

    public Receipt(List<Products> listOfProducts, double totalTax, double totalPriceWithTax) {
        this.listOfProducts = listOfProducts;
        this.totalTax = totalTax;
        this.totalPriceWithTax = totalPriceWithTax;
        this.productCountMap = calculateProductCountMap(listOfProducts);
    }

    private Map<Products, Integer> calculateProductCountMap(List<Products> productsList) {
        Map<Products, Integer> countMap = new HashMap<>();

        for (Products product : productsList) {
            countMap.put(product, countMap.getOrDefault(product, 0) + 1);
        }

        return countMap;
    }

    public List<Products> getListOfProducts() {
        return listOfProducts;
    }

    public Map<Products, Integer> getProductCountMap() {
        return productCountMap;
    }

    public double getTotalTax() {
        return totalTax;
    }

    public double getTotalPriceWithTax() {
        return totalPriceWithTax;
    }

    public void getTotalPriceWithoutTax() {
    }
}
