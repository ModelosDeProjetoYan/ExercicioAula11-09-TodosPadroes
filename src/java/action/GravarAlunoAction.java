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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Aluno;
import persistence.AlunoDao;
/**
 *
 * @author YanNotebook
 */
public class GravarAlunoAction implements Action {

    public GravarAlunoAction() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("textNome");
        String matricula = request.getParameter("textMatricula");
        if (nome.equals("") || matricula.equals("")) {
            response.sendRedirect("Cadastrojsp.jsp");
        } else {
            try {
                Aluno aluno = new Aluno();
                aluno.setMatricula(matricula);
                aluno.setNome(nome);
                AlunoDao.getInstance().save(aluno);
                response.sendRedirect("index.jsp");
            } catch (SQLException ex) {
                response.sendRedirect("erroAoCadastrar.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(GravarAlunoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
