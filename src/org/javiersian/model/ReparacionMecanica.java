
package org.javiersian.model;

public class ReparacionMecanica extends Vehiculo{

   private double costoRepuestos;
    private double horasManoObra;
    private double precioHora;

    public ReparacionMecanica(String descripcion, double costoRepuestos, double horasManoObra, double precioHora) {
        super(descripcion);
        this.costoRepuestos = costoRepuestos;
        this.horasManoObra = horasManoObra;
        this.precioHora = precioHora;
    }

    public double getCostoRepuestos() {
        return costoRepuestos;
    }

    public void setCostoRepuestos(double costoRepuestos) {
        this.costoRepuestos = costoRepuestos;
    }

    public double getHorasManoObra() {
        return horasManoObra;
    }

    public void setHorasManoObra(double horasManoObra) {
        this.horasManoObra = horasManoObra;
    }

    public double getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(double precioHora) {
        this.precioHora = precioHora;
    }

    @Override
    public double facturar() {
        return costoRepuestos + (horasManoObra * precioHora);
    }
}