$(function() {
  
  $(".btOption").click(function() {
      let idItem = $(this).attr('id');
      document.querySelector("#takeId").value=idItem;
      document.querySelector("#takeIdU").value=idItem;
  });

  $(".delItem").click(function() {
      let formRegister = document.querySelector("#deleteItem");
      formRegister.action = "/organizer/servletcontroller?process=DeleteItem";
      formRegister.submit();
  });
  
  $(".checkTar").click(function() {
      let idItem = $(this).attr('id');
      document.querySelector("#takeId").value=idItem;
      let formRegister = document.querySelector("#deleteItem");
      formRegister.action = "/organizer/servletcontroller?process=DeleteItem";
      formRegister.submit();
  });

  $(".edit").click(function() {
      //let formRegister = document.querySelector("#updateItem");
      //formRegister.action = "/organizer/servletcontroller?process=";
      //formRegister.submit();
  });

})
