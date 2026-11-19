package edu.curso;
import java.util.List;

public interface ContatoDAO { 
    Contato salvar(Contato c);
    void remover( Contato c);
    List<Contato> pesquisarTodos();
    void atualizar( long id, Contato c);
}