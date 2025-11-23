package br.com.fiap.gs.bo;

import br.com.fiap.gs.beans.MissaoDiaria;
import br.com.fiap.gs.dao.MissaoDiariaDAO;

import java.sql.SQLException;
import java.util.List;

public class MissaoDiariaBO {

    private MissaoDiariaDAO missaoDAO;

    public MissaoDiariaBO() throws SQLException, ClassNotFoundException {
        missaoDAO = new MissaoDiariaDAO();
    }

    public List<MissaoDiaria> selecionarBo() throws SQLException {
        return missaoDAO.selecionar();
    }

    public String inserirBo(MissaoDiaria missao) throws SQLException {
        if (missao.getTitulo() == null || missao.getTitulo().isEmpty()) {
            return "O título da missão é obrigatório!";
        }
        return missaoDAO.inserir(missao);
    }

    public String atualizarBo(MissaoDiaria missao) throws SQLException {
        return missaoDAO.atualizar(missao);
    }

    public String deletarBo(int id) throws SQLException {
        return missaoDAO.deletar(id);
    }
}
