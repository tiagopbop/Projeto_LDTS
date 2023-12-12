package org.game.viewer.menu;

import org.game.gui.GUI;
import org.game.model.Position;
import org.game.model.menu.Selection;
import org.game.viewer.Viewer;

import java.io.IOException;

public class SelectionViewer extends Viewer<Selection> {
    public SelectionViewer(Selection model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) throws IOException {
        if(getModel().getPlate()==4)
        {
            drawMelee(gui);
            gui.drawText(new Position(31, 5), "Melee Atacks", "#FFBF00");

            for (int i = 0; i < getModel().getNumberEntries(); i++) {
                gui.drawText(
                        new Position(32, 7 + 2*i),
                        getModel().getEntry(i),
                        getModel().isSelected(i) ? "#0000B3" : "#FFFFFF");
            }
        }


        else if(getModel().getPlate()==5){
            gui.drawText(new Position(31, 5), "Magic Atacks", "#800080");
            drawMagic(gui);
            for (int i = 0; i < getModel().getNumberEntries(); i++) {
                gui.drawText(
                        new Position(32, 7 + 2*i),
                        getModel().getEntry(i),
                        getModel().isSelected(i) ? "#0000B3" : "#FFFFFF");
            }

        }

        else
        {
            drawInventory(gui);
            gui.drawText(new Position(37, 5), "Items", "#008000");
            gui.drawText(new Position(50, 5), "Amount", "#008000");
            drawStats(gui);
        }

        gui.drawText(new Position(40, 30), "Press 'b' to back", "#FFFFFF");
        gui.drawText(
                new Position(8 , 2 ),
                getModel().getHero().getStatus().getNome(),
                "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++){
            gui.drawText(
                    new Position(32, 7 + 2*i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#0000B3" : "#FFFFFF");
            if(getModel().getPlate()<4)
            {
                String a = "x";
                a+= Integer.toString(getModel().getQuantidade(i));
                gui.drawText(
                        new Position(52, 7 + 2*i), a,"#FFFFFF");
            }


    }
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



        String mana_texto = "mana: " + String.valueOf(getModel().getHero().getStatus().getMana_atual())
                + "/" + String.valueOf(getModel().getHero().getStatus().getAtributos_atualizados().getMana());

        String lvl = "LVL: " + String.valueOf(getModel().getHero().getStatus().getAtributos_real().getLevel());

        String forca = "stren: " + String.valueOf(getModel().getHero().getStatus().getAtributos_real().getForca());
        String inteligencia = "intel: " + String.valueOf(getModel().getHero().getStatus().getAtributos_real().getInteligencia());
        String velocidade = "speed: " + String.valueOf(getModel().getHero().getStatus().getAtributos_real().getVelocidade());


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
                new Position(5 , 17),
                xp_texto,
                "#FFFFFF");

        gui.drawText(
                new Position(5 , 16 ),
                lvl,
                "#FFFFFF");
    }

    public void drawMelee(GUI gui) throws IOException {
        //verde
        String top = new String("");
        top += (char) 130;
        gui.drawText(new Position(0, 0), top, "#FFBF00");
        gui.drawText(new Position(0, 32), top, "#FFBF00");
        gui.drawText(new Position(60, 32), top, "#FFBF00");
        gui.drawText(new Position(60, 0), top, "#FFBF00");



        top = "";
        for (int i = 0; i < 59; i++) {
            top += (char) 140;
        }
        gui.drawText(new Position(1, 0), top, "#FFBF00");

        top = "";
        for (int i = 0; i < 59; i++) {
            top += (char) 141;
        }
        gui.drawText(new Position(1, 32), top, "#FFBF00");

        top = "";
        top += (char) 142;
        for (int i = 0; i < 31; i++) {
            gui.drawText(new Position(0, i + 1), top, "#FFBF00");

        }
        top = "";
        top += (char) 143;
        for (int i = 0; i < 31; i++) {
            gui.drawText(new Position(60, i + 1), top, "#FFBF00");

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


        top = new String("");
        top += (char)130;
        gui.drawText(new Position(20,0),top , "#FFBF00");
        gui.drawText(new Position(20,32),top , "#FFBF00");
        top = "";
        top += (char)143;
        for(int i = 0; i<31; i++){
            gui.drawText(new Position(20,i+1), top, "#FFBF00");

        }
    }
    public void drawMagic(GUI gui) throws IOException {
        //verde
        String top = new String("");
        top += (char) 130;
        gui.drawText(new Position(0, 0), top, "#800080");
        gui.drawText(new Position(0, 32), top, "#800080");
        gui.drawText(new Position(60, 32), top, "#800080");
        gui.drawText(new Position(60, 0), top, "#800080");


        top = "";
        for (int i = 0; i < 59; i++) {
            top += (char) 140;
        }
        gui.drawText(new Position(1, 0), top, "#800080");

        top = "";
        for (int i = 0; i < 59; i++) {
            top += (char) 141;
        }
        gui.drawText(new Position(1, 32), top, "#800080");

        top = "";
        top += (char) 142;
        for (int i = 0; i < 31; i++) {
            gui.drawText(new Position(0, i + 1), top, "#800080");

        }
        top = "";
        top += (char) 143;
        for (int i = 0; i < 31; i++) {
            gui.drawText(new Position(60, i + 1), top, "#800080");

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

        top = new String("");
        top += (char)130;
        gui.drawText(new Position(20,0),top , "#800080");
        gui.drawText(new Position(20,32),top , "#800080");
        top = "";
        top += (char)143;
        for(int i = 0; i<31; i++){
            gui.drawText(new Position(20,i+1), top, "#800080");

        }
    }

}
