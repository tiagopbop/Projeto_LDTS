package org.game.rpg_elements.Inimigos;

import org.game.rpg_elements.LoaderStatus;
import org.game.rpg_elements.Status;

import java.io.IOException;

public class Monstro {
    private String nome;
    private Status status;

    public Monstro(String nome) throws IOException {
        this.nome = nome;
        this.status = new LoaderStatus().createStatus("inimigos/" + nome);
    }

    public String getNome() {
        return nome;
    }

    public Status getStatus() {
        return status;
    }
}
