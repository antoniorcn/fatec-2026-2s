package edu.curso;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;

public class TesteBorder extends Application { 

    @Override
    public void start(Stage stage) { 
        BorderPane p = new BorderPane();
        Scene scn = new Scene( p, 800, 600 );

        Button btnOk = new Button( "Ok" );
        p.setBottom( btnOk );

        Label lblHello = new Label("Bem vindo ao meu primeiro programa com Java FX");
        p.setTop( lblHello );

        TextField txtNome = new TextField();
        p.setCenter( txtNome );

        BorderPane.setAlignment(btnOk, Pos.BOTTOM_CENTER);

        stage.setScene( scn );
        stage.show();
    }

    public static void main(String[] args) { 
        Application.launch(TesteBorder.class, args);
    }
}