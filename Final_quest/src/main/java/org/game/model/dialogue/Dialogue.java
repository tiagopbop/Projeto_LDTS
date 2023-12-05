package org.game.model.dialogue;

import java.util.ArrayList;
import java.util.List;

public class Dialogue {
    private String title;
    private List<String> texto;

    public Dialogue(){
        List<String> t = new ArrayList<>();
        t.add("The hero stared into the void");
        this.title = "";
        this.texto = t;
    }

    public Dialogue(String title, List<String> texto){
        this.title = title;
        this.texto = texto;
    }

    public List<String> getTexto() {
        return texto;
    }

    public String getTitle() {
        return title;
    }

    public void setTexto(List<String> texto) {
        this.texto = texto;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
