package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FuncoesDao {
    private Conexao conexao = new Conexao();

    public boolean inserirFuncoes() {
        try{
            Connection conndb = conexao.conectar();
            PreparedStatement novaFuncao = conndb.prepareStatement("INSERT INTO funcoes " +
                    "(nome) VALUES (?);");

            novaFuncao.setString(1, "Porteiro");

            int linhaAfetada = novaFuncao.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }catch (Exception erro) {
            System.out.println("Erro ao inserir função: " + erro);
            return false;
        }
    }
    public boolean deletarFuncoes() {
        try{
            Connection conndb = conexao.conectar();
            PreparedStatement removeFuncoes = conndb.prepareStatement("DELETE FROM funcoes WHERE id = ?;");

            removeFuncoes.setInt(1, 1);

            int linhaAfetada = removeFuncoes.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao deletar funcoes: " + erro);
            return false;
        }
    }

    public boolean alterarFuncoes() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement alterarFuncoes = conndb.prepareStatement("UPDATE funcoes " + "SET nome = ? WHERE id = ?;");

            alterarFuncoes.setString(1, "Secretária");
            alterarFuncoes.setInt(2, 3);

            int linhaAfetada = alterarFuncoes.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao atualizar função: " + erro);
        }
        return false;
    }

    public void pesquisarFuncoes() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement pesquisarFuncoes = conndb.prepareStatement("SELECT nome FROM funcoes WHERE id = ?;");
            pesquisarFuncoes.setInt(1, 1);
            ResultSet resultado = pesquisarFuncoes.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                System.out.println("Nome: "+ nome);
            }
            conndb.close();
        }
        catch (Exception erro) {
            System.out.println("Erro ao pesquisar funcoes: " + erro);
        }
    }
}
