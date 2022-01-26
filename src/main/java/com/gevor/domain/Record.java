package com.gevor.domain;

public class Record {
    private String name;
    private String surname;
    private String separator;
    private String phoneNumber;
    private String lineRepresentation;

    public Record(String line) {
        lineRepresentation = line;
    }

    public Record(String name, String surname, String separator, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.separator = separator;
        this.phoneNumber = phoneNumber;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSeparator() {
        return separator;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLineRepresentation() {
        return lineRepresentation;
    }

    public void setLineRepresentation(String lineRepresentation) {
        this.lineRepresentation = lineRepresentation;
    }

    @Override
    public String toString() {
        return lineRepresentation;
    }
}
