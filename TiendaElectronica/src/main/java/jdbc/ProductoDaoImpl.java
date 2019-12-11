/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import dao.ProductoDao;
import dto.ProductoDto;
import java.sql.*;
import java.util.*;

/**
 *
 * @author acer
 */
public class ProductoDaoImpl implements ProductoDao {

    private final String SQL_LISTAR = "SELECT * FROM productos";
    private final String SQL_AGREGAR = "INSERT INTO productos (nombre, costo, cantidad) VALUES (?, ?, ?)";
    private final String SQL_CANTIDAD = "SELECT cantidad FROM productos WHERE idproductos = ?";
    private final String SQL_ACTUALIZARCANTIDAD = "UPDATE productos SET cantidad=? WHERE idproductos=?";
    private final String SQL_OBTENER = "SELECT * FROM productos WHERE idproductos=?";
    private final String SQL_ACTUALIZAR = "UPDATE productos SET nombre=?, costo=?, cantidad=? WHERE idproductos=?";
    private final String SQL_ELIMINAR = "DELETE FROM productos WHERE idproductos=?";

    @Override
    public List<ProductoDto> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ProductoDto> productos = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_LISTAR);
            rs = stmt.executeQuery();

            while (rs.next()) {
                //se toman los datos de la tabla almacen
                int codigo = rs.getInt("idproductos");
                String nombre = rs.getString("nombre");
                Double costo = rs.getDouble("costo");
                int cantidad = rs.getInt("cantidad");

                //se instancia un objeto de tipo amacen
                ProductoDto producto = new ProductoDto(codigo, nombre, costo, cantidad);
                //se guarda el objeto en el arraylist
                productos.add(producto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return productos;
    }

    @Override
    public List<ProductoDto> listarNombre() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ProductoDto> productos = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_LISTAR);
            rs = stmt.executeQuery();

            while (rs.next()) {
                //se toman los datos de la tabla almacen
                int codigo = rs.getInt("idproductos");
                String nombre = rs.getString("nombre");

                //se instancia un objeto de tipo amacen
                ProductoDto producto = new ProductoDto(codigo, nombre);
                //se guarda el objeto en el arraylist
                productos.add(producto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return productos;
    }

    @Override
    public void actualizarCompra(int id, int cantidad) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        int nueva_Cantidad = 0;
        int cantidad_Pro = 0;
        int cantidad_compra = cantidad;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_CANTIDAD);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                cantidad_Pro = rs.getInt("cantidad");
            }

            nueva_Cantidad = cantidad_Pro + cantidad_compra;

            stmt = conn.prepareStatement(SQL_ACTUALIZARCANTIDAD);
            stmt.setInt(1, nueva_Cantidad);
            stmt.setInt(2, id);
            stmt.execute();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
    }

    @Override
    public boolean actualizarVenta(int id, int cantidad) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean cantidadAceptada = false;

        int nueva_Cantidad = 0;
        int cantidad_Pro = 0;
        int cantidad_venta = cantidad;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_CANTIDAD);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                cantidad_Pro = rs.getInt("cantidad");
            }

            nueva_Cantidad = cantidad_Pro - cantidad_venta;

            if (nueva_Cantidad >= 0) {
                stmt = conn.prepareStatement(SQL_ACTUALIZARCANTIDAD);
                stmt.setInt(1, nueva_Cantidad);
                stmt.setInt(2, id);
                stmt.execute();
                cantidadAceptada = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cantidadAceptada;
    }

    @Override
    public void agregarProducto(ProductoDto producto) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_AGREGAR);

            stmt.setString(1, producto.getNombre());
            stmt.setDouble(2, producto.getCosto());
            stmt.setInt(3, producto.getCantidad());

            stmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
    }

    @Override
    public ProductoDto obtenerProducto(String id) {
        ProductoDto producto = null;

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String elCodigo = id;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_OBTENER);
            stmt.setString(1, elCodigo);
            rs = stmt.executeQuery();

            if (rs.next()) {
                int idCodigo = rs.getInt("idproductos");
                String nombre = rs.getString("nombre");
                Double costo = rs.getDouble("costo");
                int cantidad = rs.getInt("cantidad");

                producto = new ProductoDto(idCodigo, nombre, costo, cantidad);
            } else {
                throw new SQLException("No se ah encontrado el producto" + elCodigo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return producto;
    }

    @Override
    public void actualizarProducto(ProductoDto producto_actualizado) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_ACTUALIZAR);
            stmt.setString(1, producto_actualizado.getNombre());
            stmt.setDouble(2, producto_actualizado.getCosto());
            stmt.setInt(3, producto_actualizado.getCantidad());

            stmt.setInt(4, producto_actualizado.getId());

            stmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
    }

    @Override
    public void eliminar(String id) {
        Connection conn = null;
        PreparedStatement stmt = null;

        String codigo = id;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_ELIMINAR);
            stmt.setString(1, codigo);
            stmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
    }

}
