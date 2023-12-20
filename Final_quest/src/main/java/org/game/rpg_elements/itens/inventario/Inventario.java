package org.game.rpg_elements.itens.inventario;
import org.game.rpg_elements.itens.Item;
import org.game.rpg_elements.Inimigos.drop.Drop;

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

    public void add_dinheiro(int dinheiro){
        this.dinheiro += dinheiro;
    }

    public void remove_dinheiro(int dinheiro){
        this.dinheiro -= dinheiro;
    }

}
