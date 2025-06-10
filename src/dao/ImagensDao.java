package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ImagensDao {
    private Conexao conexao = new Conexao();

    public boolean inserirImagens() {
        try{
            Connection conndb = conexao.conectar();
            PreparedStatement novaImagem = conndb.prepareStatement("INSERT INTO imagens " +
                    "(nome, caminho) VALUES (?, ?);");

            novaImagem.setString(1, "Foto 1");
            novaImagem.setString(2, "C:users/fotos/foto1.jpg");

            int linhaAfetada = novaImagem.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir imagem: " + erro);
            return false;
        }
    }
    public boolean deletarImagens() {
        try{
            Connection conndb = conexao.conectar();
            PreparedStatement removeImagens = conndb.prepareStatement("DELETE FROM imagens WHERE id = ?;");

            removeImagens.setInt(1, 1);

            int linhaAfetada = removeImagens.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao deletar imagens: " + erro);
            return false;
        }
    }
}
