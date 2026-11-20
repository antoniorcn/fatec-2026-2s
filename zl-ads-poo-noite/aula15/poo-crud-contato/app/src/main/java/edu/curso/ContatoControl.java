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
    private ContatoDAO dao = new ContatoDAOImpl();

    public ContatoControl() { 
        pesquisarTodos();
    }

    public void popularContato( Contato c ) { 
        if (c != null) { 
            nome.set( c.getNome() );
            email.set( c.getEmail() );
            telefone.set( c.getTelefone() );
        }
    }

    public void pesquisarTodos() { 
        lista.clear();
        lista.addAll( dao.pesquisarTodos() );
    }

    public boolean salvar(){
        Contato c = new Contato();
        c.setNome( nome.get() );
        c.setEmail( email.get() );
        c.setTelefone( telefone.get() );
        if (id.get() == 0) {
            dao.salvar( c );
        } else { 
            dao.atualizar(id.get(), c );
        }
        pesquisarTodos();
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
        dao.excluir( c );
        pesquisarTodos();
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