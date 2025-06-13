package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdicionaisDao {
    private Conexao conexao = new Conexao();

    public boolean inserirAdicionais() {
        try{
            Connection conndb = conexao.conectar();
            PreparedStatement novoAdicionais = conndb.prepareStatement("INSERT INTO adicionais " +
                    "(nome, preco) VALUES (?, ?);");

            novoAdicionais.setString(1, "Cesta chocolate");
            novoAdicionais.setDouble(2, 197.99);

            int linhaAfetada = novoAdicionais.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }catch (Exception erro) {
            System.out.println("Erro ao inserir adicional: " + erro);
            return false;
        }
    }

    public boolean deletarAdicionais() {
        try{
            Connection conndb = conexao.conectar();
            PreparedStatement removeAdicionais = conndb.prepareStatement("DELETE FROM adicionais WHERE id = ?;");

            removeAdicionais.setInt(1, 1);

            int linhaAfetada = removeAdicionais.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao deletar adicionais: " + erro);
            return false;
        }
    }

    public boolean alterarAdicionais() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement alterarAdicionais = conndb.prepareStatement("UPDATE adicionais " + "SET nome = ?, preco = ? WHERE id = ?;");

            alterarAdicionais.setString(1, "Vinho");
            alterarAdicionais.setDouble(2, 1999.97);
            alterarAdicionais.setInt(3, 1);

            int linhaAfetada = alterarAdicionais.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao atualizar adicionais: " + erro);
        }
        return false;
    }

    public void pesquisarAdicionais() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement pesquisarAdicionais = conndb.prepareStatement("SELECT nome, preco FROM adicionais WHERE preco < ?;");
            pesquisarAdicionais.setInt(1, 1000);
            ResultSet resultado = pesquisarAdicionais.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                String preco = resultado.getString("preco");
                System.out.println("Nome: "+ nome + "\nPreco: "+ preco);
            }
            conndb.close();
        }
        catch (Exception erro) {
            System.out.println("Erro ao pesquisar adicionais: " + erro);
        }
    }
}
