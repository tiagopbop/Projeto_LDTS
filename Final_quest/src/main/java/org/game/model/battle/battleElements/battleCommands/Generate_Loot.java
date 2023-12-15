package org.game.model.battle.battleElements.battleCommands;

import org.game.model.battle.battleElements.Battle;
import org.game.model.battle.battleElements.BattleCommander;
import org.game.rpg_elements.Inimigos.Monster;
import org.game.rpg_elements.Inimigos.drop.Drop;
import org.game.rpg_elements.Inimigos.drop.LoaderDrop;
import org.game.rpg_elements.itens.Item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Generate_Loot extends BattleCommander {
    private boolean level_up;
    private Integer xp;
    private Integer dinheiro;
    private List<Item> loot;

    public Generate_Loot(Battle battle) throws IOException {
        super(battle);
    }

    @Override
    public void execute() throws IOException {
        List<Drop> drops = new ArrayList<>();
        boolean level_up = false;

        for(Monster monster1: battle.getListMonster()){
            Drop drop = new LoaderDrop().renderDrop(monster1.getStatus().getNome());

            this.xp = drop.getExperiencia();
            this.dinheiro = battle.getParty().getParty().get(0).getHero_inventario().add_dinheiro(drop);
            this.loot = battle.getParty().getParty().get(0).getHero_inventario().add_drop_itens(drop);

            level_up = battle.getParty().getParty().get(0).add_drop(drop);
        }
        this.level_up = level_up;
    }

    public Integer getDinheiro() {
        return dinheiro;
    }

    public Integer getXp() {
        return xp;
    }

    public List<Item> getLoot() {
        return loot;
    }

    public boolean getLevel_up(){
        return this.level_up;
    }
}
