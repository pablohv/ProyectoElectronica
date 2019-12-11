/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import dto.UsuarioDto;
import java.sql.*;
import dao.UsuarioDao;

/**
 *
 * @author acer
 */
public class UsuarioDaoImpl implements UsuarioDao {

    private final String SQL_VALIDAR = "SELECT * FROM usuarios WHERE nombre=? AND contra=?";

    @Override
    public boolean existeUsuario(UsuarioDto user) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean existe = false;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_VALIDAR);
            stmt.setString(1, user.getNombre());
            stmt.setString(2, user.getContra());
            rs = stmt.executeQuery();

            if (rs.absolute(1)) {
                existe = true;
            } else {
                existe = false;
            }

        }  catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return existe;
    }

}
