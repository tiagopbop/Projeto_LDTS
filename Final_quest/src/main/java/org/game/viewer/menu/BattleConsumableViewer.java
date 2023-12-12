package org.game.viewer.menu;

import org.game.gui.GUI;
import org.game.model.Position;
import org.game.model.game.battle.BattleConsumableMenu;
import org.game.model.game.battle.MeleeMenu;
import org.game.viewer.Viewer;

import java.io.IOException;

public class BattleConsumableViewer extends Viewer<BattleConsumableMenu> {
    public BattleConsumableViewer(BattleConsumableMenu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) throws IOException {
        int page = (getModel().getPage());
        drawCombatZone(gui);
        drawStatus_hero(gui);
        drawStatus_monster(gui);

        gui.drawText(new Position(22, 8),"CONSUMABLES" , "#FFFFFF");
        int tamanho = getModel().getHero().getHero_inventario().getConsumiveis().size();
        if(tamanho >8 && page == 1)
        {
            gui.drawText(new Position(45, 29),"Page(1/2)", "#FFFFFF");

        } else if (tamanho >8 && page == 2) {
            gui.drawText(new Position(45, 29),"Page(2/2)", "#FFFFFF");

        }

        if(tamanho<=8)
        for (int i = 0; i < tamanho; i++){
            gui.drawText(
                    new Position(23, 13 + 2*i),
                    getModel().getEntryi(i).getNome().toLowerCase(),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");

            String pepe = "X";
            pepe += String.valueOf(getModel().getHero().getHero_inventario().getConsumiveis().get(getModel().getEntryi(i)));
            gui.drawText(new Position(50, 13 + 2*i),pepe , "#FFFFFF");

        }
        else  {
            if(page==1) {
                for (int i = 0; i < 8; i++) {
                    gui.drawText(
                            new Position(23, 13 + 2 * i),
                            getModel().getEntryi(i).getNome().toLowerCase(),
                            getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");

                    String pepe = "X";
                    pepe += String.valueOf(getModel().getHero().getHero_inventario().getConsumiveis().get(getModel().getEntryi(i)));
                    gui.drawText(new Position(50, 13 + 2*i),pepe , "#FFFFFF");
                }
            }
            else {
                for (int i = 0; i < tamanho-8; i++) {
                    gui.drawText(
                            new Position(23, 13 + 2*i),
                            getModel().getEntryi(i+8).getNome().toLowerCase(),
                            getModel().isSelected(i+8) ? "#FFD700" : "#FFFFFF");

                    String pepe = "X";
                    pepe += String.valueOf(getModel().getHero().getHero_inventario().getConsumiveis().get(getModel().getEntryi(i+8)));
                    gui.drawText(new Position(50, 13 + 2*i),pepe , "#FFFFFF");
            }
        }}
    }

    private void drawStatus_hero(GUI gui){
        String vida_texto = "Vida: " + String.valueOf(getModel().getHero().getStatus().getVida_atual())
                + "/" + String.valueOf(getModel().getHero().getStatus().getAtributos_atualizados().getVida());

        String mana_texto = "Mana: " + String.valueOf(getModel().getHero().getStatus().getMana_atual())
                + "/" + String.valueOf(getModel().getHero().getStatus().getAtributos_atualizados().getMana());

        gui.drawText(
                new Position(5 , 26 ),
                getModel().getHero().getStatus().getNome(),
                "#FFFFFF");

        gui.drawText(
                new Position(5 , 28 ),
                vida_texto,
                "#FFFFFF");

        gui.drawText(
                new Position(5 , 29),
                mana_texto,
                "#FFFFFF");

    }

    private void drawStatus_monster(GUI gui) throws IOException {
        String vida_texto = "Vida: " + getModel().getBattle().getMonster().getStatus().getVida_atual()
                + "/" + getModel().getBattle().getMonster().getStatus().getAtributos_atualizados().getVida();

        String mana_texto = "Mana: " + getModel().getBattle().getMonster().getStatus().getMana_atual()
                + "/" + getModel().getBattle().getMonster().getStatus().getAtributos_atualizados().getMana();

        gui.drawText(
                new Position(44 , 3 ),
                getModel().getBattle().getMonster().getStatus().getNome(),
                "#FFFFFF");

        gui.drawText(
                new Position(44 , 5 ),
                vida_texto,
                "#FFFFFF");

        gui.drawText(
                new Position(44 , 6 ),
                mana_texto,
                "#FFFFFF");
    }


    private void drawCombatZone(GUI gui) throws IOException {
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

        top ="";
        top += (char)130;
        gui.drawText(new Position(20,10),top , "#BF40BF");
        gui.drawText(new Position(20,30),top , "#BF40BF");
        gui.drawText(new Position(56,30), top, "#BF40BF");
        gui.drawText(new Position(56,10), top, "#BF40BF");

        //rosa
        top="";
        for(int i = 0; i<35; i++){
            top+=(char)140;
        }
        gui.drawText(new Position(21,10), top, "#BF40BF");

        top="";
        for(int i = 0; i<35; i++){
            top+=(char)141;
        }
        gui.drawText(new Position(21,30), top, "#BF40BF");

        top = "";
        top += (char)142;
        for(int i = 0; i<19; i++){
            gui.drawText(new Position(20,i+11), top, "#BF40BF");

        }
        top = "";
        top += (char)143;
        for(int i = 0; i<19; i++){
            gui.drawText(new Position(56,i+11), top, "#BF40BF");

        }





        //azul
        top="";
        for(int i = 0; i<13; i++){
            top+=(char)140;
        }
        gui.drawText(new Position(4,25), top, "#0000B3");

        top="";
        for(int i = 0; i<13; i++){
            top+=(char)141;
        }
        gui.drawText(new Position(4,30), top, "#0000B3");

        top = "";
        top += (char)142;
        for(int i = 0; i<6; i++){
            gui.drawText(new Position(17,i+25), top, "#0000B3");

        }
        top = "";
        top += (char)143;
        for(int i = 0; i<6; i++){
            gui.drawText(new Position(3,i+25), top, "#0000B3");

        }


        //branco
        top="";
        for(int i = 0; i<13; i++){
            top+=(char)140;
        }
        gui.drawText(new Position(4,14), top, "#FFFFFF");

        top="";
        for(int i = 0; i<13; i++){
            top+=(char)141;
        }
        gui.drawText(new Position(4,23), top, "#FFFFFF");

        top = "";
        top += (char)142;
        for(int i = 0; i<10; i++){
            gui.drawText(new Position(17,i+14), top, "#FFFFFF");

        }
        top = "";
        top += (char)143;
        for(int i = 0; i<10; i++){
            gui.drawText(new Position(3,i+14), top, "#FFFFFF");

        }








        //monster status
        top="";
        for(int i = 0; i<13; i++){
            top+=(char)140;
        }
        gui.drawText(new Position(42,2), top, "#0000B3");

        top="";
        for(int i = 0; i<13; i++){
            top+=(char)141;
        }
        gui.drawText(new Position(42,7), top, "#0000B3");

        top = "";
        top += (char)142;
        for(int i = 0; i<6; i++){
            gui.drawText(new Position(55,i+2), top, "#0000B3");

        }
        top = "";
        top += (char)143;
        for(int i = 0; i<6; i++){
            gui.drawText(new Position(42,i+2), top, "#0000B3");

        }
        gui.drawText(new Position(2, 5), "Press 'b' to back", "#FFFFFF");


    }
}

