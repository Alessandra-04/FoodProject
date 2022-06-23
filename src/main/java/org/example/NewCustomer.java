package org.example;

import java.util.Date;

public class NewCustomer {

    public long customerIdCs;
    public String customerName;
    public long contact;
    public Date dateOfPurchase;


    public NewCustomer(long customerIdCs, String customerName, long contact, Date dateOfPurchase) {
        this.customerIdCs = customerIdCs;
        this.customerName = customerName;
        this.contact = contact;
        this.dateOfPurchase = dateOfPurchase;
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

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

}
