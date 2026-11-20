package edu.curso;
import java.util.List;
import java.util.ArrayList;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ContatoControlSemDAO { 
    private ObservableList<Contato> lista = FXCollections.observableArrayList();
    private LongProperty id = new SimpleLongProperty(0);
    private StringProperty nome = new SimpleStringProperty("");
    private StringProperty email = new SimpleStringProperty("");
    private StringProperty telefone = new SimpleStringProperty("");
    private long contadorId = 1;
    private Connection con;

    public ContatoControlSemDAO() { 
        try { 
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Classe carregada com sucesso");
            con = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/poo_noite_contato",
                "root",
                "123456");
            System.out.println("Conectado no banco de dados");
            pesquisarTodos();
        } catch (ClassNotFoundException e) { 
            System.out.println("Classe Maria DB não encontrada");
        } catch (SQLException e) { 
            System.out.println("Erro ao conectar no banco de dados");
        }
    }

    public void popularContato( Contato c ) { 
        if (c != null) { 
            nome.set( c.getNome() );
            email.set( c.getEmail() );
            telefone.set( c.getTelefone() );
        }
    }

    public void pesquisarTodos() { 
        try { 
            String sql = "SELECT * FROM contatos";
            PreparedStatement stmt = con.prepareStatement( sql );
            ResultSet rs = stmt.executeQuery();
            lista.clear();
            while (rs.next()) {
                Contato c = new Contato();
                c.setId( rs.getLong("id") );
                c.setNome( rs.getString("nome") );
                c.setEmail( rs.getString("email") );
                c.setTelefone( rs.getString("telefone") );
                lista.add( c );
            }
        } catch (SQLException e) { 
            System.out.println("Erro ao inserir no banco de dados");
        }
    }

    public boolean salvar(){
        if (id.get() == 0) {
            // Contato c = new Contato();
            // c.setId( contadorId );
            // c.setNome( nome.get() );
            // c.setEmail( email.get() );
            // c.setTelefone( telefone.get() );
            // contadorId = contadorId + 1;
            // lista.add( c );

            try { 
                String sql = "INSERT INTO contatos (nome, email, telefone) VALUES (?, ?, ?)";
                PreparedStatement stmt = con.prepareStatement( sql );
                stmt.setString(1, nome.get());
                stmt.setString(2, email.get());
                stmt.setString(3, telefone.get());
                stmt.executeUpdate();
                pesquisarTodos();
            } catch (SQLException e) { 
                System.out.println("Erro ao inserir no banco de dados");
            }

        } else { 
            // for (int i = 0; i < lista.size(); i++) { 
            //     Contato c = lista.get( i );
            //     if (c != null && c.getId() == id.get()) { 
            //         Contato novo = new Contato();
            //         novo.setId( id.get() );
            //         novo.setNome( nome.get() );
            //         novo.setEmail( email.get() );
            //         novo.setTelefone( telefone.get() );
            //         lista.set( i, novo );
            //     }
            // }
            try { 
                String sql = "UPDATE contatos SET nome=?, email=?, telefone=? WHERE id=?";
                PreparedStatement stmt = con.prepareStatement( sql );
                stmt.setString(1, nome.get());
                stmt.setString(2, email.get());
                stmt.setString(3, telefone.get());
                stmt.setLong(4, id.get());
                stmt.executeUpdate();
                pesquisarTodos();
            } catch (SQLException e) { 
                System.out.println("Erro ao inserir no banco de dados");
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
        try { 
            String sql = "DELETE FROM contatos WHERE id=?";
            PreparedStatement stmt = con.prepareStatement( sql );
            stmt.setLong(1, c.getId());
            stmt.executeUpdate();
            pesquisarTodos();
        } catch (SQLException e) { 
            System.out.println("Erro ao inserir no banco de dados");
        }
        // lista.remove( c );
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