package com.aksenov.silverpancake;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


class Cat {
    private @Id @GeneratedValue Long id;
    private String name;
    private String breed;

    Cat(String name, String breed) {

        this.name = name;
        this.breed = breed;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getBreed() {
        return this.breed;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Cat cat))
            return false;
        return Objects.equals(this.id, cat.id) && Objects.equals(this.name, cat.name)
                && Objects.equals(this.breed, cat.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.breed);
    }

    @Override
    public String toString() {
        return "Cat{" + "id=" + this.id + ", name='" + this.name + '\'' + ", breed='" + this.breed + '\'' + '}';
    }
}
