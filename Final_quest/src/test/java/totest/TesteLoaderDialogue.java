package totest;

import org.game.model.dialogue.Dialogue;
import org.game.model.dialogue.LoaderDialogo;
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

    private boolean men;

    @BeforeEach
    public void Helper(){
        this.title_1 = "NPC 1";
        this.title_2 = "NPC 2";
        this.text_1 = "ola caro aventureiro!";
        this.text_2 = "Lindo meu menino";
        this.men = true;
    }


    @Test
    public void TesteLoaderDialogue() throws IOException {
        List<Dialogue> teste = new LoaderDialogo().renderDialogue("npc");

        Assertions.assertEquals(title_1, teste.get(0).getTitle());
        Assertions.assertEquals(text_1, teste.get(0).getTexto().get(0));

        Assertions.assertEquals(title_2, teste.get(1).getTitle());
        Assertions.assertEquals(text_2, teste.get(1).getTexto().get(0));
        Assertions.assertEquals(men, teste.get(0).getMen());
    }
}
