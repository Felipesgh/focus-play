package br.com.fiap.gs.bo;

import br.com.fiap.gs.beans.Usuario;
import br.com.fiap.gs.dao.UsuarioDAO;

import java.sql.SQLException;
import java.util.List;

public class UsuarioBO {

    private UsuarioDAO usuarioDAO;

    public UsuarioBO() throws SQLException, ClassNotFoundException {
        usuarioDAO = new UsuarioDAO();
    }

    public List<Usuario> selecionarBo() throws SQLException {
        return usuarioDAO.selecionar();
    }

    public String inserirBo(Usuario usuario) throws SQLException {
        if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
            return "O nome do usuário é obrigatório!";
        }
        return usuarioDAO.inserir(usuario);
    }

    public String atualizarBo(Usuario usuario) throws SQLException {
        return usuarioDAO.atualizar(usuario);
    }

    public String deletarBo(int id) throws SQLException {
        return usuarioDAO.deletar(id);
    }
}
