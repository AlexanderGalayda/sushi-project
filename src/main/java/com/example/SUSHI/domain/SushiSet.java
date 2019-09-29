package com.example.SUSHI.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SushiSet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String name;
    private double price;
    private int weight;
    private int amountPiece;
    private String consist;
    private String filename;

    public SushiSet(){

    }
    public SushiSet(String name, double price, int weight, int amountPiece, String consist){
        this.name=name;
        this.price = price;
        this.weight = weight;
        this.amountPiece = amountPiece;
        this.consist = consist;

    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAmountPiece() {
        return amountPiece;
    }

    public void setAmountPiece(int amountPiece) {
        this.amountPiece = amountPiece;
    }

    public String getConsist() {
        return consist;
    }

    public void setConsist(String consist) {
        this.consist = consist;
    }
}
