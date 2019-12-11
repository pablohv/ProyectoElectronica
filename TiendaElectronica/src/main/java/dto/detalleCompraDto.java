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
public class detalleCompraDto {

    private int idCom;
    private int idPro;
    private int cantidadCom;
    private String fechaCom;

    public detalleCompraDto(int idCom, int idPro, int cantidadCom, String fechaCom) {
        this.idCom = idCom;
        this.idPro = idPro;
        this.cantidadCom = cantidadCom;
        this.fechaCom = fechaCom;
    }

    public detalleCompraDto(int idPro, int cantidadCom, String fechaCom) {
        this.idPro = idPro;
        this.cantidadCom = cantidadCom;
        this.fechaCom = fechaCom;
    }

    public int getIdCom() {
        return idCom;
    }

    public void setIdCom(int idCom) {
        this.idCom = idCom;
    }

    public int getIdPro() {
        return idPro;
    }

    public void setIdPro(int idPro) {
        this.idPro = idPro;
    }

    public int getCantidadCom() {
        return cantidadCom;
    }

    public void setCantidadCom(int cantidadCom) {
        this.cantidadCom = cantidadCom;
    }

    public String getFechaCom() {
        return fechaCom;
    }

    public void setFechaCom(String fechaCom) {
        this.fechaCom = fechaCom;
    }

    @Override
    public String toString() {
        return "detalleCompraDto{" + "idCom=" + idCom + ", idPro=" + idPro + ", cantidadCom=" + cantidadCom + ", fechaCom=" + fechaCom + '}';
    }

}
