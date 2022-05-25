package org.example;

public class NewOrder {

    public long productIdOrder;
    public long customerId;
    public String descriptionOfOrder;
    public double totalPrice;
    public String assignedEmployee;
    public String status;
    public int date;


    public NewOrder (long productIdOrder, long customerId, String descriptionOfOrder, double totalPrice, String assignedEmployee, String status, int date) {
        this.productIdOrder = productIdOrder;
        this.customerId = customerId;
        this.descriptionOfOrder = descriptionOfOrder;
        this.totalPrice = totalPrice;
        this.assignedEmployee = assignedEmployee;
        this.status = status;
        this.date = date;
    }

    public long getProductIdOrder() {
        return productIdOrder;
    }

    public void setProductIdOrder(long productIdOrder) {
        this.productIdOrder = productIdOrder;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getDescriptionOfOrder() {
        return descriptionOfOrder;
    }

    public void setDescriptionOfOrder(String descriptionOfOrder) {
        this.descriptionOfOrder = descriptionOfOrder;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getAssignedEmployee() {
        return assignedEmployee;
    }

    public void setAssignedEmployee(String assignedEmployee) {
        this.assignedEmployee = assignedEmployee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
}
