package com.biscoito.waffer;
import java.util.Random;

public class Relatorio { 

    public static void main(String[] args){
        StringBuffer relatorio = new StringBuffer("Relatório do Grupo Biscoito\n\n\n");

        int dias = 30;
        int meses = 6;
        int empresas = 1000;

        System.out.println("Calculando o relatório...");
        Random rnd = new Random();
        for (int empresa = 1; empresa <= empresas; empresa++){ 
            for (int mes = 1; mes <= meses; mes++){ 
                for (int dia = 1; dia <= dias; dia++){ 
                    int valor = rnd.nextInt(1000, 100000);
                    String texto = String.format("Mes: %d  Dia: %d  Valor: R$ %d,00\n", 
                            mes, dia, valor);
                    relatorio.append(texto);
                }
            }
        }

        System.out.println(relatorio.toString());

    }

}