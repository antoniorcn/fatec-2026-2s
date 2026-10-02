package edu.curso;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.Scene;

public class TesteGridPane extends Application { 

    @Override
    public void start(Stage stage) { 
        GridPane p = new GridPane();
        Scene scn = new Scene( p, 800, 600 );
        stage.setScene( scn );
        Label lblTitulo = new Label("Hello World Java FX");
        p.add( lblTitulo, 0, 0 );
        TextField txt = new TextField();
        p.add( txt, 1, 0 );
        Button btnOk = new Button("Ok");
        p.add( btnOk, 1, 1 );
        stage.show();
    }

    public static void main(String[] args) { 
        Application.launch(TesteGridPane.class, args);
    }
}