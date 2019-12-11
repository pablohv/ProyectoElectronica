/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import dao.DventaDao;
import dto.detalleVentaDto;
import java.sql.*;
import java.util.*;

/**
 *
 * @author acer
 */
public class DventaDaoImpl implements DventaDao {

    private final String SQL_LISTAR = "SELECT * FROM detalleventa";
    private final String SQL_AGREGAR = "INSERT INTO detalleventa (idproductos, cantidadventa, fechaventa) VALUES (?, ?, ?)";

    @Override
    public List<detalleVentaDto> listarVentas() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<detalleVentaDto> ventas = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_LISTAR);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idVen = rs.getInt("iddetalleventa");
                int idPro = rs.getInt("idproductos");
                int cantVen = rs.getInt("cantidadventa");
                String fechVen = rs.getString("fechaventa");

                detalleVentaDto venta = new detalleVentaDto(idVen, idPro, cantVen, fechVen);
                ventas.add(venta);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return ventas;
    }

    @Override
    public void agregarVenta(detalleVentaDto venta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_AGREGAR);

            stmt.setInt(1, venta.getIdPro());
            stmt.setInt(2, venta.getCantidad());
            stmt.setString(3, venta.getFechaVen());

            stmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
    }

}
