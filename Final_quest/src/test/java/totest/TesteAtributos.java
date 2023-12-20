package totest;

import org.game.rpg_elements.status.Atributos;
import org.game.rpg_elements.status.ataque.Ataque;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class TesteAtributos {
    private Integer level;
    private Integer vida;
    private Integer mana;
    private Integer forca;
    private Integer inteligencia;
    private Integer velocidade;

    @BeforeEach
    public void helper(){
        this.level = 5;
        this.vida = 30;
        this.mana = 20;
        this.forca = 10;
        this.inteligencia = 15;
        this.velocidade = 35;
    }

    @Test
    public void TesteAtributosConstructor(){
        Integer level_up = 200;
        Atributos teste = new Atributos(level, vida, mana, forca, inteligencia, velocidade);

        Assertions.assertEquals(level, teste.getLevel());
        Assertions.assertEquals(vida, teste.getVida());
        Assertions.assertEquals(mana, teste.getMana());
        Assertions.assertEquals(forca, teste.getForca());
        Assertions.assertEquals(inteligencia, teste.getInteligencia());
        Assertions.assertEquals(velocidade, teste.getVelocidade());
        Assertions.assertEquals(level_up, teste.exp_level_up());

        Atributos atributos = new Atributos(level, vida, mana, forca, inteligencia, velocidade);
        teste = new Atributos(atributos);

        Assertions.assertEquals(level, teste.getLevel());
        Assertions.assertEquals(vida, teste.getVida());
        Assertions.assertEquals(mana, teste.getMana());
        Assertions.assertEquals(forca, teste.getForca());
        Assertions.assertEquals(inteligencia, teste.getInteligencia());
        Assertions.assertEquals(velocidade, teste.getVelocidade());
        Assertions.assertEquals(level_up, teste.exp_level_up());
    }

    @Test
    public void TesteChangeAtributos(){
        Atributos teste = new Atributos(level, vida, mana, forca, inteligencia, velocidade);

        Integer level = 6;
        Integer vida = 40;
        Integer mana = 30;
        Integer forca = 20;
        Integer inteligencia = 25;
        Integer velocidade = 45;

        teste.add_level(1);
        teste.add_vida(10);
        teste.add_mana(10);
        teste.add_forca(10);
        teste.add_inteligencia(10);
        teste.add_velocidade(10);

        Assertions.assertEquals(level, teste.getLevel());
        Assertions.assertEquals(vida, teste.getVida());
        Assertions.assertEquals(mana, teste.getMana());
        Assertions.assertEquals(forca, teste.getForca());
        Assertions.assertEquals(inteligencia, teste.getInteligencia());
        Assertions.assertEquals(velocidade, teste.getVelocidade());

        vida = 20;
        mana = 10;
        forca = 0;
        inteligencia = 5;
        velocidade = 25;

        teste.remove_vida(20);
        teste.remove_mana(20);
        teste.remove_forca(20);
        teste.remove_inteligencia(20);
        teste.remove_velocidade(20);

        Assertions.assertEquals(vida, teste.getVida());
        Assertions.assertEquals(mana, teste.getMana());
        Assertions.assertEquals(forca, teste.getForca());
        Assertions.assertEquals(inteligencia, teste.getInteligencia());
        Assertions.assertEquals(velocidade, teste.getVelocidade());

    }

    @Test
    public void TesteLearnAtaque(){
        Atributos atributos = new Atributos(level, vida, mana, forca, inteligencia, velocidade);

        String nome = "Slash";
        String origem = "fisico";
        Integer dano = 6;
        Integer acerto = 80;
        Integer custo = 0;

        Map<String, Integer> requesitos = new HashMap<>();
        requesitos.put("level", 1);
        requesitos.put("vida", 10);
        requesitos.put("mana", 10);
        requesitos.put("forca", 10);
        requesitos.put("inteligencia", 10);
        requesitos.put("velocidade", 10);

        Ataque ataque = new Ataque(nome, origem, dano, acerto, custo, requesitos);

        Assertions.assertTrue(atributos.learn_ataque(ataque));

        requesitos.clear();
        requesitos.put("level", 10);

        ataque = new Ataque(nome, origem, dano, acerto, custo, requesitos);
        Assertions.assertFalse(atributos.learn_ataque(ataque));
    }

}
