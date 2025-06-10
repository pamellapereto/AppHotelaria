package util;

import dao.*;
import model.Clientes;
import model.Usuarios;

import java.sql.Connection;

public class TesteConexao {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        Connection condb = conexao.conectar();
        if (condb != null) {
            System.out.println("Conexão estabelcida com sucesso!");
            try {

                UsuariosDao usuariosDao = new UsuariosDao();
                usuariosDao.deletarUsuario();

                System.out.println("Usuario removido com sucesso!");
                condb.close();
                System.out.println("Conexão encerrada!");

            } catch (Exception erro) {
                System.out.println("Erro ao encerrar a conexão: " + erro.getMessage());
            }
        } else {
            System.out.println("Falha ao conectar ao banco de dados!");
        }
    }
}