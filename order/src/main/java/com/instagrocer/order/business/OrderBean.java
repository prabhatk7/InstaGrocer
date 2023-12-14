package com.instagrocer.order.business;
import java.util.Objects;

public class OrderBean {
    private int orderId;
    private String itemName;
    private int quantity;
    private double amount = 0;

    public OrderBean() {
    }

    public OrderBean(int orderId, String itemName, int quantity, double amount) {
        this.orderId = orderId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.amount = amount;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public OrderBean orderId(int orderId) {
        setOrderId(orderId);
        return this;
    }

    public OrderBean itemName(String itemName) {
        setItemName(itemName);
        return this;
    }

    public OrderBean quantity(int quantity) {
        setQuantity(quantity);
        return this;
    }

    public OrderBean amount(double amount) {
        setAmount(amount);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof OrderBean)) {
            return false;
        }
        OrderBean orderBean = (OrderBean) o;
        return orderId == orderBean.orderId && Objects.equals(itemName, orderBean.itemName) && quantity == orderBean.quantity && amount == orderBean.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, itemName, quantity, amount);
    }

    @Override
    public String toString() {
        return "{" +
            " orderId='" + getOrderId() + "'" +
            ", itemName='" + getItemName() + "'" +
            ", quantity='" + getQuantity() + "'" +
            ", amount='" + getAmount() + "'" +
            "}";
    }


}
