/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uthh.edd.unidad1.tda;

/**
 *Juan Nicacio Hernandez Alvarado
 * @author Lenovo_PC
 */
import java.util.ArrayList;
public class carritoCompras {

    // Atributos del TDA (encapsulados)
    private ArrayList<producto> listaProductos; 
    private double presupuestoMaximo;           
    private double total;                       

    
     //Constructor por defecto: carrito vacío con presupuesto de 1000.
    
    public carritoCompras() {
        this.listaProductos = new ArrayList<>();
        this.presupuestoMaximo = 1000.0;
        this.total = 0.0;
    }

    
     // Constructor parametrizado: valida el presupuesto mediante su setter.
     
    public carritoCompras(double presupuestoMaximo) {
        this.listaProductos = new ArrayList<>();
        this.setPresupuestoMaximo(presupuestoMaximo);
        this.total = 0.0;
    }

    //Devuelve el presupuesto máximo
    public double getPresupuestoMaximo() {
        return this.presupuestoMaximo;
    }

    //Asigna el presupuesto; no puede ser negativo.
    public void setPresupuestoMaximo(double presupuestoMaximo) {
        if (presupuestoMaximo < 0) {
            throw new IllegalArgumentException("El presupuesto máximo no puede ser negativo.");
        }
        this.presupuestoMaximo = presupuestoMaximo;
    }

    //Devuelve el último total calculado. */
    public double getTotal() {
        return this.total;
    }

    
     //Devuelve una copia de la lista (copia defensiva) para no exponer
     //la lista interna y proteger el encapsulamiento.
     
    public ArrayList<producto> getListaProductos() {
        return new ArrayList<>(this.listaProductos);
    }

    // ---------- MÉTODOS DE LÓGICA / PROCESAMIENTO ----------

   
     // Agrega un producto al carrito y actualiza el total.
     //Lanza excepción si el producto es nulo.
     
    public void agregarProducto(producto nuevo) {
        if (nuevo == null) {
            throw new IllegalArgumentException("No se puede agregar un producto nulo.");
        }
        this.listaProductos.add(nuevo);
        this.calcularTotal();
    }

    
     //Elimina el producto de la posición indicada (base 0).
     //Retorna true si se eliminó, false si el índice no es válido.
    
    public boolean eliminarProducto(int indice) {
        if (indice >= 0 && indice < this.listaProductos.size()) {
            this.listaProductos.remove(indice);
            this.calcularTotal();
            return true;
        }
        return false;
    }

   
     //Vacía el carrito y reinicia el total a 0.
    
    public void vaciar() {
        this.listaProductos.clear();
        this.total = 0.0;
    }

    
     //Calcula el total del carrito usando recursividad y lo guarda en el atributo 'total'.
    
    public double calcularTotal() {
        this.total = calcularTotalRecursivo(0);
        return this.total;
    }

    /**
     * Método recursivo que suma el costo final de los productos.
     * Caso base: indice == tamaño de la lista, retorna 0.0.
     * Avance: costo del producto actual + llamada con indice + 1.
     */
    private double calcularTotalRecursivo(int indice) {
        if (indice == this.listaProductos.size()) {
            return 0.0; // caso base
        }
        return this.listaProductos.get(indice).calcularCostoFinal()
                + calcularTotalRecursivo(indice + 1); // avance
    }

    
    //Indica si el total actual no supera el presupuesto máximo.
    
    public boolean estaDentroDelPresupuesto() {
        return this.total <= this.presupuestoMaximo;
    }
}