package org.game.rpg_rules.itens.inventario.inventario_commands.itens;

import org.game.rpg_rules.itens.Item;
import org.game.rpg_rules.itens.inventario.Inventario;
import org.game.rpg_rules.itens.inventario.InventarioCommander;

import java.io.IOException;
import java.util.Map;

public class InventarioAddConsumiveis extends InventarioCommander {
    private Item consumivel;
    private int quantidade;

    public InventarioAddConsumiveis(Inventario inventario, Item consumivel, int quantidade) throws IOException {
        super(inventario);
        this.consumivel = consumivel;
        this.quantidade = quantidade;
    }

    @Override
    public void execute() throws IOException {
        boolean flag = true;

        for(Map.Entry<Item, Integer> entry: inventario.getConsumiveis().entrySet()){
            if(entry.getKey().getNome().equals(consumivel.getNome())){
                inventario.getInventario().put(entry.getKey(), inventario.getInventario().get(entry.getKey()) + quantidade);
                inventario.getConsumiveis().put(entry.getKey(), inventario.getConsumiveis().get(entry.getKey()) + quantidade);
                flag = false;
                break;
            }
        }
        if(flag){
            inventario.getInventario().put(consumivel, quantidade);
            inventario.getConsumiveis().put(consumivel, quantidade);
        }
    }

}
