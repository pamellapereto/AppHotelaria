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
                //ImagensQuartosDao imagensQuartosDao = new ImagensQuartosDao();
                //imagensQuartosDao.inserirImagensQuartos();

                UsuariosDao usuariosDao = new UsuariosDao();
                usuariosDao.inserirUsuario();

                QuartosDao quartosDao = new QuartosDao();
                quartosDao.inserirQuartos();

                AdicionaisDao adicionaisDao = new AdicionaisDao();
                adicionaisDao.inserirAdicionais();

               ClientesDao clientesDao = new ClientesDao();
               clientesDao.inserirClientes();

                FuncoesDao funcoesDao = new FuncoesDao();
                funcoesDao.inserirFuncoes();


                System.out.println("Função inserida com sucesso!");
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