package org.game.rpg_elements.itens;

import org.game.rpg_elements.status.Loader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoaderItem extends Loader {
    public Item createItem(String filename, String type) throws IOException {
        List<String> lines = null;
        Item res;

        String file_path = "/itens/";

        if(type == "consumivel"){
            file_path += "consumiveis/" + filename;
            lines = Loader(file_path);
        }
        else if(type == "equipamento") {
            Map<String, Integer> requirements = new HashMap<String, Integer>();
            file_path += "equipamento/" + filename;
            lines = Loader(file_path);
        }

        int num_requesitos = lines.indexOf("Requesitos");

        res = new Item(lines.get(0), lines.get(1), createEfeitos(lines), createRequesitos(lines, num_requesitos));
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
