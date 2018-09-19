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
public class MementoRecuperaAction implements Action {

    public MementoRecuperaAction() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("textNome");
        String email = request.getParameter("textSenha");
        if (nome.equals("") || email.equals("")) {
            response.sendRedirect("index.jsp");
        } else {
            try {
                Aluno aluno = new Aluno();
                AlunoDao.getInstance().save(aluno);
                response.sendRedirect("alunoCadastrado.jsp");
            } catch (SQLException ex) {
                response.sendRedirect("erroAoCadastrar.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MementoRecuperaAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
