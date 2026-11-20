package edu.curso;

import java.util.List;

public interface ContatoDAO { 
    Contato salvar( Contato c );
    List<Contato> pesquisarTodos();
    void excluir( Contato c );
    void atualizar( long id, Contato c );
}