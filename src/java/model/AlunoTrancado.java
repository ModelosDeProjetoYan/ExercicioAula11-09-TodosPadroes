/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author YanNotebook
 */
public class AlunoTrancado implements AlunoEstado{
    public void setMatriculado(Aluno a) {
        a.setStatus(new AlunoMatriculado());
    }

    @Override
    public void setTrancado(Aluno a) {
    }


    @Override
    public void setFormado(Aluno a) {
    
    }

    @Override
    public String getStado() {
        return "Trancado";
    }
    
}
