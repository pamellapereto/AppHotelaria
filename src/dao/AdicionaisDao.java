package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

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
}
