package edu.curso;
import java.util.List;
import java.util.ArrayList;

public class ContatoControl { 
    private List<Contato> lista = new ArrayList<>();

    public void adicionar( Contato c ){ 
        lista.add( c );
    }

    public Contato pesquisar( String texto ) { 
        for (Contato c : lista) { 
            if (c.getNome().contains(texto)) { 
                return c;
            }
        }
        return null;
    }
}