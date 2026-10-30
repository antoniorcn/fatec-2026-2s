package edu.curso;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.event.EventHandler;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;

public class ContatoView extends Application {

    private ContatoControl control = new ContatoControl();

    @Override
    public void start(Stage stage) { 
        GridPane p = new GridPane();
        Scene scn = new Scene( p, 300, 200 );
        stage.setScene( scn );

        
        p.add( new Label("Nome e Sobrenome: "), 0, 0 );
        p.add( new Label("Telefone: "), 0, 1 );
        p.add( new Label("Email: "), 0, 2 );

        TextField txtNome = new TextField();
        TextField txtTelefone = new TextField();
        TextField txtEmail = new TextField();
        p.add( txtNome, 1, 0 );
        p.add( txtTelefone, 1, 1 );
        p.add( txtEmail, 1, 2 );

        Button btnSalvar = new Button("Salvar");
        Button btnPesquisar = new Button("Pesquisar");
        p.add( btnSalvar, 0, 3 );
        p.add( btnPesquisar, 1, 3 );

        btnSalvar.setOnAction( e -> { 
            Contato c = new Contato();
            c.setNome( txtNome.getText() );
            c.setTelefone( txtTelefone.getText() );
            c.setEmail( txtEmail.getText() );
            control.adicionar( c );
        });

        btnPesquisar.setOnAction( e -> { 
            Contato c = control.pesquisar( txtNome.getText() );
            if (c != null) { 
                txtNome.setText( c.getNome() );
                txtTelefone.setText( c.getTelefone() );
                txtEmail.setText( c.getEmail() );
            }
        });
        stage.show();
    }

    public static void main(String[] args) { 
        Application.launch(ContatoView.class, args);
    }
}