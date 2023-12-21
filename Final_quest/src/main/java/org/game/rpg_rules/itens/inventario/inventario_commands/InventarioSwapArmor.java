package org.game.rpg_rules.itens.inventario.inventario_commands;

import org.game.rpg_rules.itens.Item;
import org.game.rpg_rules.itens.inventario.Inventario;
import org.game.rpg_rules.itens.inventario.InventarioCommander;
import org.game.rpg_rules.itens.inventario.inventario_commands.itens.InventarioAddEquipamento;
import org.game.rpg_rules.itens.inventario.inventario_commands.itens.InventarioRemoveEquipamento;

import java.io.IOException;

public class InventarioSwapArmor extends InventarioCommander {
    private Item equipamento;
    public InventarioSwapArmor(Inventario inventario, Item equipamento) throws IOException {
        super(inventario);
        this.equipamento = equipamento;
    }

    @Override
    public void execute() throws IOException {
        Item item;
        if(equipamento.getType().equals("capacete")){
            item = inventario.getEquipado().getCapacete();
            inventario.getEquipado().setCapacete(equipamento);

        }
        else if(equipamento.getType().equals("peitoral")){
            item = inventario.getEquipado().getPeitoral();
            inventario.getEquipado().setPeitoral(equipamento);

        }
        else {
            item = inventario.getEquipado().getCalcas();
            inventario.getEquipado().setCalcas(equipamento);
        }

        InventarioAddEquipamento addEquipamento = new InventarioAddEquipamento(inventario, item, 1);
        addEquipamento.execute();

        InventarioRemoveEquipamento removeEquipamento = new InventarioRemoveEquipamento(inventario, equipamento);
        removeEquipamento.execute();

    }
}
