package org.javiersian.model;

public abstract class Vehiculo {
   private String descripcion;

    public Vehiculo(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public abstract double facturar();

    @Override
    public String toString() {
        return descripcion + " - Q" + String.format("%.2f", facturar());
    }
}