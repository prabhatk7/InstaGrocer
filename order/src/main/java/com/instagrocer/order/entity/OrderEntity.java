package com.instagrocer.order.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String itemName;
    private int quantity;
    private double amount;


    public OrderEntity() {
    }

    public OrderEntity(int orderId, String itemName, int quantity, double amount) {
        super();
        this.id = orderId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.amount = amount;
    }

    public int getOrderId() {
        return this.id;
    }

    public void setOrderId(int orderId) {
        this.id = orderId;
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

    public OrderEntity orderId(int orderId) {
        setOrderId(orderId);
        return this;
    }

    public OrderEntity itemName(String itemName) {
        setItemName(itemName);
        return this;
    }

    public OrderEntity quantity(int quantity) {
        setQuantity(quantity);
        return this;
    }

    public OrderEntity amount(double amount) {
        setAmount(amount);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof OrderEntity)) {
            return false;
        }
        OrderEntity orderEntity = (OrderEntity) o;
        return id == orderEntity.id && Objects.equals(itemName, orderEntity.itemName) && quantity == orderEntity.quantity && amount == orderEntity.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, itemName, quantity, amount);
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
