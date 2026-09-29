/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uthh.edd.unidad1.tda;

/**
 * Juan Nicacio Hernandez Alvarado
 * @author Lenovo_PC
 */
public class productoDigital extends producto {
    // Atributo propio de los productos digitales
    private String tipoLicencia;
    //Constructor: inicializa los datos heredados con super y valida la licencia.
    public productoDigital(String nombre, double precioUnitario, int cantidad, String tipoLicencia) {
        super(nombre, precioUnitario, cantidad);
        this.setTipoLicencia(tipoLicencia);
    }
    //Devuelve el tipo de licencia
    public String getTipoLicencia() {
        return this.tipoLicencia;
    }
    //Asigna la licencia; no puede ser nula ni vacía.
    public void setTipoLicencia(String tipoLicencia) {
        if (tipoLicencia == null || tipoLicencia.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de licencia no puede quedar vacío.");
        }
        this.tipoLicencia = tipoLicencia;
    }
    //Los productos digitales no tienen envío, por lo que el costo, es el mismo que el de la clase base.
    @Override
    public double calcularCostoFinal() {
        return super.calcularCostoFinal();
    }
}
