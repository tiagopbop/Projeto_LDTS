package org.game.viewer.inventory;

import org.game.gui.GUI;
import org.game.model.Position;
import org.game.model.battle.menus.Receive;
import org.game.rpg_rules.status.ataque.Ataque;
import org.game.rpg_rules.status.ataque.Learn_Ataque;
import org.game.viewer.Viewer;

import java.io.IOException;
import java.util.List;

public class ReceiveViewer extends Viewer<Receive> {
    private String novo_ataque;
    private boolean toDraw = false;
    public ReceiveViewer(Receive model) {
        super(model);


        List<Ataque> ataques = null;
        try {
            ataques = new Learn_Ataque().aprender(getModel().getHero().getStatus().getAtributos_real(), getModel().getHero().getStatus().getAtaques());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(!ataques.isEmpty())
        {
            for(Ataque ataque: ataques)
            {
                getModel().getHero().getStatus().add_ataque(ataque);
            }
             novo_ataque = ataques.get(0).getNome();
             toDraw= true;
        }


    }

    @Override
    protected void drawElements(GUI gui) throws IOException {

           if(toDraw) gui.drawText(new Position(20,29), "You learned " + novo_ataque, "#FFFFFF");



        gui.drawText(
                new Position(29, 20), "ok","#0000B3");
        int plate = getModel().getPlate();
        switch (plate){
            case 0:
                drawChestOpen(gui);
                break;
            case 1:
                drawBattleWon(gui);
                break;
        }
    }

    public void drawChestOpen(GUI gui) throws IOException
    {
    //    if(getModel().getContent())
        {
            String p = "you have received a: " + String.valueOf(getModel().getHero().getStatus().getVida_atual());
        }
      //  else
        {
            String p = "you have received nothing...";
        }

        //gui.drawText(new Position(30, 10), p,"#0000B3");

    }

    public void drawBattleWon(GUI gui) throws IOException
    {
        String victory = "you have won the battle!";
        String rec = "you received:";
        String gold = "+" + String.valueOf(getModel().getDinheiro()) + " gold";
        String xp = "+" + String.valueOf(getModel().getXp()) + " xp";

        // String item = ->alguma coisa que vai buscar o item que acabo de receber
        String lvlup = "you have leveled up!" ; //nao implementado ainda

        gui.drawText(
                new Position(19, 4), victory,"#FFFFFF");
        gui.drawText(
                new Position(24, 6), rec,"#FFFFFF");
        gui.drawText(
                new Position(25, 11), gold,"#FFFFFF");
        gui.drawText(
                new Position(25, 12), xp,"#FFFFFF");





        //verde
        String top = new String("");
        top += (char)130;
        gui.drawText(new Position(17,0),top , "#FFBF00");
        gui.drawText(new Position(17,32),top , "#FFBF00");
        gui.drawText(new Position(43,32), top, "#FFBF00");
        gui.drawText(new Position(43,0), top, "#FFBF00");

        top="";
        for(int i = 0; i<25; i++){
            top+=(char)140;
        }
        gui.drawText(new Position(18,0), top, "#FFBF00");

        top="";
        for(int i = 0; i<25; i++){
            top+=(char)141;
        }
        gui.drawText(new Position(18,32), top, "#FFBF00");





        top = "";
        top += (char)142;
        for(int i = 0; i<31; i++){
            gui.drawText(new Position(17,i+1), top, "#FFBF00");

        }
        top = "";
        top += (char)143;
        for(int i = 0; i<31; i++){
            gui.drawText(new Position(43,i+1), top, "#FFBF00");

        }


        top = "";
        top += (char)142;
        for(int i = 0; i<33; i++){
            gui.drawText(new Position(12,i), top, "#FF5733");

        }
        top = "";
        top += (char)143;
        for(int i = 0; i<33; i++){
            gui.drawText(new Position(48,i), top, "#FF5733");

        }



        top = "";
        top += (char)142;
        for(int i = 0; i<31; i++){
            gui.drawText(new Position(7,i+1), top, "#C70039");

        }
        top = "";
        top += (char)143;
        for(int i = 0; i<31; i++){
            gui.drawText(new Position(53,i+1), top, "#C70039");

        }



        top = "";
        top += (char)142;
        for(int i = 0; i<29; i++){
            gui.drawText(new Position(2,i+2), top, "#900C3F");

        }

        top = "";
        top += (char)143;
        for(int i = 0; i<29; i++){
            gui.drawText(new Position(58,i+2), top, "#900C3F");

        }


    }

}
