package org.game.rpg_elements.status.ataque;

import java.util.Map;

public class Ataque {
    private String nome;
    private String origem;
    private int dano;
    private int acerto;

    private int custo;

    private Map<String, Integer> requesitos;

    public Ataque(String nome, String origem, int dano, int acerto, int custo){
        this.nome = nome;
        this.origem = origem;
        this.dano = dano;
        this.acerto = acerto;
        this.custo = custo;
    }

    public Ataque(String nome, String origem, int dano, int acerto, int custo, Map<String, Integer> requesitos){
        this.nome = nome;
        this.origem = origem;
        this.dano = dano;
        this.acerto = acerto;
        this.custo = custo;
        this.requesitos = requesitos;
    }

    public Map<String, Integer> getRequesitos() {
        return requesitos;
    }

    public String getNome() {
        return nome;
    }

    public String getOrigem() {
        return origem;
    }

    public int getDano() {
        return dano;
    }

    public int getAcerto() {
        return acerto;
    }

    public int getCusto() {
        return custo;
    }
}
