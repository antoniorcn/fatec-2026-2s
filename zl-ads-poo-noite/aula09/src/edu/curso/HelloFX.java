package edu.curso;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.Scene;

public class HelloFX extends Application { 

    @Override
    public void start(Stage stage) { 
        Pane p = new Pane();
        Scene scn = new Scene( p, 800, 600 );
        stage.setScene( scn );
        Label lblTitulo = new Label("Hello World Java FX");
        lblTitulo.relocate(250, 0);
        p.getChildren().add( lblTitulo );
        TextField txt = new TextField();
        txt.relocate(320, 140);
        p.getChildren().add( txt );
        Button btnOk = new Button("Ok");
        btnOk.relocate(390, 550);
        p.getChildren().add( btnOk );
        stage.show();
    }

    public static void main(String[] args) { 
        Application.launch(HelloFX.class, args);
    }
}