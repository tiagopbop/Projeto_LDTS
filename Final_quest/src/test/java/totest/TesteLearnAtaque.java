package totest;

import org.game.model.dialogue.Dialogue;
import org.game.model.game.elements.Hero;
import org.game.rpg_elements.status.ataque.Ataque;
import org.game.rpg_elements.status.ataque.LoaderAtaque;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TesteLearnAtaque {
    private Ataque ataque_1;
    private Ataque ataque_2;
    private Hero hero;

    @BeforeEach
    public void Helper() throws IOException {
        this.ataque_1 = new LoaderAtaque().createAtaque("4");
        this.ataque_2 = new LoaderAtaque().createAtaque("3");

        this.hero = new Hero(0,0, new Dialogue(), "hero");
    }

    @Test
    public void TesteLwarnAtaque(){
        Assertions.assertTrue(hero.getStatus().getAtributos_real().learn_ataque(ataque_1));
        Assertions.assertFalse(hero.getStatus().getAtributos_real().learn_ataque(ataque_2));

    }
}
