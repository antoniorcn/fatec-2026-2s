package edu.curso;

public class Teste { 

    public static void main(String[] args) { 
        System.out.println("Inicio do programa");
        Aluno aluno1 = new Aluno();
        Animal a1 = new Animal(10.0);
        Animal a2 = new Animal(20.0);
        Pessoa p1 = new Pessoa("Joao", "1111");
        Pessoa p2 = new Pessoa("Maria", "2222");
        System.out.println("Fim do programa");
    }
}