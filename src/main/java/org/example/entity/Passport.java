package org.example.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity(name = "passports")
public class Passport {

    @EmbeddedId
    private PassportId passportId;

    public Passport() {
    }

    public Passport(PassportId passportId) {
        this.passportId = passportId;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "passportId=" + passportId +
                '}';
    }
}
