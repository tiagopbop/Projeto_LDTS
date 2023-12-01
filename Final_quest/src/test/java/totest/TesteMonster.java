package totest;

import org.game.rpg_elements.Inimigos.Monstro;
import org.game.rpg_elements.LoaderStatus;
import org.game.rpg_elements.Status;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TesteMonster {
    private int vida;
    private int mana;
    private int forca;
    private int inteligencia;
    private int velocidade;

    private String nome_1;
    private String origem_1;
    private int dano_1;
    private float acerto_1;

    private int custo_1;

    private String nome_2;
    private String origem_2;
    private int dano_2;
    private float acerto_2;

    private int custo_2;

    @BeforeEach
    public void Helper(){
        this.vida = 15;
        this.mana = 8;
        this.forca = 2;
        this.inteligencia = 0;
        this.velocidade = 10;

        nome_1 = "Tackle";
        origem_1 = "fisico";
        dano_1 = 3;
        acerto_1 = 0.90F;
        custo_1 = 0;

        nome_2 = "Sleep";
        origem_2 = "elementar";
        dano_2 = 0;
        acerto_2 = 1F;
        custo_2 = 0;
    }

    @Test
    public void TesteMonster() throws IOException {
        Monstro teste = new Monstro("slime");

        Assertions.assertEquals(vida, teste.getStatus().getAtributos().getVida());
        Assertions.assertEquals(mana, teste.getStatus().getAtributos().getMana());
        Assertions.assertEquals(forca, teste.getStatus().getAtributos().getForca());
        Assertions.assertEquals(inteligencia, teste.getStatus().getAtributos().getInteligencia());
        Assertions.assertEquals(velocidade, teste.getStatus().getAtributos().getVelocidade());

        Assertions.assertEquals(nome_1, teste.getStatus().getAtaques().get(0).getNome());
        Assertions.assertEquals(origem_1, teste.getStatus().getAtaques().get(0).getOrigem());
        Assertions.assertEquals(dano_1, teste.getStatus().getAtaques().get(0).getDano());
        Assertions.assertEquals(acerto_1, teste.getStatus().getAtaques().get(0).getAcerto());
        Assertions.assertEquals(custo_1, teste.getStatus().getAtaques().get(0).getCusto());

        Assertions.assertEquals(nome_2, teste.getStatus().getAtaques().get(1).getNome());
        Assertions.assertEquals(origem_2, teste.getStatus().getAtaques().get(1).getOrigem());
        Assertions.assertEquals(dano_2, teste.getStatus().getAtaques().get(1).getDano());
        Assertions.assertEquals(acerto_2, teste.getStatus().getAtaques().get(1).getAcerto());
        Assertions.assertEquals(custo_2, teste.getStatus().getAtaques().get(1).getCusto());
    }
}
