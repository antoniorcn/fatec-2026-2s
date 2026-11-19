package edu.curso;

import java.util.List;
import java.util.ArrayList;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.LongProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ContatoControl { 
    private ObservableList<Contato> lista = FXCollections.observableArrayList();

    private LongProperty id = new SimpleLongProperty(0);
    private StringProperty nome = new SimpleStringProperty("");
    private StringProperty email = new SimpleStringProperty("");
    private StringProperty telefone = new SimpleStringProperty("");

    private int contadorId = 1;

    private ContatoDAO dao = new ContatoDAOImpl();

    public ContatoControl() { 
        pesquisarTodos();
    }

    public LongProperty idProperty() { 
        return this.id;
    }

    public StringProperty nomeProperty() { 
        return this.nome;
    }

    public StringProperty emailProperty() { 
        return this.email;
    }

    public StringProperty telefoneProperty() { 
        return this.telefone;
    }

    public boolean salvar() {
        Contato c = new Contato();
        c.setNome( nome.get() );
        c.setEmail( email.get() );
        c.setTelefone( telefone.get() );            
        if (id.get() != 0) {
            dao.atualizar(id.get(), c);

        } else {
            dao.salvar( c );
        }
        pesquisarTodos();
        limparCampos();
        return true;
    }

    public void pesquisarTodos() { 
        lista.clear();
        lista.addAll( dao.pesquisarTodos() );
    }

    public void pesquisar() {
        for (Contato c : lista) {
            if (c != null && c.getNome().contains( nome.get() )) { 
               nome.set( c.getNome() );
               email.set( c.getEmail() );
               telefone.set( c.getTelefone() );
            }   
        }
    }

    public void limparCampos() { 
        id.set( 0 );
        nome.set( "" );
        email.set( "" );
        telefone.set( "" );
    }

    public void excluir( Contato c ) {
        dao.remover( c );
        pesquisarTodos();
    }

    public void atualizar( Contato c ) {
        id.set( c.getId() );
        nome.set( c.getNome() );
        telefone.set( c.getTelefone() );
        email.set( c.getEmail() );
    }

    public ObservableList<Contato> getLista() { 
        return lista;
    }
}