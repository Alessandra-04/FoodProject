package org.example;

public class NewCustomer {

    public long customerIdCs;
    public String customerName;
    public String descriptionOfOrderCustomer;
    public long contact;
    public int dateOfPurchase;
    public String review;

    public NewCustomer (long customerIdCs, String customerName, String descriptionOfOrderCustomer, long contact, int dateOfPurchase, String review) {
        this.customerIdCs = customerIdCs;
        this.customerName = customerName;
        this.descriptionOfOrderCustomer = descriptionOfOrderCustomer;
        this.contact = contact;
        this.dateOfPurchase = dateOfPurchase;
        this.review = review;
    }

    public long getCustomerIdCs() {
        return customerIdCs;
    }

    public void setCustomerIdCs(long customerIdCs) {
        this.customerIdCs = customerIdCs;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDescriptionOfOrderCustomer() {
        return descriptionOfOrderCustomer;
    }

    public void setDescriptionOfOrderCustomer(String descriptionOfOrderCustomer) {
        this.descriptionOfOrderCustomer = descriptionOfOrderCustomer;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public int getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(int dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
