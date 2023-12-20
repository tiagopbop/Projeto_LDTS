package org.game.rpg_elements.dialogue;

import java.util.List;

public class Dialogue {
    private String title;
    private List<List<String>> all_texto;
    private int dialogo_atual;
    private boolean fim;
    private List<String> texto;
    private  Integer men;
    private int pos;
    private boolean flag;

    public Dialogue(){
        this.title = "";
        this.men = 0;
        this.pos = 0;
        this.flag = false;
    }

    public Dialogue(String title){
        this.title = title;
        this.men = 0;
        this.pos = 0;
        this.flag= false;
        this.fim = false;
    }


    public Dialogue(Dialogue dialogue){
        this.title = dialogue.getTitle();
        this.texto = dialogue.getTexto();
        this.all_texto = dialogue.getAll_texto();
        this.dialogo_atual = dialogue.getDialogo_atual();
        this.men = dialogue.getMen();
        this.pos = 0;
        this.fim = false;
        if(dialogue.flag){
            this.flag = true;
        }
        else{
            this.flag = false;
        }

    }

    public Dialogue(String title, List<List<String>> all_texto){
        this.title = title;
        this.all_texto = all_texto;

        this.dialogo_atual = 0;
        this.texto = all_texto.get(dialogo_atual);

        this.men = 0;
        this.pos = 0;
        this.flag = true;
        this.fim = false;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setMen(Integer men) {
        this.men = men;
    }

    public void add_pos(){
        this.pos++;
    }

    public  boolean has_line() {
         if(!flag) {
            return false;
        }
        else if(pos >= texto.size()) {
            return  false;
        }
        else{
             return  true;
         }
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
    public Integer getMen() {
        return this.men;
    }
    public void setTexto(List<String> texto) {
        this.texto = texto;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getDialogo_atual() {
        return dialogo_atual;
    }
    public List<List<String>> getAll_texto() {
        return all_texto;
    }
    public void setDialogo_atual(int dialogo_atual) {
        this.dialogo_atual = dialogo_atual;
    }
    public void next_dialogo(){
        dialogo_atual++;
        if(dialogo_atual >= all_texto.size()){
            dialogo_atual = 0;
        }
        else if(dialogo_atual + 1 >= all_texto.size()){
            fim = true;
        }
        texto = all_texto.get(dialogo_atual);

    }

    public boolean getFim(){
        return this.fim;
    }

    public void setFim(boolean fim) {
        this.fim = fim;
    }

    public void setAll_texto(List<List<String>> all_texto) {
        this.all_texto = all_texto;
    }
}
