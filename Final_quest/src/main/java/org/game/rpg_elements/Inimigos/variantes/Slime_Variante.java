package org.game.rpg_elements.Inimigos.variantes;

import org.game.model.battle.battleElements.Individuo;
import org.game.rpg_elements.Inimigos.Monster;
import org.game.rpg_elements.Inimigos.MonsterDecorator;
import org.game.rpg_elements.status.Status;

public class Slime_Variante extends MonsterDecorator {

    public Slime_Variante(Individuo individuo) {
        super(individuo);
    }

    @Override
    public void Assembler() {
        Status t = getIndividuo().getStatus();
        t.getAtributos_real().add_vida(20);
        t.setNome("MegaSlime");

        t.setAtributos_atualizados(t.getAtributos_real());
        t.reset_status();

        Monster res = (Monster) this.getIndividuo();
        res.setStatus(t);

        this.setIndividuo(res);
    }
}
