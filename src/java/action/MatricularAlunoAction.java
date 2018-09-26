/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Aluno;
import persistence.AlunoDao;

/**
 *
 * @author YanNotebook
 */
public class MatricularAlunoAction implements Action {

    public MatricularAlunoAction() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer id = Integer.parseInt(request.getParameter("id"));

        try {
            RequestDispatcher dispachante = request.getRequestDispatcher("WEB-INF/index.jsp");
            if (id != null) {
                Aluno aux = AlunoDao.getInstance().getAlunoByID(id);
                int ultimmoEstado = AlunoDao.getInstance().getMementos(id).getPosicaoEstadosSalvos();
                String novoEstado = AlunoDao.getInstance().getMementos(id).getEstadosSalvos().get(ultimmoEstado).toString();
                aux.setMatriculado();
                if (!(aux.getStado().equals(novoEstado))) {
                    AlunoDao.getInstance().saveEstado(id, aux.getStado());
                }
            }
            request.setAttribute("alunos", AlunoDao.getInstance().getAlunosBanco());

            dispachante.forward(request, response);

        } catch (SQLException ex) {
            response.sendRedirect("erroAoCadastrar.jsp");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FormarAlunoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
