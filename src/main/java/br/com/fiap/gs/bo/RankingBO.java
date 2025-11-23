package br.com.fiap.gs.bo;

import br.com.fiap.gs.beans.Usuario;
import br.com.fiap.gs.dao.UsuarioDAO;

import java.sql.SQLException;
import java.util.List;

public class RankingBO {

    private UsuarioDAO usuarioDAO;

    public RankingBO() {
        try {
            this.usuarioDAO = new UsuarioDAO();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao iniciar RankingBO: " + e.getMessage());
        }
    }

    public List<Usuario> selecionarRankingBO() {
        try {
            return usuarioDAO.selecionarRanking();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar ranking: " + e.getMessage());
        }
    }
}
