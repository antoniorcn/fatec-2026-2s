package edu.curso;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ContatoDAOImpl implements ContatoDAO {
    private Connection con;

    public ContatoDAOImpl() { 
        try { 
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/poo_tarde_contatos",
                "root",
                "123456" );
            System.out.println("Conectado no database");
        } catch (Exception e) { 
            System.out.println("Erro ao conectar no database");
            e.printStackTrace();
        }
    }

    @Override
    public Contato salvar(Contato c) { 
        try {
            String sql = "INSERT INTO contatos (nome, email, telefone) VALUES (?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getEmail());
            stmt.setString(3, c.getTelefone());
            stmt.executeUpdate();
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    long idGerado = rs.getLong(1);
                    c.setId( idGerado );
                    System.out.println("ID inserido: " + idGerado);
                }
            }
            System.out.println("Contato atualizado na tabela");
            return c;
        } catch (Exception e) { 
            System.out.println("Erro ao conectar no database");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void remover( Contato c) {
        try {
            String sql = "DELETE FROM contatos WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setLong(1, c.getId());
            stmt.executeUpdate();
            System.out.println("Contato excluido com sucesso tabela");
        } catch (Exception e) { 
            System.out.println("Erro ao conectar no database");
            e.printStackTrace();
        }
    }

    @Override
    public List<Contato> pesquisarTodos() {
        List<Contato> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM contatos";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            System.out.println("Contatos lidos da tabela");
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
        return lista;
    }

    @Override
    public void atualizar( long id, Contato c) { 
        try {
            String sql = "UPDATE contatos SET nome=?, email=?, telefone=? WHERE id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getEmail());
            stmt.setString(3, c.getTelefone());
            stmt.setLong(4, id);
            stmt.executeUpdate();
            System.out.println("Contato atualizado na tabela");
        } catch (Exception e) { 
            System.out.println("Erro ao conectar no database");
            e.printStackTrace();
        }
    }
}