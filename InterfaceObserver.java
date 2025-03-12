// Interface Observer
package classes;
public interface IObserver {
    void update(boolean estado);
}

// Interface State
package classes;
public interface EstadoSemestre {
    void adicionarObservador(Semestre semestre, IObserver observer);
}

// Estado Ativo
package classes;
import java.util.ArrayList;

public class Ativo implements EstadoSemestre {
    @Override
    public void adicionarObservador(Semestre semestre, IObserver observer) {
        semestre.adicionarObservadorPrivado(observer);
    }
}

// Estado Inativo
package classes;
public class Inativo implements EstadoSemestre {
    @Override
    public void adicionarObservador(Semestre semestre, IObserver observer) {
        System.out.println("Erro: Não é possível adicionar observadores em um semestre inativo.");
    }
}

// Classe Semestre
package classes;
import java.util.ArrayList;

public class Semestre {
    private String nome;
    private EstadoSemestre estado;
    private ArrayList<IObserver> observadores;

    public Semestre(String nome, boolean ativo) {
        this.nome = nome;
        this.observadores = new ArrayList<>();
        this.estado = ativo ? new Ativo() : new Inativo();
    }

    public void setEstado(EstadoSemestre estado) {
        this.estado = estado;
    }

    public void ativar() {
        setEstado(new Ativo());
    }

    public void desativar() {
        setEstado(new Inativo());
    }

    public void adicionarObservador(IObserver observer) {
        estado.adicionarObservador(this, observer);
    }
    
    private void adicionarObservadorPrivado(IObserver observer) {
        observadores.add(observer);
    }

    public ArrayList<IObserver> getObservadores() {
        return observadores;
    }
}
