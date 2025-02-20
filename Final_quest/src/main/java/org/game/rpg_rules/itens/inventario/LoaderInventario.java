package org.game.rpg_rules.itens.inventario;

import org.game.rpg_rules.FactoryRPGElements;
import org.game.rpg_rules.itens.Item;
import org.game.rpg_rules.itens.LoaderItem;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoaderInventario extends FactoryRPGElements<Inventario> {
    private LoaderItem factory;

    public LoaderInventario(){
        this.factory = new LoaderItem();
    }

    public LoaderInventario(LoaderItem factory){
        this.factory = factory;
    }

    @Override
    public Inventario createRPGelement(List<String> lines) throws IOException{
        Inventario res;

        Map<Item, Integer> inventario = new HashMap<Item, Integer>();
        Map<Item, Integer> equipamentos = new HashMap<Item, Integer>();
        Map<Item, Integer> consumiveis = new HashMap<Item, Integer>();
        Equipado equipado = new Equipado();

        int pos = createItens(lines, 1, inventario, equipamentos, true);
        int new_pos = createItens(lines, pos, inventario, consumiveis, false);
        pos = createEquipado(lines, new_pos, equipado);


        res = new Inventario(inventario, equipamentos, consumiveis, equipado, Integer.valueOf(lines.get(pos)));

        return res;
    }

    private int createItens(List<String> lines, int pos, Map<Item, Integer> inventario, Map<Item, Integer> itens, boolean item_type) throws IOException {
        boolean flag = true;

        Item item = null;
        Integer value;

        while((!lines.get(pos).equals("consumiveis")) && (!lines.get(pos).equals("equipado"))){
            if(flag){
                if(item_type){
                    item = factory.renderEquipamento(lines.get(pos));
                }
                else{
                    item = factory.renderConsumivel(lines.get(pos));
                }
                flag = false;
            }
            else{
                value = Integer.valueOf(lines.get(pos));
                inventario.put(item, value);
                itens.put(item, value);

                flag = true;
            }
            pos++;
        }
        return pos + 1;
    }

    private int createEquipado(List<String> lines,int pos, Equipado equipado) throws IOException {
        Item item = null;
        int count = 0;

        while(!lines.get(pos).equals("dinheiro")){
            item = factory.renderEquipamento(lines.get(pos));

            if(count == 0){
                equipado.setCapacete(item);
            }
            else if(count == 1){
                equipado.setPeitoral(item);
            }
            else {
                equipado.setCalcas(item);
            }

            count++;
            pos++;
        }
        return pos + 1;
    }
}
