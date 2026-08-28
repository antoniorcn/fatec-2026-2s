package com.apex.exp;

public class FolhaPagamento {

    // public double pagar(double salario, double vt, double vr) { 
    //     double valorSerPago = salario + vt + vr;
    //     return valorSerPago;
    // }

    // public double pagar(double salario, double vt, double vr, double bonus) { 
    //     double valorSerPago = salario + vt + vr + bonus;
    //     return valorSerPago;
    // }

    // public double pagar(double salario, double vt, 
    //                     double vr, double bonus, double salarioFamilia) { 
    //     double valorSerPago = salario + vt + vr + bonus + salarioFamilia;
    //     return valorSerPago;
    // }

    public double pagar(double salario, double ... beneficios ) { 
        double valorSerPago = salario;
        for (int i = 0; i < beneficios.length; i++) {
            valorSerPago += beneficios[i];
        }
        return valorSerPago;
    }

    public static void main(String[] args){ 
        FolhaPagamento fp = new FolhaPagamento();
        double total = fp.pagar( 3500, 300, 600);
        System.out.printf("Total a ser pago R$ %7.2f para o Joao\n", total);
        double total2 = fp.pagar( 3500, 300, 600, 1200);
        System.out.printf("Total a ser pago R$ %7.2f para o Paulo\n", total2);
        double total3 = fp.pagar( 3500, 300, 600, 1200, 100);
        System.out.printf("Total a ser pago R$ %7.2f para a Maria\n", total3);
    }
    
} 