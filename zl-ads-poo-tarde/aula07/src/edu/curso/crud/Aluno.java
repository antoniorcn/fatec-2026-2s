package edu.cuTrso.crud;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Aluno { 
    private long id;
    private String ra = "";
    private String nome = "";
    private LocalDate nascimento = LocalDate.now();

    public Aluno() { 
        this(0, "00000", "Anonimo", LocalDate.now());
    }

    public Aluno(long id, String ra, String nome, LocalDate nascimento){ 
        super();
        setId(id);
        setRa(ra);
        setNome(nome);
        setNascimento(nascimento);
    }
    
    public long getId() { 
        return id;
    }
    public void setId( long id ){
        if (id >= 0) {
            this.id = id;
        }
    }

    public String getRa() {
        return ra;
    }
    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }
    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String toString() {
        DateTimeFormatter formatador = 
           DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String strNascimento = this.nascimento.format( formatador );
        // 10/09/2026 
        return String.format("(%d) %s - %s - %s",
        this.id, this.ra, this.nome, strNascimento);
    }
}