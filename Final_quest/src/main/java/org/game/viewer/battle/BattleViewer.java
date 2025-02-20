package org.game.viewer.battle;

import org.game.Game;
import org.game.gui.GUI;
import org.game.model.Position;
import org.game.model.battle.menus.BattleMenu;
import org.game.viewer.Viewer;

import java.io.IOException;




public class BattleViewer extends Viewer<BattleMenu> {
        public BattleViewer(BattleMenu menu) {
            super(menu);
        }

        @Override
        public void drawElements(GUI gui) throws IOException {

            drawCombatZone(gui);
            drawStatus_hero(gui);
            drawStatus_monster(gui);


            gui.drawText(
                    new Position(27, 23 ),
                    getModel().getEntry(0),
                    getModel().isSelectedMelee() ? "#FFD700" : "#FFFFFF");

            gui.drawText(
                    new Position(44, 23 ),
                    getModel().getEntry(1),
                    getModel().isSelectedMagic() ? "#FFD700" : "#FFFFFF");

            gui.drawText(
                    new Position(25, 27 ),
                    getModel().getEntry(2),
                    getModel().isSelectedConsume() ? "#FFD700" : "#FFFFFF");

            gui.drawText(
                    new Position(45 , 27 ),
                    getModel().getEntry(3),
                    getModel().isSelectedRun() ? "#FFD700" : "#FFFFFF");
            if(getModel().isSelectedRun() && getModel().getFloor()==3)
            {
                gui.drawText(new Position(1, 5), "YOU CANNOT ESCAPE!", "#FFFFFF");

            }

        }

        private void drawStatus_hero(GUI gui){
            String vida_texto = "heal: " + String.valueOf(getModel().getHero().getStatus().getVida_atual())
                    + "/" + String.valueOf(getModel().getHero().getStatus().getAtributos_atualizados().getVida());

            String mana_texto = "mana: " + String.valueOf(getModel().getHero().getStatus().getMana_atual())
                    + "/" + String.valueOf(getModel().getHero().getStatus().getAtributos_atualizados().getMana());

            gui.drawText(
                    new Position(3 , 26 ),
                    getModel().getHero().getStatus().getNome(),
                    "#FFFFFF");

            gui.drawText(
                    new Position(3 , 28 ),
                    vida_texto,
                    "#FFFFFF");

            gui.drawText(
                    new Position(3 , 29),
                    mana_texto,
                    "#FFFFFF");

        }

        private void drawStatus_monster(GUI gui) throws IOException {
            String vida_texto = "heal: " + getModel().getBattle().getMonster().getStatus().getVida_atual()
                    + "/" + getModel().getBattle().getMonster().getStatus().getAtributos_atualizados().getVida();

            String mana_texto = "mana: " + getModel().getBattle().getMonster().getStatus().getMana_atual()
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
            gui.drawText(new Position(20,20),top , "#BF40BF");
            gui.drawText(new Position(20,30),top , "#BF40BF");
            gui.drawText(new Position(56,30), top, "#BF40BF");
            gui.drawText(new Position(56,20), top, "#BF40BF");

            //rosa
            top="";
            for(int i = 0; i<35; i++){
                top+=(char)140;
            }
            gui.drawText(new Position(21,20), top, "#BF40BF");

            top="";
            for(int i = 0; i<35; i++){
                top+=(char)141;
            }
            gui.drawText(new Position(21,30), top, "#BF40BF");

            top = "";
            top += (char)142;
            for(int i = 0; i<9; i++){
                gui.drawText(new Position(20,i+21), top, "#BF40BF");

            }
            top = "";
            top += (char)143;
            for(int i = 0; i<9; i++){
                gui.drawText(new Position(56,i+21), top, "#BF40BF");

            }
            //azul
            top="";
            for(int i = 0; i<16; i++){
                top+=(char)140;
            }
            gui.drawText(new Position(2,25), top, "#0000B3");

            top="";
            for(int i = 0; i<16; i++){
                top+=(char)141;
            }
            gui.drawText(new Position(2,30), top, "#0000B3");

            top = "";
            top += (char)142;
            for(int i = 0; i<6; i++){
                gui.drawText(new Position(18,i+25), top, "#0000B3");

            }
            top = "";
            top += (char)143;
            for(int i = 0; i<6; i++){
                gui.drawText(new Position(1,i+25), top, "#0000B3");

            }


            //branco
            top="";
            for(int i = 0; i<14; i++){
                top+=(char)140;
            }
            gui.drawText(new Position(3,14), top, "#FFFFFF");

            top="";
            for(int i = 0; i<14; i++){
                top+=(char)141;
            }
            gui.drawText(new Position(3,23), top, "#FFFFFF");

            top = "";
            top += (char)142;
            for(int i = 0; i<10; i++){
                gui.drawText(new Position(17,i+14), top, "#FFFFFF");

            }
            top = "";
            top += (char)143;
            for(int i = 0; i<10; i++){
                gui.drawText(new Position(2,i+14), top, "#FFFFFF");

            }

            //monster
            top="";
            for(int i = 0; i<20; i++){
                top+=(char)140;
            }
            gui.drawText(new Position(20,2), top, "#FFFFFF");

            top="";
            for(int i = 0; i<20; i++){
                top+=(char)141;
            }
            gui.drawText(new Position(20,17), top, "#FFFFFF");

            top = "";
            top += (char)142;
            for(int i = 0; i<16; i++){
                gui.drawText(new Position(40,i+2), top, "#FFFFFF");

            }
            top = "";
            top += (char)143;
            for(int i = 0; i<16; i++){
                gui.drawText(new Position(20,i+2), top, "#FFFFFF");

            }


            //monster status
            top="";
            for(int i = 0; i<16; i++){
                top+=(char)140;
            }
            gui.drawText(new Position(42,2), top, "#0000B3");

            top="";
            for(int i = 0; i<16; i++){
                top+=(char)141;
            }
            gui.drawText(new Position(42,7), top, "#0000B3");

            top = "";
            top += (char)142;
            for(int i = 0; i<6; i++){
                gui.drawText(new Position(58,i+2), top, "#0000B3");

            }
            top = "";
            top += (char)143;
            for(int i = 0; i<6; i++){
                gui.drawText(new Position(42,i+2), top, "#0000B3");

            }


        }
}


