package model;

import java.util.ArrayList;
import java.util.Iterator;

public class PadraoMemento {
    public static void main(String[] args) {
        ArrayList<AlunoMemento> estadosSalvos = new ArrayList<>();
        Aluno aluno = new Aluno();
        aluno.setNome("Yan");
        aluno.setStatus(new AlunoTrancado());
        estadosSalvos.add(aluno.saveToMemento());
        aluno.setStatus(new AlunoMatriculado());
        estadosSalvos.add(aluno.saveToMemento());
        aluno.setStatus(new AlunoFormado());
        estadosSalvos.add(aluno.saveToMemento());
        
        /*Padrao Iterator*/
        for(Iterator i= estadosSalvos.iterator();
                i.hasNext();)
            System.out.println(i.next());
        aluno.restoreFormMemento(estadosSalvos.get(1));
        System.out.println(aluno.getStado());
    }
    
}
