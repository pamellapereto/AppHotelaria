package dao;

import model.Usuarios;
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
                    "(nome, senha, email, fk_cargos) VALUES (?, md5(?), ?, ?);");

            novoUsuario.setString(1, "Pamella Christini Pereto e Silva");
            novoUsuario.setString(2, "123");
            novoUsuario.setString(3,"pamellapereto@gmail.com" );
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
    public boolean autenticarUsuario(Usuarios usuario) {
                try { Connection conndb = conexao.conectar();
                    PreparedStatement stmt = conndb.prepareStatement
                    ("SELECT nome FROM usuarios WHERE email = ? AND senha = md5(?);");
            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, usuario.getSenha());
            ResultSet resultado = stmt.executeQuery();
            boolean acessoAutorizado = resultado.next();
                String nome = resultado.getString("nome");
                System.out.println("Olá, seja bem-vindo, " + nome);
            conndb.close();
            return acessoAutorizado;
        } catch (Exception erro) {
            System.out.println("Erro ao pesquisar usuario: " + erro);
            return false;
        }
    }
}

