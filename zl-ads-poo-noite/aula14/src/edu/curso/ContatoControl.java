package edu.curso;
import java.util.List;
import java.util.ArrayList;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ContatoControl { 
    private ObservableList<Contato> lista = FXCollections.observableArrayList();
    private LongProperty id = new SimpleLongProperty(0);
    private StringProperty nome = new SimpleStringProperty("");
    private StringProperty email = new SimpleStringProperty("");
    private StringProperty telefone = new SimpleStringProperty("");
    private long contadorId = 1;

    public void popularContato( Contato c ) { 
        if (c != null) { 
            nome.set( c.getNome() );
            email.set( c.getEmail() );
            telefone.set( c.getTelefone() );
        }
    }

    public boolean salvar(){
        if (id.get() == 0) {
            Contato c = new Contato();
            c.setId( contadorId );
            c.setNome( nome.get() );
            c.setEmail( email.get() );
            c.setTelefone( telefone.get() );
            contadorId = contadorId + 1;
            lista.add( c );
        } else { 
            for (int i = 0; i < lista.size(); i++) { 
                Contato c = lista.get( i );
                if (c != null && c.getId() == id.get()) { 
                    Contato novo = new Contato();
                    novo.setId( id.get() );
                    novo.setNome( nome.get() );
                    novo.setEmail( email.get() );
                    novo.setTelefone( telefone.get() );
                    lista.set( i, novo );
                }
            }
        }
        limparCampos();
        return true;
    }

    public void limparCampos() { 
        id.set( 0 );
        nome.set( "" );
        telefone.set( "" );
        email.set( "" );
    }

    public void excluir(Contato c) { 
        lista.remove( c );
    }

    public void atualizar(Contato c) {
        id.set(c.getId());
        nome.set(c.getNome() );
        telefone.set(c.getTelefone() );
        email.set(c.getEmail() );
    }

    public void pesquisar() { 
        for (Contato c : lista) { 
            if (c != null && c.getNome().contains( nome.get() )) { 
                popularContato( c );
            }
        }
    }

    public LongProperty idProperty() { 
        return id;
    }

    public StringProperty nomeProperty() { 
        return nome;
    }

    public StringProperty emailProperty() { 
        return email;
    }

    public StringProperty telefoneProperty() { 
        return telefone;
    }

    public ObservableList<Contato> getLista() { 
        return lista;
    }
}