package classes;

public class Inativo implements EstadoSemestre {
    @Override
    public void adicionarObservador(Semestre semestre, IObserver observer) {
        System.out.println("Erro: Não é possível adicionar observadores em um semestre inativo.");
    }
}
