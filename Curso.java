package Modelo;

import java.util.Objects;

public class Curso {
    private int id;
    private String nombre;
    private double costo;

    public Curso(int id, String nombre, double costo) {
        this.id = id;
        this.nombre = nombre;
        this.costo = costo;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public double getCosto() { return costo; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return id == curso.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format("%s - $%.2f", nombre, costo);
    }
}