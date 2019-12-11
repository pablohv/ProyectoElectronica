/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.ReparacionDto;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author acer
 */
public interface ReparacionDao {

    public List<ReparacionDto> listadoReparaciones();

    public void agregarReparacion(ReparacionDto reparar);
    
    public List<ReparacionDto> listadoenproceso();

    public ReparacionDto obtenerReparacion(String id);

    public void actualizarReparacion(ReparacionDto reparacion);
}
