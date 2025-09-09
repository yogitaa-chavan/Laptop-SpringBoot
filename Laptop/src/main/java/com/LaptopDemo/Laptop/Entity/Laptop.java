package com.LaptopDemo.Laptop.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String model;
    private double price;
    private int ram;
    private long imieNo;

    public Laptop(){}

    public Laptop(String model, double price, int ram, long imieNo) {
        this.model = model;
        this.price = price;
        this.ram = ram;
        this.imieNo = imieNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public long getImieNo() {
        return imieNo;
    }

    public void setImieNo(long imieNo) {
        this.imieNo = imieNo;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", ram=" + ram +
                ", imieNo=" + imieNo +
                '}';
    }
}
