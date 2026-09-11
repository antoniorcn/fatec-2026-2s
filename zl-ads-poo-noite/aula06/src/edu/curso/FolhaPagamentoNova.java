package edu.curso;

public class FolhaPagamentoNova extends FolhaPagamento { 

    @Override
    public void fazerPagamento( Funcionario f ) { 
        double imposto = f.salario * 0.12;
        double bonus = f.salario * 0.45;
        double pagar = f.salario + bonus - imposto;

        f.receberPagamento( pagar );
    }

}