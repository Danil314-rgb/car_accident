package ru.job4j.accident.model;

import java.util.Objects;

public class AccidentType {

    private int id;
    private String name;

    public AccidentType (int id, String name) {
        this.id = id;
        this.name = name;
    }

    public AccidentType() {

    }

    public AccidentType (int id) {
        this.id = id;
    }

    public AccidentType (String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccidentType type = (AccidentType) o;
        return id == type.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
