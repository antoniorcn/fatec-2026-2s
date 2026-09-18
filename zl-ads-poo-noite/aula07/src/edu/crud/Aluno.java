package edu.crud;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import edu.Pessoa;

public class Aluno extends Pessoa { 
    private long id;
    private String ra;
    private String nome;
    private LocalDate nascimento;

    public Aluno() {
        this(0, "0000", "Anonimo", LocalDate.now());
    }

    public Aluno(long id, String ra, String nome, LocalDate nascimento) {
        super();
        this.id = id;
        this.ra = ra;
        this.nome = nome;
        this.nascimento = nascimento;
    }

    public long getId() {
        return this.id;
    }
    public void setId(long id){ 
        this.id = id;
    }

    public String getRa() {
        return this.ra;
    }
    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return this.nascimento;
    }
    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String nascimentoFormatado = this.nascimento.format( dtf );
        String p = pensamento;

        Pessoa p1 = new Pessoa();
        // p.pensamento; // Vai dar erro aqui....
        return String.format("(%d) %s - %s - %s", 
        this.id, this.ra, this.nome, nascimentoFormatado);
    }
}