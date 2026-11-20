package edu.curso;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ContatoDAOImpl implements ContatoDAO {
    private Connection con;

    public ContatoDAOImpl() { 
        try { 
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Classe carregada com sucesso");
            con = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/poo_noite_contato",
                "root",
                "123456");
            System.out.println("Conectado no banco de dados");
        } catch (ClassNotFoundException e) { 
            System.out.println("Classe Maria DB não encontrada");
        } catch (SQLException e) { 
            System.out.println("Erro ao conectar no banco de dados");
        }
    }

    @Override
    public Contato salvar( Contato c ) {
        try { 
            String sql = "INSERT INTO contatos (nome, email, telefone) VALUES (?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement( sql );
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getEmail());
            stmt.setString(3, c.getTelefone());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) { 
                c.setId(rs.getLong(1));
            }
        } catch (SQLException e) { 
            System.out.println("Erro ao inserir no banco de dados");
        }
        return c;
    }

    @Override
    public List<Contato> pesquisarTodos(){
        List<Contato> lista = new ArrayList<>();
        try { 
            String sql = "SELECT * FROM contatos";
            PreparedStatement stmt = con.prepareStatement( sql );
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Contato c = new Contato();
                c.setId( rs.getLong("id") );
                c.setNome( rs.getString("nome") );
                c.setEmail( rs.getString("email") );
                c.setTelefone( rs.getString("telefone") );
                lista.add( c );
            }
        } catch (SQLException e) { 
            System.out.println("Erro ao pesquisar no banco de dados");
        }
        return lista;
    }

    @Override
    public void excluir( Contato c ) {
        try { 
            String sql = "DELETE FROM contatos WHERE id=?";
            PreparedStatement stmt = con.prepareStatement( sql );
            stmt.setLong(1, c.getId());
            stmt.executeUpdate();
        } catch (SQLException e) { 
            System.out.println("Erro ao excluir no banco de dados");
        }
    }

    @Override
    public void atualizar( long id, Contato c ){
        try { 
            String sql = "UPDATE contatos SET nome=?, email=?, telefone=? WHERE id=?";
            PreparedStatement stmt = con.prepareStatement( sql );
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getEmail());
            stmt.setString(3, c.getTelefone());
            stmt.setLong(4, id);
            stmt.executeUpdate();
        } catch (SQLException e) { 
            System.out.println("Erro ao atualizar no banco de dados");
        }
    }
}