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
    $(".modal-dialog").removeClass("modal-lg modal-md").addClass("modal-md");
    $("#MyModalLabel").text("Agregar marca");
    $("#content-modal").load("registrarMarca.jsp");
}

eliminarMarca = (marcaId) => {
    $("#content-modal").empty();
    $("#MyModal").modal('show');
    $(".modal-dialog").removeClass("modal-lg modal-md").addClass("modal-md");
    $("#MyModalLabel").text("Eliminar marca N° " + marcaId);
    $("#content-modal").load("eliminarMarca.jsp", {marcaId});
}

actualizarMarca = (marcaId) => {
    $("#content-modal").empty();
    $("#MyModal").modal('show');
    $(".modal-dialog").removeClass("modal-lg modal-md").addClass("modal-md");
    $("#MyModalLabel").text("Actualizar marca N° " + marcaId);
    $("#content-modal").load("actualizarMarca.jsp", {marcaId});
}

registrarProducto = () => {
    $("#content-modal").empty();
    $("#MyModal").modal('show');
    $(".modal-dialog").removeClass("modal-lg modal-md").addClass("modal-md");
    $("#MyModalLabel").text("Agregar producto");
    $("#content-modal").load("registrarProducto.jsp");
}

eliminarProducto = (productoId) => {
    $("#content-modal").empty();
    $("#MyModal").modal('show');
    $(".modal-dialog").removeClass("modal-lg modal-md").addClass("modal-md");
    $("#MyModalLabel").text("Eliminar producto N° " + productoId);
    $("#content-modal").load("eliminarProducto.jsp", {productoId});
}

actualizarProducto = (productoId) => {
    $("#content-modal").empty();
    $("#MyModal").modal('show');
    $(".modal-dialog").removeClass("modal-lg modal-md").addClass("modal-md");
    $("#MyModalLabel").text("Actualizar producto N° " + productoId);
    $("#content-modal").load("actualizarProducto.jsp", {productoId});
}

abrirBuscarCliente = () => {
    $("#content-modal").empty();
    $("#MyModal").modal('show');
    $(".modal-dialog").removeClass("modal-md modal-lg modal-xl").addClass("modal-md");
    $("#MyModalLabel").text("Buscar cliente");
    $("#content-modal").load("buscarCliente.jsp");
}


buscarCliente = () => {
    var nroDocumento = document.getElementById("nroDocumento").value;
    $("#direcciones").load("direcciones.jsp", {nroDocumento});
}

registrarCliente = () => {
    var nroDocumento = document.getElementById("nroDocumento").value;
    $("#content-modal").empty();
    $("#MyModal").modal('show');
    $(".modal-dialog").removeClass("modal-md").addClass("modal-md");
    $("#MyModalLabel").text("Registrar cliente");
    $("#content-modal").load("registrarCliente.jsp", {nroDocumento});
}

abrirRegistrarPedido = (nroDocumento, direccionId) => {
    $("#content-modal").empty();
    $("#MyModal").modal('show');
    $(".modal-dialog").removeClass("modal-xl").addClass("modal-xl");
    $("#MyModalLabel").text("Agregar pedido");
    $("#content-modal").load("registrarPedido.jsp", {nroDocumento, direccionId});
}

agregarProducto = () => {
    var cantidad = $("#cantidad").val();
    if (cantidad === '') {
        alert("Ingrese una cantidad");
        return
    }
    $("#detalle").empty();
    var productoId = $("select.productos").children("option:selected").val();
    var precio = $("select.productos").children("option:selected").attr('precio');
    var marca = $("select.marcas").children("option:selected").text();
    var producto = $("select.productos").children("option:selected").text();
    $.ajax({
        url: "Main?action=agregarDetalle",
        type: "POST",
        data: {
            cantidad,
            productoId,
            precio,
            marca,
            producto
        },
        dataType: "json",
        success: function (data) {
            $("#detalle").load("registrarDetallePedido.jsp");
            $("#cantidad").val('');
        }
    })

}