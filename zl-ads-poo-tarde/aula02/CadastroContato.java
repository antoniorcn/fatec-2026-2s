import java.util.Scanner;
public class CadastroContato { 
    public static void main(String args[]) { 
        // Scanner input = new Scanner(System.in);
        Scanner input; // Declaração da variavel
        input = new Scanner(System.in); // Atribuição

        System.out.println("Cadastro de Contato");

        System.out.println("Digite seu nome");
        String nome = input.nextLine();

        System.out.println("Digite sua idade");
        int idade = input.nextInt();
        input.nextLine();

        System.out.println("Digite seu email");
        String email = input.nextLine();
        
        System.out.println("Bem vindo, " + nome);
        System.out.println("Você tem " + idade + " anos");
        System.out.println("Seu email é, " + email);
    }
}