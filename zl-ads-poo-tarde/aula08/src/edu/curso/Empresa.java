package edu.curso;

public class Empresa { 

    private Funcionario f1 = new Funcionario("Kleber");
    private Funcionario f2 = new Funcionario("Julia");
    private Funcionario f3 = new Funcionario("Leandro");

    private RH rh = new RH();

    private RH rh2 = new RH();

    public void fazerPagamento() {
        rh.setBonus(1.4);
        rh2.setBonus(1.2);
        
        rh.fazerPagamento( f1, 5000.0 );
        rh.fazerPagamento( f1, 5500.0 );
        rh.fazerPagamento( f1, 5500.0 );
        rh2.fazerPagamento( f1, 5000.0 );
        rh2.fazerPagamento( f1, 5500.0 );
        rh2.fazerPagamento( f1, 5500.0 );

        System.out.println("RH Bonus: " + rh.getBonus());
        System.out.println("RH2 Bonus: " + rh2.getBonus());   
    }

    public static void main(String[] args) { 
        Empresa emp = new Empresa();
        emp.fazerPagamento();
    }
}