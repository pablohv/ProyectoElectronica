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
public class detalleVentaDto {

    private int idVen;
    private int idPro;
    private int cantidad;
    private String fechaVen;

    public detalleVentaDto(int idVen, int idPro, int cantidad, String fechaVen) {
        this.idVen = idVen;
        this.idPro = idPro;
        this.cantidad = cantidad;
        this.fechaVen = fechaVen;
    }

    public detalleVentaDto(int idPro, int cantidad, String fechaVen) {
        this.idPro = idPro;
        this.cantidad = cantidad;
        this.fechaVen = fechaVen;
    }

    public int getIdVen() {
        return idVen;
    }

    public void setIdVen(int idVen) {
        this.idVen = idVen;
    }

    public int getIdPro() {
        return idPro;
    }

    public void setIdPro(int idPro) {
        this.idPro = idPro;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFechaVen() {
        return fechaVen;
    }

    public void setFechaVen(String fechaVen) {
        this.fechaVen = fechaVen;
    }

    @Override
    public String toString() {
        return "detalleVentaDto{" + "idVen=" + idVen + ", idPro=" + idPro + ", cantidad=" + cantidad + ", fechaVen=" + fechaVen + '}';
    }

}
