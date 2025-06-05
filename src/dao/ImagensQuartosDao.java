package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ImagensQuartosDao {
    private Conexao conexao = new Conexao();

    public boolean inserirImagensQuartos() {
        try{
            Connection conndb = conexao.conectar();
            PreparedStatement novaImagemQuarto = conndb.prepareStatement("INSERT INTO imagens_quartos " +
                    "(fk_imagens, fk_quartos) VALUES (?, ?);");

            novaImagemQuarto.setInt(1, 1);
            novaImagemQuarto.setInt(2, 1);

            int linhaAfetada = novaImagemQuarto.executeUpdate();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir imagem: " + erro);
            return false;
        }
    }
}
