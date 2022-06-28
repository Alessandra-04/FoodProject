package org.example;

public class FoodItem {

    public long productId;
    public String name;
    public double standardCost;
    public double stock;

    public int amountLeft;
    public int sizeOfContainer;

    public FoodItem(long productId, String name, double standardCost, int sizeOfContainer) {
        this.productId = productId;
        this.name = name;
        this.standardCost = standardCost;
        this.sizeOfContainer = sizeOfContainer;
    }

    public int getAmountLeft() {
        return amountLeft;
    }

    public void setAmountLeft(int amountLeft) {
        this.amountLeft = amountLeft;
    }

    public void addStock(int amount){
        this.amountLeft += amount * this.sizeOfContainer;
    }
    public void useAmountLeft(int amount){
        this.amountLeft -= amount;
        calcStock();
    }
    public void calcStock(){
        this.stock = amountLeft/sizeOfContainer;
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

    public double getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


}


