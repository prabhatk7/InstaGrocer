package com.instagrocer.catalog.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "item")
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String type;
    private double price;
    private int quantity;

    public ItemEntity() {
    }

    public ItemEntity(int id, String name, String type, double price, int quantity) {
        super();
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ItemEntity id(int id) {
        setId(id);
        return this;
    }

    public ItemEntity name(String name) {
        setName(name);
        return this;
    }

    public ItemEntity type(String type) {
        setType(type);
        return this;
    }

    public ItemEntity price(double price) {
        setPrice(price);
        return this;
    }

    public ItemEntity quantity(int quantity) {
        setQuantity(quantity);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ItemEntity)) {
            return false;
        }
        ItemEntity studentEntity = (ItemEntity) o;
        return id == studentEntity.id && Objects.equals(name, studentEntity.name) && Objects.equals(type, studentEntity.type) && price == studentEntity.price && quantity == studentEntity.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, price, quantity);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", type='" + getType() + "'" +
            ", price='" + getPrice() + "'" +
            ", quantity='" + getQuantity() + "'" +
            "}";
    }
}
