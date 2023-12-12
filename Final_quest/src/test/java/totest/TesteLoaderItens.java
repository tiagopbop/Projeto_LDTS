package totest;

import org.game.rpg_elements.itens.LoaderItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.game.rpg_elements.itens.Item;

import java.io.IOException;

public class TesteLoaderItens {
    private String nome_1;
    private String type_1;
    private String atributo_1;
    private int value_1;

    private String nome_2;
    private String type_2;
    private String atributo_2;
    private int value_2;

    private String atributo_3;
    private int value_3;

    private String atr;

    private int val;

    @BeforeEach
    public void Helper(){
        nome_1 = "Pocao Pequena Geral";
        type_1 = "pocao cura";
        atributo_1 = "vida";
        value_1 = 20;
        atributo_2 = "mana";
        value_2 = 20;

        nome_2 = "Capacete Básico";
        type_2 = "capacete";
        atributo_3 = "vida";
        value_3 = 5;
        atr = "level";
        val = 1;
    }

    @Test
    public void TesteLoaderItens() throws IOException {
        Item test_1 = new LoaderItem().renderConsumivel("7");

        Assertions.assertEquals(nome_1, test_1.getNome());
        Assertions.assertEquals(type_1, test_1.getType());
        Assertions.assertEquals(value_1, test_1.getEfeitos().get(atributo_1));
        Assertions.assertEquals(value_2, test_1.getEfeitos().get(atributo_2));

        Item test_2 = new LoaderItem().renderEquipamento("1");

        Assertions.assertEquals(nome_2, test_2.getNome());
        Assertions.assertEquals(type_2, test_2.getType());
        Assertions.assertEquals(value_3, test_2.getEfeitos().get(atributo_3));
        Assertions.assertEquals(val, test_2.getRequirements().get(atr));
    }

}
