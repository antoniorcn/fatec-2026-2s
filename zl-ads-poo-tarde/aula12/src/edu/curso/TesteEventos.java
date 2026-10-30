package edu.curso;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class TesteEventos extends Application { 

    @Override
    public void start(Stage stage) { 
        BorderPane p = new BorderPane();
        Scene scn = new Scene( p, 200, 100 );

        Button btnOk = new Button( "Aperte-me" );
        p.setBottom( btnOk );

        Label lblHello = new Label("Teste de Eventos");
        p.setTop( lblHello );
        lblHello.requestFocus();
        lblHello.setOnKeyPressed( e -> { 
            System.out.println( e.getCharacter() + " - " + e.getText() );
            // lblHello.setText( e.getText() );
            if (e.getText().equals("r")){ 
                lblHello.setTextFill(Color.web("#ff0000"));
            } else if (e.getText().equals("a")){ 
                lblHello.setTextFill(Color.web("#0000ff"));
            } else if (e.getText().equals("g")){ 
                lblHello.setTextFill(Color.web("#00ff00"));
            } 
        });

        // ArrowFunction Simplificado com Action
        btnOk.setOnAction( e -> lblHello.setText("Botão clicado...") );

        TextField txtNome = new TextField();
        p.setCenter( txtNome );

        stage.setScene( scn );
        stage.show();
    }

    public static void main(String[] args) { 
        Application.launch(TesteEventos.class, args);
    }
}