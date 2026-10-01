package edu.curso;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;

public class TesteGrid extends Application { 

    @Override
    public void start(Stage stage) { 
        GridPane p = new GridPane();
        Scene scn = new Scene( p, 800, 600 );

        Button btnOk = new Button( "Ok" );
        Button btnCancelar = new Button( "Cancelar" );

        FlowPane fp = new FlowPane();

        // fp.getChildren().add( btnOk );
        // fp.getChildren().add( btnCancelar );
        fp.getChildren().addAll( btnOk, btnCancelar );
        p.add( fp, 0, 1 );

        Label lblHello = new Label("Bem vindo ao meu primeiro programa com Java FX");
        p.add( lblHello, 0, 0 );

        TextField txtNome = new TextField();
        p.add( txtNome, 1, 0 );

        stage.setScene( scn );
        stage.show();
    }

    public static void main(String[] args) { 
        Application.launch(TesteGrid.class, args);
    }
}