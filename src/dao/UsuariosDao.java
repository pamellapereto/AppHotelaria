package dao;

import model.Usuarios;
import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UsuariosDao {
    private Conexao conexao = new Conexao();

    public boolean inserirUsuario() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoUsuario = conndb.prepareStatement("INSERT INTO usuarios " +
                    "(nome, senha, email, fk_funcoes) VALUES (?, ?, md5(?), ?);");

            novoUsuario.setString(1, "João");
            novoUsuario.setString(2, "123");
            novoUsuario.setString(3,"joaosouza123@gmail.com" );
            novoUsuario.setInt(4, 1);

            int linhaAfetada = novoUsuario.executeUpdate();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir usuario: " + erro);
            return false;
        }
    }
}
