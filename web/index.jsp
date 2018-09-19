<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="Cabecalho/cabecalhojsp.jsp" %>
<h1>Lista de Alunos</h1>
<table border="1">
    <thead>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Matricula</th>
            <th>Situação Atual</th>
            <th>Operações</th>
        </tr>
    </thead>
    <c:forEach var="aluno" items="${alunos}">
        <tbody>
            <tr>
                <td>${aluno.getId()}</td>
                <td>${aluno.getNome()}</td>
                <td>${aluno.getMatricula()}</td>
                <td>${aluno.getStatus()}</td>
                <td>
                    <form action="FrontController?action=GravarContato" method="post">
                        <input name= "matricular" type="submit"/>
                        <input name= "Trancar" type="submit"/>
                        <input name= "matricular" type="submit"/>
                        <input name= "matricular" type="submit"/>
                    </form>
                </td>
            </tr>
        </tbody>
    </table>
</c:forEach>
<%@include file="Cabecalho/rodape.jspf" %>
