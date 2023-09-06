package com.waracle.cakemgr.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CakeTest {

    @Test
    public void createCake() {
        Cake cake = new Cake();

        assertNotNull(cake);
    }

    @Test
    public void createCakeWithTitleDescriptionAndImage() {
        String title = "title";
        String description = "description";
        String image = "image";

        Cake cake = new Cake(title, description, image);

        assertNull(cake.getId());
        assertEquals(title, cake.getTitle());
        assertEquals(description, cake.getDescription());
        assertEquals(image, cake.getImage());
    }

    @Test
    public void setAndGetId() {
        Long id = 1L;
        Cake cake = new Cake();

        cake.setId(id);

        assertEquals(id, cake.getId());
    }

    @Test
    public void equalsAndHashCode() {
        Cake cake = new Cake();
        Cake anotherCake = new Cake();

        assertEquals(anotherCake, cake);
        assertEquals(anotherCake.hashCode(), cake.hashCode());
    }

}
