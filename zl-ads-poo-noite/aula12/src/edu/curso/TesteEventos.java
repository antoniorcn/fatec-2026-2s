package edu.curso;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.event.EventHandler;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;

public class TesteEventos extends Application { 

    @Override
    public void start(Stage stage) { 
        BorderPane p = new BorderPane();
        Scene scn = new Scene( p, 300, 200 );
        stage.setScene( scn );

        Label lblTitulo = new Label("Teste de Eventos Java FX");
        p.setTop( lblTitulo );

        TextField txt = new TextField();
        p.setCenter( txt );

        Button btnOk = new Button("Ok");
        p.setBottom( btnOk );

        // Arrow Function 
        // btnOk.setOnMousePressed( e -> lblTitulo.setText("Botão clicado metodo 7") );
        // btnOk.setOnKeyPressed( e -> lblTitulo.setText("Botão clicado metodo 7") );
        btnOk.setOnAction( e -> lblTitulo.setText("Botão clicado metodo 8") );

        stage.show();
    }

    public static void main(String[] args) { 
        Application.launch(TesteEventos.class, args);
    }
}