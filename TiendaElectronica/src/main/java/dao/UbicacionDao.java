/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.UbicacionDto;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author acer
 */
public interface UbicacionDao {

    public List<UbicacionDto> lista();

    public void agregarUbicacion(String idPro, String idAlm);

    public void eliminarUbicacion(String idProducto, String idAlmacen);
}
