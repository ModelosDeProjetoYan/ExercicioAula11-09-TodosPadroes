<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../Cabecalho/cabecalhojsp.jsp" %>
<h1>Lista de Alunos</h1>
<table border="1">
    <thead>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Matricula</th>
            <th>Situa��o Atual</th>
            <th>Opera��es</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="aluno" items="${alunos}">
            <tr>
                <td>${aluno.getId()}</td>
                <td>${aluno.getNome()}</td>
                <td>${aluno.getMatricula()}</td>
                <td>${aluno.getStado()}</td>
                <td>
                    <form action="FrontController?action=GravarContato" method="post">
                        <input name= "matricular" type="submit"/>
                        <input name= "Trancar" type="submit"/>
                        <input name= "matricular" type="submit"/>
                        <input name= "matricular" type="submit"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<%@include file="../Cabecalho/rodape.jspf" %>
