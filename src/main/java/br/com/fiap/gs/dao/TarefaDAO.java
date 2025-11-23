package br.com.fiap.gs.dao;

import br.com.fiap.gs.beans.Tarefa;
import br.com.fiap.gs.conexoes.ConexaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TarefaDAO {

    private Connection minhaConexao;

    public TarefaDAO() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserir(Tarefa tarefa) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "INSERT INTO TAREFAS (TITULO, DESCRICAO, PONTUACAO, USUARIO_ID) VALUES (?, ?, ?, ?)"
        );
        stmt.setString(1, tarefa.getTitulo());
        stmt.setString(2, tarefa.getDescricao());
        stmt.setInt(3, tarefa.getPontuacao());
        stmt.setInt(4, tarefa.getUsuarioId());

        stmt.execute();
        stmt.close();

        return "Tarefa cadastrada com sucesso!";
    }

    public String atualizar(Tarefa tarefa) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "UPDATE TAREFAS SET TITULO=?, DESCRICAO=?, PONTUACAO=?, USUARIO_ID=? WHERE ID=?"
        );
        stmt.setString(1, tarefa.getTitulo());
        stmt.setString(2, tarefa.getDescricao());
        stmt.setInt(3, tarefa.getPontuacao());
        stmt.setInt(4, tarefa.getUsuarioId());
        stmt.setInt(5, tarefa.getId());

        stmt.executeUpdate();
        stmt.close();

        return "Tarefa atualizada com sucesso!";
    }

    public String deletar(int id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("DELETE FROM TAREFAS WHERE ID=?");
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
        return "Tarefa removida com sucesso!";
    }

    public List<Tarefa> selecionar() throws SQLException {
        List<Tarefa> lista = new ArrayList<>();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM TAREFAS ORDER BY PONTUACAO DESC");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Tarefa t = new Tarefa();
            t.setId(rs.getInt("ID"));
            t.setTitulo(rs.getString("TITULO"));
            t.setDescricao(rs.getString("DESCRICAO"));
            t.setPontuacao(rs.getInt("PONTUACAO"));
            t.setUsuarioId(rs.getInt("USUARIO_ID"));
            lista.add(t);
        }

        stmt.close();
        return lista;
    }
}
