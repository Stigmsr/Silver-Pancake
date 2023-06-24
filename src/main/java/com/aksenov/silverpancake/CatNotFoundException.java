package com.aksenov.silverpancake;

public class CatNotFoundException extends RuntimeException {
    public CatNotFoundException(Long id) {
        super("Couldn't find cat with id " + id);
    }
}
