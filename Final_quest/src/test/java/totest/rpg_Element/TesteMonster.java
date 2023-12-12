package totest.rpg_Element;

import org.game.rpg_elements.Inimigos.Monster;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TesteMonster {
    private int level;
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
        this.level = 3;
        this.vida = 15;
        this.mana = 8;
        this.forca = 2;
        this.inteligencia = 0;
        this.velocidade = 10;

        nome_1 = "Tackle";
        origem_1 = "fisico";
        dano_1 = 3;
        acerto_1 = 90;
        custo_1 = 0;

        nome_2 = "Fizz";
        origem_2 = "magico";
        dano_2 = 10;
        acerto_2 = 80;
        custo_2 = 5;
    }

    @Test
    public void TesteMonster() throws IOException {
        Monster teste = new Monster("2");

        Assertions.assertEquals(level, teste.getStatus().getAtributos_atualizados().getLevel());
        Assertions.assertEquals(vida, teste.getStatus().getAtributos_atualizados().getVida());
        Assertions.assertEquals(mana, teste.getStatus().getAtributos_atualizados().getMana());
        Assertions.assertEquals(forca, teste.getStatus().getAtributos_atualizados().getForca());
        Assertions.assertEquals(inteligencia, teste.getStatus().getAtributos_atualizados().getInteligencia());
        Assertions.assertEquals(velocidade, teste.getStatus().getAtributos_atualizados().getVelocidade());

        Assertions.assertEquals(nome_1, teste.getStatus().getAtaques().get(0).getNome());
        Assertions.assertEquals(origem_1, teste.getStatus().getAtaques().get(0).getOrigem());
        Assertions.assertEquals(dano_1, teste.getStatus().getAtaques().get(0).getDano());
        Assertions.assertEquals(acerto_1, teste.getStatus().getAtaques().get(0).getAcerto());
        Assertions.assertEquals(custo_1, teste.getStatus().getAtaques().get(0).getCusto());
        Assertions.assertEquals(origem_1, teste.getStatus().getAtaques_fisicos().get(0).getOrigem());

        Assertions.assertEquals(nome_2, teste.getStatus().getAtaques().get(1).getNome());
        Assertions.assertEquals(origem_2, teste.getStatus().getAtaques().get(1).getOrigem());
        Assertions.assertEquals(dano_2, teste.getStatus().getAtaques().get(1).getDano());
        Assertions.assertEquals(acerto_2, teste.getStatus().getAtaques().get(1).getAcerto());
        Assertions.assertEquals(custo_2, teste.getStatus().getAtaques().get(1).getCusto());
        Assertions.assertEquals(origem_2, teste.getStatus().getAtaques_magicos().get(0).getOrigem());
    }
}
