package totest;

import org.game.rpg_elements.FactoryRPGElements;
import org.game.rpg_elements.status.ataque.Ataque;
import org.game.rpg_elements.status.ataque.LoaderAtaque;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TesteLoaderAtaques {
    private String nome;
    private String origem;
    private int dano;
    private float acerto;
    private int custo;
    private String atr_1;
    private Integer val_1;
    private String atr_2;
    private Integer val_2;
    @BeforeEach
    public void Helper(){
        nome = "Slash";
        origem = "fisico";
        dano = 6;
        acerto = 80;
        custo = 0;
        atr_1 = "level";
        val_1 = 1;
        atr_2 = "forca";
        val_2 = 10;
    }
    @Test
    public void TesteLoaderAtaques() throws IOException {
        FactoryRPGElements factoryRPGElements = new LoaderAtaque();
        Ataque test = factoryRPGElements.renderAtaque("1");

        Assertions.assertEquals(nome, test.getNome());
        Assertions.assertEquals(origem, test.getOrigem());
        Assertions.assertEquals(dano, test.getDano());
        Assertions.assertEquals(acerto, test.getAcerto());
        Assertions.assertEquals(custo, test.getCusto());

        Assertions.assertEquals(val_1, test.getRequesitos().get(atr_1));
        Assertions.assertEquals(val_2, test.getRequesitos().get(atr_2));
    }
}
