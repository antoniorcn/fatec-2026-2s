package edu.curso.crud;
import java.time.LocalDate;

public class AlunoControl {
    private int indice = 0;
    private Aluno[] alunos = new Aluno[1000];

    public void cadastrar( Aluno a ) {
        a.setId( indice );
        alunos[indice] = a;
        indice++;
    }

    public boolean excluir(String ra) { 
        for (int i = 0; i < alunos.length; i++) {
            Aluno a = alunos[i];
            if (a != null && a.getRa().equals(ra)) { 
                alunos[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean atualizar(String ra, Aluno alunoAtualizado) { 
        for (int i = 0; i < alunos.length; i++) {
            Aluno a = alunos[i];
            if (a != null && a.getRa().equals(ra)) { 
                a.setNome( alunoAtualizado.getNome() );
                a.setNascimento( alunoAtualizado.getNascimento() );
                return true;
            }
        }
        return false;
    }

    public Aluno pesquisarPorRa( String ra ){ 
        for (int i = 0; i < alunos.length; i++) {
            Aluno a = alunos[i];
            if (a != null && a.getRa().equals(ra)) { 
                return a;
            }
        }
        return null;
    }

    public String listarTodos() {
        StringBuffer textosAlunos = new StringBuffer("");
        for (int i = 0; i < alunos.length; i++) {
            Aluno a = alunos[i];
            if (a != null) { 
                textosAlunos.append( a + "\n" );
            }
        }
        return textosAlunos.toString();
    }
} 