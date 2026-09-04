package edu.curso;

public class Pessoa extends Animal { 
    String nome;
    String cpf;

    public Pessoa(String nome, String cpf) { 
        super( 20.0 );
        System.out.println("Criando uma Pessoa....");
        this.nome = nome;
        this.cpf = cpf;
    }

    public Pessoa() {
        this("Anonimo", "0000");
    }

}