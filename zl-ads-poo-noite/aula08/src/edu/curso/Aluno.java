package edu.curso;

public class Aluno { 
    public String ra;
    public final static double notaParaPassar = 6.0;

    public void matricular() { 
        System.out.println("Matriculando aluno com RA: " + this.ra );
    }

    public static void dormir() { 
        System.out.println("Aluno esta dormindo");
    }
}