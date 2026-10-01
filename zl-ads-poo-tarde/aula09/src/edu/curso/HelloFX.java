package edu.curso;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloFX extends Application { 

    @Override
    public void start(Stage stage) { 
        Pane p = new Pane();
        Scene scn = new Scene( p, 800, 600 );

        Button btnOk = new Button( "Ok" );
        p.getChildren().add( btnOk );
        btnOk.relocate(380, 500);

        Label lblHello = new Label("Bem vindo ao meu primeiro programa com Java FX");
        p.getChildren().add( lblHello );
        lblHello.relocate(350.0, 20.0);

        TextField txtNome = new TextField();
        p.getChildren().add( txtNome );
        txtNome.relocate(200, 300);

        stage.setScene( scn );
        stage.show();
    }

    public static void main(String[] args) { 
        Application.launch(HelloFX.class, args);
    }
}