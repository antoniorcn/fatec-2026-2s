package edu.curso;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java.util.List;
import java.util.ArrayList;

public class AgendaContatoLinguica extends Application {

    private List<Contato> lista = new ArrayList<>();

    @Override
    public void start(Stage stage) { 
        GridPane p = new GridPane();
        Scene scn = new Scene( p, 400, 200 );

        TextField txtNome = new TextField();
        TextField txtTelefone = new TextField();
        TextField txtEmail = new TextField();

        p.add(new Label("Nome e Sobrenome:"), 0, 0);
        p.add(new Label("Telefone:"), 0, 1);
        p.add(new Label("Email:"), 0, 2);
        p.add(txtNome, 1, 0);
        p.add(txtTelefone, 1, 1);
        p.add(txtEmail, 1, 2);

        Button btnSalvar = new Button( "Salvar" );
        Button btnPesquisar = new Button( "Pesquisar" );
        p.add( btnSalvar, 0, 3 );
        p.add( btnPesquisar, 1, 3 );

        btnSalvar.setOnAction( e -> {
            Contato c = new Contato();
            c.setNome( txtNome.getText() );
            c.setEmail( txtEmail.getText() );
            c.setTelefone( txtTelefone.getText() );

            lista.add( c );
            new Alert(
                Alert.AlertType.INFORMATION, "Contato salvo com sucesso",
                ButtonType.OK
            ).showAndWait();
        });

        btnPesquisar.setOnAction( e -> {
            for (Contato c : lista) { 
                if (c.getNome().contains( txtNome.getText() )) { 
                    txtNome.setText( c.getNome() );
                    txtEmail.setText( c.getEmail() );
                    txtTelefone.setText( c.getTelefone() );
                }
            }
        });

        stage.setScene( scn );
        stage.show();
    }

    public static void main(String[] args) { 
        Application.launch(AgendaContatoLinguica.class, args);
    }
}