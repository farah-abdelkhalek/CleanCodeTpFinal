package Billing;

public enum TaxSystem {
    TAX {
        public double calculateTax(Products product) {
            return product.getPrice() * 0.1;
            }
        },
    NO_TAX {
        public double calculateTax(Products product) {
            return 0;
            }
        },
    IMPORTED_TAX {
        public double calculateTax(Products product) {
            if (product.isImported()) {
                return product.getPrice() * 0.15;
            } else {
                return 0;
                }
            }
        },
    IMPORTED_NO_TAX {
        public double calculateTax(Products product) {
            if (product.isImported()) {
                return product.getPrice() * 0.05;
            } else {
                return 0;
                }
            }
        };

    public abstract double calculateTax(Products product);
}

