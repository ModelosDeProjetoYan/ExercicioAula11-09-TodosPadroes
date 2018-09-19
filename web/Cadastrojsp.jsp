<%-- 
    Document   : Cadastrojsp
    Created on : 18/09/2018, 22:58:14
    Author     : yan
--%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@include file="Cabecalho/cabecalhojsp.jsp" %>
<h1>Cadastro de Contatos</h1>
<form action="FrontController?action=GravarAluno" method="post">
    Entre com seu nome
    <input type="text" name="textNome"/><br/>
    Digite sua Matricula
    <input type="text" name="textMatricula"/><br/>
    <input type="submit"/>
</form>
<%@include file="Cabecalho/rodape.jspf" %>
