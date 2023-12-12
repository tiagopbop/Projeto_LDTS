package org.game.model.game.battle;

import org.game.Game;
import org.game.controller.Controller;
import org.game.gui.GUI;
import org.game.model.menu.Death;
import org.game.model.menu.LevelUp;
import org.game.model.menu.Receive;
import org.game.rpg_elements.itens.Item;
import org.game.states.DeathState;
import org.game.states.LevelUpState;
import org.game.states.ReceiveState;

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
                int res = getModel().star_turn("item", item);

                if(res == 1){
                    System.out.println("batalha continua");
                    //batalha continua

                }
                else if(res == 0){
                    System.out.println("heroi morreu");
                    game.addState(new DeathState(new Death(getModel().getHero().getHero_inventario(),getModel().getHero())));
                    return;
                    //heroi morreu
                }
                else {
                    System.out.println("monstro morreu");
                    boolean level_up = getModel().getBattle().generate_loot();

                    Integer dinheiro = getModel().getBattle().getDinheiro();
                    Integer xp = getModel().getBattle().getXp();
                    List<Item> itens = getModel().getBattle().getLoot();

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
