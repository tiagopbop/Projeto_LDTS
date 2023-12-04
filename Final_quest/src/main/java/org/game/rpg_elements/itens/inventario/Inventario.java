package org.game.rpg_elements.itens.inventario;
import org.game.rpg_elements.itens.Equipamento;
import org.game.rpg_elements.itens.Item;

import java.util.List;
import java.util.Map;

public class Inventario {
    Map<Item, Integer> inventario;
    Map<Item, Integer> equipamentos;
    Map<Item, Integer> consumiveis;
    Equipado equipado;
    int dinheiro;

    public Inventario(Map<Item, Integer> inventario, Map<Item, Integer> equipamentos, Map<Item, Integer> consumiveis, Equipado equipado, int dinheiro){
        this.inventario = inventario;
        this.equipamentos = equipamentos;
        this.consumiveis = consumiveis;
        this.equipado = equipado;
        this.dinheiro = dinheiro;
    }

    public Map<Item, Integer> getInventario() {
        return inventario;
    }

    public Map<Item, Integer> getEquipamentos() {
        return equipamentos;
    }

    public Map<Item, Integer> getConsumiveis() {
        return consumiveis;
    }

    public Equipado getEquipado() {
        return equipado;
    }

    public int getDinheiro() {
        return dinheiro;
    }

    public void add_equipamento(Item equipamento, int quantidade){
        Integer quat = inventario.get(equipamento);

        if(quat != null){
            inventario.replace(equipamento, quantidade + quat);
            equipamentos.replace(equipamento, quantidade + quat);
        }
        else{
            inventario.put(equipamento, quantidade);
            equipamentos.put(equipamento, quantidade);
        }
    }

    public void add_consumivel(Item consumivel, int quantidade){
        Integer quat = inventario.get(consumivel);

        if(quat != null){
            inventario.replace(consumivel, quantidade + quat);
            consumiveis.replace(consumivel, quantidade + quat);
        }
        else{
            inventario.put(consumivel, quantidade);
            consumiveis.put(consumivel, quantidade);
        }
    }

    public void remove_equipamento(Item equipamento){
        Integer quat = inventario.get(equipamento);

        if(quat == 1){
            inventario.remove(equipamento);
            equipamentos.remove(equipamento);
        }
        else{
            inventario.replace(equipamento, quat - 1);
            equipamentos.replace(equipamento, quat - 1);
        }
    }

    public void remove_consumivel(Item consumivel){
        Integer quat = inventario.get(consumivel);

        if(quat == 1){
            inventario.remove(consumivel);
            consumiveis.remove(consumivel);
        }
        else{
            inventario.replace(consumivel, quat - 1);
            consumiveis.replace(consumivel, quat - 1);
        }
    }

    public void add_dinheiro(int dinheiro){
        this.dinheiro += dinheiro;
    }

    public void remove_dinheiro(int dinheiro){
        this.dinheiro -= dinheiro;
    }

    public void swap_armor(Item equipamento){
        Item item;
        if(equipamento.getType().equals("capacete")){
            item = this.equipado.getCapacete();
            this.equipado.setCapacete(equipamento);

        }
        else if(equipamento.getType().equals("peitoral")){
            item = this.equipado.getPeitoral();
            this.equipado.setPeitoral(equipamento);

        }
        else {
            item = this.equipado.getCalcas();
            this.equipado.setCalcas(equipamento);
        }

        add_equipamento(item, 1);
        remove_equipamento(equipamento);
    }
}
