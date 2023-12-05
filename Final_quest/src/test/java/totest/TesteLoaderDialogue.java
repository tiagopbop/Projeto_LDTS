package totest;

import org.game.model.dialogue.Dialogue;
import org.game.model.game.map.LoaderDialogo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class TesteLoaderDialogue {
    private String title_1;
    private String title_2;
    private String text_1;
    private String text_2;

    @BeforeEach
    public void Helper(){
        this.title_1 = "NPC 1";
        this.title_2 = "NPC 2";
        this.text_1 = "Pokemon Go";
        this.text_2 = "Lindo meu menino";
    }


    @Test
    public void TesteLoaderDialogue() throws IOException {
        List<Dialogue> teste = new LoaderDialogo().createListDialogue("npc");

        Assertions.assertEquals(title_1, teste.get(0).getTitle());
        Assertions.assertEquals(text_1, teste.get(0).getTexto().get(0));

        Assertions.assertEquals(title_2, teste.get(1).getTitle());
        Assertions.assertEquals(text_2, teste.get(1).getTexto().get(0));
    }
}
