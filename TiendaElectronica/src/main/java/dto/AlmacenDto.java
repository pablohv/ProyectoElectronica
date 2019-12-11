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
public class AlmacenDto {

    private int id;
    private String nombre;
    private String ubicacion;
    private String estado;

    public AlmacenDto(int id, String nombre, String ubicacion, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.estado = estado;
    }

    public AlmacenDto(String nombre, String ubicacion, String estado) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.estado = estado;
    }

    public AlmacenDto(int id, String nombre) {
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

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Almacen{" + "id=" + id + ", nombre=" + nombre + ", ubicacion=" + ubicacion + ", estado=" + estado + '}';
    }

}
