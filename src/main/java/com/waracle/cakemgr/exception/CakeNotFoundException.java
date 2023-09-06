package com.waracle.cakemgr.exception;

public class CakeNotFoundException extends RuntimeException {

    public CakeNotFoundException(Long id) {
        super("Could not find cake with id " + id);
    }

}
