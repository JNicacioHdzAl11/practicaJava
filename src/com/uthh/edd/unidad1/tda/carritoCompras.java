/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uthh.edd.unidad1.tda;

/**
 *
 * @author Lenovo_PC
 */
import java.util.ArrayList;
public class carritoCompras {

    // Atributos del TDA (Encapsulamiento)
    private ArrayList<producto> listaProductos;
    private double presupuestoMaximo;
    private double total; // Atributo explícito del modelo

    // Constructor por defecto
    public carritoCompras() {
        this.listaProductos = new ArrayList<>();
        this.presupuestoMaximo = 1000.0;
        this.total = 0.0;
    }

    // Constructor parametrizado con validación
    public carritoCompras(double presupuestoMaximo) {
        this.listaProductos = new ArrayList<>();
        this.setPresupuestoMaximo(presupuestoMaximo);
        this.total = 0.0;
    }

    // Métodos de acceso y modificación (Getters y Setters)
    public double getPresupuestoMaximo() {
        return this.presupuestoMaximo;
    }

    public void setPresupuestoMaximo(double presupuestoMaximo) {
        if (presupuestoMaximo < 0) {
            throw new IllegalArgumentException("El presupuesto máximo no puede ser negativo.");
        }
        this.presupuestoMaximo = presupuestoMaximo;
    }

    public double getTotal() {
        return this.total;
    }

    public ArrayList<producto> getListaProductos() {
        return this.listaProductos;
    }

    // --- MÉTODOS DE LÓGICA / PROCESAMIENTO ---

    // 1. Agregar producto
    public void agregarProducto(producto producto) {
        if (producto == null) {
            throw new IllegalArgumentException("No se puede agregar un producto nulo.");
        }
        this.listaProductos.add(producto);
    }

    // 2. Eliminar producto por índice
    public boolean eliminarProducto(int indice) {
        if (indice >= 0 && indice < this.listaProductos.size()) {
            this.listaProductos.remove(indice);
            return true;
        }
        return false;
    }

    // 3. Método público que calcula el total y actualiza el atributo explícito 'total'
    public double calcularTotal() {
        this.total = calcularTotalRecursivo(0);
        return this.total;
    }

    /**
     * 4. Método recursivo
     * Caso Base: indice == listaProductos.size() -> Retorna 0.0
     * Condición de Avance: Suma costo actual + llamada recursiva con (indice + 1)
     */
    private double calcularTotalRecursivo(int indice) {
        if (indice == this.listaProductos.size()) {
            return 0.0; // Caso base
        }
        producto p = this.listaProductos.get(indice);
        return p.calcularCostoFinal() + calcularTotalRecursivo(indice + 1);
    }

    // 5. Verificar si el total actual no supera el presupuesto
    public boolean estaDentroDelPresupuesto() {
        return calcularTotal() <= this.presupuestoMaximo;
    }
}
