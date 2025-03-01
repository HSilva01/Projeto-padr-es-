package classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Apliquei o padrão Singleton para o banco de dados (DataBase)
    static DataBase db;
    static int opcao;
    static Scanner entrada;

    public static void main(String[] args) {
        entrada = new Scanner(System.in);  // Inicializando o Scanner
        db = DataBase.getInstance();       // Inicializando o Singleton DataBase
        menuPrincipal();
        entrada.close();
    }

    public static void menuPrincipal() {
        do {
            System.out.println("╔═════════════════════════════════════════╗");
            System.out.println("║                MENU                     ║");
            System.out.println("╠═════════════════════════════════════════╣");
            System.out.println("║       1 - Menu Coordenador              ║");
            System.out.println("║        2 - Menu Professor               ║");
            System.out.print("Opção: ");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    menuCoordenador();
                    break;
                case 2:
                    menuProfessor();
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    public static void menuCoordenador() {
        System.out.println("Insira a Senha de Coordenador");
        System.out.print("Senha: ");
        opcao = entrada.nextInt();
        if (opcao == db.getSenhaCoordenador()) {
            System.out.println("Senha Correta, Seja Bem-vindo");
        } else {
            menuCoordenador();
        }

        do {
            System.out.println("╔═════════════════════════════════════════╗");
            System.out.println("║                MENU                     ║");
            System.out.println("╠═════════════════════════════════════════╣");
            System.out.println("║     1 - Cadastrar um professor          ║");
            System.out.println("║     2 - Vincular um prof. a turma       ║");
            System.out.println("║     3 - Cadastrar um estudante          ║");
            System.out.println("║     4 - Vincular estud. a turma         ║");
            System.out.println("║     5 - Cadastrar um curso              ║");
            System.out.println("║     6 - Cadastrar uma turma             ║");
            System.out.println("║     7 - Cadastrar um coordenador        ║");
            System.out.println("║  8 - Atribuir notas aos estudantes      ║");
            System.out.println("║     9 - Mostrar a estatística           ║");
            System.out.println("║      10 - Lista de recuperação          ║");
            System.out.println("║          11 - Lista geral               ║");
            System.out.println("║           12 - Histórico                ║");
            System.out.println("║  13 - Exportar Dados do Estudante       ║");
            System.out.println("║           14 - Histórico                ║");
            System.out.println("║             0 - Sair                    ║");
            System.out.println("╚═════════════════════════════════════════╝");
            System.out.print("Opção: ");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarProfessor();
                    break;
                case 2:
                    vincularProfessorTurma();
                    break;
                case 3:
                    cadastrarAluno();
                    break;
                case 4:
                    vincularEstudanteTurma();
                    break;
                case 5:
                    cadastrarCurso();
                    break;
                case 6:
                    cadastrarTurma();
                    break;
                case 7:
                    cadastarCoordenador();
                    break;
                case 8:
                    cadastrarNotas();
                    break;
                case 9:
                    mostrarEstatistica();
                    break;
                case 10:
                    exibirListaRecuperacao();
                    break;
                case 11:
                    exibirListaGeral();
                    break;
                case 12:
                    exibirHistorico();
                    break;
                case 13:
                    exportarDadosEstudante();
                    break;
                case 14:
                    importDadosEstudanteMEC();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    public static void menuProfessor() {
        System.out.println("Insira a Senha de Professor");
        System.out.print("Senha: ");
        opcao = entrada.nextInt();
        if (opcao == db.getSenhaProfessor()) {
            System.out.println("Senha Correta, Seja Bem-vindo");
        } else {
            menuProfessor();
        }

        do {
            System.out.println("╔═════════════════════════════════════════╗");
            System.out.println("║                MENU                     ║");
            System.out.println("╠═════════════════════════════════════════╣");
            System.out.println("║  1 - Atribuir notas aos estudantes      ║");
            System.out.println("║     2 - Mostrar a estatística           ║");
            System.out.println("║      3 - Lista de recuperação           ║");
            System.out.println("║           4 - Histórico                 ║");
            System.out.println("║             0 - Sair                    ║");
            System.out.println("╚═════════════════════════════════════════╝");
            System.out.print("Opção: ");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarNotas();
                    break;
                case 2:
                    mostrarEstatistica();
                    break;
                case 3:
                    exibirListaRecuperacao();
                    break;
                case 4:
                    exibirHistorico();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    public static void cadastarCoordenador() {
        System.out.println("Lista de professores:");
        for (int i = 0; i < db.getProfessores().size(); i++) {
            System.out.printf("%d - %s\n", i + 1, db.getProfessores().get(i).getNome());
        }

        System.out.print("Escolha o professor coordenador: ");
        int escolhaProfessor = entrada.nextInt();

        if (escolhaProfessor < 0 || escolhaProfessor > db.getProfessores().size() - 1) {
            System.out.println("Escolha inválida.");
            return;
        }

        System.out.print("Escolha o curso para vinculá-lo como coordenador: ");
        for (int i = 0; i < db.getCursos().size(); i++) {
            System.out.printf("%d - %s\n", i + 1, db.getCursos().get(i).getNomeCurso());
        }
        int escolhaCurso = entrada.nextInt();

        if (escolhaCurso < 0 || escolhaCurso > db.getCursos().size() - 1) {
            System.out.println("Escolha inválida.");
            return;
        }

        db.getCursos().get(escolhaCurso).vincularCoordenador(db.getProfessores().get(escolhaProfessor));
        System.out.println(db.getProfessores().get(escolhaProfessor).getNome() + " agora é o coordenador.");
    }

    // Abaixo segue o exemplo de algumas classes ausentes que você precisa ajustar ou adicionar ao seu código:

    // Classe Nota
    public static class Nota {
        private double nota1;
        private double nota2;
        private double nota3;
        private double notaRecuperacao;

        public double calcularMedia() {
            return (nota1 + nota2 + nota3) / 3;
        }

        public void verificarSituacao() {
            double media = calcularMedia();
            if (media >= 7) {
                System.out.println("Aprovado");
            } else if (media >= 2.5) {
                System.out.println("Em recuperação");
            } else {
                System.out.println("Reprovado");
            }
        }

        // Getters and setters
        public double getNota1() {
            return nota1;
        }

        public void setNota1(double nota1) {
            this.nota1 = nota1;
        }

        public double getNota2() {
            return nota2;
        }

        public void setNota2(double nota2) {
            this.nota2 = nota2;
        }

        public double getNota3() {
            return nota3;
        }

        public void setNota3(double nota3) {
            this.nota3 = nota3;
        }

        public double getNotaRecuperacao() {
            return notaRecuperacao;
        }

        public void setNotaRecuperacao(double notaRecuperacao) {
            this.notaRecuperacao = notaRecuperacao;
        }
    }

    // Classe Estudante
    public static class Estudante {
        private String nome;
        private String matricula;
        private Nota nota;

        public Estudante(String nome, String matricula) {
            this.nome = nome;
            this.matricula = matricula;
            this.nota = new Nota();
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getMatricula() {
            return matricula;
        }

        public void setMatricula(String matricula) {
            this.matricula = matricula;
        }

        public Nota getNota() {
            return nota;
        }

        public void setNota(Nota nota) {
            this.nota = nota;
        }
    }

    // Classe DataBase com Singleton
    public static class DataBase {
        private static DataBase instance;

        private ArrayList<Estudante> estudantes;
        private ArrayList<Professor> professores;
        private ArrayList<Curso> cursos;
        private int senhaCoordenador;
        private int senhaProfessor;

        private DataBase() {
            estudantes = new ArrayList<>();
            professores = new ArrayList<>();
            cursos = new ArrayList<>();
            senhaCoordenador = 1234;
            senhaProfessor = 5678;
        }

        public static DataBase getInstance() {
            if (instance == null) {
                instance = new DataBase();
            }
            return instance;
        }

        // Getters and setters
        public int getSenhaCoordenador() {
            return senhaCoordenador;
        }

        public int getSenhaProfessor() {
            return senhaProfessor;
        }

        public ArrayList<Estudante> getEstudantes() {
            return estudantes;
        }

        public ArrayList<Professor> getProfessores() {
            return professores;
        }

        public ArrayList<Curso> getCursos() {
            return cursos;
        }
    }

    // Exemplo de classe Professor (adicione conforme necessidade)
    public static class Professor {
        private String nome;

        public Professor(String nome) {
            this.nome = nome;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }
    }

    // Classe Curso (adicione conforme necessidade)
    public static class Curso {
        private String nomeCurso;
        private Professor coordenador;

        public Curso(String nomeCurso) {
            this.nomeCurso = nomeCurso;
        }

        public String getNomeCurso() {
            return nomeCurso;
        }

        public void setNomeCurso(String nomeCurso) {
            this.nomeCurso = nomeCurso;
        }

        public void vincularCoordenador(Professor coordenador) {
            this.coordenador = coordenador;
        }
    }
}
