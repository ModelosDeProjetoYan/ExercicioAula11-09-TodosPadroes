/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Aluno;
import action.ActionFactoryState;
import model.AlunoEstado;
import model.AlunoMemento;
import model.Historico;

/**
 *
 * @author YanNotebook
 */
public class AlunoDao {

    private static AlunoDao instance = new AlunoDao();
    private ArrayList<Historico> mementos = new ArrayList<>();
    private AlunoEstado action = null;

    private AlunoDao() {
    }

    public static AlunoDao getInstance() {
        return instance;
    }

    public void save(Aluno aluno) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();

            st.execute("insert into USUARIO (NOME, MATRICULA, SITUACAO)"
                    + " values ('" + aluno.getNome() + "','"
                    + aluno.getMatricula() + "','" + aluno.getStado() + "')");

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResoucers(conn, st);
        }
    }

    public void saveEstado(int id, String estado) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.executeUpdate("update USUARIO set SITUACAO = '" + estado
                    + "' where(id = " + id + ")");
            mementos.get(testaSePossuiHistorico(id))
                    .setEstadosSalvos(
                            new AlunoMemento(action = ActionFactoryState.create(estado)));
            mementos.get(testaSePossuiHistorico(id)).setPosicaoEstadosSalvos(
            mementos.get(testaSePossuiHistorico(id)).getPosicaoEstadosSalvos()+1);
            for(int i=mementos.get(testaSePossuiHistorico(id)).getEstadosSalvos().size()-1;
                    i > mementos.get(testaSePossuiHistorico(id)).getPosicaoEstadosSalvos();
                    i--){
                mementos.get(testaSePossuiHistorico(id)).getEstadosSalvos().remove(i);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResoucers(conn, st);
        }
    }

    public ArrayList<Aluno> getAlunosBanco() {
        ArrayList alunos = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        ResultSet resultado;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            resultado = st.executeQuery("select * from USUARIO");
            while (resultado.next()) {
                Aluno a = new Aluno();
                a.setId(resultado.getInt("ID"));
                a.setStatus(action
                        = ActionFactoryState.create(resultado.getString("SITUACAO")));
                a.setMatricula(resultado.getString("MATRICULA"));
                a.setNome(resultado.getString("NOME"));
                alunos.add(a);
                if (testaSePossuiHistorico(resultado.getInt("ID")) == mementos.size()) {
                    Historico h = new Historico(resultado.getInt("ID"));
                    h.setEstadosSalvos(a.saveToMemento());
                    mementos.add(h);
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
        } finally {
            closeResoucers(conn, st);
        }
        return alunos;
    }

    public int testaSePossuiHistorico(int id) {
        int i=0;
        while(i < mementos.size() && mementos.get(i).getId() != id){
            i++;
        }
        return i;
    }

    public Historico getMementos(int id) {
        return mementos.get(testaSePossuiHistorico(id));
    }

    private void closeResoucers(Connection conn, Statement st) {
        try {
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }

        } catch (SQLException e) {

        }

    }

    public void atualizaEstatus(Integer id, int i) throws ClassNotFoundException, SQLException {
        AlunoMemento a;
        Integer elemento = mementos.get(testaSePossuiHistorico(id)).getPosicaoEstadosSalvos();
        Connection conn = null;
        Statement st = null;
        if (i == -1) {
            if (elemento != null && elemento > 0) {
                a = mementos.get(testaSePossuiHistorico(id)).getEstadosSalvos().get(elemento - 1);
                mementos.get(testaSePossuiHistorico(id)).setPosicaoEstadosSalvos(elemento - 1);
                try {
                    conn = DatabaseLocator.getInstance().getConnection();
                    st = conn.createStatement();
                    st.executeUpdate("update USUARIO set SITUACAO = '" + a.toString()
                            + "' where(id = " + id + ")");

                } catch (SQLException e) {
                    throw e;
                } finally {
                    closeResoucers(conn, st);
                }
            }
        } else if(i == 1){
            if (elemento != null && elemento >= 0 && 
                    elemento < mementos.get(testaSePossuiHistorico(id)).getEstadosSalvos().size()-1) {
                a = mementos.get(testaSePossuiHistorico(id)).getEstadosSalvos().get(elemento+1);
                mementos.get(testaSePossuiHistorico(id)).setPosicaoEstadosSalvos(elemento+1);
                try {
                    conn = DatabaseLocator.getInstance().getConnection();
                    st = conn.createStatement();
                    st.executeUpdate("update USUARIO set SITUACAO = '" + a.toString()
                            + "' where(id = " + id + ")");

                } catch (SQLException e) {
                    throw e;
                } finally {
                    closeResoucers(conn, st);
                }
            }
        }else{
            
        
        }
    }
}
