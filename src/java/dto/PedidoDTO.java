/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.sql.Date;
import model.comprobante.Comprobante;
import model.estado.Estado;
import model.metodoPago.MetodoPago;
import model.tipoPago.TipoPedido;

/**
 *
 * @author droperdev
 */
public class PedidoDTO {

    private int id;
    private ClienteDTO cliente;
    private DireccionDTO direccion;
    private Estado estado;
    private Comprobante comprobante;
    private TipoPedido tipoPedido;
    private MetodoPago metodoPago;
    private UsuarioDTO usuario;
    private Double total;
    private Date createdAt;
    private Date updatedAt;

    public PedidoDTO() {
    }

    @Override
    public String toString() {
        return "PedidoDTO{" + "id=" + id + ", cliente=" + cliente + ", direccion=" + direccion + ", estado=" + estado + ", comprobante=" + comprobante + ", tipoPedido=" + tipoPedido + ", metodoPago=" + metodoPago + ", usuario=" + usuario + ", total=" + total + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public DireccionDTO getDireccion() {
        return direccion;
    }

    public void setDireccion(DireccionDTO direccion) {
        this.direccion = direccion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Comprobante getComprobante() {
        return comprobante;
    }

    public void setComprobante(Comprobante comprobante) {
        this.comprobante = comprobante;
    }

    public TipoPedido getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(TipoPedido tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

}
