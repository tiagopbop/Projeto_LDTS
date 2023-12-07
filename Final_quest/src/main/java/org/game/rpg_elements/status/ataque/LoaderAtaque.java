package org.game.rpg_elements.status.ataque;

import org.game.rpg_elements.FactoryRPGElements;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoaderAtaque extends FactoryRPGElements<Ataque> {
    @Override
    public Ataque createRPGelement(List<String> lines){
        Ataque res;

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
