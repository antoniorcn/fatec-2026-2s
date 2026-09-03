package edu.curso.crud;
import java.time.LocalDate;
import java.util.Scanner;

public class Crud { 

    private Scanner input = new Scanner(System.in);

    public void menu() { 
        System.out.println("M E N U  C R U D  A L U N O S");
        System.out.println("(C)riar");
        System.out.println("(L)istar todos");
        System.out.println("(A)tualizar");
        System.out.println("(R)emover");
        System.out.println("(S)air");

        System.out.println("Digite uma opcao valida: ");

        String resposta = input.nextLine().toUpperCase();
        if (resposta.length() > 0) { 
            char opcao = resposta.charAt(0);

            if (opcao == 'C') { 
                cadastrar();
            }
        }
    }

    public void cadastrar() { 
        System.out.println("Digite o RA do aluno: ");
        String ra = input.nextLine();
        System.out.println("Digite o Nome do aluno: ");
        String nome = input.nextLine();

        Aluno a = new Aluno();
        a.setRa( ra );
        a.setNome( nome );
    }

    public static void main(String[] args) { 

        Crud crud = new Crud();
        crud.menu();

    }
}