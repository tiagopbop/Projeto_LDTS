package totest;

import org.game.rpg_elements.LoaderStatus;
import org.game.rpg_elements.Status;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TesteLoaderStatus {
    private int vida;
    private int mana;
    private int forca;
    private int inteligencia;
    private int velocidade;

    private String nome;
    private String origem;
    private int dano;
    private float acerto;

    private int custo;

    @BeforeEach
    public void Helper(){
        this.vida = 20;
        this.mana = 10;
        this.forca = 5;
        this.inteligencia = 0;
        this.velocidade = 15;

        nome = "Slash";
        origem = "fisico";
        dano = 6;
        acerto = 0.80F;
        custo = 0;
    }

    @Test
    public void TesteLoaderStatus() throws IOException {
        Status teste = new LoaderStatus().createStatus("hero");

        Assertions.assertEquals(vida, teste.getAtributos().getVida());
        Assertions.assertEquals(mana, teste.getAtributos().getMana());
        Assertions.assertEquals(forca, teste.getAtributos().getForca());
        Assertions.assertEquals(inteligencia, teste.getAtributos().getInteligencia());
        Assertions.assertEquals(velocidade, teste.getAtributos().getVelocidade());

        Assertions.assertEquals(nome, teste.getAtaques().get(0).getNome());
        Assertions.assertEquals(origem, teste.getAtaques().get(0).getOrigem());
        Assertions.assertEquals(dano, teste.getAtaques().get(0).getDano());
        Assertions.assertEquals(acerto, teste.getAtaques().get(0).getAcerto());
        Assertions.assertEquals(custo, teste.getAtaques().get(0).getCusto());
    }
}
