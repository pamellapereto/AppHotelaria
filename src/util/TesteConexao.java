package util;
import controller.UsuariosController;
import dao.*;
import model.Usuarios;

import java.sql.Connection;

public class TesteConexao {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        UsuariosController usuariosController = new UsuariosController();
        Connection condb = conexao.conectar();
            if (condb != null) {
            System.out.println("Conexão estabelecida com sucesso!");
            try {
                //Testando a autenticação de um usuário
                usuariosController.verificarCredenciais("admin@gmail.com", "admin");
                condb.close();
                System.out.println("Conexão encerrada!");
            } catch (Exception erro) {
                System.out.println("Erro ao encerrar a conexão: " + erro.getMessage()); }
        } else {
            System.out.println("Falha ao conectar ao banco de dados!");}
    }
}