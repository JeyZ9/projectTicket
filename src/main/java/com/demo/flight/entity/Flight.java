package com.demo.flight.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Flight {
    @GeneratedValue
//    fields
    @Id
    private Long id;
    @Lob
    private byte[] image;
    private String name;
    private String description;
    private String category;
    private Double price;

    public Flight(){

    }

    public Flight(byte[] image, String name, String description, String category, Double price){
        this.image = image;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
    }

    //    Getters and Setters
    public Long getId(){
        return id;
    }

    public byte[] getImage(){
        return image;
    }

    public String getName(){
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public Double getPrice(){
        return price;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setImage(byte[] image){
        this.image = image;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public void setPrice(Double price){
        this.price = price;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                "}";
    }
}
