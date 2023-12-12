package totest;

import org.game.model.dialogue.Dialogue;
import org.game.model.game.elements.Hero;
import org.game.rpg_elements.FactoryRPGElements;
import org.game.rpg_elements.Inimigos.Monster;
import org.game.rpg_elements.itens.Item;
import org.game.rpg_elements.itens.LoaderItem;
import org.game.rpg_elements.status.ataque.Ataque;
import org.game.rpg_elements.status.ataque.Formula_Dano;
import org.game.rpg_elements.status.ataque.LoaderAtaque;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.management.monitor.Monitor;
import java.io.IOException;

public class TesteDano {
    private Hero hero;
    private Ataque ataque;
    private Monster m;
    private Integer dano;

    private Integer vida_atual;

    private Item pocao;

    private Item bomba;

    private Integer vida_pos_bomba;

    private Integer apos_ataque;

    private Integer vida_atual_2;

    public TesteDano() throws IOException {
    }


    @BeforeEach
    public void Helper() throws IOException {
        this.hero = new Hero();
        this.m = new Monster("1");
        this.ataque = new LoaderAtaque().renderAtaque("1");
        this.dano = 1006;
        this.vida_atual = hero.getStatus().getVida_atual();
        this.pocao = new LoaderItem().renderConsumivel("1");
        this.bomba = new LoaderItem().renderConsumivel("16");
        this.vida_pos_bomba = -966;
        this.apos_ataque = -976;
        this.vida_atual_2 = -956;
    }

    @Test
    public void TesteDano(){
        int teste_1 = new Formula_Dano().Dano(ataque, hero.getStatus().getAtributos_atualizados(), m.getStatus().getAtributos_atualizados().getVelocidade());
        if(teste_1 == 0){
            Assertions.assertEquals(0,teste_1);
        }
        else{
            Assertions.assertEquals(dano,teste_1);
        }
    }

    @Test
    public void testePerderVida(){
        hero.getStatus().dano_recebido(dano);
        Assertions.assertEquals(apos_ataque, hero.getStatus().getVida_atual());

        hero.getStatus().usar_item(pocao);
        Assertions.assertEquals(vida_atual_2, hero.getStatus().getVida_atual());

        hero.getStatus().usar_item(bomba);
        Assertions.assertEquals(vida_pos_bomba, hero.getStatus().getVida_atual());
    }


}
