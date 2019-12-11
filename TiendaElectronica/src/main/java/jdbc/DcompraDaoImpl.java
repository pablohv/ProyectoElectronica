/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import dao.DcompraDao;
import dto.detalleCompraDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author acer
 */
public class DcompraDaoImpl implements DcompraDao {

    private final String SQL_LISTAR = "SELECT * FROM detallecompra";
    private final String SQL_AGREGAR = "INSERT INTO detallecompra (idproductos, cantidad, fecha) VALUES (?, ?, ?)";

    @Override
    public List<detalleCompraDto> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<detalleCompraDto> compras = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_LISTAR);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idCom = rs.getInt("iddetallecompra");
                int idPro = rs.getInt("idproductos");
                int cant = rs.getInt("cantidad");
                String fech = rs.getString("fecha");

                detalleCompraDto com = new detalleCompraDto(idCom, idPro, cant, fech);
                compras.add(com);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return compras;
    }

    @Override
    public void agregarDcompra(detalleCompraDto compras) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_AGREGAR);

            stmt.setInt(1, compras.getIdPro());
            stmt.setInt(2, compras.getCantidadCom());
            stmt.setString(3, compras.getFechaCom());

            stmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
    }

}
