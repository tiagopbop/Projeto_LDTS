package org.game.rpg_elements.Inimigos.variantes;

import org.game.model.battle.battleElements.Individuo;
import org.game.rpg_elements.Inimigos.Monster;
import org.game.rpg_elements.Inimigos.MonsterDecorator;
import org.game.rpg_elements.Inimigos.strategy.AgressiveStrategy;
import org.game.rpg_elements.Inimigos.strategy.NormalStrategy;
import org.game.rpg_elements.Inimigos.strategy.Strategy;
import org.game.rpg_elements.status.Status;

public class Slime_Variante extends MonsterDecorator {
    private Strategy strategy;

    public Slime_Variante(Individuo individuo, Strategy strategy){
        super(individuo);
        this.strategy = strategy;
    }

    public Slime_Variante(Individuo individuo) {
        super(individuo);
        this.strategy = new NormalStrategy();
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
        res.setStrategy(strategy);

        this.setIndividuo(res);
    }
}
