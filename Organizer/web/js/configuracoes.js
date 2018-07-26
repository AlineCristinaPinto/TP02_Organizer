$(function() {
  $(".perfil").click(function() {
    $("#trocarImgPerfil").modal();
  });

  $("#excluiConta").click(function() {
    $("#excluirModal").modal();
  });

  $("#logout").click(function() {
    $("#logoutModal").modal();
  });
})
