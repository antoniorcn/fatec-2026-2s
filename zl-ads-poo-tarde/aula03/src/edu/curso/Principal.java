package edu.curso;

public class Principal { 

    
    public static void main(String[] args) { 
        Aluno a1 = new Aluno();
        a1.ra = "0001";
        a1.nome = "Joao Silva"; 

        Aluno a2 = new Aluno();
        a2.ra = "0002";
        a2.nome = "Maria Silva";

        a1.estudar();
        a2.estudar();    

    }

}