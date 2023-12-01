package org.game.rpg_elements;

import java.util.List;

public class Status {
    private Atributos atributos;
    private List<Ataque> ataques;

    public Status(Atributos atributos, List<Ataque> ataques){
        this.atributos = atributos;
        this.ataques = ataques;
    }

    public Atributos getAtributos() {
        return atributos;
    }

    public List<Ataque> getAtaques() {
        return ataques;
    }

}
