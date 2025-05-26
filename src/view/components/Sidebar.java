package view.components;


import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

//SE ACONTECEU ISSO DEU MERDA


public class Sidebar extends VBox {
    public Button btnCliente = new Button("Clientes");
    public Button btnFuncionario = new Button("Funcionarios");
    public Button btnQuarto = new Button("Quartos");
    public Button btnReserva = new Button("Reservas");
    public Button btnRelatorio = new Button("Relatórios");

    public Sidebar() {
        Image iconFuncionario = new Image(getClass().getResourceAsStream(
                "/view/resources/img/icon-funcionario.png"));
        Image iconCliente = new Image(getClass().getResourceAsStream(
                "/view/resources/img/icon-cliente.png"));
        Image iconQuarto = new Image(getClass().getResourceAsStream(
                "/view/resources/img/icon-quarto.png"));
        Image iconRelatorio = new Image(getClass().getResourceAsStream(
                "/view/resources/img/icon-relatorio.png"));
        Image iconReserva = new Image(getClass().getResourceAsStream(
                "/view/resources/img/icon-reserva.png"));

        //Carregamento das fontes
        Font fonteRegular = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/" +
                "LeagueSpartan-Regular.ttf"), 14);

        Font fonteNegrito = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/" +
                "LeagueSpartan-Bold.ttf"), 15);


        //Objeto para manipular dimensões da imagem JÁ CARREGADAS
        ImageView viewIconFuncionario =  new ImageView(iconFuncionario);
        viewIconFuncionario.setFitHeight(30); //Altura
        viewIconFuncionario.setFitWidth(30); //Largura

        ImageView viewIconCliente =  new ImageView(iconCliente);
        viewIconCliente.setFitHeight(30); //Altura
        viewIconCliente.setFitWidth(30); //Largura

        ImageView viewIconQuarto =  new ImageView(iconQuarto);
        viewIconQuarto.setFitHeight(30); //Altura
        viewIconQuarto.setFitWidth(30); //Largura

        ImageView viewIconRelatorio =  new ImageView(iconRelatorio);
        viewIconRelatorio.setFitHeight(30); //Altura
        viewIconRelatorio.setFitWidth(30); //Largura

        ImageView viewIconReserva =  new ImageView(iconReserva);
        viewIconReserva.setFitHeight(30); //Altura
        viewIconReserva.setFitWidth(30); //Largura

        btnCliente.setGraphic(viewIconCliente);
        btnFuncionario.setGraphic(viewIconFuncionario);
        btnQuarto.setGraphic(viewIconQuarto);
        btnReserva.setGraphic(viewIconRelatorio);
        btnRelatorio.setGraphic(viewIconReserva);

        Label lblMenu = new Label("Grand Hotel");
        lblMenu.setStyle("-fx-text-fill: #d6c388;"       //Cor
        );
        lblMenu.setFont(Font.font(fonteNegrito.getFamily(), 25));

        //Estilização dos botões (fundo e borda transparentes)
        String styleButton = "-fx-background-color: transparent;" +
                             "-fx-border-color: transparent; " +
                             "-fx-graphic-text-gap: 10px;" +
                             "-fx-alignment: center;" +
                             "-fx-cursor: hand;";   //Setar o cursor de mãozinha para o mouse

        btnCliente.setStyle(styleButton);
        btnFuncionario.setStyle(styleButton);
        btnQuarto.setStyle(styleButton);
        btnReserva.setStyle(styleButton);
        btnRelatorio.setStyle(styleButton);

        //Objetivo: ao passar o mouse, trocar o fundo do botão para uma cor que desejar
        btnCliente.setOnMouseEntered(evento ->
                btnCliente.setStyle(styleButton.replace("transparent", "#D6C388FF")));

        btnCliente.setOnMouseExited(evento -> btnCliente.setStyle(styleButton));



        //Espaçamento externo (margem) do componente label até o botão
        setMargin(lblMenu, new Insets(0,        0,       20,       0));
                    //margem:        superior,   direita,    inferior,    esquerda

        setStyle("-fx-background-color: #ffffff; -fx-padding: 40px;");
        setSpacing(12);   //Metodo setSpacing para espaçar todos os componentes que fazem parte do menu
        getChildren().addAll(lblMenu, btnCliente, btnFuncionario,
                btnQuarto, btnReserva, btnRelatorio);
    }
}
