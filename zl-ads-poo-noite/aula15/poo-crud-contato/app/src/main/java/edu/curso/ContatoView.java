package edu.curso;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.event.EventHandler;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import javafx.beans.binding.Bindings;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableCell;
import javafx.util.Callback;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.util.converter.NumberStringConverter;

public class ContatoView extends Application {

    private ContatoControl control = new ContatoControl();
    private TableView<Contato> table = new TableView<>();

    @Override
    public void start(Stage stage) {
        BorderPane panPrincipal = new BorderPane();
        GridPane p = new GridPane();
        Scene scn = new Scene( panPrincipal, 600, 400 );
        stage.setScene( scn );

        p.add( new Label("Id: "), 0, 0 );
        p.add( new Label("Nome e Sobrenome: "), 0, 1 );
        p.add( new Label("Telefone: "), 0, 2 );
        p.add( new Label("Email: "), 0, 3 );

        TextField txtId = new TextField();
        txtId.setEditable( false );

        TextField txtNome = new TextField();
        TextField txtTelefone = new TextField();
        TextField txtEmail = new TextField();
        
        p.add( txtId, 1, 0 );
        p.add( txtNome, 1, 1 );
        p.add( txtTelefone, 1, 2 );
        p.add( txtEmail, 1, 3 );


        TableColumn<Contato, String> colNome = new TableColumn<>("Nome");
        colNome.setCellValueFactory(
            item -> new ReadOnlyStringWrapper(item.getValue().getNome())
        );

        TableColumn<Contato, String> colEmail = new TableColumn<>("Email");
        colEmail.setCellValueFactory(
            item -> new ReadOnlyStringWrapper(item.getValue().getEmail())
        );

        TableColumn<Contato, String> colTelefone = new TableColumn<>("Telefone");
        colTelefone.setCellValueFactory(
            item -> new ReadOnlyStringWrapper(item.getValue().getTelefone())
        );

        TableColumn<Contato, Void> colAcoes = new TableColumn<>("Ações");
        Callback<TableColumn<Contato, Void>, TableCell<Contato, Void>> callBack = 
            new Callback<>(){ 
                public TableCell<Contato, Void> call(TableColumn<Contato, Void> tc) { 
                    TableCell<Contato, Void> tableCell = new TableCell<>(){

                        private final Button btnExcluir = new Button("Excluir");
                        private final Button btnAtualizar = new Button("Atualizar");
                        private final HBox painelBotoes = new HBox();
                        
                        {
                            painelBotoes.getChildren().addAll(btnAtualizar, btnExcluir);
                            btnExcluir.setOnAction( e -> {
                                    System.out.printf("Contato %s excluido\n", getTableRow().getItem() );
                                    control.excluir( getTableRow().getItem() );
                                });
                            btnAtualizar.setOnAction( e -> {
                                    System.out.printf("Contato %s atualizado\n", getTableRow().getItem() );
                                    control.atualizar( getTableRow().getItem() );
                                });
                        }
                        public void updateItem(Void valor, boolean empty) {
                            if (!empty) {                                
                                setGraphic( painelBotoes );
                            } else { 
                                setGraphic(null);
                            }
                        }
                    };
                    return tableCell;
                }
            };
        colAcoes.setCellFactory( callBack );

        table.getColumns().addAll( colNome, colEmail, colTelefone, colAcoes );
        table.setItems( control.getLista() );

        table.getSelectionModel()
            .selectedItemProperty()
            .addListener(
                (obs, antigo, novo) -> { 
                    control.popularContato(  novo  ); 
                } 
            );

        Bindings.bindBidirectional(txtId.textProperty(), control.idProperty(), new NumberStringConverter());
        Bindings.bindBidirectional(txtNome.textProperty(), control.nomeProperty() );
        Bindings.bindBidirectional(txtEmail.textProperty(), control.emailProperty() );
        Bindings.bindBidirectional(txtTelefone.textProperty(), control.telefoneProperty() );

        Button btnSalvar = new Button("Salvar");
        Button btnPesquisar = new Button("Pesquisar");
        p.add( btnSalvar, 0, 4 );
        p.add( btnPesquisar, 1, 4 );

        btnSalvar.setOnAction( e -> { 
            if (control.salvar()) { 
                new Alert(AlertType.INFORMATION, 
                    "Contato cadastrado com sucesso", ButtonType.OK)
                    .showAndWait();
            }
        });

        panPrincipal.setTop( p );
        panPrincipal.setCenter( table );

        btnPesquisar.setOnAction( e -> control.pesquisar() );
        stage.show();
    }

    public static void main(String[] args) { 
        Application.launch(ContatoView.class, args);
    }
}