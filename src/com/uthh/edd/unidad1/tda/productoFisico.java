/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uthh.edd.unidad1.tda;

/**
 *Juan Nicacio Hernandez Alvarado
 * @author Lenovo_PC
 */
public class productoFisico extends producto {
    // Atributo propio de los productos físicos
    private double costoEnvio;
    //Constructor: inicializa los datos heredados con super y valida el envío.
    public productoFisico(String nombre, double precioUnitario, int cantidad, double costoEnvio) {
        super(nombre, precioUnitario, cantidad);
        this.setCostoEnvio(costoEnvio);
    }
    //Devuelve el costo de envío.
    public double getCostoEnvio() {
        return this.costoEnvio;
    }
    // Asigna el costo de envío; no puede ser negativo. 
    public void setCostoEnvio(double costoEnvio) {
        if (costoEnvio < 0) {
            throw new IllegalArgumentException("El costo de envío no puede ser menor a 0.");
        }
        this.costoEnvio = costoEnvio;
    }
    //Sobrescribe el cálculo base: suma el envío (una vez por línea de producto).
    @Override
    public double calcularCostoFinal() {
        return super.calcularCostoFinal() + this.costoEnvio;
    }
}
