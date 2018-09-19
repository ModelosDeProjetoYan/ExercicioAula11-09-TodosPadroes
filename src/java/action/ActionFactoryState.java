/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.*;
import model.AlunoEstado;

/**
 *
 * @author YanNotebook
 */
public class ActionFactoryState {
    public static AlunoEstado create(String action){
        AlunoEstado actionObject = null;
        String nomeClasse = "Aluno"+action;
        Class classe = null;
        Object objeto = null;
        try {
            classe = Class.forName(nomeClasse);
            objeto = classe.newInstance();
        } catch (Exception e) {
            return null;
        }
        if(!(objeto instanceof AlunoEstado)) return null;
        actionObject = (AlunoEstado) objeto;
        return actionObject;
    }
    
}
