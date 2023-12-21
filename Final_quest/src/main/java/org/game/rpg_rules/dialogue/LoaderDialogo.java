package org.game.rpg_rules.dialogue;

import org.game.rpg_rules.FactoryRPGElements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoaderDialogo extends FactoryRPGElements<List<Dialogue>> {

    @Override
    public List<Dialogue> createRPGelement(List<String> lines) throws IOException{
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

        if(lines.get(pos).equals("1")){
            dialogue.setMen(1);
        }else if(lines.get(pos).equals("2")){
            dialogue.setMen(2);
        }
        else {
            dialogue.setMen(0);
        }
        pos++;

        List<String> text = new ArrayList<String>();
        List<List<String>> all_text = new ArrayList<>();

        while(!lines.get(pos).equals("#")){
            while(!lines.get(pos).equals("?")){
                text.add(lines.get(pos));
                pos++;
            }

            all_text.add(text);
            text = new ArrayList<>();

            pos++;
        }

        dialogue.setAll_texto(all_text);
        dialogue.setTexto(all_text.get(0));

        return pos + 1;
    }
}
