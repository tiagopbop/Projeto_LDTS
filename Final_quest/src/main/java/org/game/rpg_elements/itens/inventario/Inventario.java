package org.game.rpg_elements.itens.inventario;
import com.sun.jdi.Value;
import org.game.rpg_elements.itens.Equipamento;
import org.game.rpg_elements.itens.Item;
import org.game.rpg_elements.status.Drop;

import java.util.*;

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
        boolean flag = true;

        for(Map.Entry<Item, Integer> entry: consumiveis.entrySet()){
            if(entry.getKey().getNome().equals(consumivel.getNome())){
                inventario.put(entry.getKey(), inventario.get(entry.getKey()) + quantidade);
                consumiveis.put(entry.getKey(), consumiveis.get(entry.getKey()) + quantidade);
                flag = false;
                break;
            }
        }
        if(flag){
            inventario.put(consumivel, quantidade);
            consumiveis.put(consumivel, quantidade);
        }
    }

    public Map<Item, Integer> lista_capacetes(){
        Map<Item, Integer> res = new HashMap<>();
        for(Map.Entry<Item, Integer> entry: equipamentos.entrySet()){
            if(entry.getKey().getType().equals("capacete")){
                res.put(entry.getKey(), entry.getValue());
            }
        }
        return res;
    }

    public Map<Item, Integer> lista_peitoral(){
        Map<Item, Integer> res = new HashMap<>();
        for(Map.Entry<Item, Integer> entry: equipamentos.entrySet()){
            if(entry.getKey().getType().equals("peitoral")){
                res.put(entry.getKey(), entry.getValue());
            }
        }
        return res;
    }

    public Map<Item, Integer> lista_calcas(){
        Map<Item, Integer> res = new HashMap<>();
        for(Map.Entry<Item, Integer> entry: equipamentos.entrySet()){
            if(entry.getKey().getType().equals("calcas")){
                res.put(entry.getKey(), entry.getValue());
            }
        }
        return res;
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

    public Integer add_dinheiro(Drop drop){
        Integer dinheiro;
        Random random = new Random();

        int max_dinheiro = drop.getMax_dinheiro();
        int min_dinheiro = drop.getMim_dinheiro();

        int int_rand = random.nextInt(max_dinheiro - min_dinheiro + 1) + min_dinheiro;
        dinheiro = int_rand;

        add_dinheiro(dinheiro);
        return dinheiro;
    }

    public List<Item> add_drop_itens(Drop drop){
        Random random = new Random();
        List<Item> items = new ArrayList<>();

        Map<Item, Integer> itens_drop = drop.getItens_droped();
        random = new Random();

        for(Map.Entry<Item, Integer> entry : itens_drop.entrySet()){
            Integer int_rand = random.nextInt(100) + 1;
            if(entry.getValue() > int_rand){
                items.add(entry.getKey());
                add_consumivel(entry.getKey(), 1);
            }
        }
        return items;
    }
}
