package totest;

import org.game.rpg_elements.Inimigos.Monster;
import org.game.rpg_elements.Inimigos.Variantes.Slime_Variante;
import org.game.rpg_elements.status.Drop;
import org.game.rpg_elements.status.LoaderDrop;
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
        this.vida = 40;
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
