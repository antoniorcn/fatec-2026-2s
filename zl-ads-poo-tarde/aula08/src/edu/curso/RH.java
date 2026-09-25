package edu.curso;

public class RH {

    // private static double bonus = 1.0;
    private double bonus = 1.0;

    public void fazerPagamento(Funcionario f, double valor) {
        double pagar = valor * bonus;
        f.receberPagamento( pagar );
    }

    public double getBonus() { 
        // return RH.bonus;
        return this.bonus;
    }

    public void setBonus( double valor ) { 
        // RH.bonus = valor;
        this.bonus = valor;
    }
}