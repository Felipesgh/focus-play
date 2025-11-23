package br.com.fiap.gs.main;

import br.com.fiap.gs.beans.*;
import br.com.fiap.gs.bo.*;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        int opcao;
        do {
            String menu = """
                    --- FOCUSPLAY ---
                    1 - Gerenciar Usuários
                    2 - Gerenciar Tarefas
                    3 - Gerenciar Missões Diárias
                    0 - Sair
                    """;
            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcao) {
                case 1 -> menuUsuario();
                case 2 -> menuTarefa();
                case 3 -> menuMissao();
                case 0 -> JOptionPane.showMessageDialog(null, "Encerrando o programa...");
                default -> JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        } while (opcao != 0);
    }

    // ===== MENU USUÁRIO =====
    private static void menuUsuario() throws SQLException, ClassNotFoundException {
        UsuarioBO usuarioBO = new UsuarioBO();
        int opcao;
        do {
            String menu = """
                    --- MENU USUÁRIO ---
                    1 - Cadastrar Usuário
                    2 - Listar Usuários
                    3 - Atualizar Usuário
                    4 - Deletar Usuário
                    0 - Voltar
                    """;
            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcao) {
                case 1 -> {
                    Usuario u = new Usuario();
                    u.setNome(JOptionPane.showInputDialog("Nome:"));
                    u.setEmail(JOptionPane.showInputDialog("Email:"));
                    u.setSenha(JOptionPane.showInputDialog("Senha:"));
                    u.setPontosTotais(0);
                    u.setNivel("Iniciante");
                    JOptionPane.showMessageDialog(null, usuarioBO.inserirBo(u));
                }
                case 2 -> {
                    List<Usuario> usuarios = usuarioBO.selecionarBo();
                    StringBuilder sb = new StringBuilder("=== USUÁRIOS ===\n");
                    usuarios.forEach(u -> sb.append(u).append("\n"));
                    JOptionPane.showMessageDialog(null, sb.toString());
                }
                case 3 -> {
                    Usuario u = new Usuario();
                    u.setId(Integer.parseInt(JOptionPane.showInputDialog("ID do usuário:")));
                    u.setNome(JOptionPane.showInputDialog("Novo nome:"));
                    u.setEmail(JOptionPane.showInputDialog("Novo email:"));
                    u.setSenha(JOptionPane.showInputDialog("Nova senha:"));
                    u.setNivel(JOptionPane.showInputDialog("Novo nível:"));
                    u.setPontosTotais(Integer.parseInt(JOptionPane.showInputDialog("Nova pontuação:")));
                    JOptionPane.showMessageDialog(null, usuarioBO.atualizarBo(u));
                }
                case 4 -> {
                    int id = Integer.parseInt(JOptionPane.showInputDialog("ID do usuário a excluir:"));
                    JOptionPane.showMessageDialog(null, usuarioBO.deletarBo(id));
                }
                case 0 -> {}
                default -> JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        } while (opcao != 0);
    }

    // ===== MENU TAREFA =====
    private static void menuTarefa() throws SQLException, ClassNotFoundException {
        TarefaBO tarefaBO = new TarefaBO();
        int opcao;
        do {
            String menu = """
                    --- MENU TAREFA ---
                    1 - Cadastrar Tarefa
                    2 - Listar Tarefas
                    3 - Atualizar Tarefa
                    4 - Deletar Tarefa
                    0 - Voltar
                    """;
            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcao) {
                case 1 -> {
                    Tarefa t = new Tarefa();
                    t.setTitulo(JOptionPane.showInputDialog("Título:"));
                    t.setDescricao(JOptionPane.showInputDialog("Descrição:"));
                    t.setPontuacao(Integer.parseInt(JOptionPane.showInputDialog("Pontuação:")));
                    t.setUsuarioId(Integer.parseInt(JOptionPane.showInputDialog("ID do usuário:")));
                    JOptionPane.showMessageDialog(null, tarefaBO.inserirBo(t));
                }
                case 2 -> {
                    List<Tarefa> tarefas = tarefaBO.selecionarBo();
                    StringBuilder sb = new StringBuilder("=== TAREFAS ===\n");
                    tarefas.forEach(t -> sb.append(t).append("\n"));
                    JOptionPane.showMessageDialog(null, sb.toString());
                }
                case 3 -> {
                    Tarefa t = new Tarefa();
                    t.setId(Integer.parseInt(JOptionPane.showInputDialog("ID da tarefa:")));
                    t.setTitulo(JOptionPane.showInputDialog("Novo título:"));
                    t.setDescricao(JOptionPane.showInputDialog("Nova descrição:"));
                    t.setPontuacao(Integer.parseInt(JOptionPane.showInputDialog("Nova pontuação:")));
                    t.setUsuarioId(Integer.parseInt(JOptionPane.showInputDialog("ID do usuário:")));
                    JOptionPane.showMessageDialog(null, tarefaBO.atualizarBo(t));
                }
                case 4 -> {
                    int id = Integer.parseInt(JOptionPane.showInputDialog("ID da tarefa a excluir:"));
                    JOptionPane.showMessageDialog(null, tarefaBO.deletarBo(id));
                }
                case 0 -> {}
                default -> JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        } while (opcao != 0);
    }

    // ===== MENU MISSÃO =====
    private static void menuMissao() throws SQLException, ClassNotFoundException {
        MissaoDiariaBO missaoBO = new MissaoDiariaBO();
        int opcao;
        do {
            String menu = """
                    --- MENU MISSÕES DIÁRIAS ---
                    1 - Cadastrar Missão
                    2 - Listar Missões
                    3 - Atualizar Missão
                    4 - Deletar Missão
                    0 - Voltar
                    """;
            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcao) {
                case 1 -> {
                    MissaoDiaria m = new MissaoDiaria();
                    m.setTitulo(JOptionPane.showInputDialog("Título:"));
                    m.setDescricao(JOptionPane.showInputDialog("Descrição:"));
                    m.setPontos(Integer.parseInt(JOptionPane.showInputDialog("Pontuação:")));
                    m.setUsuarioId(Integer.parseInt(JOptionPane.showInputDialog("ID do usuário:")));
                    JOptionPane.showMessageDialog(null, missaoBO.inserirBo(m));
                }
                case 2 -> {
                    List<MissaoDiaria> missoes = missaoBO.selecionarBo();
                    StringBuilder sb = new StringBuilder("=== MISSÕES ===\n");
                    missoes.forEach(m -> sb.append(m).append("\n"));
                    JOptionPane.showMessageDialog(null, sb.toString());
                }
                case 3 -> {
                    MissaoDiaria m = new MissaoDiaria();
                    m.setId(Integer.parseInt(JOptionPane.showInputDialog("ID da missão:")));
                    m.setTitulo(JOptionPane.showInputDialog("Novo título:"));
                    m.setDescricao(JOptionPane.showInputDialog("Nova descrição:"));
                    m.setPontos(Integer.parseInt(JOptionPane.showInputDialog("Novos Pontos:")));
                    m.setUsuarioId(Integer.parseInt(JOptionPane.showInputDialog("ID do usuário:")));
                    JOptionPane.showMessageDialog(null, missaoBO.atualizarBo(m));
                }
                case 4 -> {
                    int id = Integer.parseInt(JOptionPane.showInputDialog("ID da missão a excluir:"));
                    JOptionPane.showMessageDialog(null, missaoBO.deletarBo(id));
                }
                case 0 -> {}
                default -> JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        } while (opcao != 0);
    }
}
