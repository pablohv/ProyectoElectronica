/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.ProductoDto;
import java.sql.*;
import java.util.*;

/**
 *
 * @author acer
 */
public interface ProductoDao {

    public List<ProductoDto> listar();

    public List<ProductoDto> listarNombre();

    public void actualizarCompra(int id, int cantidad);
    
    public boolean actualizarVenta(int id, int cantidad);

    public void agregarProducto(ProductoDto producto);

    public ProductoDto obtenerProducto(String id);

    public void actualizarProducto(ProductoDto producto_actualizado);

    public void eliminar(String id);
}
