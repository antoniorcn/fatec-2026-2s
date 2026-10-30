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

public class TesteEventos2 extends Application { 

    @Override
    public void start(Stage stage) { 
        BorderPane p = new BorderPane();
        Scene scn = new Scene( p, 200, 100 );

        Button btnOk = new Button( "Aperte-me" );
        p.setBottom( btnOk );

        Label lblHello = new Label("Teste de Eventos");
        p.setTop( lblHello );

        // Instância de classe anonima
        EventHandler<MouseEvent> intercept = new EventHandler<>(){
            @Override
            public void handle(MouseEvent evento) { 
                lblHello.setText("Botão clicado...");    
            }
        };

        btnOk.addEventHandler( MouseEvent.MOUSE_PRESSED, intercept );

        TextField txtNome = new TextField();
        p.setCenter( txtNome );

        stage.setScene( scn );
        stage.show();
    }

    public static void main(String[] args) { 
        Application.launch(TesteEventos.class, args);
    }
}