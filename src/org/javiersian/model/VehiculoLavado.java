package org.javiersian.model;

public class VehiculoLavado extends Vehiculo {

    private String tipoVehiculo;

    public VehiculoLavado(String descripcion, String tipoVehiculo) {
        super(descripcion);
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    @Override
    public double facturar() {
        if (tipoVehiculo.equalsIgnoreCase("Grande") || tipoVehiculo.equalsIgnoreCase("SUV")) {
            return 100.0;
        } else if (tipoVehiculo.equalsIgnoreCase("Mediano")) {
            return 75.0;
        }
        return 50.0;
    }
}
