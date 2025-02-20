package org.game.model.battle.battleElements.battleCommands;

import org.game.model.battle.battleElements.Battle;
import org.game.model.battle.battleElements.BattleCommander;
import org.game.model.battle.battleElements.Individuo;
import org.game.rpg_rules.Inimigos.Monster;
import org.game.rpg_rules.Inimigos.drop.Drop;
import org.game.rpg_rules.Inimigos.drop.LoaderDrop;
import org.game.rpg_rules.itens.Item;
import org.game.rpg_rules.itens.inventario.inventario_commands.InventarioAddDinheiro;
import org.game.rpg_rules.itens.inventario.inventario_commands.InventarioDropItens;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Generate_Loot extends BattleCommander {
    private LoaderDrop loaderDrop;
    private InventarioAddDinheiro inventarioAddDinheiro;
    private InventarioDropItens inventarioDropItens;
    private boolean level_up;
    private Integer xp;
    private Integer dinheiro;
    private List<Item> loot;

    public Generate_Loot(Battle battle, LoaderDrop loaderDrop, InventarioDropItens inventarioDropItens, InventarioAddDinheiro inventarioAddDinheiro) throws IOException {
        super(battle);
        this.loaderDrop = loaderDrop;
        this.inventarioAddDinheiro = inventarioAddDinheiro;
        this.inventarioDropItens = inventarioDropItens;
    }

    public Generate_Loot(Battle battle) throws IOException {
        super(battle);
        this.loaderDrop = new LoaderDrop();
    }

    @Override
    public void execute() throws IOException {
        List<Drop> drops = new ArrayList<>();
        boolean level_up = false;

        for(Individuo monster1: battle.getListMonster()){
            Drop drop = loaderDrop.renderDrop(monster1.getStatus().getNome());

            this.xp = drop.getExperiencia();

            if(inventarioAddDinheiro == null){
                 inventarioAddDinheiro = new InventarioAddDinheiro(battle.getParty().getParty().get(0).getHero_inventario(), drop);

            }
            inventarioAddDinheiro.execute();
            this.dinheiro = inventarioAddDinheiro.getDinheiro();

            if(inventarioDropItens == null){
                 inventarioDropItens = new InventarioDropItens(battle.getParty().getParty().get(0).getHero_inventario(), drop);

            }
            inventarioDropItens.execute();
            this.loot = inventarioDropItens.getItems();

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
