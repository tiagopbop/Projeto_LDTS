package org.game.controller.battleController;

import org.game.Game;
import org.game.controller.Controller;
import org.game.gui.GUI;
import org.game.model.battle.battleElements.battleCommands.Generate_Loot;
import org.game.model.battle.menus.BattleConsumableMenu;
import org.game.model.battle.menus.Death;
import org.game.model.battle.menus.LevelUp;
import org.game.model.battle.menus.Receive;
import org.game.rpg_elements.itens.Item;
import org.game.states.battle.DeathState;
import org.game.states.battle.LevelUpState;
import org.game.states.battle.ReceiveState;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class BattleConsumableController extends Controller<BattleConsumableMenu> {
    public BattleConsumableController(BattleConsumableMenu model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case BACK:
                game.previousState();
                break;
            case SELECT:
                Item item = getModel().getEntryi(getModel().getCurrentEntry());
                int res = getModel().start_turn("item" ,item);

                if(res == 1){
                    //batalha continua

                }
                else if(res == 0){
                    game.addState(new DeathState(new Death(getModel().getHero().getHero_inventario(),getModel().getHero())));
                    return;
                    //heroi morreu
                }
                else {
                    Generate_Loot generateLoot = new Generate_Loot(getModel().getBattle());
                    generateLoot.execute();

                    boolean level_up = generateLoot.getLevel_up();

                    Integer dinheiro = generateLoot.getDinheiro();
                    Integer xp = generateLoot.getXp();
                    List<Item> itens = generateLoot.getLoot();

                    if(level_up)
                    {
                        game.addState(new LevelUpState(new LevelUp(getModel().getHero().getHero_inventario(),getModel().getHero(),dinheiro,xp,itens,level_up)));
                    }
                    else game.addState(new ReceiveState(new Receive(1,getModel().getHero().getHero_inventario(),getModel().getHero(), dinheiro, xp, itens, level_up)));
                    return;
                    //monstro morreu
                }
                game.previousState();
                break;

    }
}
}
