package org.game.controller.inventortController;

import org.game.Game;
import org.game.controller.Controller;
import org.game.gui.GUI;
import org.game.model.menu.Shop;
import org.game.rpg_elements.itens.Item;
import org.game.rpg_elements.itens.LoaderItem;

import java.io.IOException;
import java.net.URISyntaxException;

public class ShopController extends Controller<Shop> {
    public ShopController(Shop model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException {
        switch (action) {
            case UP:
                getModel().nextEntryUp();
                break;
            case DOWN:
                getModel().nextEntryDown();
                break;
            case LEFT:
                getModel().nextEntryLeft();
                break;
            case RIGHT:
                getModel().nextEntryRight();
                break;
            case SELECT:
                Item item;
                switch (getModel().getCurrent())
                {
                    case 0:
                        item  = new LoaderItem().renderConsumivel("1");
                        if(getModel().getHero().getHero_inventario().getDinheiro()>=10)
                        {
                            getModel().getHero().getHero_inventario().remove_dinheiro(10);
                            getModel().getHero().getHero_inventario().add_consumivel(item,1);
                            game.notifyBuy(0);
                        }
                        else game.notifyBuy(1);
                        break;

                    case 1:
                        item  = new LoaderItem().renderConsumivel("2");
                        if(getModel().getHero().getHero_inventario().getDinheiro()>=25)
                        {
                            getModel().getHero().getHero_inventario().remove_dinheiro(25);
                            getModel().getHero().getHero_inventario().add_consumivel(item,1);
                            game.notifyBuy(0);
                        }
                        else game.notifyBuy(1);                        break;
                    case 2:
                        item  = new LoaderItem().renderConsumivel("3");
                        if(getModel().getHero().getHero_inventario().getDinheiro()>=50)
                        {
                            getModel().getHero().getHero_inventario().remove_dinheiro(50);
                            getModel().getHero().getHero_inventario().add_consumivel(item,1);
                            game.notifyBuy(0);
                        }
                        else game.notifyBuy(1);                        break;
                    case 3:
                        item  = new LoaderItem().renderConsumivel("4");
                        if(getModel().getHero().getHero_inventario().getDinheiro()>=10)
                        {
                            getModel().getHero().getHero_inventario().remove_dinheiro(10);
                            getModel().getHero().getHero_inventario().add_consumivel(item,1);
                            game.notifyBuy(0);
                        }
                        else game.notifyBuy(1);                        break;
                    case 4:
                        item  = new LoaderItem().renderConsumivel("5");
                        if(getModel().getHero().getHero_inventario().getDinheiro()>=25)
                        {
                            getModel().getHero().getHero_inventario().remove_dinheiro(25);
                            getModel().getHero().getHero_inventario().add_consumivel(item,1);
                            game.notifyBuy(0);
                        }
                        else game.notifyBuy(1);                        break;
                    case 5:
                        item  = new LoaderItem().renderConsumivel("6");
                        if(getModel().getHero().getHero_inventario().getDinheiro()>=50)
                        {
                            getModel().getHero().getHero_inventario().remove_dinheiro(50);
                            getModel().getHero().getHero_inventario().add_consumivel(item,1);
                            game.notifyBuy(0);
                        }
                        else game.notifyBuy(1);                        break;
                    case 6:
                        item  = new LoaderItem().renderConsumivel("7");
                        if(getModel().getHero().getHero_inventario().getDinheiro()>=40)
                        {
                            getModel().getHero().getHero_inventario().remove_dinheiro(40);
                            getModel().getHero().getHero_inventario().add_consumivel(item,1);
                            game.notifyBuy(0);
                        }
                        else game.notifyBuy(1);                        break;
                    case 7:
                        item  = new LoaderItem().renderConsumivel("8");
                        if(getModel().getHero().getHero_inventario().getDinheiro()>=80)
                        {
                            getModel().getHero().getHero_inventario().remove_dinheiro(80);
                            getModel().getHero().getHero_inventario().add_consumivel(item,1);
                            game.notifyBuy(0);
                        }
                        else game.notifyBuy(1);                        break;
                    case 10:
                        item  = new LoaderItem().renderConsumivel("9");
                        if(getModel().getHero().getHero_inventario().getDinheiro()>=100)
                        {
                            getModel().getHero().getHero_inventario().remove_dinheiro(100);
                            getModel().getHero().getHero_inventario().add_consumivel(item,1);
                            game.notifyBuy(0);
                        }
                        else game.notifyBuy(1);                        break;
                    case 11:
                        item  = new LoaderItem().renderConsumivel("10");
                        if(getModel().getHero().getHero_inventario().getDinheiro()>=40)
                        {
                            getModel().getHero().getHero_inventario().remove_dinheiro(40);
                            getModel().getHero().getHero_inventario().add_consumivel(item,1);
                            game.notifyBuy(0);
                        }
                        else game.notifyBuy(1);                        break;
                    case 12:
                        item  = new LoaderItem().renderConsumivel("11");
                        if(getModel().getHero().getHero_inventario().getDinheiro()>=40)
                        {
                            getModel().getHero().getHero_inventario().remove_dinheiro(40);
                            getModel().getHero().getHero_inventario().add_consumivel(item,1);
                            game.notifyBuy(0);
                        }
                        else game.notifyBuy(1);                        break;
                    case 13:
                        item  = new LoaderItem().renderConsumivel("12");
                        if(getModel().getHero().getHero_inventario().getDinheiro()>=40)
                        {
                            getModel().getHero().getHero_inventario().remove_dinheiro(40);
                            getModel().getHero().getHero_inventario().add_consumivel(item,1);
                            game.notifyBuy(0);
                        }
                        else game.notifyBuy(1);                        break;
                    case 14:
                        item  = new LoaderItem().renderConsumivel("13");
                        if(getModel().getHero().getHero_inventario().getDinheiro()>=40)
                        {
                            getModel().getHero().getHero_inventario().remove_dinheiro(40);
                            getModel().getHero().getHero_inventario().add_consumivel(item,1);
                            game.notifyBuy(0);
                        }
                        else game.notifyBuy(1);                        break;
                    case 15:
                        item  = new LoaderItem().renderConsumivel("14");
                        if(getModel().getHero().getHero_inventario().getDinheiro()>=40)
                        {
                            getModel().getHero().getHero_inventario().remove_dinheiro(40);
                            getModel().getHero().getHero_inventario().add_consumivel(item,1);
                            game.notifyBuy(0);
                        }
                        else game.notifyBuy(1);                        break;
                    case 16:
                        item  = new LoaderItem().renderConsumivel("15");
                        if(getModel().getHero().getHero_inventario().getDinheiro()>=40)
                        {
                            getModel().getHero().getHero_inventario().remove_dinheiro(40);
                            getModel().getHero().getHero_inventario().add_consumivel(item,1);
                            game.notifyBuy(0);
                        }
                        else game.notifyBuy(1);                        break;
                    case 17:
                        item  = new LoaderItem().renderConsumivel("16");
                        if(getModel().getHero().getHero_inventario().getDinheiro()>=30)
                        {
                            getModel().getHero().getHero_inventario().remove_dinheiro(30);
                            getModel().getHero().getHero_inventario().add_consumivel(item,1);
                            game.notifyBuy(0);
                        }
                        else game.notifyBuy(1);                        break;

                }


                break;
            case BACK:
                game.previousState();
                break;
            case ESC:
                game.previousState();
                break;

        }
    }
}
