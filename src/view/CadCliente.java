package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import view.components.PanelButtons;
import view.components.Sidebar;

public class CadCliente extends Application {

    @Override
    public void start(Stage janela) throws Exception {
        Sidebar menu = new Sidebar();
        PanelButtons buttons = new PanelButtons();

        Image iconBtnPessoa = new Image(getClass().getResourceAsStream("/view/resources/img/Pessoa.png"));

        BorderPane mainPane = new BorderPane();
        mainPane.setLeft(menu);


        ImageView iconPessoa = new ImageView(iconBtnPessoa);
        iconPessoa.setFitWidth(20);
        iconPessoa.setFitHeight(20);

        Label lblTitulo = new Label("Cadastro de Cliente");
        lblTitulo.setAlignment(Pos.CENTER);
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold");
        HBox tituloBox = new HBox(iconPessoa, lblTitulo);
        tituloBox.setPadding(new Insets(20,20,20,20));
        tituloBox.setAlignment(Pos.CENTER);

        Label lblNome = new Label("Nome");
        TextField txtNome = new TextField();
        txtNome.setMaxWidth(200);

        Label lblCpf = new Label("CPF");
        TextField txtCpf = createMaskField("###.###.###-##");
        txtCpf.setMaxWidth(200);

        Label lblTelefone = new Label("Telefone");
        TextField txtTelefone = createMaskField("(##) #####-####");
        txtTelefone.setMaxWidth(200);

        Label lblEmail = new Label("Email");
        TextField txtEmail = new TextField();
        txtEmail.setMinWidth(200);

        ComboBox emailOpt = new ComboBox();
        emailOpt.getItems().addAll("@gmail.com", "@email.com","@yahoo.com");
        emailOpt.setMinWidth(120);

        GridPane gridEmail = new GridPane();
        gridEmail.add(txtEmail, 1, 0);
        gridEmail.add(emailOpt, 2, 0);
        gridEmail.setMaxWidth(200);

        GridPane fromGrid = new GridPane();
        fromGrid.setAlignment(Pos.CENTER);
        fromGrid.add(lblNome,0, 0);
        fromGrid.add(txtNome, 1, 0);
        fromGrid.add(lblCpf, 0, 1);
        fromGrid.add(txtCpf, 1, 1);
        fromGrid.add(lblTelefone, 0, 2);
        fromGrid.add(txtTelefone, 1, 2);
        fromGrid.add(lblEmail, 0, 3);
        fromGrid.add(gridEmail, 1, 3);
        fromGrid.setHgap(10);
        fromGrid.setVgap(10);

        fromGrid.add(buttons, 1, 4);

        VBox layout = new VBox(tituloBox, fromGrid);
        layout.setAlignment(Pos.CENTER);
        mainPane.setCenter(layout);

        Scene scene = new Scene(mainPane, 650,500);
        janela.setTitle("Cadastro de Cliente");
        janela.setScene (scene);
        janela.setResizable(false);
        janela.show();
    }

    private TextField createMaskField(String mask) {
        TextField txtMask = new TextField();
        txtMask.textProperty().addListener((observable, oldValue, newValue) -> {
            String value = newValue.replaceAll("[^0-9]", "");
            StringBuilder formatField = new StringBuilder();
            int index = 0;
            for (char caracter : mask.toCharArray()) {
                if (caracter == '#') {
                    if (index < value.length()) {
                        formatField.append(value.charAt(index));
                        index++;
                    } else {
                        break;
                    }
                } else {
                    formatField.append(caracter);
                }
            }
            txtMask.setText(formatField.toString());
        });
        return txtMask;
    }

    public static void main(String[] args) {
        launch(args);
    }
}