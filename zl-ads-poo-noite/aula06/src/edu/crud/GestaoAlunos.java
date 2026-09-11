 package edu.crud;
import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class GestaoAlunos { 

    private int indice = 0;
    private Aluno[] alunos = new Aluno[1000];
    private Scanner input = new Scanner(System.in);
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void menu() {
        boolean executando = true;      

        while (executando) {
            System.out.println("G E S T A O  D E  A L U N O S");
            System.out.println("Menu de Opcoes");
            System.out.println("(C)riar");
            System.out.println("(E)xibir");
            System.out.println("(R)emover");
            System.out.println("(A)tualizar");
            System.out.println("(S)air");
            System.out.print("Escolha sua opcao ==> ");
            String linha = input.nextLine().toUpperCase();
            if (linha.length() > 0) { 
                char opcao = linha.charAt(0);
                if (opcao == 'C') { 
                    criar();
                } else if (opcao == 'E') { 
                    exibir();
                } else if (opcao == 'R') { 
                    excluir();
                } else if (opcao == 'A') {
                    atualizar();
                } else if (opcao == 'S') {
                    executando = false;
                }
            }
            System.out.print("Tecle <ENTER> para continuar...");
            input.nextLine();
        }
    }

    public void criar() {
        System.out.println("Criando Aluno");
        System.out.println("Digite o RA do Aluno:");
        String ra = input.nextLine();
        System.out.println("Digite o Nome do Aluno:");
        String nome = input.nextLine();
        System.out.println("Digite o Nascimento do Aluno no formato (dd/mm/yyyy):");
        String textoNascimento = input.nextLine();
        LocalDate nascimento = LocalDate.parse( textoNascimento, dtf );
        Aluno a = new Aluno(++indice, ra, nome, nascimento);
        alunos[indice - 1] = a;
    }

    public void exibir() { }

    public void excluir() { }

    public void atualizar() { }

    public static void main(String[] args) {
        GestaoAlunos ge = new GestaoAlunos();
        ge.menu(); 
        // Aluno a1 = new Aluno(1, "0001", "Joao Silva", LocalDate.of(2004, 3, 8));
        // Aluno a2 = new Aluno(2, "0002", "Maria Silva", LocalDate.of(2005, 6, 23));

        // System.out.println( a1 );
        // System.out.println( a2 );
    }
}