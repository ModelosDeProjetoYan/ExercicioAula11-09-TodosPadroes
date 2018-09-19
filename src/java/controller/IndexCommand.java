/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Aluno;
import persistence.AlunoDao;

/**
 *
 * @author yan
 */
class IndexCommand implements Command {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
                RequestDispatcher dispachante = request.getRequestDispatcher("WEB-INF/index.jsp");
                ArrayList<Aluno> alunos = new ArrayList<>();
                alunos =AlunoDao.getInstance().getAlunosBanco(); 
                request.setAttribute("alunos",
                         alunos);      
                dispachante.forward(request, response);
         
        }

    }

}
