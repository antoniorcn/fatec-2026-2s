package com.apex.exp;

import java.util.Random;

public class TesteStringBuffer { 

    public static void main(String[] args) { 
        Random rnd = new Random();
        System.out.println("Sistema de Exportação");
        int empresas = 1000;
        int meses = 6;
        int dias = 30;       

        StringBuffer relatorio = new StringBuffer("");
        for (int empresa = 1; empresa <= empresas; empresa++){ 
            for (int mes = 1; mes <= meses; mes++){ 
                for (int dia = 1; dia <= dias; dia++ ){
                    int valor = rnd.nextInt(1000, 100000);
                    String linha = String.format(
                            "Empresa: %d  Mes: %d Dia: %d exportado US$ %9.2f\n", 
                            empresa, mes, dia, (float)valor);
                    relatorio.append(linha);
                }
            }
        }
        System.out.println( relatorio );

    }
}