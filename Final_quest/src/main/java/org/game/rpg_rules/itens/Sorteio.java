package org.game.rpg_rules.itens;

import java.io.IOException;
import java.util.Random;

public class Sorteio {

    public Item equipamento() throws IOException {
        Random rand = new Random();
        int sor = rand.nextInt(1,13);

        return new LoaderItem().renderEquipamento(String.valueOf(sor));
    }
}
