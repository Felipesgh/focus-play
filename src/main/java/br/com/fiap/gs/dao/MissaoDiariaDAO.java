package br.com.fiap.gs.dao;

import br.com.fiap.gs.beans.MissaoDiaria;
import br.com.fiap.gs.conexoes.ConexaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MissaoDiariaDAO {

    private Connection minhaConexao;

    public MissaoDiariaDAO() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserir(MissaoDiaria missao) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "INSERT INTO MISSOES_DIARIAS (TITULO, DESCRICAO, PONTOS, USUARIO_ID) VALUES (?, ?, ?, ?)"
        );
        stmt.setString(1, missao.getTitulo());
        stmt.setString(2, missao.getDescricao());
        stmt.setInt(3, missao.getPontos());
        stmt.setInt(4, missao.getUsuarioId());

        stmt.execute();
        stmt.close();

        return "Missão cadastrada com sucesso!";

    }

    public String atualizar(MissaoDiaria missao) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "UPDATE MISSOES_DIARIAS SET TITULO=?, DESCRICAO=?, PONTOS=?, USUARIO_ID=? WHERE ID=?"
        );
        stmt.setString(1, missao.getTitulo());
        stmt.setString(2, missao.getDescricao());
        stmt.setInt(3, missao.getPontos());
        stmt.setInt(4, missao.getUsuarioId());
        stmt.setInt(5, missao.getId());

        stmt.executeUpdate();
        stmt.close();

        return "Missão atualizada com sucesso!";
    }

    public String deletar(int id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("DELETE FROM MISSOES_DIARIAS WHERE ID=?");
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
        return "Missão removida com sucesso!";
    }

    public List<MissaoDiaria> selecionar() throws SQLException {
        List<MissaoDiaria> lista = new ArrayList<>();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM MISSOES_DIARIAS ORDER BY TITULO");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            MissaoDiaria m = new MissaoDiaria();
            m.setId(rs.getInt("ID"));
            m.setTitulo(rs.getString("TITULO"));
            m.setDescricao(rs.getString("DESCRICAO"));
            m.setPontos(rs.getInt("PONTOS"));
            m.setUsuarioId(rs.getInt("USUARIO_ID"));
            lista.add(m);
        }

        stmt.close();
        return lista;
    }
}

