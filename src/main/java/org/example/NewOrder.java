package org.example;

import java.util.Date;

public class NewOrder {

    public long productIdOrder;
    public long customerId;
    public double totalPrice;
    public String description;
    public Date dateOfOrder;
    public String status;
    public Date dueDate;


    public NewOrder (long productIdOrder, long customerId, double totalPrice, String description, Date dateOfOrder, String status, Date dueDate) {
        this.productIdOrder = productIdOrder;
        this.customerId = customerId;
        this.totalPrice = totalPrice;
        this.description = description;
        this.dateOfOrder = dateOfOrder;
        this.status = status;
        this.dueDate = dueDate;
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

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(Date dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
