package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class FuncoesDao {
    private Conexao conexao = new Conexao();

    public boolean inserirFuncoes() {
        try{
            Connection conndb = conexao.conectar();
            PreparedStatement novaFuncao = conndb.prepareStatement("INSERT INTO funcoes " +
                    "(nome) VALUES (?);");

            novaFuncao.setString(1, "Porteiro");

            int linhaAfetada = novaFuncao.executeUpdate();
            return linhaAfetada > 0;
        }catch (Exception erro) {
            System.out.println("Erro ao inserir função: " + erro);
            return false;
        }
    }
}
