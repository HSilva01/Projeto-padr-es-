package classes;

public class EstudanteTurma {
    private Estudante estudante;
    private Nota nota;

    public EstudanteTurma(){}
    
    public EstudanteTurma(Estudante estudante){
        this.estudante = estudante;
        this.nota = new Nota();
    }

    public EstudanteTurma(Estudante estudante, Nota nota){
        this.estudante = estudante;
        this.nota =nota;
    }

    public Nota getNota(){
        return nota;
    }

    public void setNota(Nota nota){
        this.nota = nota;
    }

    public Estudante getEstudante(){
        return Estudante;
    }

    public void setEstudante(Estudante estudante){
        this.estudante = estudante;
    }
}
