/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.detalleCompraDto;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author acer
 */
public interface DcompraDao {

    public List<detalleCompraDto> listar();

    public void agregarDcompra(detalleCompraDto compras);
}
