package org.game.rpg_elements.Inimigos.drop;

import org.game.rpg_elements.FactoryRPGElements;
import org.game.rpg_elements.Inimigos.drop.Drop;
import org.game.rpg_elements.itens.Item;
import org.game.rpg_elements.itens.LoaderItem;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoaderDrop extends FactoryRPGElements<Drop> {

    @Override
    public Drop createRPGelement(List<String> lines) throws IOException{
        Map<Item, Integer> drop_itens = new HashMap<Item, Integer>();
        int pos = createDrop_itens(drop_itens, lines);

        Drop res = new Drop(Integer.valueOf(lines.get(1)), Integer.valueOf(lines.get(2)), drop_itens, Integer.valueOf(lines.get(pos)));

        return res;
    }

    private int createDrop_itens(Map<Item, Integer> drop_itens, List<String> lines) throws IOException {
        int count = 4;
        Item item = null;
        Integer chance = 0;
        boolean flag = true;

        while(!lines.get(count).equals("Experiência")){
            if(flag){
                item = new LoaderItem().renderConsumivel(lines.get(count));
                flag = false;
            }
            else{
                chance = Integer.valueOf(lines.get(count));
                drop_itens.put(item, chance);
                flag = true;
            }

            count++;
        }
        return count + 1;
    }
}
