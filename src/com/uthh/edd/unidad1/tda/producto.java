/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uthh.edd.unidad1.tda;

/**
 *
 * @author Lenovo_PC
 */
public class producto {

    private String nombre;
    private double precioUnitario;
    private int cantidad;

    // Constructores
    public producto() {
        this.nombre = "Producto genérico";
        this.precioUnitario = 50.0;
        this.cantidad = 1;
    }

    public producto(String nombre, double precioUnitario, int cantidad) {
        this.setNombre(nombre);
        this.setPrecioUnitario(precioUnitario);
        this.setCantidad(cantidad);
    }

    // Getters y Setters con encapsulamiento y validación
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede quedar vacío.");
        }
        this.nombre = nombre;
    }

    public double getPrecioUnitario() {
        return this.precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        if (precioUnitario <= 0) {
            throw new IllegalArgumentException("El precio unitario debe ser mayor a 0.");
        }
        this.precioUnitario = precioUnitario;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser menor a 0.");
        }
        this.cantidad = cantidad;
    }

    // Método de procesamiento del dominio
    public double calcularCostoFinal() {
        return this.precioUnitario * this.cantidad;
    }
}
