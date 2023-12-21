package totest;

import org.game.rpg_rules.itens.Item;
import org.game.rpg_rules.itens.inventario.Equipado;
import org.game.rpg_rules.status.Atributos;
import org.game.rpg_rules.status.Status;
import org.game.rpg_rules.status.ataque.Ataque;
import org.game.rpg_rules.status.ataque.LoaderAtaque;
import org.game.rpg_rules.status.statusCommands.Add_Experiencia;
import org.game.rpg_rules.status.statusCommands.Atualizar_Equipado;
import org.game.rpg_rules.status.statusCommands.Usar_Item;
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

    //commands tests

    @Test
    public void TesteAddExperiencia() throws IOException {
        Status teste = new Status(atributos_real, ataques, nome, str);
        Integer experiencia  = 120;

        Add_Experiencia addExperiencia = new Add_Experiencia(teste, experiencia);
        addExperiencia.execute();

        Assertions.assertEquals(experiencia, teste.getExperiencia());
        Assertions.assertFalse(addExperiencia.getRes());

        addExperiencia = new Add_Experiencia(teste, experiencia);
        addExperiencia.execute();

        experiencia = 40;

        Assertions.assertEquals(experiencia, teste.getExperiencia());
        Assertions.assertTrue(addExperiencia.getRes());

    }

    @Test
    public void TesteUsarPocaoCura() throws IOException {
        Status teste = new Status(atributos_real, ataques, nome, str);

        String nome = "1";
        String tipo = "pocao cura";

        Map<String, Integer> efeitos = new HashMap<>();
        efeitos.put("vida", 5);
        efeitos.put("mana", 5);

        Integer vida = 20;
        Integer mana = 10;

        teste.setVida_atual(20);
        teste.setMana_atual(10);

        Assertions.assertEquals(vida, teste.getVida_atual());
        Assertions.assertEquals(mana, teste.getMana_atual());

        vida = 25;
        mana = 15;

        Item item = new Item(nome, tipo, efeitos);
        Usar_Item usarItem = new Usar_Item(teste, item);
        usarItem.execute();

        Assertions.assertEquals(vida, teste.getVida_atual());
        Assertions.assertEquals(mana, teste.getMana_atual());

        vida = 30;
        mana = 20;
        usarItem.execute();

        Assertions.assertEquals(vida, teste.getVida_atual());
        Assertions.assertEquals(mana, teste.getMana_atual());

        usarItem.execute();

        Assertions.assertEquals(vida, teste.getVida_atual());
        Assertions.assertEquals(mana, teste.getMana_atual());
    }

    @Test
    public void TesteUsar_pocao_efeito() throws IOException {
        Status teste = new Status(atributos_real, ataques, nome, str);

        String nome = "1";
        String tipo = "pocao efeito";

        Map<String, Integer> efeitos = new HashMap<>();

        efeitos.put("vida", 5);
        efeitos.put("mana", 5);
        efeitos.put("forca", 5);
        efeitos.put("inteligencia", 5);
        efeitos.put("velocidade", 5);

        Item item = new Item(nome, tipo, efeitos);

        Integer vida = 30;
        Integer mana = 20;
        Integer forca = 10;
        Integer inteligencia = 15;
        Integer velocidade = 35;

        Usar_Item usarItem = new Usar_Item(teste, item);
        usarItem.execute();

        Assertions.assertEquals(vida, teste.getAtributos_real().getVida());
        Assertions.assertEquals(mana, teste.getAtributos_real().getMana());
        Assertions.assertEquals(forca, teste.getAtributos_real().getForca());
        Assertions.assertEquals(inteligencia, teste.getAtributos_real().getInteligencia());
        Assertions.assertEquals(velocidade, teste.getAtributos_real().getVelocidade());

        vida = 35;
        mana = 25;
        forca = 15;
        inteligencia = 20;
        velocidade = 40;

        Assertions.assertEquals(vida, teste.getAtributos_atualizados().getVida());
        Assertions.assertEquals(mana, teste.getAtributos_atualizados().getMana());
        Assertions.assertEquals(forca, teste.getAtributos_atualizados().getForca());
        Assertions.assertEquals(inteligencia, teste.getAtributos_atualizados().getInteligencia());
        Assertions.assertEquals(velocidade, teste.getAtributos_atualizados().getVelocidade());

    }

    @Test
    public void TestarUsar_essencio() throws IOException {
        Status teste = new Status(atributos_real, ataques, nome, str);

        String nome = "1";
        String tipo = "essencio";

        Map<String, Integer> efeitos = new HashMap<>();

        efeitos.put("vida", 5);
        efeitos.put("mana", 5);
        efeitos.put("forca", 5);
        efeitos.put("inteligencia", 5);
        efeitos.put("velocidade", 5);

        Item item = new Item(nome, tipo, efeitos);

        Integer vida = 30;
        Integer mana = 20;
        Integer forca = 10;
        Integer inteligencia = 15;
        Integer velocidade = 35;

        Usar_Item usarItem = new Usar_Item(teste, item);
        usarItem.execute();

        Assertions.assertEquals(vida, teste.getAtributos_real().getVida());
        Assertions.assertEquals(mana, teste.getAtributos_real().getMana());
        Assertions.assertEquals(forca, teste.getAtributos_real().getForca());
        Assertions.assertEquals(inteligencia, teste.getAtributos_real().getInteligencia());
        Assertions.assertEquals(velocidade, teste.getAtributos_real().getVelocidade());

        vida = 25;
        mana = 15;
        forca = 5;
        inteligencia = 10;
        velocidade = 30;

        Assertions.assertEquals(vida, teste.getAtributos_atualizados().getVida());
        Assertions.assertEquals(mana, teste.getAtributos_atualizados().getMana());
        Assertions.assertEquals(forca, teste.getAtributos_atualizados().getForca());
        Assertions.assertEquals(inteligencia, teste.getAtributos_atualizados().getInteligencia());
        Assertions.assertEquals(velocidade, teste.getAtributos_atualizados().getVelocidade());
    }

    @Test
    public void TesteUsar_bomba() throws IOException {
        Status teste = new Status(atributos_real, ataques, nome, str);

        String nome = "1";
        String tipo = "bomba";

        Map<String, Integer> efeitos = new HashMap<>();
        efeitos.put("vida", 5);
        efeitos.put("mana", 5);

        Integer vida = 10;
        Integer mana = 10;

        teste.setVida_atual(10);
        teste.setMana_atual(10);

        Assertions.assertEquals(vida, teste.getVida_atual());
        Assertions.assertEquals(mana, teste.getMana_atual());

        vida = 5;
        mana = 5;

        Item item = new Item(nome, tipo, efeitos);
        Usar_Item usarItem = new Usar_Item(teste, item);
        usarItem.execute();

        Assertions.assertEquals(vida, teste.getVida_atual());
        Assertions.assertEquals(mana, teste.getMana_atual());

        vida = 0;
        mana = 0;
        usarItem.execute();

        Assertions.assertEquals(vida, teste.getVida_atual());
        Assertions.assertEquals(mana, teste.getMana_atual());

        usarItem.execute();

        Assertions.assertEquals(vida, teste.getVida_atual());
        Assertions.assertEquals(mana, teste.getMana_atual());
    }

    @Test
    public void TesteAtualizarEquipado() throws IOException {
        Status teste = new Status(atributos_real, ataques, nome, str);

        Map<String, Integer> efeitos = new HashMap<>();
        efeitos.put("vida", 5);
        efeitos.put("mana", 5);
        efeitos.put("forca", 5);
        efeitos.put("inteligencia", 5);
        efeitos.put("velocidade", 5);

        Integer vida = 30;
        Integer mana = 20;
        Integer forca = 10;
        Integer inteligencia = 15;
        Integer velocidade = 35;

        Map<String, Integer> requesitos = new HashMap<>();
        requesitos.put("level", 5);

        Item capacete = new Item("Capacete Básico", "capacete", efeitos, requesitos);
        Item peitoral = new Item("Capacete Básico", "capacete", efeitos, requesitos);
        Item calcas = new Item("Capacete Básico", "capacete", efeitos, requesitos);

        Equipado equipado = new Equipado(capacete, peitoral, calcas);
        Atualizar_Equipado atualizarEquipado = new Atualizar_Equipado(teste,  equipado, true);
        atualizarEquipado.execute();

        Assertions.assertEquals(vida, teste.getAtributos_real().getVida());
        Assertions.assertEquals(mana, teste.getAtributos_real().getMana());
        Assertions.assertEquals(forca, teste.getAtributos_real().getForca());
        Assertions.assertEquals(inteligencia, teste.getAtributos_real().getInteligencia());
        Assertions.assertEquals(velocidade, teste.getAtributos_real().getVelocidade());

        vida = 45;
        mana = 35;
        forca = 25;
        inteligencia = 30;
        velocidade = 50;

        Assertions.assertEquals(vida, teste.getAtributos_atualizados().getVida());
        Assertions.assertEquals(mana, teste.getAtributos_atualizados().getMana());
        Assertions.assertEquals(forca, teste.getAtributos_atualizados().getForca());
        Assertions.assertEquals(inteligencia, teste.getAtributos_atualizados().getInteligencia());
        Assertions.assertEquals(velocidade, teste.getAtributos_atualizados().getVelocidade());

        Assertions.assertEquals(vida, teste.getVida_atual());
        Assertions.assertEquals(mana, teste.getMana_atual());
    }

}
