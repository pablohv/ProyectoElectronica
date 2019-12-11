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
public class UsuarioDto {
    private String nombre;
    private String contra;
    private String tecnologia;
    private String genero;
    private String ocupacion;

    public UsuarioDto(String nombre, String contra, String tecnologia, String genero, String ocupacion) {
        this.nombre = nombre;
        this.contra = contra;
        this.tecnologia = tecnologia;
        this.genero = genero;
        this.ocupacion = ocupacion;
    }
    
    public UsuarioDto(String nombre, String contra) {
        this.nombre = nombre;
        this.contra = contra;
    }
    
    public UsuarioDto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    @Override
    public String toString() {
        return "usuarioDto{" + "nombre=" + nombre + ", contra=" + contra + ", tecnologia=" + tecnologia + ", genero=" + genero + ", ocupacion=" + ocupacion + '}';
    }
    
}
