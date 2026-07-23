
package org.javiersian.controller;

import java.util.ArrayList;
import org.javiersian.model.Vehiculo;

public class VehiculoController {
  private ArrayList<Vehiculo> listaServicios;
    
    public void agregarVehiculo(Vehiculo vehiculo) {
        listaServicios.add(vehiculo);
    }

    public ArrayList<Vehiculo> getListaVehiculo() {
        return listaServicios;
    }

    public double calcularTotalIngresos() {
        double total = 0;

        for (Vehiculo vehiculo : listaServicios) {
            total += vehiculo.facturar();
        }

        return total;
    }


}