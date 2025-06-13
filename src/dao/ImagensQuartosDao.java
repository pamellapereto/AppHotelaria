package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir imagem: " + erro);
            return false;
        }
    }
    public boolean deletarImagensQuartos() {
        try{
            Connection conndb = conexao.conectar();
            PreparedStatement removeImagensQuartos = conndb.prepareStatement("DELETE FROM imagens_quartos WHERE id = ?;");

            removeImagensQuartos.setInt(1, 1);

            int linhaAfetada = removeImagensQuartos.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao deletar imagens_quartos: " + erro);
            return false;
        }
    }

    public boolean alterarImagensQuartos() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement alterarImagensQuartos = conndb.prepareStatement("UPDATE imagens_quartos " + "SET fk_imagens = ?, fk_quartos = ? WHERE id = ?;");

            alterarImagensQuartos.setInt(1, 1);
            alterarImagensQuartos.setInt(2, 1);
            alterarImagensQuartos.setInt(3, 1);

            int linhaAfetada = alterarImagensQuartos.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao atualizar imagens_quartos: " + erro);
        }
        return false;
    }

    public void pesquisarImagensQuartos() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement pesquisarImagensQuartos = conndb.prepareStatement("SELECT fk_imagens, fk_quartos FROM imagens_quartos WHERE id = ?;");
            pesquisarImagensQuartos.setInt(1, 1);
            ResultSet resultado = pesquisarImagensQuartos.executeQuery();

            while (resultado.next()) {
                String fk_imagens = resultado.getString("fk_imagens");
                String fk_quartos = resultado.getString("fk_quartos");
                System.out.println("fk_imagens = " + fk_imagens + " fk_quartos = " + fk_quartos);
            }
            conndb.close();
        }
        catch (Exception erro) {
            System.out.println("Erro ao pesquisar imagens_quartos: " + erro);
        }
    }
}
