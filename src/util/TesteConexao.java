package util;

import dao.*;
import model.Usuarios;

import java.sql.Connection;

public class TesteConexao {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        //Novo objeto criado (nova instância da classe model.Usuarios)
        Usuarios usuario = new Usuarios("Pamella Christini Pereto e Silva", "pamellapereto@gmail.com", "123", 1);

        Connection condb = conexao.conectar();
        if (condb != null) {
            System.out.println("Conexão estabelcida com sucesso!");
            try {

                //Testando a inserção e a autenticação de um usuário
                UsuariosDao usuariosDao = new UsuariosDao();

                //usuariosDao.inserirUsuario();
                usuariosDao.autenticarUsuario(usuario); //Objeto passado como parâmetro para autenticação



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