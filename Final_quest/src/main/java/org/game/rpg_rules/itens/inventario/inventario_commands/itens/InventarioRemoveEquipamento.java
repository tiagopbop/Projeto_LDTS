package org.game.rpg_rules.itens.inventario.inventario_commands.itens;

import org.game.rpg_rules.itens.Item;
import org.game.rpg_rules.itens.inventario.Inventario;
import org.game.rpg_rules.itens.inventario.InventarioCommander;

import java.io.IOException;
import java.util.Map;

public class InventarioRemoveEquipamento extends InventarioCommander {
    private boolean res;
    private Item equipamento;

    public InventarioRemoveEquipamento(Inventario inventario, Item equipamento) throws IOException {
        super(inventario);
        this.equipamento = equipamento;
    }

    @Override
    public void execute() throws IOException {
        for(Map.Entry<Item, Integer> entry: inventario.getEquipamentos().entrySet()){
            if(entry.getKey().getNome().equals(equipamento.getNome())){
                if(entry.getValue() > 1){
                    inventario.getInventario().put(entry.getKey(), inventario.getInventario().get(entry.getKey()) - 1);
                    inventario.getEquipamentos().put(entry.getKey(), inventario.getEquipamentos().get(entry.getKey()) - 1);
                    this.res = false;
                    break;
                }
                else if(entry.getValue() == 1){
                    inventario.getInventario().remove(entry.getKey());
                    inventario.getEquipamentos().remove(entry.getKey());
                    this.res = true;
                    break;
                }
            }
        }
    }

    public boolean getRes(){
        return this.res;
    }
}
