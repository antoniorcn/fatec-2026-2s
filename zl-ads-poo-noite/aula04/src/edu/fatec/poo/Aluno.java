package edu.fatec.poo;

public class Aluno { 

    String nome = "";
    String ra = "";

    public void exibir() { 
        String texto = String.format("Nome: %s   RA: %s", 
        this.nome, this.ra );
        System.out.println( texto );
    }

    public float calcularMedia( float n1, float n2 ){ 
        float m = (n1 + n2) / 2;
        return m;
    }

}