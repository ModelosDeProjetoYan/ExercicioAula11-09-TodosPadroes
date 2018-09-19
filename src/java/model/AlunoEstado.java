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
public interface AlunoEstado {
    public void setMatriculado(Aluno a);
    public void setTrancado(Aluno a);
    public void setFormado(Aluno a);
    public String getStado();
    
}
