/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.AlunoDao;

/**
 *
 * @author yan
 */
class IndexCommand implements Command {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
                RequestDispatcher dispachante = request.getRequestDispatcher("/index.jsp");
                request.setAttribute("alunos",
                        AlunoDao.getInstance().getAlunosBanco());      
                dispachante.forward(request, response);
         
        }

    }

}
