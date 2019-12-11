/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import dto.AlmacenDto;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author acer
 */
public interface AlmacenDao {

    public List<AlmacenDto> listar();
    
    public List<AlmacenDto> listarNombre();

    public void agregarAlmacen(AlmacenDto almacen);

    public AlmacenDto obtenerAlmacen(String id);

    public void actualizarAlmacen(AlmacenDto Almacen_Actualizado);

    public void eliminarAlmacen(String id);
}
