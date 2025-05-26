package view;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Login extends Application {

    private boolean senhaVisivel = false;

    public void start(Stage stage) {
        //Carregamento das imagens
        Image eyeOpen = new Image(getClass().getResourceAsStream("/view/resources/img/olho-meio-aberto.png"));
        Image eyeClosed = new Image(getClass().getResourceAsStream("/view/resources/img/invisivel.png"));


        //Visualização das imagens
        ImageView viewEyeOpen = new ImageView(eyeOpen);
        viewEyeOpen.setFitWidth(20);
        viewEyeOpen.setFitHeight(20);

        ImageView viewEyeClosed = new ImageView(eyeClosed);
        viewEyeClosed.setFitWidth(20);
        viewEyeClosed.setFitHeight(20);

        //Componente utilizado para senha no JavaFX
        PasswordField senha = new PasswordField();
        senha.setPromptText("Digite sua senha");

        //TextField (permite visibilidade da informação)
        TextField txtSenha = new TextField();
        txtSenha.setPromptText("Digite sua senha");
        txtSenha.setVisible(false);
        txtSenha.setManaged(false);

        //Botão
        Button toggleBtn = new Button();
        toggleBtn.setGraphic(viewEyeOpen);
        toggleBtn.setStyle("-fx-background-color: transparent;");

        //Chamada para o evento a partir do clique no toggleBtn
        toggleBtn.setOnAction(evento -> {
            senha.setVisible(senhaVisivel);
            senha.setManaged(senhaVisivel);
            txtSenha.setVisible(!senhaVisivel);
            txtSenha.setManaged(!senhaVisivel);
            toggleBtn.setGraphic(senhaVisivel ? viewEyeOpen : viewEyeClosed );
            if (senhaVisivel) {
                senha.setText(txtSenha.getText());
            }else {
                txtSenha.setText(senha.getText());
            }
            senhaVisivel = !senhaVisivel;

            //Se a senha está visivel, ou seja, senhaVisivel = true
//            if (senhaVisivel) {
//                //Seta o texto de txtSenha (visível) para senha (passwordField)
//                senha.setText(txtSenha.getText());
//                //Exibe novamente senha (passwordField) e o inclui no layout
//                senha.setVisible(true);
//                senha.setManaged(true);
//                //Oculta txtSenha (TextField) e o retira do layout para não ocupar espaço
//                txtSenha.setVisible(false);
//                txtSenha.setManaged(false);
//                /*Troca o ícone do botão para o olho aberto, indicando que a
//                senha pode ser novamente vista ao clicar*/
//                toggleBtn.setGraphic(viewEyeOpen);
//                //Atualiza a variável de controle indicando que a senha não está visível
//                senhaVisivel = false;
//            }
//
//            //Se a senha está oculta, portanto senhaVisivel = false
//            else {
//                //Seta o texto de senha (PasswordField - invisível) para txtSenha (TextField - visível)
//                txtSenha.setText(senha.getText());
//
//                //Exibe o componente txtSenha (texto visível) e o inclui no layout
//                txtSenha.setVisible(true);
//                txtSenha.setManaged(true);
//
//                //Oculta o componente senha (PasswordField - invisível) e o retira do layout
//                senha.setVisible(false);
//                senha.setManaged(false);
//
//                /*Troca o ícone do botão para o olho fechado, indicando que a
//                senha pode ser novamente oculta ao clicar*/
//                toggleBtn.setGraphic(viewEyeClosed);
//
//                senhaVisivel = true;
//            }
        });



        //Botão Login
        Button btnLogin = new Button("Acessar");

        HBox senhaBox = new HBox(5, senha, txtSenha, toggleBtn);
        senhaBox.setAlignment(Pos.CENTER);


        VBox mainBox = new VBox(20, senhaBox, btnLogin);
        mainBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(mainBox, 600, 400);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}