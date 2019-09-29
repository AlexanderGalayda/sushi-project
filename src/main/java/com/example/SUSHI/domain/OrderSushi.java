package com.example.SUSHI.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderSushi {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String status;
    private int phone;
    private String address;
    private String additional;



   public OrderSushi(){

    }

    public OrderSushi(String status, int phone, String address, String additional) {
        this.status = status;
        this.phone = phone;
        this.address = address;
        this.additional = additional;
    }

    public OrderSushi(int phone, String address, String additional){
        this.phone = phone;
        this.address = address;
        this.additional = additional;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAdditional() {
        return additional;
    }

    public void setAdditional(String additional) {
        this.additional = additional;
    }
}
