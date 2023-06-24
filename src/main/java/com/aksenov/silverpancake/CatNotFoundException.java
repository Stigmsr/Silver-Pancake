package com.aksenov.silverpancake;

class CatNotFoundException extends RuntimeException {
    CatNotFoundException(Long id) {
        super("Could not find Cat with id " + id);
    }
}

