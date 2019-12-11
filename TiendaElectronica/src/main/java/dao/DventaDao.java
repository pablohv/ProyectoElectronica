/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.detalleVentaDto;
import java.sql.*;
import java.util.*;

/**
 *
 * @author acer
 */
public interface DventaDao {

    public List<detalleVentaDto> listarVentas();

    public void agregarVenta(detalleVentaDto venta);
}
