package org.game.viewer.battle;

import org.game.gui.GUI;
import org.game.model.Position;
import org.game.model.battle.menus.LevelUp;
import org.game.rpg_rules.status.ataque.Ataque;
import org.game.rpg_rules.status.ataque.Learn_Ataque;
import org.game.viewer.Viewer;

import java.io.IOException;
import java.util.List;

public class LevelUpViewer extends Viewer<LevelUp> {
    public LevelUpViewer(LevelUp model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) throws IOException {

        int l = getModel().getHero().getStatus().getAtributos_real().getLevel();
        String lvl = "You are now level " + String.valueOf(l);
        gui.drawText(
                new Position(22,2),
                lvl,
               "#FFFFFF");
        gui.drawText(
                new Position(11,3),
                "Chose one of the following stats to increase:",
                "#FFFFFF");



        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(17, 11 + 2*i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");

        drawDesign(gui);
        drawStats(gui);
    }
    public void drawStats(GUI gui)
    {
        String vida_texto = String.valueOf(getModel().getHero().getStatus().getAtributos_atualizados().getVida())
                + " ->" + String.valueOf(getModel().getHero().getStatus().getAtributos_atualizados().getVida() + 5);


        String mana_texto =  String.valueOf(getModel().getHero().getStatus().getAtributos_atualizados().getMana())
                + " ->" + String.valueOf(getModel().getHero().getStatus().getAtributos_atualizados().getMana() + 5);


        String forca =  String.valueOf(getModel().getHero().getStatus().getAtributos_real().getForca())
                + " ->" + String.valueOf(getModel().getHero().getStatus().getAtributos_atualizados().getForca() + 3);

        String inteligencia = String.valueOf(getModel().getHero().getStatus().getAtributos_real().getInteligencia())
                + " ->" + String.valueOf(getModel().getHero().getStatus().getAtributos_atualizados().getInteligencia() + 3);

        String velocidade = String.valueOf(getModel().getHero().getStatus().getAtributos_real().getVelocidade())
                + " ->" + String.valueOf(getModel().getHero().getStatus().getAtributos_atualizados().getVelocidade() + 3);



        gui.drawText(
                new Position(40 , 11 ),
                vida_texto,
                "#FFFFFF");

        gui.drawText(
                new Position(40, 13),
                mana_texto,
                "#FFFFFF");


        gui.drawText(
                new Position(40 , 15),
                forca,
                "#FFFFFF");
        gui.drawText(
                new Position(40 , 17 ),
                inteligencia,
                "#FFFFFF");
        gui.drawText(
                new Position(40 , 19 ),
                velocidade,
                "#FFFFFF");


    }

    public void drawDesign(GUI gui)
    {
        String top = new String("");
        top += (char)130;
        gui.drawText(new Position(0,0),top , "#01B4AA");
        gui.drawText(new Position(0,32),top , "#01B4AA");
        gui.drawText(new Position(60,32), top, "#01B4AA");
        gui.drawText(new Position(60,0), top, "#01B4AA");

        top="";
        for(int i = 0; i<59; i++){
            top+=(char)140;
        }
        gui.drawText(new Position(1,0), top, "#01B4AA");

        top="";
        for(int i = 0; i<59; i++){
            top+=(char)141;
        }
        gui.drawText(new Position(1,32), top, "#01B4AA");

        top = "";
        top += (char)142;
        for(int i = 0; i<31; i++){
            gui.drawText(new Position(0,i+1), top, "#01B4AA");

        }
        top = "";
        top += (char)143;
        for(int i = 0; i<31; i++){
            gui.drawText(new Position(60,i+1), top, "#01B4AA");

        }






         top = new String("");
        top += (char)130;
        gui.drawText(new Position(5,5),top , "#E23C52");
        gui.drawText(new Position(5,27),top , "#E23C52");
        gui.drawText(new Position(55,27), top, "#E23C52");
        gui.drawText(new Position(55,5), top, "#E23C52");

        top="";
        for(int i = 0; i<49; i++){
            top+=(char)140;
        }
        gui.drawText(new Position(6,5), top, "#E23C52");

        top="";
        for(int i = 0; i<49; i++){
            top+=(char)141;
        }
        gui.drawText(new Position(6,27), top, "#E23C52");

        top = "";
        top += (char)142;
        for(int i = 0; i<21; i++){
            gui.drawText(new Position(5,i+6), top, "#E23C52");

        }
        top = "";
        top += (char)143;
        for(int i = 0; i<21; i++){
            gui.drawText(new Position(55,i+6), top, "#E23C52");

        }
    }
}
