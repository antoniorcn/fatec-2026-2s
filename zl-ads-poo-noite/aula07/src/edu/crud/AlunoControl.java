package edu.crud;

public class AlunoControl {
    private int indice = 0;
    private Aluno[] alunos = new Aluno[1000];

    public void criar( Aluno a ){ 
        a.setId( indice );
        alunos[indice] = a;
        indice++;
    }

    public String listarTodos() {
        StringBuffer sb = new StringBuffer(); 
        for (int i = 0; i < alunos.length; i++) { 
            Aluno a = alunos[i];
            if (a != null) { 
                sb.append( a + "\n");
            }
        }
        return sb.toString();
    }

    public boolean excluir( String ra ) {
        int i = indicePorRa( ra );
        if ( i >= 0 ) { 
            alunos[i] = null;
            return true;
        } else { 
            return false;
        }
    }


    public boolean atualizar( int i, Aluno novo ) {
        if (novo != null) { 
            novo.setId( i );
            alunos[i] = novo;
            return true;
        } else { 
            return false;
        }
    }

    public int indicePorRa( String ra ) { 
        for (int i = 0; i < alunos.length; i++) { 
            Aluno a = alunos[i];
            if (a != null && 
                a.getRa() != null && 
                a.getRa().equals( ra )) { 
                return i;
            }
        }
        return -1;
    }

    public Aluno procurarPorRa( String ra ) { 
        for (int i = 0; i < alunos.length; i++) { 
            Aluno a = alunos[i];
            if (a != null && 
                a.getRa() != null && 
                a.getRa().equals( ra )) { 
                return a;
            }
        }
        return null;
    }
}