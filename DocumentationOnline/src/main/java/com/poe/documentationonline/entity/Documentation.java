package com.poe.documentationonline.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "documentations")
public class Documentation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String description;
    private String url;
    
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category docCategory;

    public Documentation() {
    }
    
    public Documentation(Long id, String name, String description, String url, Category docCategory) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
        this.docCategory = docCategory;
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
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Category getDocCategory() {
        return docCategory;
    }

    public void setDocCategory(Category docCategory) {
        this.docCategory = docCategory;
    }

    public void setNotNullData(Documentation updatedDocumentation) {
        
        if(updatedDocumentation.getName()!= null) {
            this.setName(updatedDocumentation.getName());
        }
        
        if(updatedDocumentation.getDescription()!= null) {
            this.setDescription(updatedDocumentation.getDescription());
        }
        
        if(updatedDocumentation.getUrl()!= null) {
            this.setUrl(updatedDocumentation.getUrl());
        }
    }
    
    @Override
    public String toString() {
        return "Documentation{" + "id=" + id + ", name=" + name + ", description=" + description 
                + ", url=" + url + ", docCategory=" + docCategory + '}';
    }
}