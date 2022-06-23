package org.example;

public class FoodItem {

    public long productId;
    public String name;
    public double standardCost;
    public int stock;
    public Double amountLeft;


    public FoodItem(long productId, String name, double standardCost, int stock, Double amountLeft) {
        this.productId = productId;
        this.name = name;
        this.standardCost = standardCost;
        this.stock = stock;
        this.amountLeft = amountLeft;
    }

    public FoodItem(String group, String group1, String group2) {
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

    public double getCategory() {
        return amountLeft;
    }

    public void setCategory(Double category) {
        this.amountLeft = category;
    }
}


