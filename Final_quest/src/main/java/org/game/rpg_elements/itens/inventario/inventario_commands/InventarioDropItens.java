package org.game.rpg_elements.itens.inventario.inventario_commands;

import org.game.rpg_elements.Inimigos.drop.Drop;
import org.game.rpg_elements.itens.Item;
import org.game.rpg_elements.itens.inventario.Inventario;
import org.game.rpg_elements.itens.inventario.InventarioCommander;
import org.game.rpg_elements.itens.inventario.inventario_commands.itens.InventarioAddConsumiveis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class InventarioDropItens extends InventarioCommander {
    private Drop drop;
    private List<Item> items;
    public InventarioDropItens(Inventario inventario, Drop drop) throws IOException {
        super(inventario);
        this.drop = drop;
    }

    @Override
    public void execute() throws IOException {
        Random random = new Random();

        List<Item> items_t = new ArrayList<>();
        Map<Item, Integer> itens_drop = drop.getItens_droped();

        for(Map.Entry<Item, Integer> entry : itens_drop.entrySet()){
            Integer int_rand = random.nextInt(100) + 1;
            if(entry.getValue() > int_rand){
                items_t.add(entry.getKey());

                InventarioAddConsumiveis inventarioAddConsumiveis = new InventarioAddConsumiveis(inventario, entry.getKey(), 1);
                inventarioAddConsumiveis.execute();
            }
        }

        items = items_t;

    }

    public List<Item> getItems() {
        return items;
    }
}
