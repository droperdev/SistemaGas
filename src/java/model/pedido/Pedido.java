/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pedido;

/**
 *
 * @author droperdev
 */
public class Pedido {

    private int Id;
    private int NroDoc;
    private int DireccionId;
    private int EstadoId;
    private int ComprobanteId;
    private int TipoPedidoId;
    private int MetodoPagoId;
    private int RepartidorId;

    public Pedido() {
    }

    public Pedido(int NroDoc, int DireccionId, int EstadoId, int ComprobanteId, int TipoPedidoId, int MetodoPagoId) {
        this.NroDoc = NroDoc;
        this.DireccionId = DireccionId;
        this.EstadoId = EstadoId;
        this.ComprobanteId = ComprobanteId;
        this.TipoPedidoId = TipoPedidoId;
        this.MetodoPagoId = MetodoPagoId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getNroDoc() {
        return NroDoc;
    }

    public void setNroDoc(int NroDoc) {
        this.NroDoc = NroDoc;
    }

    public int getDireccionId() {
        return DireccionId;
    }

    public void setDireccionId(int DireccionId) {
        this.DireccionId = DireccionId;
    }

    public int getEstadoId() {
        return EstadoId;
    }

    public void setEstadoId(int EstadoId) {
        this.EstadoId = EstadoId;
    }

    public int getComprobanteId() {
        return ComprobanteId;
    }

    public void setComprobanteId(int ComprobanteId) {
        this.ComprobanteId = ComprobanteId;
    }

    public int getTipoPedidoId() {
        return TipoPedidoId;
    }

    public void setTipoPedidoId(int TipoPedidoId) {
        this.TipoPedidoId = TipoPedidoId;
    }

    public int getMetodoPagoId() {
        return MetodoPagoId;
    }

    public void setMetodoPagoId(int MetodoPagoId) {
        this.MetodoPagoId = MetodoPagoId;
    }

    public int getRepartidorId() {
        return RepartidorId;
    }

    public void setRepartidorId(int RepartidorId) {
        this.RepartidorId = RepartidorId;
    }

}
