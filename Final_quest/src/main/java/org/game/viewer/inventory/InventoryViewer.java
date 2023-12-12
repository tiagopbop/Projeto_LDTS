package org.game.viewer.inventory;

import org.game.gui.GUI;
import org.game.model.Position;
import org.game.model.menu.Inventory;
import org.game.viewer.Viewer;

import java.io.IOException;

public class InventoryViewer extends Viewer<Inventory> {
    public InventoryViewer(Inventory model) {
        super(model);
    }

    @Override
    public void drawElements(GUI gui) throws  IOException {
        gui.drawText(new Position(34, 5), "Inventory", "#008000");
        drawInventory(gui);
        drawStats(gui);
        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(34, 10 + 2*i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#0000B3" : "#FFFFFF");
    }

    public void drawInventory(GUI gui) throws IOException {
        //verde
        String top = new String("");
        top += (char)130;
        gui.drawText(new Position(0,0),top , "#008000");
        gui.drawText(new Position(0,32),top , "#008000");
        gui.drawText(new Position(60,32), top, "#008000");
        gui.drawText(new Position(60,0), top, "#008000");



        top="";
        for(int i = 0; i<59; i++){
            top+=(char)140;
        }
        gui.drawText(new Position(1,0), top, "#008000");

        top="";
        for(int i = 0; i<59; i++){
            top+=(char)141;
        }
        gui.drawText(new Position(1,32), top, "#008000");

        top = "";
        top += (char)142;
        for(int i = 0; i<31; i++){
            gui.drawText(new Position(0,i+1), top, "#008000");

        }
        top = "";
        top += (char)143;
        for(int i = 0; i<31; i++){
            gui.drawText(new Position(60,i+1), top, "#008000");

        }

        top = new String("");
        top += (char)130;
        gui.drawText(new Position(20,0),top , "#008000");
        gui.drawText(new Position(20,32),top , "#008000");
        top = "";
        top += (char)143;
        for(int i = 0; i<31; i++){
            gui.drawText(new Position(20,i+1), top, "#008000");

        }

        //branco
        top="";
        for(int i = 0; i<13; i++){
            top+=(char)140;
        }
        gui.drawText(new Position(4,5), top, "#FFFFFF");

        top="";
        for(int i = 0; i<13; i++){
            top+=(char)141;
        }
        gui.drawText(new Position(4,14), top, "#FFFFFF");

        top = "";
        top += (char)142;
        for(int i = 0; i<10; i++){
            gui.drawText(new Position(17,i+5), top, "#FFFFFF");

        }
        top = "";
        top += (char)143;
        for(int i = 0; i<10; i++){
            gui.drawText(new Position(3,i+5), top, "#FFFFFF");

        }



    }
    public void drawStats(GUI gui)
    {
        String vida_texto = "vida: " + String.valueOf(getModel().getHero().getStatus().getVida_atual())
                + "/" + String.valueOf(getModel().getHero().getStatus().getAtributos_atualizados().getVida());

        String xp_texto = "EXP: " + String.valueOf(getModel().getHero().getStatus().getExperiencia())
                + "/" + String.valueOf(getModel().getHero().getStatus().getAtributos_real().exp_level_up());


        String gold_texto = "gold: " + String.valueOf(getModel().getHero().getHero_inventario().getDinheiro());

        String mana_texto = "mana: " + String.valueOf(getModel().getHero().getStatus().getMana_atual())
                + "/" + String.valueOf(getModel().getHero().getStatus().getAtributos_atualizados().getMana());

        String lvl = "LVL: " + String.valueOf(getModel().getHero().getStatus().getAtributos_real().getLevel());

        String forca = "stren: " + String.valueOf(getModel().getHero().getStatus().getAtributos_real().getForca());
        String inteligencia = "intel: " + String.valueOf(getModel().getHero().getStatus().getAtributos_real().getInteligencia());
        String velocidade = "speed: " + String.valueOf(getModel().getHero().getStatus().getAtributos_real().getVelocidade());
        gui.drawText(
                new Position(8 , 2 ),
                getModel().getHero().getStatus().getNome(),
                "#FFFFFF");

        gui.drawText(
                new Position(5 , 21 ),
                vida_texto,
                "#FFFFFF");

        gui.drawText(
                new Position(5 , 22),
                mana_texto,
                "#FFFFFF");


        gui.drawText(
                new Position(5 , 23),
                forca,
                "#FFFFFF");
        gui.drawText(
                new Position(5 , 24 ),
                inteligencia,
                "#FFFFFF");
        gui.drawText(
                new Position(5 , 25 ),
                velocidade,
                "#FFFFFF");


        gui.drawText(
                new Position(34 , 27),
                gold_texto,
                "#FFFFFF");
        gui.drawText(
                new Position(5 , 17),
                xp_texto,
                "#FFFFFF");

        gui.drawText(
                new Position(5 , 16 ),
                lvl,
                "#FFFFFF");
    }

    }



