package org.game.rpg_elements.itens.inventario.inventario_commands.itens;

import org.game.rpg_elements.Inimigos.Boss;
import org.game.rpg_elements.itens.Item;
import org.game.rpg_elements.itens.inventario.Inventario;
import org.game.rpg_elements.itens.inventario.InventarioCommander;

import java.io.IOException;
import java.util.Map;

public class InventarioRemoveConsumivel extends InventarioCommander {
    private Item consumivel;
    private boolean res;
    public InventarioRemoveConsumivel(Inventario inventario, Item consumivel) throws IOException {
        super(inventario);
        this.consumivel = consumivel;
    }

    @Override
    public void execute() throws IOException {
        for(Map.Entry<Item, Integer> entry: inventario.getConsumiveis().entrySet()){
            if(entry.getKey().getNome().equals(consumivel.getNome())){
                if(entry.getValue() > 1){
                    inventario.getInventario().put(entry.getKey(), inventario.getInventario().get(entry.getKey()) - 1);
                    inventario.getConsumiveis().put(entry.getKey(), inventario.getConsumiveis().get(entry.getKey()) - 1);
                    this.res = false;
                    break;
                }
                else if(entry.getValue() == 1){
                    inventario.getInventario().remove(entry.getKey());
                    inventario.getConsumiveis().remove(entry.getKey());
                    this.res = true;
                    break;
                }
            }
        }
    }

    public boolean getRes(){
        return res;
    }
}
