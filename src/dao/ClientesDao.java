package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClientesDao {
    private Conexao conexao = new Conexao();

    public boolean inserirClientes() {
        try{
            Connection conndb = conexao.conectar();
            PreparedStatement novoCliente = conndb.prepareStatement("INSERT INTO clientes " +
                    "(nome, cpf, telefone, email) VALUES (?, ?, ?, ?);");

            novoCliente.setString(1, "Uira");
            novoCliente.setString(2, "123.456.789-10");
            novoCliente.setString(3,"(00) 12345-6789" );
            novoCliente.setString(4, "Uircardoso123@gmail.com");

            int linhaAfetada = novoCliente.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }catch (Exception erro) {
            System.out.println("Erro ao inserir cliente: " + erro);
            return false;
        }
    }
    public boolean deletarClientes() {
        try{
            Connection conndb = conexao.conectar();
            PreparedStatement removeClientes = conndb.prepareStatement("DELETE FROM clientes WHERE id = ?;");

            removeClientes.setInt(1, 1);

            int linhaAfetada = removeClientes.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao deletar clientes: " + erro);
            return false;
        }
    }

    public boolean alterarClientes() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement alterarClientes = conndb.prepareStatement("UPDATE clientes " + "SET nome = ?, cpf = ?, telefone = ?, email = ? WHERE id = ?;");

            alterarClientes.setString(1, "Ana Laura");
            alterarClientes.setString(2, "987.654.321-00");
            alterarClientes.setString(3, "(10) 98765-4321");
            alterarClientes.setString(4, "AnaLaura@gmail.com");
            alterarClientes.setInt(5, 1);

            int linhaAfetada = alterarClientes.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao atualizar cliente: " + erro);
        }
        return false;
    }

    public void pesquisarClientes() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement pesquisarClientes = conndb.prepareStatement("SELECT nome, cpf, telefone, email FROM clientes WHERE id = ?;");
            pesquisarClientes.setInt(1, 1);
            ResultSet resultado = pesquisarClientes.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                String cpf = resultado.getString("cpf");
                String telefone = resultado.getString("telefone");
                String email = resultado.getString("email");

                System.out.println("Nome: " + nome +" Cpf: " + cpf +" Telefone: " + telefone +" Email: " + email);
            }
            conndb.close();
        }
        catch (Exception erro) {
            System.out.println("Erro ao pesquisar clientes: " + erro);
        }
    }
}