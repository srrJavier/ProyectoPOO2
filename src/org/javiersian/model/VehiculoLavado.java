package org.javiersian.model;

public class VehiculoLavado extends Vehiculo{
    
    private double salarioMensual;
    
    public VehiculoLavado(){
        
    }
    
    public VehiculoLavado(String id, String nombre, double salarioMensual){
        super(id,nombre);
        this.salarioMensual = salarioMensual;
    }
    
    public void setSalarioMensual(double salarioMensual){
        //acceder al atributo de clase y asignar  el parametro del metodo
        //validaciones -
        this.salarioMensual = salarioMensual;
    }
    
    public double getSalarioMensual(){
       //atributos de clase
       return this.salarioMensual;
    }
    
    @Override
    public double calcularTotal() {
       return this.salarioMensual;
    }
}

