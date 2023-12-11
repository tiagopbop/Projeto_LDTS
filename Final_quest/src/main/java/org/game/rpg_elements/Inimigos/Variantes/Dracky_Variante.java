package org.game.rpg_elements.Inimigos.Variantes;

import org.game.model.game.battle.Individuo;
import org.game.rpg_elements.Inimigos.Monster;
import org.game.rpg_elements.MonsterDecorator;
import org.game.rpg_elements.status.Status;

public class Dracky_Variante extends MonsterDecorator {
    public Dracky_Variante(Individuo individuo) {
        super(individuo);
    }

    @Override
    public void Assembler() {
        Status t = getIndividuo().getStatus();
        t.getAtributos_real().add_vida(20);
        t.setNome("MegaDracky");

        t.reset_status();

        Monster res = (Monster) this.getIndividuo();
        res.setStatus(t);


        this.setIndividuo(res);
    }
}
