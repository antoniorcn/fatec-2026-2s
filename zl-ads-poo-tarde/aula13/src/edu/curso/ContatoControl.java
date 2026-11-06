package edu.curso;

import java.util.List;
import java.util.ArrayList;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ContatoControl { 
    private ObservableList<Contato> lista = FXCollections.observableArrayList();

    private StringProperty nome = new SimpleStringProperty("");
    private StringProperty email = new SimpleStringProperty("");
    private StringProperty telefone = new SimpleStringProperty("");

    public StringProperty nomeProperty() { 
        return this.nome;
    }

    public StringProperty emailProperty() { 
        return this.email;
    }

    public StringProperty telefoneProperty() { 
        return this.telefone;
    }

    // public String getNome() { 
    //     return nome.get();
    // }

    // public void setNome(String valor) { 
    //     nome.set(valor);
    // }

    // public void mostrarNome() { 
    //     System.out.println("Conteudo do nome: " + nome.get() );
    // }

    // public void alterarNome() { 
    //     nome.set("Leonardo");
    // }

    public boolean salvar() {
        Contato c = new Contato();
        c.setNome( nome.get() );
        c.setEmail( email.get() );
        c.setTelefone( telefone.get() );
        lista.add( c );
        return true;
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

    public ObservableList<Contato> getLista() { 
        return lista;
    }
}