package edu.curso;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.Scene;

public class TesteBorderPane extends Application { 

    @Override
    public void start(Stage stage) { 
        BorderPane p = new BorderPane();
        Scene scn = new Scene( p, 800, 600 );
        stage.setScene( scn );
        Label lblTitulo = new Label("Hello World Java FX");
        p.setTop( lblTitulo );
        TextField txt = new TextField();
        p.setCenter( txt );
        Button btnOk = new Button("Ok");
        p.setBottom( btnOk );
        stage.show();
    }

    public static void main(String[] args) { 
        Application.launch(TesteBorderPane.class, args);
    }
}