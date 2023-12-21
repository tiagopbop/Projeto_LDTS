package totest;

import org.game.rpg_rules.Inimigos.Monster;
import org.game.rpg_rules.Inimigos.strategy.AgressiveStrategy;
import org.game.rpg_rules.Inimigos.strategy.NormalStrategy;
import org.game.rpg_rules.Inimigos.strategy.Strategy;
import org.game.rpg_rules.Inimigos.variantes.Dracky_Variante;
import org.game.rpg_rules.Inimigos.variantes.Skeleton_Variante;
import org.game.rpg_rules.Inimigos.variantes.Slime_Variante;
import org.game.rpg_rules.Inimigos.variantes.Spider_Variante;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class TesteDecorator {

    @Test
    public void TesteDracky_Variante() throws IOException {
        Strategy strategyMock = Mockito.mock(AgressiveStrategy.class);

        Monster monster = new Monster("1");

        String nome = "MegaDracky";
        Integer vida = 40;

        Dracky_Variante teste = new Dracky_Variante(monster, strategyMock);
        teste.Assembler();

        Assertions.assertEquals(nome, teste.getStatus().getNome());
        Assertions.assertEquals(vida, teste.getStatus().getAtributos_real().getVida());
    }

    @Test
    public void TesteSlime_Variante() throws IOException {
        Strategy strategyMock = Mockito.mock(NormalStrategy.class);

        Monster monster = new Monster("2");

        String nome = "MegaSlime";
        Integer vida = 35;

        Slime_Variante teste = new Slime_Variante(monster, strategyMock);
        teste.Assembler();

        Assertions.assertEquals(nome, teste.getStatus().getNome());
        Assertions.assertEquals(vida, teste.getStatus().getAtributos_real().getVida());
    }

    @Test
    public void TesteSkeleton_Variante() throws IOException {
        Strategy strategyMock = Mockito.mock(AgressiveStrategy.class);

        Monster monster = new Monster("3");

        String nome = "MegaSkeleton";
        Integer vida = 50;

        Skeleton_Variante teste = new Skeleton_Variante(monster, strategyMock);
        teste.Assembler();

        Assertions.assertEquals(nome, teste.getStatus().getNome());
        Assertions.assertEquals(vida, teste.getStatus().getAtributos_real().getVida());
    }

    @Test
    public void TesteSpider_Variante() throws IOException {
        Strategy strategyMock = Mockito.mock(AgressiveStrategy.class);

        Monster monster = new Monster("4");

        String nome = "MegaSpider";
        Integer vida = 45;

        Spider_Variante teste = new Spider_Variante(monster, strategyMock);
        teste.Assembler();

        Assertions.assertEquals(nome, teste.getStatus().getNome());
        Assertions.assertEquals(vida, teste.getStatus().getAtributos_real().getVida());
    }
}
