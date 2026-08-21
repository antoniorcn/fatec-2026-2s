class Pessoa {
    private String nome = "";
    private int idade = 0;
    
    // Construtor da classe Pessoa
    public Pessoa(String nome, int idade) { 
        this.nome = nome;
        this.idade = idade;
        System.out.println("Pessoa criada...");
    }

    public void imprimirNome() { 
        System.out.println("Nome da Pessoa: " + this.nome);
    }

    @Override 
    public String toString() { 
        return "Nome: " + this.nome + "\tIdade: " + this.idade;
    }
    
    public String getNome() { 
        return this.nome;
    }
    public void setNome(String valor) { 
        this.nome = valor;
    }
    public int getIdade() { 
        return this.idade;
    }
    public void setIdade( int valor ) { 
        this.idade = valor;
    }
}

class Aluno extends Pessoa { 
    private String ra;

    public Aluno(String nome, int idade, String ra) { 
        super(nome, idade);
        this.ra = ra;  
        // Construtores
        // Herança
        // Agregação  e Composição
        // Cadeia de Construtores
    }

    public void imprimeNome() { 
        System.out.println("Nome do Aluno: " + this.getNome() );
    }

    public String getRa() { 
        return this.ra;
    }
    public void setRa(String ra) {
        this.ra = ra;
    }
}

public class Teste { 
    public static void main(String args[]) { 
        Pessoa p1 = new Pessoa("Joao Silva", 21);
        Pessoa p2 = new Pessoa("Maria Silva", 20);
        Aluno a1 = new Aluno("Alfredo Gaspar", 22, "0001");
        Aluno a2 = new Aluno("Camila Alves", 21, "0002");

        System.out.println("Pessoa 1: " + p1);
        System.out.println("Pessoa 2: " + p2);

        System.out.println("Aluno 1: " + a1);
        System.out.println("Aluno 2: " + a2);

        p1.imprimirNome();
        p2.imprimirNome();

        a1.imprimirNome();
        a2.imprimirNome();
    }
}

