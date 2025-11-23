package br.com.fiap.gs.dao;

import br.com.fiap.gs.beans.Usuario;
import br.com.fiap.gs.conexoes.ConexaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private Connection minhaConexao;

    public UsuarioDAO() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserir(Usuario usuario) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "INSERT INTO USUARIOS (NOME, EMAIL, SENHA, PONTOS_TOTAIS, NIVEL) VALUES (?, ?, ?, ?, ?)"
        );
        stmt.setString(1, usuario.getNome());
        stmt.setString(2, usuario.getEmail());
        stmt.setString(3, usuario.getSenha());
        stmt.setInt(4, usuario.getPontosTotais());
        stmt.setString(5, usuario.getNivel());

        stmt.execute();
        stmt.close();

        return "Usuário cadastrado com sucesso!";
    }

    public String atualizar(Usuario usuario) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "UPDATE USUARIOS SET NOME=?, EMAIL=?, SENHA=?, PONTOS_TOTAIS=?, NIVEL=? WHERE ID=?"
        );
        stmt.setString(1, usuario.getNome());
        stmt.setString(2, usuario.getEmail());
        stmt.setString(3, usuario.getSenha());
        stmt.setInt(4, usuario.getPontosTotais());
        stmt.setString(5, usuario.getNivel());
        stmt.setInt(6, usuario.getId());

        stmt.executeUpdate();
        stmt.close();

        return "Usuário atualizado com sucesso!";
    }

    public String deletar(int id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("DELETE FROM USUARIOS WHERE ID=?");
        stmt.setInt(1, id);

        stmt.execute();
        stmt.close();

        return "Usuário removido com sucesso!";
    }

    public List<Usuario> selecionar() throws SQLException {
        List<Usuario> lista = new ArrayList<>();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM USUARIOS ORDER BY ID");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Usuario u = new Usuario();
            u.setId(rs.getInt("ID"));
            u.setNome(rs.getString("NOME"));
            u.setEmail(rs.getString("EMAIL"));
            u.setSenha(rs.getString("SENHA"));
            u.setPontosTotais(rs.getInt("PONTOS_TOTAIS"));
            u.setNivel(rs.getString("NIVEL"));
            lista.add(u);
        }

        stmt.close();
        return lista;
    }

    public List<Usuario> selecionarRanking() throws SQLException {
        List<Usuario> lista = new ArrayList<>();

        String sql = "SELECT NOME, PONTOS_TOTAIS FROM USUARIOS ORDER BY PONTOS_TOTAIS DESC";

        PreparedStatement stmt = minhaConexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Usuario u = new Usuario();
            u.setNome(rs.getString("NOME"));
            u.setPontosTotais(rs.getInt("PONTOS_TOTAIS"));

            // deixamos os outros campos vazios, como visto em aula
            u.setId(0);
            u.setEmail(null);
            u.setSenha(null);
            u.setNivel(null);

            lista.add(u);
        }

        stmt.close();
        rs.close();

        return lista;
    }
}

