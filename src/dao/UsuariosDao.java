package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuariosDao {
    private Conexao conexao = new Conexao();

    public boolean inserirUsuario() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoUsuario = conndb.prepareStatement("INSERT INTO usuarios " +
                    "(nome, senha, email, fk_funcoes) VALUES (?, md5(?), ?, ?);");

            novoUsuario.setString(1, "João");
            novoUsuario.setString(2, "123");
            novoUsuario.setString(3,"joasouza123@gmail.com" );
            novoUsuario.setInt(4, 1);

            int linhaAfetada = novoUsuario.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir usuario: " + erro);
            return false;
        }
    }

    public boolean deletarUsuario() {
        try{
            Connection conndb = conexao.conectar();
            PreparedStatement removeUsuario = conndb.prepareStatement("DELETE FROM usuarios WHERE id = ?;");

            removeUsuario.setInt(1, 1);

            int linhaAfetada = removeUsuario.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao deletar usuario: " + erro);
            return false;
        }
    }

    public boolean alterarUsuario() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement alterarUsuario = conndb.prepareStatement("UPDATE usuarios " + "SET nome = ?, senha = md5(?), email = ?, fk_funcoes = ? WHERE id = ?;");

            alterarUsuario.setString(1, "João");
            alterarUsuario.setInt(2, 321);
            alterarUsuario.setString(3, "Souza@gmail.com");
            alterarUsuario.setInt(4, 1);
            alterarUsuario.setInt(5, 3);

            int linhaAfetada = alterarUsuario.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao atualizar usuario: " + erro);
        }
        return false;
    }

    public void pesquisarUsuario() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement pesquisarUsuario = conndb.prepareStatement("SELECT nome, email FROM usuarios WHERE fk_funcoes = ?;");
            pesquisarUsuario.setInt(1, 1);
            ResultSet resultado = pesquisarUsuario.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                String email = resultado.getString("email");
                System.out.println("Nome: "+ nome + "\nEmail: "+ email);
            }
            conndb.close();
        }
        catch (Exception erro) {
            System.out.println("Erro ao pesquisar usuario: " + erro);
        }
    }
}

