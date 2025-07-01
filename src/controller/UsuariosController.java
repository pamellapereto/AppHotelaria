package controller;
import dao.UsuariosDao;
import model.Usuarios;

public class UsuariosController {
    private final UsuariosDao usuariosDao;

    /*Construtor para inicializar objeto UsuariosController(). Ao inicializá-lo, O construtor
    de UsuariosDao() será executado, significa que a camada de Controle estará verificando se os
    parâmetros necessários foram informados para que sejam enviados às requisições (package DAO)*/
    public UsuariosController() {
       this.usuariosDao = new UsuariosDao();
    }

    /*Metodo para verificar se os parâmetros necessários para autenticação
    estão presentes, ou seja, não podem ser vazios ou nulos; se estiverem presentes,
    um objeto de Usuarios é inicializado como uma instância*/
    public boolean verificarCredenciais(String email, String senha) {
        if (email == null || email.isEmpty()  || senha == null || senha.isEmpty()) {
            return false; }
        Usuarios usuario = new Usuarios("", email, senha, 0);
        return usuariosDao.autenticarUsuario(usuario);
    }
}


