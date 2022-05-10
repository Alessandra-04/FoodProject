package org.example;

public class ChurrosItems {

    public int productId;
    public String name;
    public String description;
    public double standardCost;
    public int stock;
    public String supplier;
    public String category;

    public ChurrosItems(int productId, String name, String description, double standardCost, int stock, String supplier, String category) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.standardCost = standardCost;
        this.stock = stock;
        this.supplier = supplier;
        this.category = category;
    }
}
