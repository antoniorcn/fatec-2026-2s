package edu.curso;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Teste { 
    public static void main(String[] args) { 
        System.out.println("Teste de App com Gradle");
        try { 
            Class.forName("org.mariadb.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/poo_tarde_contatos",
                "root",
                "123456" );
            System.out.println("Conectado no database");
            String sql = "INSERT INTO contatos (nome, email, telefone) VALUES ('Joao Silva', 'joao@teste.com', '1111')";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
            System.out.println("Contato gravado com sucesso");
        } catch (Exception e) { 
            System.out.println("Erro ao conectar no database");
            e.printStackTrace();
        }
    }
}