package edu.curso;

import java.util.List;
import java.util.ArrayList;

public class ContatoControl { 
    private List<Contato> lista = new ArrayList<>();

    public void salvar(Contato c) { 
        lista.add( c );
    }

    public Contato pesquisar(String nome) {
        for (Contato c : lista) { 
            if (c.getNome().contains( nome )) { 
                return c;
            }
        }
        return null;
    }
}