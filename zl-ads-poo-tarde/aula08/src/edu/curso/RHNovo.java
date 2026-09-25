package edu.curso;
public class RHNovo extends RH {
    @Override
    public void fazerPagamento(Funcionario f, double valor) {
        double pagar = valor * 1.4;
        f.receberPagamento( pagar );
    }
}