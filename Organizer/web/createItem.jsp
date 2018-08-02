<%@page import="java.util.ArrayList"%>
<%@page import="br.cefetmg.inf.organizer.model.domain.User"%>
<%@page import="br.cefetmg.inf.organizer.model.service.impl.KeepTag"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id='tagItem' class='java.util.ArrayList' scope="page"/>
<jsp:useBean class="br.cefetmg.inf.organizer.model.domain.User" id="userSessao" scope="page" ></jsp:useBean>
<%userSessao = (User) request.getSession().getAttribute("user");%>

<html>
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
        <div class="page-container">
            <!-- Menu lateral -->
            <div class="page-sidebar">
                <ul class="x-navigation">
                    <li class="xn-logo">
                        <a href="#">Organizer</a>
                        <a href="#" class="x-navigation-control"></a>
                    </li>
                    <li class="xn-profile">
                        <a href="#" class="profile-mini">
                            <img src="imgs/icon.jpg" />
                        </a>
                        <div class="profile">
                            <div class="profile-image">
                                <img src="imgs/icon.jpg"/>
                            </div>
                            <div class="profile-data">
                                <div class="profile-data-name">Nome do UsuÃ¡rio</div>
                                <div class="profile-data-title">email_usuario@gmail.com</div>
                            </div>
                        </div>
                    </li>
                    <li>
                        <a href="#"><span class="fa fa-comments"></span> <span class="xn-text">Falar com o MAX</span></a>
                    </li>
                    <li class="xn-openable">
                        <a href="#"><span class="fa fa-adjust"></span> <span class="xn-text">Temas</span></a>
                        <ul>
                            <li><a href="#">
                              <label class="container">Tema 1
                                <input type="radio" name="tema" value="tema1">
                                <span class="checkmark"></span>
                              </label>
                            </a></li>
                            <li><a href="#">
                              <label class="container">Tema 2
                                <input type="radio" name="tema" value="tema2">
                                <span class="checkmark"></span>
                              </label>
                            </a></li>
                            <li><a href="#">
                              <label class="container">Tema 3
                                <input type="radio" name="tema" value="tema3">
                                <span class="checkmark"></span>
                              </label>
                            </a></li>
                        </ul>
                    </li>
                    <li class="xn-openable">
                        <a href="#"><span class="fa fa-file-text-o"></span> <span class="xn-text">Tipos</span></a>
                        <ul>
                            <li><a href="#">
                              <label class="container">Simples
                                <input type="checkbox" name="tipo" value="simples">
                                <span class="checkmarkSimples"></span>
                              </label>
                            </a></li>
                            <li><a href="#">
                              <label class="container">Tarefa
                                <input type="checkbox" name="tipo" value="tarefa">
                                <span class="checkmarkTarefa"></span>
                              </label>
                            </a></li>
                            <li><a href="#">
                              <label class="container">Lembrete
                                <input type="checkbox" name="tipo" value="lembrete">
                                <span class="checkmarkLembrete"></span>
                              </label>
                            </a></li>
                        </ul>
                    </li>
                    <li class="xn-openable">
                        <a href="#"><span class="fa fa-tag"></span> <span class="xn-text">Tags</span></a>
                        <ul id="ulTagMenu">
                            <li><a href="#" id="novaTag">
                              <span class="fa fa-plus-square-o"></span> <span class="xn-text">Nova Tag</span>
                            </a></li>
                            <li><a href="#">
                              <label class="container">Tag 1
                                <input type="checkbox" name="tag" value="Tag 1">
                                <span class="checkmarkTarefa"></span>
                              </label>
                            </a></li>
                            <li><a href="#">
                              <label class="container">Tag 2
                                <input type="checkbox" name="tag" value="Tag 2">
                                <span class="checkmarkTarefa"></span>
                              </label>
                            </a></li>
                            <li><a href="#">
                              <label class="container">Tag 3
                                <input type="checkbox" name="tag" value="Tag 3">
                                <span class="checkmarkTarefa"></span>
                              </label>
                            </a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="configuracoes.html"><span class="fa fa-cogs"></span> <span class="xn-text">ConfiguraÃ§Ãµes</span></a>
                    </li>
                    <li>
                        <a href="#" id="logout"><span class="fa fa-sign-out"></span> <span class="xn-text">Sair</span></a>
                    </li>
                </ul>
            </div>

            <!-- Menu Horizontal -->
            <div class="page-content">
                <ul class="x-navigation x-navigation-horizontal x-navigation-panel">
                    <li class="xn-icon-button">
                        <a href="#" class="x-navigation-minimize"><span class="fa fa-dedent"></span></a>
                    </li>

                    <!-- Pesquisa -->
                    <li class="xn-search">
                        <form role="form">
                            <input type="text" name="pesquisar" placeholder="Perquisar..."/>
                        </form>
                    </li>
                </ul>

                <div class="page-content-wrap">

                    <div class="row">
                        <div class="col-md-12">
                          <p></p>
                          <!-- Form -->
                          <form class="form-horizontal" action="/organizer/servletcontroller?process=CreateItem" method="post">

                        <div class="panel panel-default">

                            <div class="panel-body">

                              <h1 style="text-align:center">Criar Item</h1>

                              <div class="form-group">
                                  <label class="col-md-3 col-xs-12 control-label">Tipo: </label>
                                  <div class="col-md-6 col-xs-12">
                                      <select class="form-control select" id="selectOfItemType" name="selectType">
                                          <option value="SIM">Simples</option>
                                          <option value="LEM">Lembrete</option>
                                          <option value="TAR">Tarefa</option>
                                      </select>
                                  </div>
                              </div>

                              <div class="form-group">
                                    <label class="col-md-3 col-xs-12 control-label">Nome: </label>
                                    <div class="col-md-6 col-xs-12">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="fa fa-pencil"></span></span>
                                            <input type="text" class="form-control" name="nameItem" required/>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-3 col-xs-12 control-label">Descrição: </label>
                                    <div class="col-md-6 col-xs-12">
                                      <textarea class="form-control" rows="5" name="descriptionItem"></textarea>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-3 col-xs-12 control-label">Data: </label>
                                    <div class="col-md-6 col-xs-12">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="fa fa-calendar"></span></span>
                                            <input type="date" class="form-control" name="dateItem" id="dateOfItem" readonly>
                                        </div>
                                        <span class="help-block" id="helpItem">Itens de tipo simples não possuem data.</span>
                                    </div>
                                </div>

                                <div class="form-group">
                                      <label class="col-md-3 col-xs-12 control-label">Tags: </label>
                                      <div class="col-md-6 col-xs-12">
                                          <div class="input-group">
                                              <span class="input-group-addon"><span class="fa fa-tag"></span></span>
                                              <input id="tags" type="text" class="form-control" data-toggle="modal" data-target="#tagsModal" name="inputTag" readonly/>
                                          </div>
                                      </div>
                                  </div>

                              <button class="btn btn-primary pull-right" type="submit">Criar</button>
                            </div>
                        </div>
                        </form>

                        </div>
                    </div>

                </div>
            </div>
        </div>

  <!-- Modal de Inserir Tags durante a criação de um item-->
  <div class="modal fade" id="tagsModal" role="dialog">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Adicionar Tags:</h4>
        </div>
        <div class="modal-body">
          <div class="form-group">
                <label>Selecionados: </label>
                    <div class="input-group">
                        <span class="input-group-addon"><span class="fa fa-tag"></span></span>
                        <input id="tagSelected" type="text" class="form-control" disabled>
                    </div>
          </div>
          <hr>
          <label>Existentes: </label>
          <div class="container-fluid">
            <div class="panel panel-default">
                <div class="panel-body" id="scroll">
                  <ul id="ulTags">
                     
                      <%
                       KeepTag keepTag = new KeepTag();
                       tagItem = keepTag.listAlltag(userSessao);
                       
                       pageContext.setAttribute("list", tagItem);
                      %>
                      
                    <c:forEach	items='${list}' var='listTag' >
                      <c:if test="${listTag.tagName != 'Concluidos'}">
                        <li>&nbsp #${listTag.tagName}
                          <input type="checkbox" class="checkTags" value='${listTag.tagName}'>
                        </li>
                      </c:if>
                    </c:forEach> 
                    </ul>
                </div>
            </div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" class="close" data-dismiss="modal">Cancelar</button>
            <button type="button" class="btn btn-primary" onclick="insertTagsOnInput()" class="close" data-dismiss="modal">OK</button>
          </div>
          </div>
        </div>
      </div>

    </div>
  </div>

  <!-- Modal de Inserir Tags no menu-->
  <div class="modal fade" id="tagsMenu" role="dialog">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Adicionar Tags:</h4>
        </div>
        <div class="modal-body">
          <div class="form-group">
                <label>Nome: </label>
                    <div class="input-group">
                        <span class="input-group-addon"><span class="fa fa-tag"></span></span>
                        <input type="text" class="form-control">
                    </div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" >Cancelar</button>
            <button type="button" class="btn btn-primary">OK</button>
          </div>
          </div>
        </div>
      </div>

    </div>

    <!-- Modal de logout-->
    <div class="modal fade" id="logoutModal" role="dialog">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h4 class="modal-title">Logout:</h4>
          </div>
          <div class="modal-body">
           <form method="post" action="/organizer/servletcontroller?process=UserLogout">
               <p>Até logo! Deseja sair da sua conta? </p>
               <div class="modal-footer">
                 <button type="button" class="btn btn-secondary" >Cancelar</button>
                 <button class="btn btn-primary">Sair</button>
               </div>
           </form>
            </div>
          </div>
        </div>
      </div>

        <!-- Importação dos Scripts -->
        <script type="text/javascript" src="js/plugins/jquery/jquery.min.js"></script>
        <script type="text/javascript" src="js/plugins/jquery/jquery-ui.min.js"></script>
        <script type="text/javascript" src="js/plugins/bootstrap/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/plugins.js"></script>
        <script type="text/javascript" src="js/actions.js"></script>
        <script type="text/javascript" src="js/script.js"></script>
        <script type="text/javascript" src="js/tagMenu.js"></script>
        <script type="text/javascript" src="js/configuracoes.js"></script>
        <script type="text/javascript" src="js/tags.js"></script>
                  
    </body>
</html>
