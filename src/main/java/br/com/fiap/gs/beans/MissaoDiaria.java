package br.com.fiap.gs.beans;

public class MissaoDiaria {

    private int id;
    private String titulo;
    private String descricao;
    private int pontos;
    private int usuarioId;

    public MissaoDiaria() {}

    public MissaoDiaria(String titulo, String descricao, int pontos, int usuarioId) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.pontos = pontos;
        this.usuarioId = usuarioId;
    }

    public MissaoDiaria(int id, String titulo, String descricao, int pontos, int usuarioId) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.pontos = pontos;
        this.usuarioId = usuarioId;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public int getPontos() { return pontos; }
    public void setPontos(int pontos) { this.pontos = pontos; }

    public int getUsuarioId() { return usuarioId; }
    public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }

    @Override
    public String toString() {
        return "MissaoDiaria{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", pontuacao=" + pontos +
                ", usuarioId=" + usuarioId +
                '}';
    }
}
