package org.example;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ShoppingItem {

String name;
int amount;

    public ShoppingItem(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
