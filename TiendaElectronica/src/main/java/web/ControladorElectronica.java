/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import jdbc.*;
import dao.*;
import dto.*;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UsuarioDao;
import java.util.*;

/**
 *
 * @author acer
 */
@WebServlet(name = "ControladorElectronica", urlPatterns = {"/ControladorElectronica"})
public class ControladorElectronica extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String elParametro = request.getParameter("instruccion");

        switch (elParametro) {
            //esto tiene que ver con el login
            case "validar":
                validarSesion(request, response);
                break;
            //esto tiene que ver con el almacen
            case "listar_Almacen":
                listar_Almacen(request, response);
                break;
            case "agregar_Almacen":
                agregar_Almacen(request, response);
                break;
            case "cargar_Almacen":
                cargar_Almacen(request, response);
                break;
            case "actualizar_Almacen":
                actualizar_Almacen(request, response);
                break;
            case "eliminar_Almacen":
                eliminar_Almacen(request, response);
                break;
            //esto tiene que ver con los productos
            case "listar_Producto":
                listar_Producto(request, response);
                break;
            case "agregar_Producto":
                agregar_Producto(request, response);
                break;
            case "cargar_Producto":
                cargar_Producto(request, response);
                break;
            case "actualizar_Producto":
                actualizar_Producto(request, response);
                break;
            case "eliminar_Producto":
                eliminar_Producto(request, response);
                break;
            // esto es para las ubicaciones
            case "listar_ubicacion":
                listar_ubicacion(request, response);
                break;
            case "cargar_Ubicaciones":
                cargar_Ubicaciones(request, response);
                break;
            case "agregar_Ubicaciones":
                agregar_Ubicaciones(request, response);
                break;
            case "eliminar_Ubicacion":
                eliminar_Ubicacion(request, response);
                break;
            // squi empiezan las compras
            case "listar_Compras":
                listar_Compras(request, response);
                break;
            case "cargar_Compras":
                cargar_Compras(request, response);
                break;
            case "agregar_Compras":
                agregar_Compras(request, response);
                break;
            //aqui empiezan las ventas
            case "listar_Ventas":
                listar_Ventas(request, response);
                break;
            case "cargar_Ventas":
                cargar_Ventas(request, response);
                break;
            case "agregar_Ventas":
                agregar_Ventas(request, response);
                break;
            // esto es para reparaciones 
            case "listar_Reparaciones":
                listar_Reparaciones(request, response);
                break;
            case "agregar_Reparacion":
                agregar_Reparacion(request, response);
                break;
            case "listar_Repenproceso":
                listar_Repenproceso(request, response);
                break;
            case "obtener_Repenproceso":
                obtener_Repenproceso(request, response);
                break;
            case "actualizar_estatus":
                actualizar_estatus(request, response);
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void validarSesion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //se leen los parametros del login
        String usuarioForm = request.getParameter("usuario");
        String passForm = request.getParameter("password");

        //creamos un usuario
        UsuarioDto user = new UsuarioDto(usuarioForm, passForm);

        //creamos un booleano para saber si es valido
        UsuarioDao userDao = new UsuarioDaoImpl();

        //esta variable tendra la respuesta del metodo
        boolean usuarioValido = userDao.existeUsuario(user);
        //si el metodo es true entonces nos mnadara a la siguiente pagina 
        if (usuarioValido) {
            //si el usuario es encontrado en la base de datos nos mande al menu 
            RequestDispatcher miDis = request.getRequestDispatcher("/menu.jsp");
            miDis.forward(request, response);
        } else {
            //sino es encontrado nos recarga el index
            RequestDispatcher miDis = request.getRequestDispatcher("/index.jsp");
            miDis.forward(request, response);
        }

    }

    private void listar_Almacen(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //instanciamos el modelo
        AlmacenDao almacenDao = new AlmacenDaoImpl();
        // se meten los datos a un arraylist
        List<AlmacenDto> datosAlmacen = almacenDao.listar();
        // el array list se manda a la ventana donde se solicita
        request.setAttribute("almacen", datosAlmacen);
        //vamos hacia la pagina 
        RequestDispatcher miDis = request.getRequestDispatcher("/Listado_Almacen.jsp");
        miDis.forward(request, response);
    }

    private void agregar_Almacen(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String ubicacion = request.getParameter("ubicacion");
        String estado = request.getParameter("estado");

        AlmacenDao modelo = new AlmacenDaoImpl();

        AlmacenDto miAlmacen = new AlmacenDto(nombre, ubicacion, estado);
        modelo.agregarAlmacen(miAlmacen);

        this.listar_Almacen(request, response);

    }

    private void cargar_Almacen(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id_Almacen");
        AlmacenDao modelo = new AlmacenDaoImpl();
        AlmacenDto almacen = modelo.obtenerAlmacen(id);

        request.setAttribute("AlmacenActualizar", almacen);
        RequestDispatcher miDis = request.getRequestDispatcher("/Actualizar_Almacen.jsp");
        miDis.forward(request, response);

    }

    private void actualizar_Almacen(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("codigo"));
        String nombre = request.getParameter("nombre");
        String ubicacion = request.getParameter("ubicacion");
        String estado = request.getParameter("estado");

        AlmacenDto almacen_Act = new AlmacenDto(id, nombre, ubicacion, estado);
        AlmacenDao modelo = new AlmacenDaoImpl();
        modelo.actualizarAlmacen(almacen_Act);

        listar_Almacen(request, response);

    }

    private void eliminar_Almacen(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String codigo = request.getParameter("id_Almacen");

        AlmacenDao modelo = new AlmacenDaoImpl();
        modelo.eliminarAlmacen(codigo);

        listar_Almacen(request, response);

    }

    private void listar_Producto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductoDao modelos = new ProductoDaoImpl();

        // se meten los datos a un arraylist
        List<ProductoDto> productos = modelos.listar();
        // el array list se manda a la ventana donde se solicita
        request.setAttribute("producto", productos);
        //vamos hacia la pagina 
        RequestDispatcher miDis = request.getRequestDispatcher("/listado_Productos.jsp");
        miDis.forward(request, response);

    }

    private void agregar_Producto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        Double costo = Double.parseDouble(request.getParameter("costo"));
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));

        ProductoDao modelo = new ProductoDaoImpl();

        ProductoDto producto = new ProductoDto(nombre, costo, cantidad);
        modelo.agregarProducto(producto);
        listar_Producto(request, response);

    }

    private void cargar_Producto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id_Producto");

        ProductoDao modelo = new ProductoDaoImpl();
        ProductoDto producto = modelo.obtenerProducto(id);
        request.setAttribute("obtenProducto", producto);
        RequestDispatcher miDis = request.getRequestDispatcher("/actualizar_Productos.jsp");
        miDis.forward(request, response);

    }

    private void actualizar_Producto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("codigo"));
        String nombre = request.getParameter("nombre");
        Double costo = Double.parseDouble(request.getParameter("costo"));
        int cant = Integer.parseInt(request.getParameter("cantidad"));

        ProductoDao modelo = new ProductoDaoImpl();
        ProductoDto pro = new ProductoDto(id, nombre, costo, cant);
        modelo.actualizarProducto(pro);

        listar_Producto(request, response);

    }

    private void eliminar_Producto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id_Producto");

        ProductoDao modelo = new ProductoDaoImpl();
        modelo.eliminar(id);

        listar_Producto(request, response);

    }

    private void listar_ubicacion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UbicacionDao modelo = new UbicacionDaoImpl();

        List<UbicacionDto> misUbicaciones = modelo.lista();
        request.setAttribute("ubicate", misUbicaciones);
        RequestDispatcher miDis = request.getRequestDispatcher("/listado_Ubicacion.jsp");
        miDis.forward(request, response);

    }

    private void cargar_Ubicaciones(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductoDao modelo = new ProductoDaoImpl();
        AlmacenDao modeloAl = new AlmacenDaoImpl();

        List<ProductoDto> producto = modelo.listarNombre();
        List<AlmacenDto> almacen = modeloAl.listarNombre();
        request.setAttribute("productoLista", producto);
        request.setAttribute("almacenLista", almacen);
        RequestDispatcher miDis = request.getRequestDispatcher("/agregar_Ubicacion.jsp");
        miDis.forward(request, response);

    }

    private void agregar_Ubicaciones(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idPro = request.getParameter("producto");
        String idAlm = request.getParameter("almacen");

        UbicacionDao modelo = new UbicacionDaoImpl();
        modelo.agregarUbicacion(idPro, idAlm);
        listar_ubicacion(request, response);

    }

    private void eliminar_Ubicacion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idPr = request.getParameter("id_Producto");
        String idAl = request.getParameter("id_Almacen");

        UbicacionDao modelo = new UbicacionDaoImpl();
        modelo.eliminarUbicacion(idPr, idAl);
        listar_ubicacion(request, response);

    }

    private void listar_Compras(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DcompraDao modelo = new DcompraDaoImpl();
        List<detalleCompraDto> compras = modelo.listar();
        request.setAttribute("compras", compras);
        RequestDispatcher miDis = request.getRequestDispatcher("/listado_Compra.jsp");
        miDis.forward(request, response);

    }

    private void cargar_Compras(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ProductoDao modelo = new ProductoDaoImpl();
        List<ProductoDto> producto = modelo.listarNombre();
        request.setAttribute("productoLista", producto);
        RequestDispatcher miDis = request.getRequestDispatcher("/agregar_Compra.jsp");
        miDis.forward(request, response);

    }

    private void agregar_Compras(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idProducto = Integer.parseInt(request.getParameter("producto"));
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        String fechat = request.getParameter("fecha");

        // agregamos la compra a la base de dtaos
        DcompraDao modelo = new DcompraDaoImpl();
        ProductoDao modelo2 = new ProductoDaoImpl();

        detalleCompraDto compra = new detalleCompraDto(idProducto, cantidad, fechat);
        modelo.agregarDcompra(compra);
        //agregamos la cantidad total que hay en la tabla de productos
        modelo2.actualizarCompra(idProducto, cantidad);
        //listamoslas compras
        listar_Compras(request, response);

    }

    private void listar_Ventas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DventaDao modelo = new DventaDaoImpl();
        List<detalleVentaDto> ventas = modelo.listarVentas();
        request.setAttribute("ventillas", ventas);
        RequestDispatcher miDis = request.getRequestDispatcher("/listado_Ventas.jsp");
        miDis.forward(request, response);

    }

    private void cargar_Ventas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ProductoDao modelo = new ProductoDaoImpl();
        List<ProductoDto> producto = modelo.listarNombre();
        request.setAttribute("productoLista", producto);
        RequestDispatcher miDis = request.getRequestDispatcher("/agregar_Venta.jsp");
        miDis.forward(request, response);

    }

    private void agregar_Ventas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mensaje = "";

        int idProducto = Integer.parseInt(request.getParameter("producto"));
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        String fechat = request.getParameter("fecha");

        DventaDao modelo = new DventaDaoImpl();
        ProductoDao modelo2 = new ProductoDaoImpl();

        detalleVentaDto venta = new detalleVentaDto(idProducto, cantidad, fechat);
        // corroborar que se tiene disponible la cantidad de elementos 
        if (modelo2.actualizarVenta(idProducto, cantidad)) {
            //si hay la cantidad solicidata entonces registramos la venta y listamos
            modelo.agregarVenta(venta);
            listar_Ventas(request, response);
        } else {
            mensaje = "No hay disponibles " + cantidad;
            request.setAttribute("mensaje", mensaje);
            cargar_Ventas(request, response);
        }

    }

    private void listar_Reparaciones(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ReparacionDao modelo = new ReparacionDaoImpl();
        List<ReparacionDto> reparaciones = modelo.listadoReparaciones();
        request.setAttribute("reparacionesTerminadas", reparaciones);
        RequestDispatcher miDis = request.getRequestDispatcher("/listado_Reparaciones.jsp");
        miDis.forward(request, response);

    }

    private void agregar_Reparacion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fecha = request.getParameter("fecha");
        String nombre = request.getParameter("nombre");
        String aparato = request.getParameter("aparato");
        String descripcion = request.getParameter("descripcion");
        int costo = Integer.parseInt(request.getParameter("costo"));

        ReparacionDao modelo = new ReparacionDaoImpl();
        ReparacionDto reparar = new ReparacionDto(fecha, nombre, aparato, descripcion, costo);

        modelo.agregarReparacion(reparar);

        listar_Reparaciones(request, response);

    }

    private void listar_Repenproceso(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ReparacionDao modelo = new ReparacionDaoImpl();
        List<ReparacionDto> reparaciones = modelo.listadoenproceso();
        request.setAttribute("reparacionesProceso", reparaciones);
        RequestDispatcher miDis = request.getRequestDispatcher("/listado_Reproceso.jsp");
        miDis.forward(request, response);

    }

    private void obtener_Repenproceso(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String codigo = request.getParameter("id_Reparacion");

        ReparacionDao modelo = new ReparacionDaoImpl();
        ReparacionDto reparacion = modelo.obtenerReparacion(codigo);
        request.setAttribute("repareishon", reparacion);
        RequestDispatcher miDis = request.getRequestDispatcher("/actualizar_Reparacion.jsp");
        miDis.forward(request, response);

    }

    private void actualizar_estatus(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fecha = request.getParameter("fecha");
        String nombre = request.getParameter("nombre");
        int id = Integer.parseInt(request.getParameter("codigo"));

        ReparacionDao modelo = new ReparacionDaoImpl();
        ReparacionDto reparacion = new ReparacionDto(id, fecha, nombre);
        modelo.actualizarReparacion(reparacion);
        listar_Reparaciones(request, response);

    }
}
