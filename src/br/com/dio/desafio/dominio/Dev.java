package br.com.dio.desafio.dominio;

import java.util.*;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    private Set<Desafio> desafiosIniciados = new LinkedHashSet<>();

    private Set<Desafio> desafiosConcluidos = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp){
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir() {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if(conteudo.isPresent()) {
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        } else {
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }
    }

    public boolean iniciarDesafio(Desafio desafio) {
        if (this.desafiosConcluidos.contains(desafio)) {
            System.err.println("Você já concluiu este desafio!");
            return false;
        }
        if (this.desafiosIniciados.add(desafio)) {
            System.out.println("Desafio iniciado! Boa sorte.");
            return true;
        }
        return false;
    }

    public boolean completarDesafio(Desafio desafio) {
        if (this.desafiosIniciados.contains(desafio)) {
            this.desafiosConcluidos.add(desafio);
            this.desafiosIniciados.remove(desafio);
            System.out.println("Desafio concluído! Parabéns!!!");
            return true;
        } else {
            System.err.println("Erro! Você não iniciou este desafio!");
        }
        return false;
    }

    public double calcularTotalXp() {
        double xpConteudos = this.conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
        double xpDesafios = this.desafiosConcluidos
                .stream()
                .mapToDouble(Desafio::calcularXp)
                .sum();
        return  xpConteudos + xpDesafios;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    public Set<Desafio> getDesafiosIniciados() {
        return desafiosIniciados;
    }

    public void setDesafiosIniciados(Set<Desafio> desafiosIniciados) {
        this.desafiosIniciados = desafiosIniciados;
    }

    public Set<Desafio> getDesafiosConcluidos() {
        return desafiosConcluidos;
    }

    public void setDesafiosConcluidos(Set<Desafio> desafiosConcluidos) {
        this.desafiosConcluidos = desafiosConcluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }
}
