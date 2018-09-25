<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../Cabecalho/cabecalhojsp.jsp" %>
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
    <tbody>
        <c:forEach var="aluno" items="${alunos}">
            <tr>
                <td>${aluno.getId()}</td>
                <td>${aluno.getNome()}</td>
                <td>${aluno.getMatricula()}</td>
                <td>${aluno.getStado()}</td>
                <td>
                    <form action="FrontController?action=MatricularAluno" method="post">
                        <input name= "Matricular" value="matricular" type="submit"/>
                        <input type="hidden" name="id" value="${aluno.getId()}">
                    </form>
                    <form action="FrontController?action=TrancarAluno" method="post">
                        <input name= "Trancar" value="Trancar" type="submit"/>
                        <input type="hidden" name="id" value="${aluno.getId()}">
                    
                    </form>
                    <form action="FrontController?action=FormarAluno" method="post">
                        <input name= "Formar" value="Formar" type="submit"/>
                        <input type="hidden" name="id" value="${aluno.getId()}">
                    
                    </form>
                    <form action="FrontController?action=VoltarAluno" method="post">
                        <input name= "btnVoltar"  value="Voltar" type="submit"/>
                        <input type="hidden" name="id" value="${aluno.getId()}">
                    </form>
                    <form action="FrontController?action=AvancarAluno" method="post">
                        <input name= "btnAvancar"  value="Avancar" type="submit"/>
                        <input type="hidden" name="id" value="${aluno.getId()}">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<%@include file="../Cabecalho/rodape.jspf" %>
