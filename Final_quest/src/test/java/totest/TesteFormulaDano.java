package totest;

import org.game.rpg_elements.status.Atributos;
import org.game.rpg_elements.status.ataque.Ataque;
import org.game.rpg_elements.status.ataque.Formula_Dano;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TesteFormulaDano {
    private Atributos caster;

    @BeforeEach
    public void Helper() throws IOException {
        this.caster = new Atributos(5, 30, 20, 10, 15, 35);
    }

    @Test
    public void TesteDanoFisico(){
        Ataque ataque = new Ataque("t", "fisico", 10, 90, 0);

        Integer dano = 20;
        Formula_Dano formulaDano = new Formula_Dano();

        Integer teste = formulaDano.Dano(ataque, caster, 10);

        if(teste == 0){
            Assertions.assertEquals(0, teste);
        }
        else{
            Assertions.assertEquals(dano, teste);
        }

    }

    @Test
    public void TesteDanoMagico(){
        Ataque ataque = new Ataque("t", "magico", 10, 90, 0);

        Integer dano = 25;
        Formula_Dano formulaDano = new Formula_Dano();

        Integer teste = formulaDano.Dano(ataque, caster, 10);

        if(teste == 0){
            Assertions.assertEquals(0, teste);
        }
        else{
            Assertions.assertEquals(dano, teste);
        }

    }
}
