package edu.crud;
import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class AlunoBoundary { 

    // private class TipoTela { // Classe Interna
    //     largura : int;
    //     altura : int;
    // }

    private Scanner input = new Scanner(System.in);
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private AlunoControl control = new AlunoControl();

    public void menu() {
        boolean executando = true;     

        while (executando) {
            System.out.println("G E S T A O  D E  A L U N O S");
            System.out.println("Menu de Opcoes");
            System.out.println("(C)riar");
            System.out.println("(E)xibir");
            System.out.println("(L)istar Todos");
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
                } else if (opcao == 'L') { 
                    listarTodos();                    
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
        Aluno a = new Aluno(0, ra, nome, nascimento);
        control.criar( a );
        System.out.println("Aluno cadastrado com sucesso");
    }

    public void exibir() {
        System.out.println("Exibir Dados do Aluno");
        System.out.println("Digite o RA do Aluno:");
        String ra = input.nextLine();
        Aluno a = control.procurarPorRa( ra );
        if ( a != null ) { 
            System.out.println("D A D O S  D O  A L U N O");
            System.out.println(a);
        } else { 
            System.out.printf("Aluno com RA: %s não foi encontrado\n", ra);
        }
    }

    public void listarTodos() {
        System.out.println("Listar Todos Alunos");
        String texto = control.listarTodos();
        System.out.println( texto );
    }

    public void excluir() {
        System.out.println("Excluir Aluno");
        System.out.println("Digite o RA do Aluno:");
        String ra = input.nextLine();
        if (control.excluir( ra )) {
            System.out.println("Aluno excluido com sucesso");
        } else { 
            System.out.printf("Aluno com RA: %s não foi encontrado\n", ra);
        }
    }

    public void atualizar() {
        System.out.println("Atualizar Aluno");
        System.out.println("Digite o RA do Aluno:");
        String ra = input.nextLine();
        int i = control.indicePorRa( ra );
        if ( i >= 0 ) {
            System.out.println("Digite o Novo nome do Aluno:");
            String nome = input.nextLine();
            System.out.println("Digite a Nova data de nascimento do Aluno no formato (dd/mm/yyyy):");
            String textoNascimento = input.nextLine();
            LocalDate nascimento = LocalDate.parse( textoNascimento, dtf );
            Aluno alunoNovo = new Aluno();
            alunoNovo.setRa( ra );
            alunoNovo.setNome( nome );
            alunoNovo.setNascimento( nascimento );
            if (control.atualizar( i, alunoNovo )) {
                System.out.println("Aluno atualizado com sucesso");
            } else { 
                System.out.printf("Erro ao atualizar o Aluno com RA: %s\n", ra);
            }
        } else { 
            System.out.printf("Aluno com RA: %s não foi encontrado\n", ra);
        }
    }

    public static void main(String[] args) {
        AlunoBoundary alunoBoundary = new AlunoBoundary();
        alunoBoundary.menu(); 
    }
}