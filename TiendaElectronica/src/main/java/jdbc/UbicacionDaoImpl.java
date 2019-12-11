/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import dao.UbicacionDao;
import dto.UbicacionDto;
import java.sql.*;
import java.util.*;

/**
 *
 * @author acer
 */
public class UbicacionDaoImpl implements UbicacionDao {

    private final String SQL_LISTAR = "SELECT * FROM VI_KarCab";
    private final String SQL_AGREGAR = "INSERT INTO kardex VALUES (?, ?)";
    private final String SQL_ELIMINAR = "DELETE FROM kardex WHERE idproducto=? and idalmacen=?";

    @Override
    public List<UbicacionDto> lista() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<UbicacionDto> ubicaciones = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_LISTAR);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idP = rs.getInt("idproducto");
                String nomP = rs.getString("nombre");
                double costo = rs.getDouble("costo");
                int idAl = rs.getInt("idalmacen");
                String alnom = rs.getString("alnombre");
                String ubi = rs.getString("ubicacion");

                UbicacionDto ubica = new UbicacionDto(idP, nomP, costo, idAl, alnom, ubi);
                ubicaciones.add(ubica);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return ubicaciones;
    }

    @Override
    public void agregarUbicacion(String idPro, String idAlm) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_AGREGAR);

            stmt.setString(1, idPro);
            stmt.setString(2, idAlm);

            stmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
    }

    @Override
    public void eliminarUbicacion(String idProducto, String idAlmacen) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_ELIMINAR);
            stmt.setString(1, idProducto);
            stmt.setString(2, idAlmacen);
            stmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
    }
}