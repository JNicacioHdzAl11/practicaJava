/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uthh.edd.unidad1.tda;

/**
 *
 * @author Lenovo_PC
 */
public class productoDigital extends producto {

    private String tipoLicencia;

    public productoDigital(String nombre, double precioUnitario, int cantidad, String tipoLicencia) {
        super(nombre, precioUnitario, cantidad);
        this.setTipoLicencia(tipoLicencia);
    }

    public String getTipoLicencia() {
        return this.tipoLicencia;
    }

    public void setTipoLicencia(String tipoLicencia) {
        if (tipoLicencia == null || tipoLicencia.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de licencia no puede quedar vacío.");
        }
        this.tipoLicencia = tipoLicencia;
    }

    @Override
    public double calcularCostoFinal() {
        return super.calcularCostoFinal();
    }
}
