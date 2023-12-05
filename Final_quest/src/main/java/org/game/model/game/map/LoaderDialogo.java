package org.game.model.game.map;

import org.game.model.dialogue.Dialogue;
import org.game.rpg_elements.status.Loader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoaderDialogo extends Loader {
    public List<Dialogue> createListDialogue(String filename) throws IOException {
        String file_path = "/dialogos/" + filename;
        List<String> lines = Loader(file_path);

        List<Dialogue> res = new ArrayList<Dialogue>();

        int pos = 1;
        Dialogue dialogue = new Dialogue();

        while(pos < lines.size()){
            pos = create_newDialogue(lines, dialogue, pos);
            res.add(dialogue);
            dialogue = new Dialogue();
        }

        return res;
    }

    private int create_newDialogue(List<String> lines, Dialogue dialogue, int pos){
        dialogue.setTitle(lines.get(pos));
        dialogue.setFlag(true);
        pos++;
        List<String> text = new ArrayList<String>();

        while(!lines.get(pos).equals("#")){
            text.add(lines.get(pos));
            pos++;
        }

        dialogue.setTexto(text);
        return pos + 1;
    }
}
