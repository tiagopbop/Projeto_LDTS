package totest;

import org.game.model.dialogue.Dialogue;
import org.game.model.game.elements.Hero;
import org.game.rpg_elements.itens.Equipamento;
import org.game.rpg_elements.itens.Item;
import org.game.rpg_elements.itens.LoaderItem;
import org.game.rpg_elements.itens.inventario.Equipado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TesteAtualizarEquipamento {
    private Item capacete;
    private Item peitoral;
    private Item calcas;
    private Item capacete_impossivel;
    private Hero hero;
    private Equipado equipado;

    private int vida_atualizado;

    @BeforeEach
    public void Helper() throws IOException {
        capacete = new LoaderItem().renderEquipamento("1");
        peitoral = new LoaderItem().renderEquipamento("2");
        calcas = new LoaderItem().renderEquipamento("3");

        capacete_impossivel = new LoaderItem().renderEquipamento("4");

        hero = new Hero();
        equipado = new Equipado(capacete, peitoral, calcas);
        vida_atualizado = 40;
    }
    @Test
    public void TesteAtualizarEquipamento(){
        hero.getStatus().atualizar_equipado(equipado);
        Assertions.assertEquals(vida_atualizado, hero.getStatus().getVida_atual());
        Assertions.assertTrue(hero.getStatus().pode_usar_equipamento(capacete));
        Assertions.assertFalse(hero.getStatus().pode_usar_equipamento(capacete_impossivel));
    }
}
