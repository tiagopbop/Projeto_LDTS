package totest;

import org.game.rpg_elements.itens.Item;
import org.game.rpg_elements.status.Atributos;
import org.game.rpg_elements.status.Status;
import org.game.rpg_elements.status.ataque.Ataque;
import org.game.rpg_elements.status.ataque.LoaderAtaque;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TesteStatus {
    private Atributos atributos_real;
    private List<Ataque> ataques;
    private String nome;
    private String str;

    @BeforeEach
    public void Helper() throws IOException {
        this.atributos_real = new Atributos(5, 30, 20, 10, 15, 35);

        this.ataques = new ArrayList<>();

        Ataque ataque = new LoaderAtaque().renderAtaque("1");
        ataques.add(ataque);

        ataque = new LoaderAtaque().renderAtaque("3") ;
        ataques.add(ataque);

        ataque = new LoaderAtaque().renderAtaque("4") ;
        ataques.add(ataque);

        this.nome = "hero";

        this.str = "p";

    }

    @Test
    public void TesteStatusCinstructor() throws IOException {
        Status teste = new Status(atributos_real, ataques, nome, str);

        Integer at_num = 3;
        Integer f_num = 2;
        Integer mg_num = 1;

        Integer exp = 0;
        String str_t = "p";

        Ataque ataque_1 = new LoaderAtaque().renderAtaque("1");
        Ataque ataque_2 = new LoaderAtaque().renderAtaque("3");
        Ataque ataque_3 = new LoaderAtaque().renderAtaque("4");

        Assertions.assertEquals(nome, teste.getNome());
        Assertions.assertEquals(exp, teste.getExperiencia());
        Assertions.assertEquals(str_t, teste.getStrg());

        Assertions.assertEquals(atributos_real.getLevel(), teste.getAtributos_real().getLevel());
        Assertions.assertEquals(atributos_real.getVida(), teste.getAtributos_real().getVida());
        Assertions.assertEquals(atributos_real.getMana(), teste.getAtributos_real().getMana());
        Assertions.assertEquals(atributos_real.getForca(), teste.getAtributos_real().getForca());
        Assertions.assertEquals(atributos_real.getInteligencia(), teste.getAtributos_real().getInteligencia());
        Assertions.assertEquals(atributos_real.getVelocidade(), teste.getAtributos_real().getVelocidade());

        Assertions.assertEquals(atributos_real.getLevel(), teste.getAtributos_atualizados().getLevel());
        Assertions.assertEquals(atributos_real.getVida(), teste.getAtributos_atualizados().getVida());
        Assertions.assertEquals(atributos_real.getMana(), teste.getAtributos_atualizados().getMana());
        Assertions.assertEquals(atributos_real.getForca(), teste.getAtributos_atualizados().getForca());
        Assertions.assertEquals(atributos_real.getInteligencia(), teste.getAtributos_atualizados().getInteligencia());
        Assertions.assertEquals(atributos_real.getVelocidade(), teste.getAtributos_atualizados().getVelocidade());

        Assertions.assertEquals(at_num, teste.getAtaques().size());
        Assertions.assertEquals(f_num, teste.getAtaques_fisicos().size());
        Assertions.assertEquals(mg_num, teste.getAtaques_magicos().size());

        Assertions.assertEquals(ataque_1.getNome(), teste.getAtaques_fisicos().get(0).getNome());
        Assertions.assertEquals(ataque_2.getNome(), teste.getAtaques_fisicos().get(1).getNome());
        Assertions.assertEquals(ataque_3.getNome(), teste.getAtaques_magicos().get(0).getNome());

        Assertions.assertEquals(atributos_real.getVida(), teste.getVida_atual());
        Assertions.assertEquals(atributos_real.getMana(), teste.getMana_atual());

    }

    @Test
    public void TesteUsarEquipamento(){
        Status teste = new Status(atributos_real, ataques, nome, str);

        String nome = "Capacete Básico";
        String tipo = "capacete";

        Map<String, Integer> efeitos = new HashMap<>();
        efeitos.put("vida", 5);

        Map<String, Integer> requesitos = new HashMap<>();
        requesitos.put("level", 5);
        requesitos.put("vida", 10);
        requesitos.put("mana", 10);
        requesitos.put("forca", 10);
        requesitos.put("inteligencia", 10);
        requesitos.put("velocidade", 10);

        Item item = new Item(nome, tipo, efeitos, requesitos);

        Assertions.assertTrue(teste.pode_usar_equipamento(item));

        requesitos.clear();
        requesitos.put("level", 10);

        item = new Item(nome, tipo, efeitos, requesitos);
        Assertions.assertFalse(teste.pode_usar_equipamento(item));

    }

    @Test
    public void TesteReset(){
        Status teste = new Status(atributos_real, ataques, nome, str);

        Integer vida = 30;
        Integer mana = 20;

        Assertions.assertEquals(vida, teste.getVida_atual());
        Assertions.assertEquals(mana, teste.getMana_atual());

        Atributos atributos = new Atributos(5, 50, 40, 10, 15, 35);
        teste.setAtributos_atualizados(atributos);

        vida = 50;
        mana = 40;

        teste.reset_status();

        Assertions.assertEquals(vida, teste.getVida_atual());
        Assertions.assertEquals(mana, teste.getMana_atual());

    }
}
