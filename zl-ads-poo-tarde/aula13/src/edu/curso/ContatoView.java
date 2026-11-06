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
import javafx.beans.binding.Bindings;

public class ContatoView extends Application {

    private ContatoControl control = new ContatoControl();

    @Override
    public void start(Stage stage) { 
        GridPane p = new GridPane();
        Scene scn = new Scene( p, 400, 200 );

        TextField txtNome = new TextField();
        TextField txtTelefone = new TextField();
        TextField txtEmail = new TextField();

        Bindings.bindBidirectional( control.nomeProperty(), txtNome.textProperty() );
        Bindings.bindBidirectional( control.emailProperty(), txtEmail.textProperty() );
        Bindings.bindBidirectional( control.telefoneProperty(), txtTelefone.textProperty() );

        p.add(new Label("Nome e Sobrenome:"), 0, 0);
        p.add(new Label("Telefone:"), 0, 1);
        p.add(new Label("Email:"), 0, 2);
        p.add(txtNome, 1, 0);
        p.add(txtTelefone, 1, 1);
        p.add(txtEmail, 1, 2);

        Button btnSalvar = new Button( "Salvar" );
        Button btnPesquisar = new Button( "Pesquisar" );
        Button btnNome = new Button( "O que tem em Nome" );
        Button btnTrocarNome = new Button( "Trocar nome para Leonardo" );
        p.add( btnSalvar, 0, 3 );
        p.add( btnPesquisar, 1, 3 );
        p.add( btnNome, 2, 3 );
        p.add( btnTrocarNome, 3, 3 );

        btnSalvar.setOnAction( e -> {
            if (control.salvar()) { 
                new Alert(
                    Alert.AlertType.INFORMATION, "Contato salvo com sucesso",
                    ButtonType.OK
                ).showAndWait();
            } else { 
                new Alert(
                    Alert.AlertType.ERROR, "Erro ao salvar o contato",
                    ButtonType.OK
                ).showAndWait();
            }
        });

        btnPesquisar.setOnAction( e -> control.pesquisar() );

        btnNome.setOnAction( e -> control.mostrarNome() );

        btnTrocarNome.setOnAction( e -> control.alterarNome() );

        stage.setScene( scn );
        stage.show();
    }

    public static void main(String[] args) { 
        Application.launch(ContatoView.class, args);
    }
}