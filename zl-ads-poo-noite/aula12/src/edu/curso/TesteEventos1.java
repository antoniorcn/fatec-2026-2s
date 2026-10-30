package edu.curso;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.event.EventHandler;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;

class TesteAssinante implements EventHandler<Event> {
    private Label meuLabel = null;
    public void setMeuLabel( Label valor ) { 
        this.meuLabel = valor;
    }
    public Label getMeuLabel() { 
        return this.meuLabel;
    }
    @Override
    public void handle(Event e) { 
        if (e.getEventType() == MouseEvent.MOUSE_CLICKED) { 
            // System.out.println("Botão Clicado...");
            if (meuLabel != null) { 
                meuLabel.setText( "Botão Clicado ... ");
            }
        }
        // System.out.printf("Evento acionado: %s\tSource: %s\tTarget: %s\n",
        //     e.getEventType(), e.getSource(), e.getTarget()
        // );
    }
}

public class TesteEventos1 extends Application { 

    @Override
    public void start(Stage stage) { 
        BorderPane p = new BorderPane();
        Scene scn = new Scene( p, 300, 200 );
        stage.setScene( scn );

        TesteAssinante a1 = new TesteAssinante();

        Label lblTitulo = new Label("Teste de Eventos Java FX");
        p.setTop( lblTitulo );

        a1.setMeuLabel( lblTitulo );

        TextField txt = new TextField();
        p.setCenter( txt );

        Button btnOk = new Button("Ok");
        p.setBottom( btnOk );

        btnOk.addEventHandler( Event.ANY, a1 );

        stage.show();
    }

    public static void main(String[] args) { 
        Application.launch(TesteEventos1.class, args);
    }
}