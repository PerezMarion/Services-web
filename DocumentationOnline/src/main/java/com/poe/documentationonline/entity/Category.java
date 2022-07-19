package com.poe.documentationonline.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {
    
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INTEGER")
    private Long id;
    
    private String type;

    public Category() {
    }

    public Category(Long id, String type) {
        this.id = id;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNotNullData(Category updatedCategory) {
        
        if(updatedCategory.getType() != null) {
            this.setType(updatedCategory.getType());
        }
    }
    
    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", type=" + type + '}';
    }
}