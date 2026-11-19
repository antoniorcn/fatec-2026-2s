package edu.curso;

import java.util.List;
import java.util.ArrayList;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.LongProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ContatoControlSemDAO { 
    private ObservableList<Contato> lista = FXCollections.observableArrayList();

    private LongProperty id = new SimpleLongProperty(0);
    private StringProperty nome = new SimpleStringProperty("");
    private StringProperty email = new SimpleStringProperty("");
    private StringProperty telefone = new SimpleStringProperty("");

    private int contadorId = 1;
    private Connection con;

    public ContatoControlSemDAO() { 
        try { 
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/poo_tarde_contatos",
                "root",
                "123456" );
            System.out.println("Conectado no database");
            pesquisarTodos();
        } catch (Exception e) { 
            System.out.println("Erro ao conectar no database");
            e.printStackTrace();
        }
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
        if (id.get() != 0) {
            // for (int i = 0; i < lista.size(); i++) {
            //     Contato cTemp = lista.get( i );
            //     if (cTemp != null && cTemp.getId() == id.get()) {
            //         Contato novoContato = new Contato();
            //         novoContato.setId( id.get() );
            //         novoContato.setNome( nome.get() );
            //         novoContato.setEmail( email.get() );
            //         novoContato.setTelefone( telefone.get() );
            //         lista.set(i, novoContato);
            //     }
            // }
            try {
                String sql = "UPDATE contatos SET nome=?, email=?, telefone=? WHERE id=?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, nome.get());
                stmt.setString(2, email.get());
                stmt.setString(3, telefone.get());
                stmt.setLong(4, id.get());
                stmt.executeUpdate();
                System.out.println("Contato atualizado na tabela");
                pesquisarTodos();
            } catch (Exception e) { 
                System.out.println("Erro ao conectar no database");
                e.printStackTrace();
            }
        } else {
            Contato c = new Contato();
            c.setNome( nome.get() );
            c.setEmail( email.get() );
            c.setTelefone( telefone.get() );            
            c.setId( contadorId );
            contadorId = contadorId + 1;
            lista.add( c );


            try {
                String sql = "INSERT INTO contatos (nome, email, telefone) VALUES (?, ?, ?)";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, c.getNome());
                stmt.setString(2, c.getEmail());
                stmt.setString(3, c.getTelefone());
                stmt.executeUpdate();
                System.out.println("Contato inserido na tabela");
                pesquisarTodos();
            } catch (Exception e) { 
                System.out.println("Erro ao conectar no database");
                e.printStackTrace();
            }
        }
        limparCampos();
        return true;
    }

    public void pesquisarTodos() { 
        try {
            String sql = "SELECT * FROM contatos";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            System.out.println("Contatos lidos da tabela");
            lista.clear();
            while (rs.next()) { 
                Contato c = new Contato();
                c.setId( rs.getLong("id") );
                c.setNome( rs.getString("nome") );
                c.setEmail( rs.getString("email") );
                c.setTelefone( rs.getString("telefone") ); 
                lista.add( c );
            }
        } catch (Exception e) { 
            System.out.println("Erro ao conectar no database");
            e.printStackTrace();
        }
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
        try {
            String sql = "DELETE FROM contatos WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setLong(1, c.getId());
            stmt.executeUpdate();
            System.out.println("Contato excluido com sucesso tabela");
            pesquisarTodos();
        } catch (Exception e) { 
            System.out.println("Erro ao conectar no database");
            e.printStackTrace();
        }
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