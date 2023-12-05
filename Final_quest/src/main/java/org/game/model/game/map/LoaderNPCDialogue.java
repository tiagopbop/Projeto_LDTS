package org.game.model.game.map;

import org.game.model.dialogue.Dialogue;

import java.util.ArrayList;
import java.util.List;

public class LoaderNPCDialogue {
    public List<Dialogue> createDialogue()
    {
        Dialogue dialogue1 = new Dialogue("Hello brave hero, I'M cummer");
        Dialogue dialogue2 = new Dialogue("I HATE N");

        List<Dialogue> res = new ArrayList<>();
        res.add(dialogue1);
        res.add(dialogue2);
        return res;
    }
}
