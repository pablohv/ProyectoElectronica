/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import dao.AlmacenDao;
import dto.AlmacenDto;
import java.sql.*;
import java.util.*;

/**
 *
 * @author acer
 */
public class AlmacenDaoImpl implements AlmacenDao {

    private final String SQL_LISTAR = "SELECT * FROM almacen";
    private final String SQL_AGREGAR = "INSERT INTO almacen (alnombre, ubicacion, estado) VALUES (?, ?, ?)";
    private final String SQL_OBTENER = "SELECT * FROM almacen WHERE idalmacen=?";
    private final String SQL_ACTUALIZAR = "UPDATE almacen SET alnombre=?, ubicacion=?, estado=? WHERE idalmacen=?";
    private final String SQL_ELIMINAR = "DELETE FROM almacen WHERE idalmacen=?";

    @Override
    public List<AlmacenDto> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<AlmacenDto> listaAlmacen = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_LISTAR);
            rs = stmt.executeQuery();

            while (rs.next()) {
                //se toman los datos de la tabla almacen
                int codigo = rs.getInt("idalmacen");
                String nombre = rs.getString("alnombre");
                String ubicacion = rs.getString("ubicacion");
                String estado = rs.getString("estado");

                //se instancia un objeto de tipo amacen
                AlmacenDto miAlmacen = new AlmacenDto(codigo, nombre, ubicacion, estado);
                //se guarda el objeto en el arraylist
                listaAlmacen.add(miAlmacen);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return listaAlmacen;
    }

    @Override
    public List<AlmacenDto> listarNombre() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<AlmacenDto> listaAlmacen = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_LISTAR);
            rs = stmt.executeQuery();

            while (rs.next()) {
                //se toman los datos de la tabla almacen
                int codigo = rs.getInt("idalmacen");
                String nombre = rs.getString("alnombre");

                //se instancia un objeto de tipo amacen
                AlmacenDto miAlmacen = new AlmacenDto(codigo, nombre);
                //se guarda el objeto en el arraylist
                listaAlmacen.add(miAlmacen);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return listaAlmacen;
    }

    @Override
    public void agregarAlmacen(AlmacenDto almacen) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_AGREGAR);

            stmt.setString(1, almacen.getNombre());
            stmt.setString(2, almacen.getUbicacion());
            stmt.setString(3, almacen.getEstado());

            stmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
    }

    @Override
    public AlmacenDto obtenerAlmacen(String id) {
        AlmacenDto miAlmacen = null;

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
                int idCodigo = rs.getInt("idalmacen");
                String nombre = rs.getString("alnombre");
                String ubicacion = rs.getString("ubicacion");
                String estado = rs.getString("estado");

                miAlmacen = new AlmacenDto(idCodigo, nombre, ubicacion, estado);
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
        return miAlmacen;
    }

    @Override
    public void actualizarAlmacen(AlmacenDto Almacen_Actualizado) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_ACTUALIZAR);
            stmt.setString(1, Almacen_Actualizado.getNombre());
            stmt.setString(2, Almacen_Actualizado.getUbicacion());
            stmt.setString(3, Almacen_Actualizado.getEstado());

            stmt.setInt(4, Almacen_Actualizado.getId());

            stmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
    }

    @Override
    public void eliminarAlmacen(String id) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_ELIMINAR);
            stmt.setString(1, id);
            stmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
    }
}
