package classes;

import java.util.ArrayList;

//APLIQUE SINGLETON NESTA CLASSE

public class DataBase {
    
    private static DataBase instance;
    private ArrayList<Aluno> alunos;
    private ArrayList<Professor> professores;
    private ArrayList<Curso> cursos;
    private ArrayList<Turma> turmas;

    private DataBase() {
       alunos = new ArrayList<>();
        professores = new ArrayList<>();
       cursos = new ArrayList<>();
     turmas = new ArrayList<>();
}

public static DataBase getInstance() {
    if (instance == null) {
        instance = new DataBase();
    }
    return instance;
}

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public ArrayList<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(ArrayList<Professor> professores) {
        this.professores = professores;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }

    public ArrayList<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(ArrayList<Turma> turmas) {
        this.turmas = turmas;
    }
}
