/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author acer
 */
public class ProductoDto {

    private int id;
    private String nombre;
    private double costo;
    private int cantidad;

    public ProductoDto(int id, String nombre, double costo, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.costo = costo;
        this.cantidad = cantidad;
    }

    public ProductoDto(String nombre, double costo, int cantidad) {
        this.nombre = nombre;
        this.costo = costo;
        this.cantidad = cantidad;
    }

    public ProductoDto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "ProductoDto{" + "id=" + id + ", nombre=" + nombre + ", costo=" + costo + ", cantidad=" + cantidad + '}';
    }

}
