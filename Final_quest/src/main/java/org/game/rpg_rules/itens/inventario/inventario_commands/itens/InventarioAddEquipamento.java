package org.game.rpg_rules.itens.inventario.inventario_commands.itens;

import org.game.rpg_rules.itens.Item;
import org.game.rpg_rules.itens.inventario.Inventario;
import org.game.rpg_rules.itens.inventario.InventarioCommander;

import java.io.IOException;
import java.util.Map;

public class InventarioAddEquipamento extends InventarioCommander {
    private Item equipamento;
    private int quantidade;


    public InventarioAddEquipamento(Inventario inventario, Item equipamento, int quantidade) throws IOException {
        super(inventario);
        this.equipamento = equipamento;
        this.quantidade = quantidade;
    }

    @Override
    public void execute() throws IOException {
        boolean flag = true;

        for(Map.Entry<Item, Integer> entry: inventario.getEquipamentos().entrySet()){
            if(entry.getKey().getNome().equals(equipamento.getNome())){
                inventario.getInventario().put(entry.getKey(), inventario.getInventario().get(entry.getKey()) + quantidade);
                inventario.getEquipamentos().put(entry.getKey(), inventario.getEquipamentos().get(entry.getKey()) + quantidade);
                flag = false;
                break;
            }
        }
        if(flag){
            inventario.getEquipamentos().put(equipamento, quantidade);
            inventario.getEquipamentos().put(equipamento, quantidade);
        }
    }
}
