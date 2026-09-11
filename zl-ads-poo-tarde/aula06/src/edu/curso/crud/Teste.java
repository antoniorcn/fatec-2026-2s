package edu.curso.crud;

import java.time.LocalDate;

public class Teste { 
    public static void main(String[] args) {
        Aluno a1 = new Aluno(1, "Joao Silva", "1111", LocalDate.of(2004, 9, 30));
        Aluno a2 = new Aluno(2, "Maria Silva", "2222", LocalDate.of(2005, 4, 17));

        System.out.println("Aluno 1: " + a1);
        System.out.println("Aluno 2: " + a2);
    }
}