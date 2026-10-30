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

class InterceptadorDeEventos implements EventHandler<MouseEvent> { 
    private Label meuLabel = null;

    public void setLabel( Label novoLabel ) { 
        this.meuLabel = novoLabel;
    }

    public Label getLabel() { 
        return this.meuLabel;
    }

    public void handle(MouseEvent evento) { 
        System.out.printf("Evento Tipo: %s\tSource: %s\tTarget: %s \n",
        evento.getEventType(), evento.getSource(), evento.getTarget());

        if (this.meuLabel != null && evento.getEventType() == MouseEvent.MOUSE_PRESSED) { 
            this.meuLabel.setText("Você clicou no botão");
        }
    }
}

public class TesteEventos1 extends Application { 

    @Override
    public void start(Stage stage) { 
        InterceptadorDeEventos intercept = new InterceptadorDeEventos();
        BorderPane p = new BorderPane();
        Scene scn = new Scene( p, 200, 100 );
        // stage.addEventHandler( MouseEvent.ANY, intercept );        

        Button btnOk = new Button( "Aperte-me" );
        p.setBottom( btnOk );

        btnOk.addEventHandler( MouseEvent.MOUSE_PRESSED, intercept );

        Label lblHello = new Label("Teste de Eventos");
        p.setTop( lblHello );

        intercept.setLabel( lblHello );

        TextField txtNome = new TextField();
        p.setCenter( txtNome );

        stage.setScene( scn );
        stage.show();
    }

    public static void main(String[] args) { 
        Application.launch(TesteEventos.class, args);
    }
}