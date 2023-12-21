package org.game.rpg_rules.itens.inventario.inventario_commands;

import org.game.rpg_rules.Inimigos.drop.Drop;
import org.game.rpg_rules.itens.inventario.Inventario;
import org.game.rpg_rules.itens.inventario.InventarioCommander;

import java.io.IOException;
import java.util.Random;

public class InventarioAddDinheiro extends InventarioCommander {
    private Drop drop;
    private Integer dinheiro;
    public InventarioAddDinheiro(Inventario inventario, Drop drop) throws IOException {
        super(inventario);
        this.drop = drop;
    }

    @Override
    public void execute() throws IOException {
        Random random = new Random();

        int max_dinheiro = drop.getMax_dinheiro();
        int min_dinheiro = drop.getMim_dinheiro();

        int int_rand = random.nextInt(max_dinheiro - min_dinheiro + 1) + min_dinheiro;

        this.inventario.add_dinheiro(int_rand);
        this.dinheiro = int_rand;
    }
    public Integer getDinheiro() {
        return dinheiro;
    }
}
