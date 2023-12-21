package org.game.viewer.inventory;

import org.game.gui.GUI;
import org.game.model.Position;
import org.game.model.menu.Shop;
import org.game.rpg_rules.itens.Item;
import org.game.rpg_rules.itens.LoaderItem;
import org.game.viewer.Viewer;

import java.io.IOException;
import java.util.Map;

public class ShopViewer extends Viewer<Shop> {
    public ShopViewer(Shop model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) throws IOException {
        gui.drawText(
                new Position(9, 5),
                getModel().getEntry(0),
                getModel().isSelected(new Position(0, 0)) ? "#FFD700" : "#FFFFFF");

        gui.drawText(
                new Position(9, 7),
                getModel().getEntry(1),
                getModel().isSelected(new Position(0, 1)) ? "#FFD700" : "#FFFFFF");

        gui.drawText(
                new Position(9, 9),
                getModel().getEntry(2),
                getModel().isSelected(new Position(0, 2)) ? "#FFD700" : "#FFFFFF");

        gui.drawText(
                new Position(9, 11),
                getModel().getEntry(3),
                getModel().isSelected(new Position(0, 3)) ? "#FFD700" : "#FFFFFF");
        gui.drawText(
                new Position(9, 13),
                getModel().getEntry(4),
                getModel().isSelected(new Position(0, 4)) ? "#FFD700" : "#FFFFFF");

        gui.drawText(
                new Position(9, 15),
                getModel().getEntry(5),
                getModel().isSelected(new Position(0, 5)) ? "#FFD700" : "#FFFFFF");

        gui.drawText(
                new Position(9, 17),
                getModel().getEntry(6),
                getModel().isSelected(new Position(0, 6)) ? "#FFD700" : "#FFFFFF");

        gui.drawText(
                new Position(9, 19),
                getModel().getEntry(7),
                getModel().isSelected(new Position(0, 7)) ? "#FFD700" : "#FFFFFF");
        gui.drawText(
                new Position(31, 5),
                getModel().getEntry(8),
                getModel().isSelected(new Position(1, 0)) ? "#FFD700" : "#FFFFFF");

        gui.drawText(
                new Position(31, 7),
                getModel().getEntry(9),
                getModel().isSelected(new Position(1, 1)) ? "#FFD700" : "#FFFFFF");

        gui.drawText(
                new Position(31, 9),
                getModel().getEntry(10),
                getModel().isSelected(new Position(1, 2)) ? "#FFD700" : "#FFFFFF");

        gui.drawText(
                new Position(31, 11),
                getModel().getEntry(11),
                getModel().isSelected(new Position(1, 3)) ? "#FFD700" : "#FFFFFF");
        gui.drawText(
                new Position(31, 13),
                getModel().getEntry(12),
                getModel().isSelected(new Position(1, 4)) ? "#FFD700" : "#FFFFFF");

        gui.drawText(
                new Position(31, 15),
                getModel().getEntry(13),
                getModel().isSelected(new Position(1, 5)) ? "#FFD700" : "#FFFFFF");

        gui.drawText(
                new Position(31, 17),
                getModel().getEntry(14),
                getModel().isSelected(new Position(1, 6)) ? "#FFD700" : "#FFFFFF");

        gui.drawText(
                new Position(31, 19),
                getModel().getEntry(15),
                getModel().isSelected(new Position(1, 7)) ? "#FFD700" : "#FFFFFF");


        gui.drawText(
                new Position(25, 1),
                "KITTYSHOP UwU",
                "#FFFFFF");
        String gold_texto = "gold: " + String.valueOf(getModel().getHero().getHero_inventario().getDinheiro());
        gui.drawText(
                new Position(2, 1),
                gold_texto,
                "#FFFFFF");


        drawBorders(gui);


        //desenhar preço quantidade breve descriçao
        switch (getModel().getCurrent()) {
            case 0:
                gui.drawText(new Position(20, 26), "price: 10", "#FFFFFF");
                drawAmount(gui,"1");
                gui.drawText(new Position(20, 30), "this gives 20 hp", "#FFFFFF");
                break;

            case 1:
                gui.drawText(new Position(20, 26), "price: 25", "#FFFFFF");
                drawAmount(gui,"2");
                gui.drawText(new Position(20, 30), "this gives 50 hp", "#FFFFFF");
                break;

            case 2:
                gui.drawText(new Position(20, 26), "price: 50", "#FFFFFF");
                drawAmount(gui,"3");
                gui.drawText(new Position(20, 30), "this gives 200 hp", "#FFFFFF");
                break;
            case 3:
                gui.drawText(new Position(20, 26), "price: 10", "#FFFFFF");
                drawAmount(gui,"4");
                gui.drawText(new Position(20, 30), "this gives 20 mana", "#FFFFFF");
                break;
            case 4:
                gui.drawText(new Position(20, 26), "price: 25", "#FFFFFF");
                drawAmount(gui,"5");
                gui.drawText(new Position(20, 30), "this gives 50 mana", "#FFFFFF");
                break;
            case 5:
                gui.drawText(new Position(20, 26), "price: 50", "#FFFFFF");
                drawAmount(gui,"6");
                gui.drawText(new Position(20, 30), "this gives 200 mana", "#FFFFFF");
                break;
            case 6:
                gui.drawText(new Position(20, 26), "price: 40", "#FFFFFF");
                drawAmount(gui,"7");
                gui.drawText(new Position(20, 30), "this gives 20 hp and 20 mana", "#FFFFFF");
                break;
            case 7:
                gui.drawText(new Position(20, 26), "price: 80", "#FFFFFF");
                drawAmount(gui,"8");
                gui.drawText(new Position(20, 30), "this gives 50 hp and 50 mana", "#FFFFFF");
                break;
            case 10:
                gui.drawText(new Position(20, 26), "price: 100", "#FFFFFF");
                drawAmount(gui,"9");
                gui.drawText(new Position(20, 30), "this gives 200 hp and 200 mana", "#FFFFFF");
                break;
            case 11:
                gui.drawText(new Position(20, 26), "price: 40", "#FFFFFF");
                drawAmount(gui,"10");
                gui.drawText(new Position(20, 30), "this increases speed by 20 in battle", "#FFFFFF");
                break;
            case 12:
                gui.drawText(new Position(20, 26), "price: 40", "#FFFFFF");
                drawAmount(gui,"11");
                gui.drawText(new Position(20, 30), "this increases strength by 20 in battle", "#FFFFFF");
                break;
            case 13:
                gui.drawText(new Position(20, 26), "price: 40", "#FFFFFF");
                drawAmount(gui,"12");
                gui.drawText(new Position(20, 30), "this increases intel by 20 in battle", "#FFFFFF");
                break;

            case 14:
                gui.drawText(new Position(20, 26), "price: 40", "#FFFFFF");
                drawAmount(gui,"13");
                gui.drawText(new Position(20, 30), "this reduces the enemy speed by 20", "#FFFFFF");
                break;
            case 15:
                gui.drawText(new Position(20, 26), "price: 40", "#FFFFFF");
                drawAmount(gui,"14");
                gui.drawText(new Position(20, 30), "this reduces the enemy strength by 20", "#FFFFFF");
                break;
            case 16:
                gui.drawText(new Position(20, 26), "price: 40", "#FFFFFF");
                drawAmount(gui,"15");
                gui.drawText(new Position(20, 30), "this reduces the enemy intel by 20", "#FFFFFF");
                break;
            case 17:
                gui.drawText(new Position(20, 26), "price: 30", "#FFFFFF");
                drawAmount(gui,"16");
                gui.drawText(new Position(20, 30), "throw a bomb for 20 hp", "#FFFFFF");
                break;

        }
    }


    public void drawAmount(GUI gui, String file) throws IOException {
        boolean flag=true;
        Item item = new LoaderItem().renderConsumivel(file);

        for(Map.Entry<Item, Integer> entry: getModel().getHero().getHero_inventario().getConsumiveis().entrySet())
        {
            if(entry.getKey().getNome().equals(item.getNome()))
            {
                gui.drawText(new Position(20, 28), "you have: " +entry.getValue() , "#FFFFFF");
                flag = false;
            }
        }

        if(flag)
        {
            gui.drawText(new Position(20, 28), "you have: 0", "#FFFFFF");

        }
    }

    public void drawBorders(GUI gui) throws IOException {
        //verde
        String top = new String("");
        top += (char) 130;
        gui.drawText(new Position(0, 0), top, "#FF7FFF");
        gui.drawText(new Position(0, 32), top, "#FF7FFF");
        gui.drawText(new Position(60, 32), top, "#FF7FFF");
        gui.drawText(new Position(60, 0), top, "#FF7FFF");


        top = "";
        for (int i = 0; i < 59; i++) {
            top += (char) 140;
        }
        gui.drawText(new Position(1, 0), top, "#FF7FFF");

        top = "";
        for (int i = 0; i < 59; i++) {
            top += (char) 141;
        }
        gui.drawText(new Position(1, 32), top, "#FF7FFF");

        top = "";
        top += (char) 142;
        for (int i = 0; i < 31; i++) {
            gui.drawText(new Position(0, i + 1), top, "#FF7FFF");

        }
        top = "";
        top += (char) 143;
        for (int i = 0; i < 31; i++) {
            gui.drawText(new Position(60, i + 1), top, "#FF7FFF");

        }





        top="";
        for(int i = 0; i<14; i++){
            top+=(char)140;
        }
        gui.drawText(new Position(3,22), top, "#FFFFFF");

        top="";
        for(int i = 0; i<14; i++){
            top+=(char)141;
        }
        gui.drawText(new Position(3,31), top, "#FFFFFF");

        top = "";
        top += (char)142;
        for(int i = 0; i<10; i++){
            gui.drawText(new Position(17,i+22), top, "#FFFFFF");

        }
        top = "";
        top += (char)143;
        for(int i = 0; i<10; i++){
            gui.drawText(new Position(2,i+22), top, "#FFFFFF");

        }


    }
}