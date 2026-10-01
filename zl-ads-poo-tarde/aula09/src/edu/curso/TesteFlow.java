package edu.curso;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TesteFlow extends Application { 

    @Override
    public void start(Stage stage) { 
        FlowPane p = new FlowPane();
        Scene scn = new Scene( p, 800, 600 );

        Button btnOk = new Button( "Ok" );
        p.getChildren().add( btnOk );

        Label lblHello = new Label("Bem vindo ao meu primeiro programa com Java FX");
        p.getChildren().add( lblHello );

        TextField txtNome = new TextField();
        p.getChildren().add( txtNome );

        stage.setScene( scn );
        stage.show();
    }

    public static void main(String[] args) { 
        Application.launch(TesteFlow.class, args);
    }
}