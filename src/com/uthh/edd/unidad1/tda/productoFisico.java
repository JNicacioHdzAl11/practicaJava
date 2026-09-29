/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uthh.edd.unidad1.tda;

/**
 *
 * @author Lenovo_PC
 */
public class productoFisico extends producto {

    private double costoEnvio;

    public productoFisico(String nombre, double precioUnitario, int cantidad, double costoEnvio) {
        super(nombre, precioUnitario, cantidad);
        this.setCostoEnvio(costoEnvio);
    }

    public double getCostoEnvio() {
        return this.costoEnvio;
    }

    public void setCostoEnvio(double costoEnvio) {
        if (costoEnvio < 0) {
            throw new IllegalArgumentException("El costo de envío no puede ser menor a 0.");
        }
        this.costoEnvio = costoEnvio;
    }

    @Override
    public double calcularCostoFinal() {
        return super.calcularCostoFinal() + this.costoEnvio;
    }
}
