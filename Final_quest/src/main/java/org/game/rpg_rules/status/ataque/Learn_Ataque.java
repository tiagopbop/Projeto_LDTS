package org.game.rpg_rules.status.ataque;

import org.game.model.battle.battleElements.Hero;
import org.game.rpg_rules.status.Atributos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Learn_Ataque {
    private static Integer num_ataques = 6;
    private LoaderAtaque loaderAtaque;

    public Learn_Ataque(){
        this.loaderAtaque = new LoaderAtaque();
    }

    public Learn_Ataque(LoaderAtaque loaderAtaque){
        this.loaderAtaque = loaderAtaque;
    }

    public List<Ataque> aprender(Atributos atributos, List<Ataque> ataques) throws IOException {
        List<Ataque> res = new ArrayList<>();
        Ataque ataque;

        for(int i = 1; i <= num_ataques; i++){
            ataque = loaderAtaque.renderAtaque(String.valueOf(i));
            if(tem_ataque(ataques, ataque)){
                if(atributos.learn_ataque(ataque)){
                    res.add(ataque);
                }
            }
        }

        return  res;
    }

    private boolean tem_ataque(List<Ataque> ataques, Ataque ataque){
        boolean flag = true;

        for(Ataque ataque1 : ataques){
            if(ataque1.getNome().equals(ataque.getNome())){
                flag = false;
                break;
            }
        }

        return flag;
    }
}
