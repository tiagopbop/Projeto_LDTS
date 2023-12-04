package org.game.model.game.map;

import org.game.model.Dialogue.Dialogue;

import java.util.ArrayList;
import java.util.List;

public class LoaderSignDialogue {
    public List<Dialogue> createDialogue()
    {
        Dialogue dialogue1 = new Dialogue("Welcome to the bar");
        Dialogue dialogue2 = new Dialogue("KAWASAKI,CAGO, KRIKO, ESTRIPPER");

        List<Dialogue> res = new ArrayList<>();
        res.add(dialogue1);
        res.add(dialogue2);
        return res;
    }

}
