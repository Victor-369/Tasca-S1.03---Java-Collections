package com.pruebas.proyecto.nivell1.model;

import java.util.Objects;

public class Month {
    private String name;

    public Month(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (this == o) return true;
        Month month = (Month) o;
        return Objects.equals(name, month.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
