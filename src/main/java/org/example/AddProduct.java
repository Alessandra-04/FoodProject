package org.example;

import java.util.Date;

public class AddProduct {

    public long prodProductId;
    public String productCategory;
    public Date dateMade;
    public Date dateExpired;
    public int amountProduced;

    public AddProduct(long prodProductId, String productCategory, Date dateMade, Date dateExpired, int amountProduced) {
        this.prodProductId = prodProductId;
        this.productCategory = productCategory;
        this.dateMade = dateMade;
        this.dateExpired = dateExpired;
        this.amountProduced = amountProduced;

    }

    public long getProdProductId() {
        return prodProductId;
    }

    public void setProdProductId(long prodProductId) {
        this.prodProductId = prodProductId;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public Date getDateMade() {
        return dateMade;
    }

    public void setDateMade(Date dateMade) {
        this.dateMade = dateMade;
    }

    public Date getDateExpired() {
        return dateExpired;
    }

    public void setDateExpired(Date dateExpired) {
        this.dateExpired = dateExpired;
    }

    public int getAmountProduced() {
        return amountProduced;
    }

    public void setAmountProduced(int amountProduced) {
        this.amountProduced = amountProduced;
    }
}