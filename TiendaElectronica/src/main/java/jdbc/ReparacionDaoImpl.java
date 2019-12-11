/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import dao.ReparacionDao;
import dto.ReparacionDto;
import java.sql.*;
import java.util.*;

/**
 *
 * @author acer
 */
public class ReparacionDaoImpl implements ReparacionDao {

    private final String SQL_LISTAR = "SELECT * FROM reparaciones WHERE fechaentrega IS NOT NULL OR fechaentrega <> ''";
    private final String SQL_AGREGAR = "INSERT INTO reparaciones (fecha, nombre, aparato, descripcion, costo) VALUES (?, ?, ?, ?, ?)";
    private final String SQL_LISTARPROCESO = "SELECT * FROM reparaciones WHERE fechaentrega IS NULL OR fecha = ''";
    private final String SQL_OBTENER = "SELECT * FROM reparaciones WHERE idreparaciones=?";
    private final String SQL_ACTUALIZAR = "UPDATE reparaciones SET fechaentrega=?, entregoa=? WHERE idreparaciones=?";

    @Override
    public List<ReparacionDto> listadoReparaciones() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ReparacionDto> reparaciones = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_LISTAR);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idreparaciones");
                String fechaRe = rs.getString("fecha");
                String nombre = rs.getString("nombre");
                String apa = rs.getString("aparato");
                String des = rs.getString("descripcion");
                int cos = rs.getInt("costo");
                String fechaen = rs.getString("fechaentrega");
                String entrego = rs.getString("entregoa");

                ReparacionDto reparacion = new ReparacionDto(id, fechaRe, nombre, apa, des, cos, fechaen, entrego);
                reparaciones.add(reparacion);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return reparaciones;
    }

    @Override
    public void agregarReparacion(ReparacionDto reparar) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_AGREGAR);

            stmt.setString(1, reparar.getFechaEntrada());
            stmt.setString(2, reparar.getNombre());
            stmt.setString(3, reparar.getAparato());
            stmt.setString(4, reparar.getDescripcion());
            stmt.setInt(5, reparar.getCosto());

            stmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
    }

    @Override
    public List<ReparacionDto> listadoenproceso() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ReparacionDto> proceso = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_LISTARPROCESO);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idreparaciones");
                String fechaRe = rs.getString("fecha");
                String nombre = rs.getString("nombre");
                String apa = rs.getString("aparato");
                String des = rs.getString("descripcion");
                int cos = rs.getInt("costo");

                ReparacionDto reparacion = new ReparacionDto(id, fechaRe, nombre, apa, des, cos);
                proceso.add(reparacion);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return proceso;
    }

    @Override
    public ReparacionDto obtenerReparacion(String id) {
        ReparacionDto reparacion = null;

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
                int idRep = rs.getInt("idreparaciones");
                String fechaEntrada = rs.getString("fecha");
                String nombre = rs.getString("nombre");
                String aparato = rs.getString("aparato");
                String descripcion = rs.getString("descripcion");
                int costo = rs.getInt("costo");
                String fechaSalida = rs.getString("fechaentrega");
                String nombreRecoge = rs.getString("entregoa");

                reparacion = new ReparacionDto(idRep, fechaEntrada, nombre, aparato, descripcion, costo, fechaSalida, nombreRecoge);
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
        return reparacion;
    }

    @Override
    public void actualizarReparacion(ReparacionDto reparacion) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_ACTUALIZAR);

            stmt.setString(1, reparacion.getFechaSalida());
            stmt.setString(2, reparacion.getNombreRecoge());

            stmt.setInt(3, reparacion.getIdRep());

            stmt.execute();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
    }

}
