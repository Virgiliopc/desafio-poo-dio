package br.com.dio.desafio.dominio;

import java.util.Objects;

public class Desafio extends Conteudo {
    private String linguagem;

    private String dificuldade;

    public Desafio(String titulo, String descricao, String linguagem, String dificuldade) {
        super(titulo, descricao);
        this.linguagem = linguagem;
        this.dificuldade = dificuldade;
    }

    public Desafio(){
    }

    @Override
    public double calcularXp() {
        int xpBonus = 0;
        if (Objects.equals(this.getDificuldade(), "facil")) {
            xpBonus = 20;
        } else if (Objects.equals(this.getDificuldade(), "media")) {
            xpBonus = 50;
        } else if (Objects.equals(this.getDificuldade(), "dificil")) {
            xpBonus = 100;
        }
        return XP_PADRAO + xpBonus;
    }

    public String getLinguagem() {
        return linguagem;
    }

    public void setLinguagem(String linguagem) {
        this.linguagem = linguagem;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    @Override
    public String toString() {
        return "Desafio{" +
                "titulo='" + this.getTitulo() + '\'' +
                ", descricao='" + this.getDescricao() + '\'' +
                ", linguagem='" + linguagem + '\'' +
                ", dificuldade='" + dificuldade + '\'' +
                '}';
    }
}
