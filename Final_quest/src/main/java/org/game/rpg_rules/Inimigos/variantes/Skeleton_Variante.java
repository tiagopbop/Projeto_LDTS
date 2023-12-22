package org.game.rpg_rules.Inimigos.variantes;

import org.game.model.battle.battleElements.Individuo;
import org.game.rpg_rules.Inimigos.Monster;
import org.game.rpg_rules.Inimigos.MonsterDecorator;
import org.game.rpg_rules.Inimigos.strategy.AgressiveStrategy;
import org.game.rpg_rules.Inimigos.strategy.Strategy;
import org.game.rpg_rules.status.Status;

public class Skeleton_Variante extends MonsterDecorator {
    private Strategy strategy;

    public Skeleton_Variante(Individuo individuo, Strategy strategy) {
        super(individuo);
        this.strategy = strategy;
    }

    public Skeleton_Variante(Individuo individuo) {
        super(individuo);
        this.strategy = new AgressiveStrategy();
    }

    @Override
    public void Assembler() {
        Status t = getIndividuo().getStatus();
        t.getAtributos_real().add_vida(20);
        t.setNome("MegaSkeleton");

        t.setAtributos_atualizados(t.getAtributos_real());
        t.reset_status();

        Monster res = (Monster) this.getIndividuo();
        res.setStatus(t);
        res.setStrategy(strategy);

        this.setIndividuo(res);
    }

    @Override
    public Strategy getStrategy() {
        return strategy;
    }
}
