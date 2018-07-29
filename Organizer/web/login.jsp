<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="br.cefetmg.inf.organizer.controller.UserValidation"%>

<c:if test="${UserValidation.validate(request,response)}"> 
    <jsp:forward page="index.jsp"></jsp:forward>
</c:if>

<html class="body-full-height">
    <head>
        <title>Organizer</title>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="stylesheet" type="text/css" href="css/theme-default.css"/>
        <link rel="stylesheet" href="css/styles.css">
    </head>
    <body>

        <div class="login-container">

            <div class="login-box animated fadeInDown">
                <div class="login-logo"></div>
                <div class="login-body">
                    <div class="login-title"><strong>Bem Vindo(a) ao Organizer!</strong></div>
                    <form id="formLogin" action="/organizer/servletcontroller?process=UserLogin" class="form-horizontal" method="post">
                     <div class="form-group">
                        <div class="col-md-12">
                            <input name="email" type="text" class="form-control" placeholder="Email" required/>
                        </div>
                     </div>
                     <div class="form-group">
                        <div class="col-md-12">
                            <input name="password" type="password" class="form-control" placeholder="Senha" required/>
                        </div>
                     </div>
                     <div class="form-group">
                        <div class="col-md-6">
                            <button class="btn btn-info btn-block">Logar</button>
                        </div>
                     </div>
                    </form>
                    <div class="login-subtitle">
                        Não possui uma conta ainda? <a href="cadastrar.jsp">Crie uma conta</a>
                    </div>
                </div>
            </div>

        </div>

    </body>
</html>
