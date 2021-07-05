/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.marca.Marca;
import model.marca.MarcaDAOImpl;
import model.pedido.PedidoDAOImpl;
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

}
