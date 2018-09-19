<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@include file="Cabecalho/cabecalhojsp.jsp" %>
<h1>Cadastro de Contatos</h1>
<form action="FrontController?action=GravarContato" method="post">
    Entre com seu nome
    <input type="text" name="textNome"/><br/>
    Digite sua senha
    <input type="text" name="textEmail"/><br/>
    <input type="submit"/>
</form>
<%@include file="Cabecalho/rodape.jspf" %>
