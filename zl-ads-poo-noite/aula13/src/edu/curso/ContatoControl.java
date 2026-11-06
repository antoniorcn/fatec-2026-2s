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

    // public ContatoControl() { 
    //     nome.addListener(      
    //         (obs, valorAntigo, valorNovo) -> {
    //             System.out.printf("Valor Antigo: %s\tValor Novo: %s\n",
    //                valorAntigo, valorNovo);
    //         }
    //     );
    // }


    public void popularContato( Contato c ) { 
        if (c != null) { 
            nome.set( c.getNome() );
            email.set( c.getEmail() );
            telefone.set( c.getTelefone() );
        }
    }

    public boolean salvar(){
        Contato c = new Contato();
        c.setNome( nome.get() );
        c.setEmail( email.get() );
        c.setTelefone( telefone.get() );
        lista.add( c );
        nome.set("");
        email.set("");
        telefone.set("");
        return true;
    }

    public void pesquisar() { 
        for (Contato c : lista) { 
            if (c != null && c.getNome().contains( nome.get() )) { 
                popularContato( c );
            }
        }
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