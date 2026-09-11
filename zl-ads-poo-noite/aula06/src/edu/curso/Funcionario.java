package edu.curso;

public class Funcionario { 

    String cargo;
    double salario;

    public Funcionario( String cargo, double salario ) { 
        this.cargo = cargo;
        this.salario = salario;
    }

    public void receberPagamento( double valor ) { 
        System.out.println("Eba recebi " + valor);
    }

}