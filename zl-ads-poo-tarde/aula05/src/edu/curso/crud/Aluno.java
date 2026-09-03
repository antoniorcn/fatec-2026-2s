package edu.curso.crud;
import java.time.LocalDate;

public class Aluno { 
    private long id;
    private String ra = "";
    private String nome = "";
    private LocalDate nascimento = LocalDate.now();
    public long getId() { 
        return id;
    }
    public void setId( long id ){
        if (id >= 0) {
            this.id = id;
        }
    }
}