/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


cargarProductos = (marcaId) => {
    $(".marca").removeClass("selected");
    $("#marca" + marcaId).addClass("selected");
    $("#productos").load("pcontent.jsp", {marcaId});
};

window.onload = () => {
    cargarProductos(1);
}