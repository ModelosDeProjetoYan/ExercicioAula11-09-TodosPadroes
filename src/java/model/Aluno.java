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
public class Aluno {
    private AlunoEstado status;
    private String nome;
    private int id;
    private String matricula;
    public Aluno() {
        status = new AlunoMatriculado();
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
 
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setStatus(AlunoEstado a){
        status = a;
    }
    public void setMatriculado() {
        status.setMatriculado(this);
    }

    public void setTrancado() {
        status.setTrancado(this);
    }


    public void setFormado() {
        status.setFormado(this);
    }

    public String getStado() {
        return status.getStado();
    }
   public AlunoMemento saveToMemento(){
       return new AlunoMemento(status);
   }
   public void restoreFormMemento(AlunoMemento memento){
       status = memento.getEstadoSalvo();
   } 
}
