package edu.curso.crud;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AlunoBoundary { 

    private Scanner input = new Scanner(System.in);
    private DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private AlunoControl control = new AlunoControl();

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
        Aluno a = new Aluno(0, ra, nome, nascimento);
        control.cadastrar( a );
    }

    public void excluir() { 
        System.out.println("... Exclusão de Aluno ...");
        System.out.println("Digite o RA do aluno a ser excluído: ");
        String ra = input.nextLine();
        if (control.excluir( ra )) { 
            System.out.printf("Aluno RA: %s removido com sucesso\n", ra);
        } else { 
            System.out.printf("Aluno com RA: %s não foi encontrado\n", ra);
        }
    }

    public void atualizar() { 
        System.out.println("... Atualização de Aluno ...");
        System.out.println("Digite o RA do aluno a ser atualizado: ");
        String ra = input.nextLine();
        if (control.pesquisarPorRa( ra ) != null) {
            System.out.println("Digite o novo nome do aluno: ");
            Aluno a = new Aluno();
            a.setNome( input.nextLine() );
            System.out.println("Digite a nova data de nascimento do aluno no formato (dd/mm/yyyy): ");
            String strNascimento = input.nextLine();
            try { 
                a.setNascimento( LocalDate.parse(strNascimento, formatador) );
            } catch (Exception e) { 
                System.out.println("Data de Nascimento Inválida");
            }
            if (control.atualizar( ra, a )) { 
                System.out.printf("Aluno RA: %s atualizado com sucesso\n", ra);
            } 
        } else { 
            System.out.printf("Aluno com RA: %s não foi encontrado\n", ra);
        }
    }

    public void exibir() { 
        System.out.println("... Exibição de Aluno ...");
        System.out.println("Digite o RA do aluno a ser exibido: ");
        String ra = input.nextLine();
        Aluno a = control.pesquisarPorRa( ra );
        if ( a != null ){ 
            System.out.println("Dados do aluno: ");
            System.out.println(a);
        } else { 
            System.out.printf("Aluno com RA: %s não foi encontrado\n", ra);
        }
    }

    public void listarTodos() {
        System.out.println("L I S T A G E M  D E  A L U N O S");
        System.out.println(control.listarTodos());
    }

    public static void main(String[] args) { 
        AlunoBoundary boundary = new AlunoBoundary();
        boundary.menu();
    }
}