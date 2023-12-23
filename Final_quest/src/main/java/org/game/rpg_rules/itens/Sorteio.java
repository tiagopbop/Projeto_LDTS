package org.game.rpg_rules.itens;

import java.io.IOException;
import java.util.Random;

public class Sorteio {
    private static Integer itens_max = 16;
    private static Integer equipamento_max = 12;
    public Item item() throws IOException {
        Random rand = new Random();
        int sor = rand.nextInt(1,itens_max + 1);

        return new LoaderItem().renderConsumivel(String.valueOf(sor));
    }

    public Item equipamento() throws IOException {
        Random rand = new Random();
        int sor = rand.nextInt(1,equipamento_max);

        return new LoaderItem().renderEquipamento(String.valueOf(sor));
    }
}
