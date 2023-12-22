package org.game.controller.gameController.elementController;

import org.game.Game;
import org.game.controller.gameController.GameController;
import org.game.gui.GUI;
import org.game.model.Position;
import org.game.model.menu.OpenChest;
import org.game.rpg_rules.dialogue.Dialogue;
import org.game.rpg_rules.dialogue.HeroMovementDialogue;
import org.game.model.game.map.Map;

import org.game.model.game.map.MapLoader;
import org.game.model.menu.Inventory;
import org.game.rpg_rules.itens.Item;
import org.game.rpg_rules.itens.Sorteio;
import org.game.rpg_rules.itens.inventario.Equipado;
import org.game.rpg_rules.itens.inventario.inventario_commands.itens.InventarioAddEquipamento;
import org.game.rpg_rules.itens.tipo.Equipamento;
import org.game.states.inventory.InventoryState;
import org.game.states.inventory.OpenChestState;
import org.game.states.map.MapState;

import java.io.IOException;
import java.net.URISyntaxException;

public class DialogueController extends GameController {

    public DialogueController(Map map) {
        super(map);
    }
    private GUI.ACTION pre_act;

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException {

        if (action == GUI.ACTION.UP) {
            pre_act = GUI.ACTION.UP;
            getModel().setNarrator(new HeroMovementDialogue().CreateDialogue());

        }
        if (action == GUI.ACTION.RIGHT) {
            pre_act = GUI.ACTION.RIGHT;
            getModel().setNarrator(new HeroMovementDialogue().CreateDialogue());

        }
        if (action == GUI.ACTION.DOWN) {
            pre_act = GUI.ACTION.DOWN;
            getModel().setNarrator(new HeroMovementDialogue().CreateDialogue());
        }
        if (action == GUI.ACTION.LEFT) {
            pre_act = GUI.ACTION.LEFT;
            getModel().setNarrator(new HeroMovementDialogue().CreateDialogue());
        }


        if (action == GUI.ACTION.INVENTORY) {
            Inventory inventory = new Inventory(getModel().getHero().getHero_inventario(), getModel().getHero());
            InventoryState state = new InventoryState(inventory);
            game.addState(state);
        }
        if (action == GUI.ACTION.INTERACT) {


            if (game.get_inside_castle()||game.getFloor()==3) {
                switch (game.getFloor()) {
                    case 1:
                        if (getModel().getHero().getHeroElement().getPosition().equals(new Position(17, 15))) {
                            game.previousState();
                            game.previousfloor();
                            getModel().getHero().getHeroElement().setPosition(new Position(36, 9));
                            game.setinside_castle(false);
                            return;
                        }


                        if (getModel().getHero().getHeroElement().getPosition().equals(new Position(43, 7))) {
                            MapState state = (new MapState(new MapLoader("SecondRoom", game.getHero()).createMap(getModel().getHero()), 2));
                            game.addfloor();
                            getModel().getHero().getHeroElement().setPosition(new Position(43, 15));
                            game.addState(state);
                            return;

                        }

                    case 2:
                        if (getModel().getHero().getHeroElement().getPosition().equals(new Position(43, 15))) {
                            game.previousState();
                            getModel().getHero().getHeroElement().setPosition(new Position(43, 7));
                            game.previousfloor();
                            return;
                        }

                        if (getModel().getHero().getHeroElement().getPosition().equals(new Position(49, 6))) {
                            MapState state = (new MapState(new MapLoader("BossRoom.txt", game.getHero()).createMap(getModel().getHero()), 2));
                            getModel().getHero().getHeroElement().setPosition(new Position(8, 12));
                            game.addState(state);
                            game.addfloor();
                            return;

                        }
                    case 3:
                        if (getModel().getHero().getHeroElement().getPosition().equals(new Position(8, 12))) {
                            game.previousState();
                            getModel().getHero().getHeroElement().setPosition(new Position(49, 6));
                            game.previousfloor();
                            return;
                        }                }
            }

                if (getModel().getHero().get_in_map() && getModel().getHero().getHeroElement().getPosition().equals(new Position(36, 9)) && !game.get_inside_castle()) {
                    MapState state = (new MapState(new MapLoader("FirstRoom", game.getHero()).createMap(getModel().getHero()), 2));
                    getModel().getHero().getHeroElement().setPosition(new Position(17, 15));
                    game.addState(state);
                    game.addfloor();
                    game.setinside_castle(true);
                    return;
                }
//17, 15
//43 7
                Dialogue t = new Dialogue();
                if (pre_act == GUI.ACTION.UP) {
                    if(getModel().isInteractableChest(getModel().getHero().getHeroElement().getPosition().getUp()) )
                    {
                        if(game.list_of_chests().get(game.getFloor()).equals(false))
                        {
                            Item equipamento = new Sorteio().equipamento();
                            InventarioAddEquipamento aaa = new InventarioAddEquipamento(getModel().getHero().getHero_inventario(),equipamento,1 );
                            aaa.execute();
                            game.close_one(game.getFloor());
                            game.addState(new OpenChestState(new OpenChest(equipamento,game.getHero())));
                            return;
                        }

                    }
                    t = getModel().isInteractable(getModel().getHero().getHeroElement().getPosition().getUp());
                }
                if (pre_act == GUI.ACTION.LEFT) {
                    if(getModel().isInteractableChest(getModel().getHero().getHeroElement().getPosition().getLeft()) )
                    {
                        if(game.list_of_chests().get(game.getFloor()).equals(false))
                        {
                            Item equipamento = new Sorteio().equipamento();
                            InventarioAddEquipamento aaa = new InventarioAddEquipamento(getModel().getHero().getHero_inventario(),equipamento,1 );
                            aaa.execute();
                            game.close_one(game.getFloor());
                            game.addState(new OpenChestState(new OpenChest(equipamento,game.getHero())));

                            return;
                        }

                    }
                    t = getModel().isInteractable(getModel().getHero().getHeroElement().getPosition().getLeft());
                }
                if (pre_act == GUI.ACTION.DOWN) {
                    if(getModel().isInteractableChest(getModel().getHero().getHeroElement().getPosition().getDown()) )
                    {
                        if(game.list_of_chests().get(game.getFloor()).equals(false))
                        {
                            Item equipamento = new Sorteio().equipamento();
                            InventarioAddEquipamento aaa = new InventarioAddEquipamento(getModel().getHero().getHero_inventario(),equipamento,1 );
                            aaa.execute();
                            game.close_one(game.getFloor());
                            game.addState(new OpenChestState(new OpenChest(equipamento,game.getHero())));

                            return;
                        }

                    }
                    t = getModel().isInteractable(getModel().getHero().getHeroElement().getPosition().getDown());
                }
                if (pre_act == GUI.ACTION.RIGHT) {
                    if(getModel().isInteractableChest(getModel().getHero().getHeroElement().getPosition().getRight()) )
                    {
                        if(game.list_of_chests().get(game.getFloor()).equals(false))
                        {
                            Item equipamento = new Sorteio().equipamento();
                            InventarioAddEquipamento aaa = new InventarioAddEquipamento(getModel().getHero().getHero_inventario(),equipamento,1 );
                            aaa.execute();
                            game.close_one(game.getFloor());
                            game.addState(new OpenChestState(new OpenChest(equipamento,game.getHero())));
                            return;
                        }

                    }
                    t = getModel().isInteractable(getModel().getHero().getHeroElement().getPosition().getRight());
                }

                if (t.getMen() == 2) {
                    getModel().setNarrator(t);
                    getModel().setOptions(2);
                } else if (t.getMen() == 1) {
                    getModel().setNarrator(t);
                    getModel().setOptions(1);
                } else {
                    getModel().setNarrator(t);
                }
            }

        }


    }
