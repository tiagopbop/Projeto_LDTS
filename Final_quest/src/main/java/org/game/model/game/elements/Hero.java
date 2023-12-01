package org.game.model.game.elements;

import org.game.rpg_elements.Atributos;
import org.game.rpg_elements.LoaderStatus;
import org.game.rpg_elements.Status;

import java.io.IOException;

public class Hero extends Element{
    private Status status;

    public Hero(int x, int y) throws IOException {
        super(x, y);
        status = new LoaderStatus().createStatus("hero");
    }
}
