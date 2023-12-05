package org.game.model.game.map;

import org.game.model.Dialogue.Dialogue;
import org.game.model.Dialogue.new_Dialogue;
import org.game.rpg_elements.status.Loader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoaderDialogo extends Loader {
    public List<new_Dialogue> createListDialogue(String filename) throws IOException {
        String file_path = "/dialogos/" + filename;
        List<String> lines = Loader(file_path);

        List<new_Dialogue> res = new ArrayList<new_Dialogue>();

        int pos = 1;
        new_Dialogue dialogue = new new_Dialogue();

        while(pos < lines.size()){
            pos = create_newDialogue(lines, dialogue, pos);
            res.add(dialogue);
            dialogue = new new_Dialogue();
        }

        return res;
    }

    private int create_newDialogue(List<String> lines, new_Dialogue dialogue, int pos){
        dialogue.setTitle(lines.get(pos));
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
