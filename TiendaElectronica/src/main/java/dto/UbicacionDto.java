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
public class UbicacionDto {

    private int idProducto;
    private String nombrePro;
    private double costo;
    private int idAlm;
    private String nombreAl;
    private String ubicacion;

    public UbicacionDto(int idProducto, String nombrePro, double costo, int idAlm, String nombreAl, String ubicacion) {
        this.idProducto = idProducto;
        this.nombrePro = nombrePro;
        this.costo = costo;
        this.idAlm = idAlm;
        this.nombreAl = nombreAl;
        this.ubicacion = ubicacion;
    }

    public UbicacionDto(int idProducto, int idAlm) {
        this.idProducto = idProducto;
        this.idAlm = idAlm;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombrePro() {
        return nombrePro;
    }

    public void setNombrePro(String nombrePro) {
        this.nombrePro = nombrePro;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getIdAlm() {
        return idAlm;
    }

    public void setIdAlm(int idAlm) {
        this.idAlm = idAlm;
    }

    public String getNombreAl() {
        return nombreAl;
    }

    public void setNombreAl(String nombreAl) {
        this.nombreAl = nombreAl;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "UbicacionDto{" + "idProducto=" + idProducto + ", nombrePro=" + nombrePro + ", costo=" + costo + ", idAlm=" + idAlm + ", nombreAl=" + nombreAl + ", ubicacion=" + ubicacion + '}';
    }

}
