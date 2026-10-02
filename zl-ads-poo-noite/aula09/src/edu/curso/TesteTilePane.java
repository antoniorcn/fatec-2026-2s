package edu.curso;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.TilePane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.Scene;

public class TesteTilePane extends Application { 

    @Override
    public void start(Stage stage) { 
        TilePane p = new TilePane();
        Scene scn = new Scene( p, 800, 600 );
        stage.setScene( scn );
        Label lblTitulo = new Label("Hello World Java FX");
        p.getChildren().add( lblTitulo );
        TextField txt = new TextField();
        p.getChildren().add( txt );
        Button btnOk = new Button("Ok");
        p.getChildren().add( btnOk );
        stage.show();
    }

    public static void main(String[] args) { 
        Application.launch(TesteTilePane.class, args);
    }
}