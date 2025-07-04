package view;

import controller.QuartosController;
import controller.UsuariosController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Quartos;
import view.components.Buttons;
import view.components.Sidebar;

public class CadQuarto extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        BorderPane mainPane = new BorderPane();

        Buttons buttons = new Buttons();
        buttons.setAlignment(Pos.CENTER);
        buttons.setPadding(new Insets(20,20,20,20));

        Sidebar sidebar = new Sidebar();
        mainPane.setLeft(sidebar);

        Font fontRegular = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/DmSansRegular.ttf"), 12);
        Font fontSemiBold = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/DmSansSemiBold.ttf"), 12);

        String styleSemiBold = "-fx-text-fill: #000000;" +
                "-fx-font-size: 18;" +
                "-fx-font-family: '" + fontSemiBold.getFamily() + "';";

        String styleRegular = "-fx-text-fill: #000000;" +
                "-fx-font-size: 12;" +
                "-fx-font-family: '" + fontRegular.getFamily() + "';";

        Image iconBtnQuarto = new Image(getClass().getResourceAsStream("/view/resources/img/Quarto2.png"));

        ImageView iconQuarto = new ImageView(iconBtnQuarto);
        iconQuarto.setFitWidth(20);
        iconQuarto.setFitHeight(20);

        Label lblTitulo = new Label("Cadastro de Quarto: ");
        lblTitulo.setStyle(styleSemiBold);
        lblTitulo.setAlignment(Pos.CENTER);
        HBox tituloBox = new HBox(iconQuarto, lblTitulo);
        tituloBox.setPadding(new Insets(20,20,20,20));
        tituloBox.setAlignment(Pos.CENTER);

        Label lblNome = new Label("Nome do Quarto: ");
        lblNome.setStyle(styleRegular);
        TextField txtNome = new TextField();
        txtNome.setMinWidth(200);

        Label lblNumero = new Label("Numero do Quarto: ");
        lblNumero.setStyle(styleRegular);
        TextField txtNumero = new TextField();
        txtNumero.setMinWidth(200);

        Label lblPreco = new Label("Preço do Quarto: ");
        lblNumero.setStyle(styleRegular);
        TextField txtPreco = createMaskField("R$###,##");;
        txtNumero.setMinWidth(200);

        Label lblCamaCasal = new Label("Quantidade Cama Casal: ");
        lblCamaCasal.setStyle(styleRegular);
        Spinner<Integer> qtdCamaCasal = new Spinner<>(0, 2, 0);
        qtdCamaCasal.setMinWidth(200);

        Label lblCamaSolteiro = new Label("Quantidade Cama Solteiro: ");
        lblCamaSolteiro.setStyle(styleRegular);
        Spinner<Integer> qtdCamaSolteiro = new Spinner<>(0, 2, 0);
        qtdCamaSolteiro.setMinWidth(200);

        ComboBox disponivelOpt = new ComboBox();
        disponivelOpt.getItems().addAll("Disponivel", "Indisponivel");
        disponivelOpt.setMinWidth(120);

        GridPane fromGrid = new GridPane();
        fromGrid.setAlignment(Pos.CENTER);
        fromGrid.add(lblNome,0, 0);
        fromGrid.add(txtNome, 1, 0);
        fromGrid.add(lblNumero, 0, 1);
        fromGrid.add(txtNumero, 1, 1);
        fromGrid.add(lblPreco, 0, 2);
        fromGrid.add(txtPreco, 1, 2);
        fromGrid.add(lblCamaCasal, 0, 3);
        fromGrid.add(qtdCamaCasal, 1, 3);
        fromGrid.add(lblCamaSolteiro, 0, 4);
        fromGrid.add(qtdCamaSolteiro, 1, 4);
        fromGrid.add(disponivelOpt, 0, 5);
        fromGrid.setHgap(10);
        fromGrid.setVgap(10);

        buttons.btnCadastrar.setOnAction(evento -> {
            String nome = txtNome.getText();  //TextField do nome do quarto
            String numero = txtNumero.getText(); //TextField do número do quarto
            double preco = Double.parseDouble(txtPreco.getText()); //TextField do preço do quarto
            int camaSolteiro = qtdCamaSolteiro.getValue(); //Spinner da qtd cama de solteiro do quarto
            int camaCasal = qtdCamaCasal.getValue(); //Spinner da qtd cama de casal do quarto

            //ComboBox da disponibilidade do quarto
            String disponivel = (String) disponivelOpt.getSelectionModel().getSelectedItem();
            boolean isDisponivel;
            if (disponivel.equals("Disponivel")) {
                isDisponivel = true;
            } else {
                isDisponivel = false;
            }
            QuartosController quartosController = new QuartosController();

            boolean sucessoInsercao = quartosController.verificarInfosQuartos(nome,numero,camaCasal,camaSolteiro,
                    preco, isDisponivel);
            if (sucessoInsercao) {
                System.out.println("Quarto cadastrado com sucesso!");
            } else {
                System.out.println("Não foi possivel cadastrar o quarto!");
            }
        });

        VBox layout = new VBox(tituloBox, fromGrid, buttons);
        layout.setAlignment(Pos.CENTER);
        mainPane.setCenter(layout);

        Scene scene = new Scene(mainPane, 750,500);
        stage.setTitle("Cadastro de Cliente");
        stage.setScene (scene);
        stage.setResizable(false);
        stage.show();
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
