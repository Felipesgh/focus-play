package br.com.fiap.gs.beans;

public class Tarefa {

    private int id;
    private String titulo;
    private String descricao;
    private int pontuacao;
    private int usuarioId;

    public Tarefa() {}

    public Tarefa(String titulo, String descricao, int pontuacao, int usuarioId) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.pontuacao = pontuacao;
        this.usuarioId = usuarioId;
    }

    public Tarefa(int id, String titulo, String descricao, int pontuacao, int usuarioId) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.pontuacao = pontuacao;
        this.usuarioId = usuarioId;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public int getPontuacao() { return pontuacao; }
    public void setPontuacao(int pontuacao) { this.pontuacao = pontuacao; }

    public int getUsuarioId() { return usuarioId; }
    public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }

    @Override
    public String toString() {
        return String.format("ID: %d | Título: %s | Pontos: %d | Usuário: %d",
                id, titulo, pontuacao, usuarioId);
    }
}
