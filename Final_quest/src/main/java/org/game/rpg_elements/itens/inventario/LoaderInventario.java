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

        String file_path = "/itens/inventario";
        List<String> lines = Loader(file_path);

        boolean flag_1 = true;
        boolean flag_2 = true;

        Item item = null;

        Integer value;

        for(int i = 1; i < lines.size(); i++){
            if(lines.get(i).equals("consumiveis")){
                flag_1 = false;
                continue;
            }

            if(flag_2){
                if(flag_1){
                    item = new LoaderItem().createItem(lines.get(i), "equipamento");
                }
                else{
                    item = new LoaderItem().createItem(lines.get(i), "consumivel");
                }

                flag_2 = false;
            }
            else{
                value = Integer.valueOf(lines.get(i));
                inventario.put(item, value);

                if(flag_1){
                    equipamentos.put(item, value);
                }
                else{
                    consumiveis.put(item, value);
                }

                flag_2 = true;
            }
        }

        res = new Inventario(inventario, equipamentos, consumiveis);

        return res;
    }
}
