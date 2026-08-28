package com.biscoito.waffer;

public class FolhaPagamento { 

    // public double pagar(double salario, double vt, double vr) { 
    //     double total = salario + vt + vr;
    //     return total;
    // }

    // public double pagar(double salario, double vt, double vr, double bonus) { 
    //     double total = salario + vt + vr + bonus;
    //     return total;
    // }

    public double pagar(double salario, double ... beneficios) { 
        double total = salario;
        for (int i = 0; i < beneficios.length; i++){ 
            double ben = beneficios[i];
            total = total + ben;
        }
        return total;
    }


    public static void main(String[] args) { 
        FolhaPagamento fp = new FolhaPagamento();
        double totalMiguel = fp.pagar( 4000.0, 500.0, 300.0);
        System.out.println("Miguel ganha: R$" + totalMiguel);
        double totalGabriel = fp.pagar( 4000.0, 300.0, 500.0, 300.0 );
        System.out.println("Gabriel ganha: R$" + totalGabriel);

    }

}