package edu.curso;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.beans.binding.Bindings;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.beans.property.ReadOnlyStringWrapper;

public class ContatoViewComTabela extends Application {

    private ContatoControl control = new ContatoControl();
    private TableView<Contato> table = new TableView<>();

    @Override
    public void start(Stage stage) {
        BorderPane panPrincipal = new BorderPane();
        GridPane p = new GridPane();
        Scene scn = new Scene( panPrincipal, 600, 400 );

        TextField txtNome = new TextField();
        TextField txtTelefone = new TextField();
        TextField txtEmail = new TextField();

        TableColumn<Contato, String> colNome = new TableColumn<>("Nome");
        colNome.setCellValueFactory( item -> 
            new ReadOnlyStringWrapper( item.getValue().getNome() ) );

        TableColumn<Contato, String> colEmail = new TableColumn<>("Email");
        colEmail.setCellValueFactory( item -> 
            new ReadOnlyStringWrapper( item.getValue().getEmail() ) );

        TableColumn<Contato, String> colTelefone = new TableColumn<>("Telefone");
        colTelefone.setCellValueFactory( item -> 
            new ReadOnlyStringWrapper( item.getValue().getTelefone() ) ); 

        table.getColumns().addAll( colNome, colEmail, colTelefone );

        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN);


        table.setItems( control.getLista() );

        Bindings.bindBidirectional( control.nomeProperty(), txtNome.textProperty() );
        Bindings.bindBidirectional( control.emailProperty(), txtEmail.textProperty() );
        Bindings.bindBidirectional( control.telefoneProperty(), txtTelefone.textProperty() );

        p.add(new Label("Nome e Sobrenome:"), 0, 0);
        p.add(new Label("Telefone:"), 0, 1);
        p.add(new Label("Email:"), 0, 2);
        p.add(txtNome, 1, 0);
        p.add(txtTelefone, 1, 1);
        p.add(txtEmail, 1, 2);

        Button btnSalvar = new Button( "Salvar" );
        Button btnPesquisar = new Button( "Pesquisar" );
        p.add( btnSalvar, 0, 3 );
        p.add( btnPesquisar, 1, 3 );

        btnSalvar.setOnAction( e -> {
            if (control.salvar()) { 
                new Alert(
                    Alert.AlertType.INFORMATION, "Contato salvo com sucesso",
                    ButtonType.OK
                ).showAndWait();
            } else { 
                new Alert(
                    Alert.AlertType.ERROR, "Erro ao salvar o contato",
                    ButtonType.OK
                ).showAndWait();
            }
        });

        btnPesquisar.setOnAction( e -> control.pesquisar() );

        panPrincipal.setTop( p );
        panPrincipal.setCenter( table );

        stage.setScene( scn );
        stage.show();
    }

    public static void main(String[] args) { 
        Application.launch(ContatoViewComTabela.class, args);
    }
}