package Billing;

public class Products {

    private final String name;
    private final double price;
    private final String category;
    private final boolean importStatus;

    public Products(String name, double price, boolean importStatus, String category) {
        this.name = name;
        this.price = price;
        this.importStatus = importStatus;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public boolean getIsImported() {
        return importStatus;
    }

//    public double getTaxAmount() { return getTaxAmount();}
    //à rajouter autre part
}

