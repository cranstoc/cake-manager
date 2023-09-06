package com.waracle.cakemgr.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Cake {

    private @Id @GeneratedValue Long id;
    private String title;
    private String description;
    private String image;

    public Cake() {} //no arg constructor required for JPA

    public Cake(String title, String description, String image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cake cake)) return false;
        return Objects.equals(id, cake.id) && Objects.equals(title, cake.title) && Objects.equals(description, cake.description) && Objects.equals(image, cake.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, image);
    }

}
