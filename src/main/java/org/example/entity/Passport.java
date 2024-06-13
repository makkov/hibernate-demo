package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity(name = "passports")
@IdClass(PassportId.class)
public class Passport {

    @Id
    private Integer number;

    @Id
    private String name;

    public Passport() {
    }

    public Passport(Integer number, String name) {
        this.number = number;
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}
