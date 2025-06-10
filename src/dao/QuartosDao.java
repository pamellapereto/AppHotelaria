package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class QuartosDao {
    private Conexao conexao = new Conexao();

    public boolean inserirQuartos() {
        try{
            Connection conndb = conexao.conectar();
            PreparedStatement novoQuarto = conndb.prepareStatement("INSERT INTO quartos " +
                    "(nome, numero, qtd_cama_casal, qtd_cama_solteiro, preco, disponivel)" +
                    "VALUES (?, ?, ?, ?, ?, ?);");

            novoQuarto.setString(1, "Suíte");
            novoQuarto.setInt(2, 1);
            novoQuarto.setInt(3,1);
            novoQuarto.setInt(4, 2);
            novoQuarto.setDouble(5, 1500.00);
            novoQuarto.setBoolean(6, true);

            int linhaAfetada = novoQuarto.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }catch (Exception erro) {
            System.out.println("Erro ao inserir quarto: " + erro);
            return false;
        }
    }
    public boolean deletarQuartos() {
        try{
            Connection conndb = conexao.conectar();
            PreparedStatement removeQuarto = conndb.prepareStatement("DELETE FROM quartos WHERE id = ?;");

            removeQuarto.setInt(1, 1);

            int linhaAfetada = removeQuarto.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao deletar quarto: " + erro);
            return false;
        }
    }
}
