package com.waracle.cakemgr.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CakeNotFoundExceptionTest {

    @Test
    public void createCakeNotFoundException() {
        CakeNotFoundException e = new CakeNotFoundException(1L);

        assertEquals("Could not find cake with id 1", e.getMessage());
    }

}
