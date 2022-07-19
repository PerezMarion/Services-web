package com.mycompany.apiwebrestaurant.business;

public class Meal {
    
    private Long id;
    private String name;
    private String description;
    private Float price;

    public Meal() {
    }
    
    public Meal(String nom, String description, Float prix) {
        this.name = nom;
        this.description = description;
        this.price = prix;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Plat{" + "id=" + id + ", nom=" + name + ", description=" + description + ", prix=" + price + '}';
    }
}