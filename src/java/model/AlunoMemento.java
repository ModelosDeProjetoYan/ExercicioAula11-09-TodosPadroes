package model;
public class AlunoMemento {
    private AlunoEstado estado;
    

    public AlunoMemento(AlunoEstado estado) {
        this.estado = estado;
    }

    public AlunoEstado getEstadoSalvo() {
        return estado;
    }
    public String toString(){
        return estado.getStado();
    }
}
