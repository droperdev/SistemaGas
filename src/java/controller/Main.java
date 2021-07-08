/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
import dto.DetalleDTO;
import dto.ProductoDTO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.cliente.Cliente;
import model.cliente.ClienteDAOImpl;
import model.direccion.Direccion;
import model.direccion.DireccionDAOImpl;
import model.marca.Marca;
import model.marca.MarcaDAOImpl;
import model.pedido.Pedido;
import model.pedido.PedidoDAOImpl;
import model.pedidoDetalle.PedidoDetalle;
import model.pedidoDetalle.PedidoDetalleDAOImpl;
import model.producto.Producto;
import model.producto.ProductoDAOImpl;

/**
 *
 * @author droperdev
 */
@WebServlet(name = "Main", urlPatterns = {"/Main"})
public class Main extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session;
        String action = request.getParameter("action");

        switch (action) {
            case "registrarCliente": {
                int nroDoc = Integer.parseInt(request.getParameter("nroDoc"));
                String nombre = request.getParameter("nombre");
                String celular = request.getParameter("celular");
                String correo = request.getParameter("correo");

                String address = request.getParameter("direccion");
                String referencia = request.getParameter("referencia");

                Double latitud = Double.parseDouble(request.getParameter("latitud"));
                Double longitud = Double.parseDouble(request.getParameter("longitud"));

                Cliente cliente = new Cliente(nroDoc, nombre, celular, correo);

                new ClienteDAOImpl().registrarCliente(cliente);

                Direccion direccion = new Direccion(nroDoc, address, referencia, latitud, longitud);
                int direccionId = new DireccionDAOImpl().registrarDireccion(direccion);
                write(response, new Id(nroDoc, direccionId));

                break;
            }
            case "obtenerProductos": {
                int marcaId = Integer.parseInt(request.getParameter("marcaId"));
                List<ProductoDTO> productos = new ProductoDAOImpl().obtenerProductos(marcaId);
                write(response, productos);
                break;
            }
            case "agregarDetalle": {
                session = request.getSession();
                int cantidad = Integer.parseInt(request.getParameter("cantidad"));
                String marca = request.getParameter("marca");
                double precio = Double.parseDouble(request.getParameter("precio"));
                String producto = request.getParameter("producto");
                int productoId = Integer.parseInt(request.getParameter("productoId"));

                List<DetalleDTO> detalles;
                Object object = session.getAttribute("detalles");
                if (object != null) {
                    detalles = (List) object;
                    DetalleDTO detalle = new DetalleDTO(cantidad, productoId, marca + " - " + producto, precio);

                    int index = obtenerPosicionSiExiste(detalles, detalle);
                    if (index != -1) {
                        detalles.get(index).setCantidad(detalles.get(index).getCantidad() + detalle.getCantidad());
                    } else {
                        detalles.add(detalle);
                    }
                    session.setAttribute("detalles", detalles);
                } else {
                    detalles = new ArrayList();
                    DetalleDTO detalle = new DetalleDTO(cantidad, productoId, marca + " - " + producto, precio);
                    detalles.add(detalle);
                    session.setAttribute("detalles", detalles);
                }
                write(response, true);
                break;
            }
            case "marcas":
                response.sendRedirect("marcas.jsp");
                break;
            case "registrarMarca": {
                String nombreMarca = request.getParameter("nombre");
                String fotoUrl = request.getParameter("fotoUrl");

                Marca marca = new Marca(nombreMarca, fotoUrl);
                new MarcaDAOImpl().registrarMarca(marca);
                response.sendRedirect("marcas.jsp");
                break;
            }
            case "eliminarMarca": {
                int marcaId = Integer.parseInt(request.getParameter("marcaId"));
                new MarcaDAOImpl().eliminarMarca(marcaId);
                response.sendRedirect("marcas.jsp");
                break;
            }
            case "actualizarMarca": {
                int marcaId = Integer.parseInt(request.getParameter("marcaId"));
                String nombre = request.getParameter("nombre");
                String fotoUrl = request.getParameter("fotoUrl");
                Marca marca = new Marca(marcaId, nombre, fotoUrl);
                new MarcaDAOImpl().actualizarMarca(marca);
                response.sendRedirect("marcas.jsp");
                break;
            }
            case "productos":
                response.sendRedirect("productos.jsp");
                break;
            case "registrarProducto": {
                int marcaId = Integer.parseInt(request.getParameter("marcaId"));
                String nombre = request.getParameter("nombre");
                String descripcion = request.getParameter("descripcion");
                String fotoUrl = request.getParameter("fotoUrl");
                int stock = Integer.parseInt(request.getParameter("stock"));
                double precio = Double.parseDouble(request.getParameter("precio"));

                Producto producto = new Producto(marcaId, nombre, descripcion, fotoUrl, stock, precio);

                new ProductoDAOImpl().registrarProducto(producto);
                response.sendRedirect("productos.jsp");
                break;
            }
            case "actualizarProducto": {
                int productoId = Integer.parseInt(request.getParameter("productoId"));
                String nombre = request.getParameter("nombre");
                String descripcion = request.getParameter("descripcion");
                String fotoUrl = request.getParameter("fotoUrl");
                int stock = Integer.parseInt(request.getParameter("stock"));
                double precio = Double.parseDouble(request.getParameter("precio"));

                Producto producto = new Producto();
                producto.setId(productoId);
                producto.setNombre(nombre);
                producto.setDescripcion(descripcion);
                producto.setFotoUrl(fotoUrl);
                producto.setStock(stock);
                producto.setPrecio(precio);

                new ProductoDAOImpl().actualizarProducto(producto);
                response.sendRedirect("productos.jsp");
                break;
            }
            case "eliminarProducto": {
                int productoId = Integer.parseInt(request.getParameter("productoId"));
                new ProductoDAOImpl().eliminarProducto(productoId);
                response.sendRedirect("productos.jsp");
                break;
            }
            case "pedidos":
                response.sendRedirect("pedidos.jsp");
                break;
            case "registrarPedido": {
                session = request.getSession();
                int nroDoc = Integer.parseInt(request.getParameter("nroDoc"));
                int direccionId = Integer.parseInt(request.getParameter("direccionId"));
                int metodoPagoId = Integer.parseInt(request.getParameter("metodoPagoId"));
                int comprobanteId = Integer.parseInt(request.getParameter("comprobanteId"));
                int tipoPedidoId = Integer.parseInt(request.getParameter("tipoPedidoId"));

                Pedido pedido = new Pedido(
                        nroDoc, direccionId, 1, comprobanteId, tipoPedidoId, metodoPagoId);

                int pedidoId = new PedidoDAOImpl().registrarPedido(pedido);

                List<DetalleDTO> detalles = (List) session.getAttribute("detalles");
                PedidoDetalle pedidoDetalle;
                for (int i = 0; i < detalles.size(); i++) {
                    pedidoDetalle = new PedidoDetalle();
                    pedidoDetalle.setPedidoId(pedidoId);
                    pedidoDetalle.setProductoId(detalles.get(i).getProductoId());
                    pedidoDetalle.setCantidad(detalles.get(i).getCantidad());
                    pedidoDetalle.setPrecio(detalles.get(i).getPrecio());

                    new PedidoDetalleDAOImpl().registrarDetalle(pedidoDetalle);
                }
                session.removeAttribute("detalles");

                response.sendRedirect("pedidos.jsp");
                break;
            }
            case "historial":
                response.sendRedirect("historial.jsp");
                break;

            case "asignar":
                int pedidoId = Integer.parseInt(request.getParameter("pedidoId"));
                int repartidorId = Integer.parseInt(request.getParameter("repartidorId"));
                PedidoDAOImpl pedidoDAO = new PedidoDAOImpl();
                pedidoDAO.asignarRepartidor(pedidoId, repartidorId);
                pedidoDAO.cambiarEstado(pedidoId);
                response.sendRedirect("pedidos.jsp");
                break;
            case "estado":
                pedidoId = Integer.parseInt(request.getParameter("pedidoId"));
                new PedidoDAOImpl().cambiarEstado(pedidoId);
                response.sendRedirect("pedidos.jsp");
                break;
            case "anular":
                pedidoId = Integer.parseInt(request.getParameter("pedidoId"));
                new PedidoDAOImpl().anularPedido(pedidoId);
                response.sendRedirect("pedidos.jsp");
                break;
            case "logout":
                session = request.getSession();
                session.removeAttribute("usuario");
                response.sendRedirect("index.jsp");
                break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void write(HttpServletResponse response, Object object) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(object));
    }

    private int obtenerPosicionSiExiste(List<DetalleDTO> detalles, DetalleDTO detalle) {
        int index = -1;
        for (int i = 0; i < detalles.size(); i++) {
            if (detalles.get(i).getProductoId() == detalle.getProductoId()) {
                index = i;
                break;
            }
        }
        return index;
    }

    public class Id {

        private int nroDoc;
        private int direccionId;

        public Id(int nroDoc, int direccionId) {
            this.nroDoc = nroDoc;
            this.direccionId = direccionId;
        }

    }

}
