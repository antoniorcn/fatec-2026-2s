package edu.curso.crud;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class GestaoAlunos { 

    private Scanner input = new Scanner(System.in);
    private int indice = 0;
    private Aluno[] alunos = new Aluno[1000];
    private DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void menu() {
        boolean executando = true;
        while (executando) {
            System.out.println("M E N U  C R U D  A L U N O S");
            System.out.println("(C)riar");
            System.out.println("(L)istar todos");
            System.out.println("(E)xibir");
            System.out.println("(A)tualizar");
            System.out.println("(R)emover");
            System.out.println("(S)air");

            System.out.println("Digite uma opcao valida: ");
            String resposta = input.nextLine().toUpperCase();
            if (resposta.length() > 0) { 
                char opcao = resposta.charAt(0);
                if (opcao == 'C') { 
                    cadastrar();
                } else if (opcao == 'L') { 
                    listarTodos();
                } else if (opcao == 'E') { 
                    exibir();
                } else if (opcao == 'A') { 
                    atualizar();
                } else if (opcao == 'R') { 
                    excluir();
                } else if (opcao == 'S') { 
                    System.out.println("Obrigado e volte sempre...");
                    executando = false;
                }
            }
            System.out.println("Tecle <ENTER> para continuar...");
            input.nextLine();
        }
    }

    public void cadastrar() { 
        System.out.println("Digite o RA do aluno: ");
        String ra = input.nextLine();
        System.out.println("Digite o Nome do aluno: ");
        String nome = input.nextLine();
        System.out.println("Digite a Data de nascimento do aluno no formato (dd/mm/yyyy): ");
        String strNascimento = input.nextLine();
        LocalDate nascimento = LocalDate.now();
        try { 
            nascimento = LocalDate.parse(strNascimento, formatador);
        } catch (Exception e) { 
            System.out.println("Data de Nascimento Inválida");
        }

        Aluno a = new Aluno(indice, ra, nome, nascimento);
        alunos[indice] = a;
        indice++;

    }

    public void excluir() { 
        System.out.println("... Exclusão de Aluno ...");
        System.out.println("Digite o RA do aluno a ser excluído: ");
        String ra = input.nextLine();
        for (int i = 0; i < alunos.length; i++) {
            Aluno a = alunos[i];
            if (a != null && a.getRa().equals(ra)) { 
                alunos[i] = null;
                System.out.printf("Aluno RA: %s removido com sucesso\n", ra);
                return;
            }
        }
        System.out.printf("Aluno com RA: %s não foi encontrado\n", ra);
    }

    public void atualizar() { 
        System.out.println("... Atualização de Aluno ...");
        System.out.println("Digite o RA do aluno a ser atualizado: ");
        String ra = input.nextLine();
        for (int i = 0; i < alunos.length; i++) {
            Aluno a = alunos[i];
            if (a != null && a.getRa().equals(ra)) { 
                System.out.println("Digite o Nome do aluno: ");
                a.setNome( input.nextLine() );
                System.out.println("Digite a Data de nascimento do aluno no formato (dd/mm/yyyy): ");
                String strNascimento = input.nextLine();
                try { 
                    a.setNascimento( LocalDate.parse(strNascimento, formatador) );
                } catch (Exception e) { 
                    System.out.println("Data de Nascimento Inválida");
                }
                System.out.printf("Aluno RA: %s atualizado com sucesso\n", ra);
                return;
            }
        }
        System.out.printf("Aluno com RA: %s não foi encontrado\n", ra);
    }

    public void exibir() { 
        System.out.println("... Exibição de Aluno ...");
        System.out.println("Digite o RA do aluno a ser exibido: ");
        String ra = input.nextLine();
        for (int i = 0; i < alunos.length; i++) {
            Aluno a = alunos[i];
            if (a != null && a.getRa().equals(ra)) { 
                System.out.println( a );
                return;
            }
        }
        System.out.printf("Aluno com RA: %s não foi encontrado\n", ra);
    }

    public void listarTodos() { 
        System.out.println("... Listagem de Alunos ...");
        for (int i = 0; i < alunos.length; i++) {
            Aluno a = alunos[i];
            if (a != null) { 
                System.out.println( a );
            }
        }
    }

    public static void main(String[] args) { 
        GestaoAlunos crud = new GestaoAlunos();
        crud.menu();
    }
}