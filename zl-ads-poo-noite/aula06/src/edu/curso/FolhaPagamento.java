package edu.curso;

public class FolhaPagamento { 

    public void fazerPagamento( Funcionario f ) { 
        double imposto = f.salario * 0.12;
        double bonus = f.salario * 0.3;
        double pagar = f.salario + bonus - imposto;

        f.receberPagamento( pagar );
    }

}