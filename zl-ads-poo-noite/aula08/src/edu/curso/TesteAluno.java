package edu.curso;
public class TesteAluno { 
    
    public static void main(String[] args) { 
        Aluno a1 = new Aluno();
        a1.ra = "001";
        Aluno a2 = new Aluno();
        a2.ra = "002";

        // Aluno.notaParaPassar = 5.0;
        // Aluno.notaParaPassar = 7.0;

        System.out.println("Nota para passar A1: " +
                            a1.notaParaPassar);
        System.out.println("Nota para passar A2: " +
                            a2.notaParaPassar);
        a1.matricular();
        a2.matricular();

        Aluno.dormir();
        Aluno.dormir();
    }
}