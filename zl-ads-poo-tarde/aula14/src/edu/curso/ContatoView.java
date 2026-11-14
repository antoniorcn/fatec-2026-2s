package edu.curso;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
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
import javafx.util.converter.NumberStringConverter;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableCell;
import javafx.util.Callback;
import javafx.beans.property.ReadOnlyStringWrapper;

public class ContatoView extends Application {

    private ContatoControl control = new ContatoControl();
    private TableView<Contato> table = new TableView<>();

    @Override
    public void start(Stage stage) {
        BorderPane panPrincipal = new BorderPane();
        GridPane p = new GridPane();
        Scene scn = new Scene( panPrincipal, 600, 400 );

        TextField txtId = new TextField();
        txtId.setEditable( false );
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

        TableColumn<Contato, Void> colAcoes = new TableColumn<>("Ações");

        Callback< TableColumn<Contato, Void>, TableCell<Contato, Void> > callBack = new Callback<>() {
            @Override
            public TableCell<Contato, Void> call( TableColumn<Contato, Void> coluna ) { 
                TableCell<Contato, Void> celula = new TableCell<>() { 
                    private final Button btnExcluir = new Button( "Excluir");
                    private final Button btnAtualizar = new Button( "Atualizar");
                    private final HBox painelBotoes = new HBox();

                    {
                        btnExcluir.setOnAction( e -> { 
                            // Contato c = getTableRow().getItem();
                            // control.excluir( c );
                            control.excluir( getTableRow().getItem() );
                        });
                        btnAtualizar.setOnAction( e -> { 
                            control.atualizar( getTableRow().getItem() );
                        });
                        painelBotoes.getChildren().addAll( btnAtualizar, btnExcluir );
                    }

                    @Override
                    protected void updateItem( Void item, boolean empty ) { 
                        super.updateItem( item, empty );
                        if (!empty) { 
                            setGraphic( painelBotoes  );
                        } else { 
                            setGraphic( null );
                        }
                    }
                };
                return celula;
            }
        };

        colAcoes.setCellFactory( callBack );

        table.getColumns().addAll( colNome, colEmail, colTelefone, colAcoes );

        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN);


        table.setItems( control.getLista() );

        table.getSelectionModel().selectedItemProperty().addListener(
            (obs, antigo, novo) -> { 
                if (novo != null) { 
                    txtNome.setText( novo.getNome() );
                    txtEmail.setText( novo.getEmail() );
                    txtTelefone.setText( novo.getTelefone() );
                }
            }
        );

        Bindings.bindBidirectional( txtId.textProperty(), control.idProperty(), new NumberStringConverter()  );
        Bindings.bindBidirectional( txtNome.textProperty(), control.nomeProperty() );
        Bindings.bindBidirectional( txtEmail.textProperty(), control.emailProperty() );
        Bindings.bindBidirectional( txtTelefone.textProperty(), control.telefoneProperty() );

        p.add(new Label("Id:"), 0, 0);
        p.add(new Label("Nome e Sobrenome:"), 0, 1);
        p.add(new Label("Telefone:"), 0, 2);
        p.add(new Label("Email:"), 0, 3);
        p.add(txtId, 1, 0);
        p.add(txtNome, 1, 1);
        p.add(txtTelefone, 1, 2);
        p.add(txtEmail, 1, 3);

        Button btnSalvar = new Button( "Salvar" );
        Button btnPesquisar = new Button( "Pesquisar" );
        p.add( btnSalvar, 0, 4 );
        p.add( btnPesquisar, 1, 4 );

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
        Application.launch(ContatoView.class, args);
    }
}