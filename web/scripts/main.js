/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

abrirDetallePedido = (pedidoId) => {
    console.log(pedidoId);
    $("#content-modal").empty();
    $("#MyModal").modal('show');
    $(".modal-dialog").removeClass("modal-lg").addClass("modal-lg");
    $("#MyModalLabel").text("Detalle de pedido N° " + pedidoId);
    $("#content-modal").load("detallePedido.jsp", {pedidoId});
};

abrirMapa = (pedidoId) => {
    $("#content-modal").empty();
    $("#MyModal").modal('show');
    $(".modal-dialog").removeClass("modal-lg").addClass("modal-lg");
    $("#MyModalLabel").text("Detalle de pedido N° " + pedidoId);
    $("#content-modal").load("mapa.jsp", {pedidoId});
}

asignarPedido = (pedidoId) => {
    $("#content-modal").empty();
    $("#MyModal").modal('show');
    $(".modal-dialog").removeClass("modal-lg").addClass("modal-md");
    $("#MyModalLabel").text("Asignar distribuidor al pedido N° " + pedidoId);
    $("#content-modal").load("asignar.jsp", {pedidoId});
}

cambiarEstado = (pedidoId) => {
    $("#content-modal").empty();
    $("#MyModal").modal('show');
    $(".modal-dialog").removeClass("modal-lg modal-md").addClass("modal-md");
    $("#MyModalLabel").text("Cambio de estado del pedido N° " + pedidoId);
    $("#content-modal").load("cambiarEstado.jsp", {pedidoId});
}

anularPedido = (pedidoId) => {
    $("#content-modal").empty();
    $("#MyModal").modal('show');
    $(".modal-dialog").removeClass("modal-lg modal-md").addClass("modal-md");
    $("#MyModalLabel").text("Anular pedido N° " + pedidoId);
    $("#content-modal").load("anularPedido.jsp", {pedidoId});
}

registrarMarca = () => {
    $("#content-modal").empty();
    $("#MyModal").modal('show');
    $(".modal-dialog").removeClass("modal-lg").addClass("modal-lg");
    $("#MyModalLabel").text("Agregar marca");
    $("#content-modal").load("registrarMarca.jsp");
}

registrarProducto = () => {
    $("#content-modal").empty();
    $("#MyModal").modal('show');
    $(".modal-dialog").removeClass("modal-lg").addClass("modal-lg");
    $("#MyModalLabel").text("Agregar marca");
    $("#content-modal").load("registrarProducto.jsp");
}

registrarPedido = () => {
    $("#content-modal").empty();
    $("#MyModal").modal('show');
    $(".modal-dialog").removeClass("modal-lg").addClass("modal-lg");
    $("#MyModalLabel").text("Agregar marca");
    $("#content-modal").load("registarPedido.jsp");
}