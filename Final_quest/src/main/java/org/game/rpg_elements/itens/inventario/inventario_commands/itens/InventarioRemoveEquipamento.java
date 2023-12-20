package org.game.rpg_elements.itens.inventario.inventario_commands.itens;

import org.game.rpg_elements.itens.Item;
import org.game.rpg_elements.itens.inventario.Inventario;
import org.game.rpg_elements.itens.inventario.InventarioCommander;

import java.io.IOException;

public class InventarioRemoveEquipamento extends InventarioCommander {
    private Item equipamento;

    public InventarioRemoveEquipamento(Inventario inventario, Item equipamento) throws IOException {
        super(inventario);
        this.equipamento = equipamento;
    }

    @Override
    public void execute() throws IOException {
        Integer quat = inventario.getInventario().get(equipamento);

        if(quat == 1){
            inventario.getInventario().remove(equipamento);
            inventario.getEquipamentos().remove(equipamento);
        }
        else{
            inventario.getInventario().replace(equipamento, quat - 1);
            inventario.getEquipamentos().replace(equipamento, quat - 1);
        }
    }
}
