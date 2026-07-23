package org.javiersian.model;

public class RevisionFrenos extends Vehiculo{

    private int numeroEjes;
    private double costoPorEje;

    public RevisionFrenos(String descripcion, int numeroEjes, double costoPorEje) {
        super(descripcion);
        this.numeroEjes = numeroEjes;
        this.costoPorEje = costoPorEje;
    }

    public int getNumeroEjes() {
        return numeroEjes;
    }

    public void setNumeroEjes(int numeroEjes) {
        this.numeroEjes = numeroEjes;
    }

    public double getCostoPorEje() {
        return costoPorEje;
    }

    public void setCostoPorEje(double costoPorEje) {
        this.costoPorEje = costoPorEje;
    }

    @Override
    public double facturar() {
        return numeroEjes * costoPorEje;
    }
}