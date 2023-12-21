package org.game.rpg_rules.itens;

import org.game.rpg_rules.FactoryRPGElements;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoaderItem extends FactoryRPGElements<Item> {

    @Override
    public Item createRPGelement(List<String> lines) throws IOException {
        int num_requesitos = lines.indexOf("Requesitos");

        Item res = new Item(lines.get(0), lines.get(1), createEfeitos(lines), createRequesitos(lines, num_requesitos));
        return  res;
    }

    private Map<String, Integer> createEfeitos(List<String> lines){
        Map<String, Integer> res = new HashMap<String, Integer>();

        boolean flag = true;
        int i = 3;

        String atr = null;
        Integer value;

        while(!lines.get(i).equals("Requesitos")){
            if(flag){
                atr = lines.get(i);
                flag = false;
            }
            else{
                value = Integer.valueOf(lines.get(i));
                res.put(atr, value);
                flag = true;
            }
            i++;
        }
        return res;
    }

    private Map<String, Integer> createRequesitos(List<String> lines, int n){
        Map<String, Integer> res = new HashMap<String, Integer>();

        boolean flag = true;

        String atr = null;
        Integer value;

        for(int i = n + 1; i < lines.size(); i++){
            if(flag){
                atr = lines.get(i);
                flag = false;
            }
            else{
                value = Integer.valueOf(lines.get(i));
                res.put(atr, value);
                flag = true;
            }
        }
        return res;
    }
}
