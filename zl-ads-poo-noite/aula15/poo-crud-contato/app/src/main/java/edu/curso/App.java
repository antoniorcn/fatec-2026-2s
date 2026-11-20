package edu.curso;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
public class App {
    public static void main(String[] args) {
        System.out.println("Teste de conexao com banco de dados");
        try { 
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Classe carregada com sucesso");
            Connection con = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/poo_noite_contato",
                "root",
                "123456");
            System.out.println("Conectado no banco de dados");
            String sql = "INSERT INTO contatos (nome, email, telefone) VALUES (?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement( sql );
            stmt.setString(1, "Maria Silva");
            stmt.setString(2, "maria@teste.com");
            stmt.setString(3, "(11) 2222-2222");
            stmt.executeUpdate();
        } catch (ClassNotFoundException e) { 
            System.out.println("Classe Maria DB não encontrada");
        } catch (SQLException e) { 
            System.out.println("Erro ao conectar no banco de dados");
        }
    }

}
