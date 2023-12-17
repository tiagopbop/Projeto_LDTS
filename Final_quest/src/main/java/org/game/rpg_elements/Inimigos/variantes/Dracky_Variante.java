package org.game.rpg_elements.Inimigos.variantes;

import org.game.model.battle.battleElements.Individuo;
import org.game.rpg_elements.Inimigos.Monster;
import org.game.rpg_elements.Inimigos.MonsterDecorator;
import org.game.rpg_elements.Inimigos.strategy.AgressiveStrategy;
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

        t.setAtributos_atualizados(t.getAtributos_real());
        t.reset_status();

        Monster res = (Monster) this.getIndividuo();
        res.setStatus(t);
        res.setStrategy(new AgressiveStrategy());

        this.setIndividuo(res);
    }
}
