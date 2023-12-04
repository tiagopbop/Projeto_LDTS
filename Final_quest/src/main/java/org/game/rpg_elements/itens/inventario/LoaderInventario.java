package org.game.rpg_elements.itens.inventario;

import org.game.rpg_elements.itens.Item;
import org.game.rpg_elements.itens.LoaderItem;
import org.game.rpg_elements.status.Loader;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoaderInventario extends Loader {
    public Inventario createInventario() throws IOException {
        Inventario res;

        Map<Item, Integer> inventario = new HashMap<Item, Integer>();
        Map<Item, Integer> equipamentos = new HashMap<Item, Integer>();
        Map<Item, Integer> consumiveis = new HashMap<Item, Integer>();
        Equipado equipado = new Equipado();

        String file_path = "/itens/inventario";
        List<String> lines = Loader(file_path);

        int pos = createItens(lines, 1, inventario, equipamentos);
        int new_pos = createItens(lines, pos, inventario, consumiveis);
        pos = createEquipado(lines, new_pos, equipado);


        res = new Inventario(inventario, equipamentos, consumiveis, equipado, Integer.valueOf(lines.get(pos)));

        return res;
    }

    private int createItens(List<String> lines, int pos, Map<Item, Integer> inventario, Map<Item, Integer> itens) throws IOException {
        boolean flag = true;

        Item item = null;
        Integer value;

        while((!lines.get(pos).equals("consumiveis")) && (!lines.get(pos).equals("equipado"))){
            if(flag){
                item = new LoaderItem().createItem(lines.get(pos), "equipamento");
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
            item = new LoaderItem().createItem(lines.get(pos), "equipamento");

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
