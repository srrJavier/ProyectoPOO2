package org.javiersian.model;

public abstract class Vehiculo {
    private String id;
    private String nombre;
    
    public Vehiculo(){
        
    }
    
    public Vehiculo(String id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
   

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
     public String getNombre() {
        return nombre;
    }
    

     public abstract double calcularTotal();
     
}