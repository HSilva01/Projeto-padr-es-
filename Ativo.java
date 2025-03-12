package classes;

public class Ativo implements EstadoSemestre {
    @Override
    public void adicionarObservador(Semestre semestre, IObserver observer) {
        semestre.adicionarObservadorPrivado(observer);
    }
}
