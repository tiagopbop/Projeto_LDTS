package totest;

import org.game.rpg_elements.Ataque;
import org.game.rpg_elements.LoaderAtaques;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TesteLoaderAtaques {
    private String nome;
    private String origem;
    private int dano;
    private float acerto;
    @BeforeEach
    public void Helper(){
        nome = "Slash";
        origem = "fisico";
        dano = 6;
        acerto = 0.80F;
    }
    @Test
    public void TesteLoaderAtaques() throws IOException {
        Ataque test = new LoaderAtaques().LoaderAtaques("slash");
        Assertions.assertEquals(nome, test.getNome());
        Assertions.assertEquals(origem, test.getOrigem());
        Assertions.assertEquals(dano, test.getDano());
        Assertions.assertEquals(acerto, test.getAcerto());
    }
}
