package edu.curso;

public class Contato { 
    private long id;
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

    public void setId(long valor) { 
        this.id = valor;
    }
    public long getId() { 
        return this.id;
    } 

    public void setNome(String valor) { 
        this.nome = valor;
    }
    public String getNome() { 
        return this.nome;
    }

    public void setEmail(String valor) { 
        this.email = valor;
    }
    public String getEmail() { 
        return this.email;
    }

    public void setTelefone(String valor) { 
        this.telefone = valor;
    }
    public String getTelefone() { 
        return this.telefone;
    }

    @Override
    public String toString() {
        return String.format("[%d, %s, %s, %s]\n", this.id, this.nome, this.email, this.telefone);
    } 
}