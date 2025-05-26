package view.components;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class PanelButtons extends HBox {
    public Button btnCadastrar = new Button("Cadastrar");
    public Button btnAtualizar = new Button("Atualizar");
    public Button btnExcluir = new Button("Excluir");

    public PanelButtons() {
        Image iconBtnCadastrar = new Image(getClass().getResourceAsStream("/view/resources/img/mais.png"));
        Image iconBtnAtualizar = new Image(getClass().getResourceAsStream("/view/resources/img/Atualizar.png"));
        Image iconBtnExcluir = new Image(getClass().getResourceAsStream("/view/resources/img/lixo.png"));

        ImageView iconCadastrar = new ImageView(iconBtnCadastrar);
        iconCadastrar.setFitWidth(30);
        iconCadastrar.setFitHeight(30);

        ImageView iconAtualizar = new ImageView(iconBtnAtualizar);
        iconAtualizar.setFitWidth(30);
        iconAtualizar.setFitHeight(30);

        ImageView iconExcluir = new ImageView(iconBtnExcluir);
        iconExcluir.setFitWidth(30);
        iconExcluir.setFitHeight(30);

        btnCadastrar.setGraphic(iconCadastrar);
        btnAtualizar.setGraphic(iconAtualizar);
        btnExcluir.setGraphic(iconExcluir);

        getChildren().addAll(btnCadastrar, btnAtualizar, btnExcluir);

    }

}
