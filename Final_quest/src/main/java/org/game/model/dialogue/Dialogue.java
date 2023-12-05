package org.game.model.dialogue;

import java.util.ArrayList;
import java.util.List;

public class Dialogue {
    private String title;
    private List<String> texto;
    private  boolean men;
    private int pos;
    private boolean flag;

    public Dialogue(){
        this.title = "";
        this.men = false;
        this.pos = 0;
        this.flag = false;

    }

    public Dialogue(String title){
        this.title = title;
        this.men = false;
        this.pos = 0;
        this.flag= false;
    }


    public Dialogue(Dialogue dialogue){
        this.title = dialogue.getTitle();
        this.men = false;
        this.pos = 0;
        this.flag = false;
    }

    public Dialogue(String title, List<String> texto){
        this.title = title;
        this.texto = texto;
        this.men = false;
        this.pos = 0;
        this.flag = true;
    }

    public void add_pos(){
        this.pos++;
    }

    public  boolean has_line()
    {

         if(!flag)
        {
            return false;
        }
        else if(pos>=texto.size())
        {
            return  false;
        }
        return  true;
    }

    public void reset_pos()
    {
        pos = 0;
    }

    public List<String> getTexto() {
        return texto;
    }

    public String getTitle() {
        return title;
    }


    public boolean getMen() {
        return this.men;
    }


    public void setTexto(List<String> texto) {
        this.texto = texto;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
