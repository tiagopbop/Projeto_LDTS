package org.game.rpg_elements.itens.inventario.inventario_commands.itens;

import org.game.rpg_elements.itens.Item;
import org.game.rpg_elements.itens.inventario.Inventario;
import org.game.rpg_elements.itens.inventario.InventarioCommander;

import java.io.IOException;

public class InventarioRemoveConsumivel extends InventarioCommander {
    private Item consumivel;
    public InventarioRemoveConsumivel(Inventario inventario, Item consumivel) throws IOException {
        super(inventario);
        this.consumivel = consumivel;
    }

    @Override
    public void execute() throws IOException {
        Integer quat = inventario.getInventario().get(consumivel);

        if(quat == 1){
            inventario.getInventario().remove(consumivel);
            inventario.getConsumiveis().remove(consumivel);
        }
        else{
            inventario.getInventario().replace(consumivel, quat - 1);
            inventario.getConsumiveis().replace(consumivel, quat - 1);
        }
    }
}
