package org.game.rpg_elements.status.ataque;

import org.game.rpg_elements.status.Loader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoaderAtaque extends Loader {
    public Ataque createAtaque(String filename) throws IOException {
        List<String> lines;
        Ataque res;

        String file_path = "/status/ataques/" + filename;
        lines = Loader(file_path);

        Map<String, Integer> requesitos = new HashMap<>();
        createRequesitos(lines, requesitos, 6);

        res = new Ataque(lines.get(0), lines.get(1), Integer.valueOf(lines.get(2)), Integer.valueOf(lines.get(3)), Integer.valueOf(lines.get(4)), requesitos);

        return res;
    }

    private void createRequesitos(List<String> lines, Map<String, Integer> requesitos, int pos){
        boolean flag = true;
        String atributo = new String();
        Integer value;

        while(!lines.get(pos).equals("#")){
            if(flag){
                atributo = lines.get(pos);
                flag = false;
            }
            else{
                value = Integer.valueOf(lines.get(pos));
                requesitos.put(atributo, value);
                flag = true;
            }

            pos++;
        }
    }
}
