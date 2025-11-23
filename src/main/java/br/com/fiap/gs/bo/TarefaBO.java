package br.com.fiap.gs.bo;

import br.com.fiap.gs.beans.Tarefa;
import br.com.fiap.gs.dao.TarefaDAO;

import java.sql.SQLException;
import java.util.List;

public class TarefaBO {

    private TarefaDAO tarefaDAO;

    public TarefaBO() throws SQLException, ClassNotFoundException {
        tarefaDAO = new TarefaDAO();
    }

    public List<Tarefa> selecionarBo() throws SQLException {
        return tarefaDAO.selecionar();
    }

    public String inserirBo(Tarefa tarefa) throws SQLException {
        if (tarefa.getTitulo() == null || tarefa.getTitulo().isEmpty()) {
            return "O título da tarefa é obrigatório!";
        }
        return tarefaDAO.inserir(tarefa);
    }

    public String atualizarBo(Tarefa tarefa) throws SQLException {
        return tarefaDAO.atualizar(tarefa);
    }

    public String deletarBo(int id) throws SQLException {
        return tarefaDAO.deletar(id);
    }
}

