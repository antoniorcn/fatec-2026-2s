package edu.curso;

public class Contato { 
    private String nome;
    private String email;
    private String telefone;

    public Contato() { 
        this("", "", "");
    }

    public Contato(String nome, String email, String telefone) { 
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public void setNome(String valor) { 
        this.nome = valor;
    }
    public void setEmail(String valor) { 
        this.email = valor;
    } 
    public void setTelefone(String valor) { 
        this.telefone = valor;
    }
    public String getNome() { 
        return this.nome;
    }
    public String getEmail() { 
        return this.email;
    }
    public String getTelefone() { 
        return this.telefone;
    }

    @Override
    public String toString() {
        return String.format("[%s, %s, %s]\n", this.nome, this.email, this.telefone);
    } 
}