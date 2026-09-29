/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uthh.edd.unidad1.tda;

/**
 *Juan Nicacio Hernandez Alvarado
 * @author Lenovo_PC
 */
public class producto {

    // Atributos privados (encapsulamiento)
    private String nombre;
    private double precioUnitario;
    private int cantidad;

    /**
     * Constructor por defecto: crea un producto genérico con valores válidos.
     */
    public producto() {
        this.nombre = "Producto genérico";
        this.precioUnitario = 50.0;
        this.cantidad = 1;
    }

    /**
     * Constructor parametrizado. Usa los setters para reutilizar sus validaciones.
     */
    public producto(String nombre, double precioUnitario, int cantidad) {
        this.setNombre(nombre);
        this.setPrecioUnitario(precioUnitario);
        this.setCantidad(cantidad);
    }

    /** Devuelve el nombre del producto. */
    public String getNombre() {
        return this.nombre;
    }

    /** Asigna el nombre; lanza excepción si es nulo o vacío. */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede quedar vacío.");
        }
        this.nombre = nombre;
    }

    /** Devuelve el precio por unidad. */
    public double getPrecioUnitario() {
        return this.precioUnitario;
    }

    /** Asigna el precio; debe ser mayor a 0. */
    public void setPrecioUnitario(double precioUnitario) {
        if (precioUnitario <= 0) {
            throw new IllegalArgumentException("El precio unitario debe ser mayor a 0.");
        }
        this.precioUnitario = precioUnitario;
    }

    /** Devuelve la cantidad de unidades. */
    public int getCantidad() {
        return this.cantidad;
    }

    /** Asigna la cantidad; no puede ser negativa. */
    public void setCantidad(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser menor a 0.");
        }
        this.cantidad = cantidad;
    }

    /**
     * Calcula el costo final de la línea: precio unitario por cantidad.
     * Las subclases lo sobrescriben (polimorfismo).
     */
    public double calcularCostoFinal() {
        return this.precioUnitario * this.cantidad;
    }

    /** Representación en texto del producto. */
    @Override
    public String toString() {
        return nombre + " x" + cantidad + " = $" + calcularCostoFinal();
    }
}