package org.example.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class PassportId implements Serializable {

    private Integer number;

    private String name;

    public PassportId() {
    }

    public PassportId(Integer number, String name) {
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
        return "PassportId{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}
