package edu.curso;

public class Funcionario {
    private String nome;

    public Funcionario( String nome ) { 
        this.nome = nome;
    }

    public void receberPagamento( double pgto ) { 
        System.out.printf("Eu %s recebi R$ %7.2f de pagamento\n", nome, pgto );
    }

}