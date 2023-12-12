package totest.rpg_Element;

import org.game.rpg_elements.Inimigos.Monster;
import org.game.rpg_elements.Inimigos.variantes.Slime_Variante;
import org.game.rpg_elements.Inimigos.drop.Drop;
import org.game.rpg_elements.Inimigos.drop.LoaderDrop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TesteDecorator {
    private Integer vida;
    private String name;
    private Integer xp;

    @BeforeEach
    public void Helper(){
        this.vida = 35;
        this.name = "MegaSlime";
        this.xp = 50;
    }

    @Test
    public void TesteDecorator() throws IOException {
        Monster slime = new Monster("2");
        Slime_Variante teste = new Slime_Variante(slime);
        teste.Assembler();

        Assertions.assertEquals(vida, slime.getStatus().getAtributos_real().getVida());
        Assertions.assertEquals(name, slime.getStatus().getNome());

        Drop drop_teste = new LoaderDrop().renderDrop(slime.getStatus().getNome());

        Assertions.assertEquals(xp, drop_teste.getExperiencia());

    }
}
