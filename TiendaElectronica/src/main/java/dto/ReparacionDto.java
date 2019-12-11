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
public class ReparacionDto {

    private int idRep;
    private String fechaEntrada;
    private String nombre;
    private String aparato;
    private String descripcion;
    private int costo;
    private String fechaSalida;
    private String nombreRecoge;

    public ReparacionDto(int idRep, String fechaEntrada, String nombre, String aparato, String descripcion, int costo, String fechaSalida, String nombreRecoge) {
        this.idRep = idRep;
        this.fechaEntrada = fechaEntrada;
        this.nombre = nombre;
        this.aparato = aparato;
        this.descripcion = descripcion;
        this.costo = costo;
        this.fechaSalida = fechaSalida;
        this.nombreRecoge = nombreRecoge;
    }

    public ReparacionDto(int idRep, String fechaEntrada, String nombre, String aparato, String descripcion, int costo) {
        this.idRep = idRep;
        this.fechaEntrada = fechaEntrada;
        this.nombre = nombre;
        this.aparato = aparato;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public ReparacionDto(String fechaEntrada, String nombre, String aparato, String descripcion, int costo) {
        this.fechaEntrada = fechaEntrada;
        this.nombre = nombre;
        this.aparato = aparato;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public ReparacionDto(int idRep, String fechaSalida, String nombreRecoge) {
        this.idRep = idRep;
        this.fechaSalida = fechaSalida;
        this.nombreRecoge = nombreRecoge;
    }

    public int getIdRep() {
        return idRep;
    }

    public void setIdRep(int idRep) {
        this.idRep = idRep;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAparato() {
        return aparato;
    }

    public void setAparato(String aparato) {
        this.aparato = aparato;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getNombreRecoge() {
        return nombreRecoge;
    }

    public void setNombreRecoge(String nombreRecoge) {
        this.nombreRecoge = nombreRecoge;
    }

    @Override
    public String toString() {
        return "ReparacionDto{" + "idRep=" + idRep + ", fechaEntrada=" + fechaEntrada + ", nombre=" + nombre + ", aparato=" + aparato + ", descripcion=" + descripcion + ", costo=" + costo + ", fechaSalida=" + fechaSalida + ", nombreRecoge=" + nombreRecoge + '}';
    }

}
