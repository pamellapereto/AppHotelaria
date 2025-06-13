package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

    public boolean alterarImagens() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement alterarImagens = conndb.prepareStatement("UPDATE imagens " + "SET nome = ?, caminho = ? WHERE id = ?;");

            alterarImagens.setString(1, "Foto 2");
            alterarImagens.setString(2, "C:users/fotos/foto2.jpg");
            alterarImagens.setInt(3, 1);

            int linhaAfetada = alterarImagens.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao atualizar imagens: " + erro);
        }
        return false;
    }

    public void pesquisarImagens() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement pesquisarImagens = conndb.prepareStatement("SELECT nome, caminho FROM imagens WHERE id = ?;");
            pesquisarImagens.setInt(1, 1);
            ResultSet resultado = pesquisarImagens.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                String caminho = resultado.getString("caminho");
                System.out.println("Nome: " + nome + " Caminho: " + caminho);
            }
            conndb.close();
        }
        catch (Exception erro) {
            System.out.println("Erro ao pesquisar imagens: " + erro);
        }
    }
}
