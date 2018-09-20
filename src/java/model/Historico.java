/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author yan
 */
public class Historico {
    
    private ArrayList<AlunoMemento> estadosSalvos = new ArrayList<>();
    private static int id;

    public Historico(int id) {
        this.id=id;
    }

    
    public ArrayList<AlunoMemento> getEstadosSalvos() {
        return estadosSalvos;
    }

    public void setEstadosSalvos(AlunoMemento estadosSalvos) {
        this.estadosSalvos.add(estadosSalvos);
    }

    public static int getId() {
        return id;
    }  
    
}
