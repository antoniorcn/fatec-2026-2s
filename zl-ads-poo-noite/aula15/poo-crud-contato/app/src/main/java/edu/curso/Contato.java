package edu.curso;

public class Contato {
    private long id;
    private String nome;
    private String telefone;
    private String email;

    public long getId() { 
        return this.id;
    }
    public void setId(long valor) { 
        this.id = valor;
    }

    public String getNome() { 
        return this.nome;
    }
    public void setNome(String valor) { 
        this.nome = valor;
    }

    public String getTelefone() { 
        return this.telefone;
    }
    public void setTelefone(String valor) { 
        this.telefone = valor;
    }

    public String getEmail() { 
        return this.email;
    }
    public void setEmail(String valor) { 
        this.email = valor;
    }

    @Override
    public String toString() {
        return String.format("[%d, %s, %s, %s]", 
            this.id, this.nome, this.telefone, this.email);
    } 
}