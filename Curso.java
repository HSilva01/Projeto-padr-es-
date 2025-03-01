package classes;

public class Curso {

    private String nomeCurso;
    private String totalSemestre;
    private Professor coordenador; 

    
    public Curso() {
    }

    public Curso(String nomeCurso, String totalSemestre) {
        this.nomeCurso = nomeCurso;
        this.totalSemestre = totalSemestre;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getTotalSemestre() {
        return qtdSemestre;
    }

    public void setTotalSemestre(String totalSemestre) {
        this.qtdSemestre = totalSemestre;
    }

    public void vincularCoordenador(Professor professor) {
        this.coordenador = professor;
        System.out.println("Coordenador vinculado com sucesso: " + professor.getNome());
    }

    public Professor getCoordenador() {
        return coordenador;
    }
}
