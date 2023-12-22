package org.game;

import org.game.rpg_rules.Inimigos.Monster;
import org.game.rpg_rules.Inimigos.strategy.AgressiveStrategy;
import org.game.rpg_rules.Inimigos.strategy.NormalStrategy;
import org.game.rpg_rules.Inimigos.strategy.PassiveStrategy;
import org.game.rpg_rules.status.Atributos;
import org.game.rpg_rules.status.Status;
import org.game.rpg_rules.status.ataque.Ataque;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TesteStrategy {
    private List<Ataque> ataques;
    private Ataque ataque1;
    private Ataque ataque2;
    private Ataque ataque3;
    private Ataque ataque4;
    private Ataque ataque5;
    private Ataque ataque6;
    private Status status_1;
    private Status status_2;

    @BeforeEach
    public void Helper(){
        Integer level = 3;
        Integer vida = 20;
        Integer mana = 10;
        Integer forca = 10;
        Integer inteligencia = 0;
        Integer velocidade = 7;

        Atributos atributos = new Atributos(level, vida, mana, forca, inteligencia, velocidade);

        this.ataque1 = new Ataque("1", "fisico", 10, 100, 0);
        this.ataque2 = new Ataque("2", "fisico", 20, 100, 0);
        this.ataque3 = new Ataque("3", "fisico", 5, 100, 0);

        this.ataque4 = new Ataque("4", "magico", 10, 100, 0);
        this.ataque5 = new Ataque("5", "magico", 20, 100, 0);
        this.ataque6 = new Ataque("6", "magico", 5, 100, 0);

        this.ataques = Arrays.asList(ataque1, ataque2, ataque3, ataque4, ataque5, ataque6);
        this.status_1 = new Status(atributos ,ataques, "t", "n");

        inteligencia = 30;
        atributos = new Atributos(level, vida, mana, forca, inteligencia, velocidade);

        this.status_2 = new Status(atributos ,ataques, "t", "n");
    }

    @Test
    public void TesteNormalStrategy(){
        Monster teste = new Monster(status_1);

        NormalStrategy normalStrategy = new NormalStrategy();
        Ataque ataque = normalStrategy.execute(teste);

        for(Ataque t : ataques){
            if(ataque.getNome().equals(t.getNome())){
                Assertions.assertEquals(ataque.getNome(), t.getNome());
            }
        }

        teste = new Monster(status_2);
        ataque = normalStrategy.execute(teste);

        for(Ataque t : ataques){
            if(ataque.getNome().equals(t.getNome())){
                Assertions.assertEquals(ataque.getNome(), t.getNome());
            }
        }

    }

    @Test
    public void TestePassiveStrategy() throws IOException {
        Monster teste = new Monster(status_1);

        PassiveStrategy passiveStrategy = new PassiveStrategy();
        Ataque ataque = passiveStrategy.execute(teste);

        Assertions.assertEquals(ataque6.getNome(), ataque.getNome());

        teste = new Monster(status_2);
        ataque = passiveStrategy.execute(teste);

        Assertions.assertEquals(ataque3.getNome(), ataque.getNome());
    }

    @Test
    public void TesteAgressiveStrategy() throws IOException {
        Monster teste = new Monster(status_1);

        AgressiveStrategy agressiveStrategy = new AgressiveStrategy();
        Ataque ataque = agressiveStrategy.execute(teste);

        Assertions.assertEquals(ataque2.getNome(), ataque.getNome());

        teste = new Monster(status_2);
        ataque = agressiveStrategy.execute(teste);

        Assertions.assertEquals(ataque5.getNome(), ataque.getNome());
    }
}
