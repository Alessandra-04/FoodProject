package org.example;

public class FoodItem {

        public long productId;
        public String name;
        public String description;
        public double standardCost;
        public int stock;
        public String supplier;
        public String category;


    public FoodItem(long productId, String name, String description, double standardCost, int stock, String supplier, String category) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.standardCost = standardCost;
        this.stock = stock;
        this.supplier = supplier;
        this.category = category;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getStandardCost() {
        return standardCost;
    }

    public void setStandardCost(double standardCost) {
        this.standardCost = standardCost;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}


