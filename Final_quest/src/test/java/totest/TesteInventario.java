package totest;

import org.game.rpg_elements.Inimigos.drop.Drop;
import org.game.rpg_elements.itens.Item;
import org.game.rpg_elements.itens.LoaderItem;
import org.game.rpg_elements.itens.inventario.Equipado;
import org.game.rpg_elements.itens.inventario.Inventario;
import org.game.rpg_elements.itens.inventario.inventario_commands.InventarioAddDinheiro;
import org.game.rpg_elements.itens.inventario.inventario_commands.InventarioDropItens;
import org.game.rpg_elements.itens.inventario.inventario_commands.InventarioSwapArmor;
import org.game.rpg_elements.itens.inventario.inventario_commands.itens.InventarioAddConsumiveis;
import org.game.rpg_elements.itens.inventario.inventario_commands.itens.InventarioAddEquipamento;
import org.game.rpg_elements.itens.inventario.inventario_commands.itens.InventarioRemoveConsumivel;
import org.game.rpg_elements.itens.inventario.inventario_commands.itens.InventarioRemoveEquipamento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;

public class TesteInventario {
    private Map<Item, Integer> inventario;
    private Map<Item, Integer> equipamentos;
    private Map<Item, Integer> consumiveis;
    private Equipado equipado;
    private Integer dinheiro;

    @BeforeEach
    public void Helper() throws IOException {
        Item item_1 = new LoaderItem().renderConsumivel("1");
        Item item_2 = new LoaderItem().renderConsumivel("2");
        Item item_3 = new LoaderItem().renderConsumivel("3");

        Item item_4 = new LoaderItem().renderEquipamento("1");
        Item item_5 = new LoaderItem().renderEquipamento("2");
        Item item_6 = new LoaderItem().renderEquipamento("3");

        Map<Item, Integer> inv = new HashMap<>();

        inv.put(item_1, 5);
        inv.put(item_2, 10);
        inv.put(item_3, 15);
        inv.put(item_4, 1);
        inv.put(item_5, 2);

        Map<Item, Integer> con = new HashMap<>();

        con.put(item_1, 5);
        con.put(item_2, 10);
        con.put(item_3, 15);

        Map<Item, Integer> eq = new HashMap<>();

        eq.put(item_4, 1);
        eq.put(item_5, 2);


        this.inventario = inv;
        this.equipamentos = eq;
        this.consumiveis = con;

        this.equipado = new Equipado(item_4, item_5, item_6);
        this.dinheiro = 200;
    }

    @Test
    public void TesteInventarioConstrutor() throws IOException {
        Inventario teste = new Inventario(inventario, equipamentos, consumiveis, equipado, dinheiro);

        Integer inv_num = 5;
        Integer con_num = 3;
        Integer eq_num = 2;

        Item item_4 = new LoaderItem().renderEquipamento("1");
        Item item_5 = new LoaderItem().renderEquipamento("2");
        Item item_6 = new LoaderItem().renderEquipamento("3");

        Assertions.assertEquals(inv_num, teste.getInventario().size());
        Assertions.assertEquals(con_num, teste.getConsumiveis().size());
        Assertions.assertEquals(eq_num, teste.getEquipamentos().size());

        Assertions.assertEquals(dinheiro, teste.getDinheiro());

        Assertions.assertEquals(item_4.getNome(), teste.getEquipado().getCapacete().getNome());
        Assertions.assertEquals(item_5.getNome(), teste.getEquipado().getPeitoral().getNome());
        Assertions.assertEquals(item_6.getNome(), teste.getEquipado().getCalcas().getNome());
    }

    @Test
    public void TesteListasEquipamentos() throws IOException {
        Item capacete_1 = new LoaderItem().renderEquipamento("1");
        Item capacete_2 = new LoaderItem().renderEquipamento("4");
        Item capacete_3 = new LoaderItem().renderEquipamento("7");
        Item capacete_4 = new LoaderItem().renderEquipamento("10");

        Item peitoral_1 = new LoaderItem().renderEquipamento("2");
        Item peitoral_2 = new LoaderItem().renderEquipamento("5");
        Item peitoral_3 = new LoaderItem().renderEquipamento("8");
        Item peitoral_4 = new LoaderItem().renderEquipamento("11");

        Item calcas_1 = new LoaderItem().renderEquipamento("3");
        Item calcas_2 = new LoaderItem().renderEquipamento("6");
        Item calcas_3 = new LoaderItem().renderEquipamento("9");
        Item calcas_4 = new LoaderItem().renderEquipamento("12");

        Map<Item, Integer> eq = new HashMap<>();

        eq.put(capacete_1, 1);
        eq.put(capacete_2, 1);
        eq.put(capacete_3, 1);
        eq.put(capacete_4, 1);

        eq.put(peitoral_1, 1);
        eq.put(peitoral_2, 1);
        eq.put(peitoral_3, 1);
        eq.put(peitoral_4, 1);

        eq.put(calcas_1, 1);
        eq.put(calcas_2, 1);
        eq.put(calcas_3, 1);
        eq.put(calcas_4, 1);

        Inventario teste = new Inventario(inventario, eq, consumiveis, equipado, dinheiro);

        Assertions.assertEquals(4, teste.lista_capacetes().size());
        Assertions.assertEquals(4, teste.lista_peitoral().size());
        Assertions.assertEquals(4, teste.lista_calcas().size());

        Assertions.assertEquals(1, teste.lista_capacetes().get(capacete_1));
        Assertions.assertEquals(1, teste.lista_capacetes().get(capacete_2));
        Assertions.assertEquals(1, teste.lista_capacetes().get(capacete_3));
        Assertions.assertEquals(1, teste.lista_capacetes().get(capacete_4));

        Assertions.assertEquals(1, teste.lista_peitoral().get(peitoral_1));
        Assertions.assertEquals(1, teste.lista_peitoral().get(peitoral_2));
        Assertions.assertEquals(1, teste.lista_peitoral().get(peitoral_3));
        Assertions.assertEquals(1, teste.lista_peitoral().get(peitoral_4));

        Assertions.assertEquals(1, teste.lista_calcas().get(calcas_1));
        Assertions.assertEquals(1, teste.lista_calcas().get(calcas_2));
        Assertions.assertEquals(1, teste.lista_calcas().get(calcas_3));
        Assertions.assertEquals(1, teste.lista_calcas().get(calcas_4));
    }

    @Test
    public void TesteAddConsumivel() throws IOException {
        Inventario teste = new Inventario(inventario, equipamentos, consumiveis, equipado, dinheiro);

        Item item_1 = new LoaderItem().renderConsumivel("1");
        Item item_2 = new LoaderItem().renderConsumivel("4");

        InventarioAddConsumiveis inventarioAddConsumiveis = new InventarioAddConsumiveis(teste, item_1, 1);
        inventarioAddConsumiveis.execute();

        inventarioAddConsumiveis = new InventarioAddConsumiveis(teste, item_2, 1);
        inventarioAddConsumiveis.execute();

        for(Map.Entry<Item, Integer> entry : teste.getInventario().entrySet()){
            if(entry.getKey().getNome().equals(item_1.getNome())){
                Assertions.assertEquals(6, entry.getValue());
            }
            if(entry.getKey().getNome().equals(item_2.getNome())){
                Assertions.assertEquals(1, entry.getValue());
            }
        }

        for(Map.Entry<Item, Integer> entry : teste.getConsumiveis().entrySet()){
            if(entry.getKey().getNome().equals(item_1.getNome())){
                Assertions.assertEquals(6, entry.getValue());
            }
            if(entry.getKey().getNome().equals(item_2.getNome())){
                Assertions.assertEquals(1, entry.getValue());
            }
        }
    }

    @Test
    public void TesteAddEquipamento() throws IOException {
        Inventario teste = new Inventario(inventario, equipamentos, consumiveis, equipado, dinheiro);

        Item item_1 = new LoaderItem().renderEquipamento("1");
        Item item_2 = new LoaderItem().renderEquipamento("4");

        InventarioAddEquipamento inventarioAddEquipamento = new InventarioAddEquipamento(teste, item_1, 1);
        inventarioAddEquipamento.execute();

        inventarioAddEquipamento = new InventarioAddEquipamento(teste, item_2, 1);
        inventarioAddEquipamento.execute();

        for(Map.Entry<Item, Integer> entry : teste.getInventario().entrySet()){
            if(entry.getKey().getNome().equals(item_1.getNome())){
                Assertions.assertEquals(2, entry.getValue());
            }
            if(entry.getKey().getNome().equals(item_2.getNome())){
                Assertions.assertEquals(1, entry.getValue());
            }
        }

        for(Map.Entry<Item, Integer> entry : teste.getEquipamentos().entrySet()){
            if(entry.getKey().getNome().equals(item_1.getNome())){
                Assertions.assertEquals(2, entry.getValue());
            }
            if(entry.getKey().getNome().equals(item_2.getNome())){
                Assertions.assertEquals(1, entry.getValue());
            }
        }

    }

    @Test
    public void TesteRemoveConsumivel() throws IOException {
        Inventario teste = new Inventario(inventario, equipamentos, consumiveis, equipado, dinheiro);

        Item item_1 = new LoaderItem().renderConsumivel("1");
        Item item_2 = new LoaderItem().renderConsumivel("4");

        InventarioAddConsumiveis inventarioAddConsumiveis = new InventarioAddConsumiveis(teste, item_2, 1);
        inventarioAddConsumiveis.execute();

        InventarioRemoveConsumivel inventarioRemoveConsumivel = new InventarioRemoveConsumivel(teste, item_1);
        inventarioRemoveConsumivel.execute();

        for(Map.Entry<Item, Integer> entry : teste.getInventario().entrySet()){
            if(entry.getKey().getNome().equals(item_1.getNome())){
                Assertions.assertEquals(4, entry.getValue());
                Assertions.assertFalse(inventarioRemoveConsumivel.getRes());
            }
            if(entry.getKey().getNome().equals(item_2.getNome())){
                Assertions.assertEquals(1, entry.getValue());
            }
        }

        for(Map.Entry<Item, Integer> entry : teste.getConsumiveis().entrySet()){
            if(entry.getKey().getNome().equals(item_1.getNome())){
                Assertions.assertEquals(4, entry.getValue());
                Assertions.assertFalse(inventarioRemoveConsumivel.getRes());
            }
            if(entry.getKey().getNome().equals(item_2.getNome())){
                Assertions.assertEquals(1, entry.getValue());
            }
        }

        inventarioRemoveConsumivel = new InventarioRemoveConsumivel(teste, item_2);
        inventarioRemoveConsumivel.execute();
        Assertions.assertTrue(inventarioRemoveConsumivel.getRes());

    }

    @Test
    public void TesteRemoveEquipamento() throws IOException {
        Inventario teste = new Inventario(inventario, equipamentos, consumiveis, equipado, dinheiro);

        Item item_1 = new LoaderItem().renderEquipamento("2");
        Item item_2 = new LoaderItem().renderEquipamento("1");

        InventarioRemoveEquipamento inventarioRemoveEquipamento = new InventarioRemoveEquipamento(teste, item_1);
        inventarioRemoveEquipamento.execute();

        for(Map.Entry<Item, Integer> entry : teste.getInventario().entrySet()){
            if(entry.getKey().getNome().equals(item_1.getNome())){
                Assertions.assertEquals(1, entry.getValue());
                Assertions.assertFalse(inventarioRemoveEquipamento.getRes());
            }
        }

        for(Map.Entry<Item, Integer> entry : teste.getConsumiveis().entrySet()){
            if(entry.getKey().getNome().equals(item_1.getNome())){
                Assertions.assertEquals(1, entry.getValue());
                Assertions.assertFalse(inventarioRemoveEquipamento.getRes());
            }
            if(entry.getKey().getNome().equals(item_2.getNome())){
                Assertions.assertEquals(1, entry.getValue());
            }
        }

        inventarioRemoveEquipamento = new InventarioRemoveEquipamento(teste, item_2);
        inventarioRemoveEquipamento.execute();
        Assertions.assertTrue(inventarioRemoveEquipamento.getRes());
    }

    @Test
    public void TesteSwapArmor() throws IOException {
        Inventario teste = new Inventario(inventario, equipamentos, consumiveis, equipado, dinheiro);

        Item capacete_1 = new LoaderItem().renderEquipamento("1");
        Item peitoral_1 = new LoaderItem().renderEquipamento("2");
        Item calcas_1 = new LoaderItem().renderEquipamento("3");

        Item capacete_2 = new LoaderItem().renderEquipamento("4");
        Item peitoral_2 = new LoaderItem().renderEquipamento("5");
        Item calcas_2 = new LoaderItem().renderEquipamento("6");

        InventarioSwapArmor swapArmor = new InventarioSwapArmor(teste, capacete_2);
        swapArmor.execute();

        swapArmor = new InventarioSwapArmor(teste, peitoral_2);
        swapArmor.execute();

        swapArmor = new InventarioSwapArmor(teste, calcas_2);
        swapArmor.execute();

        Assertions.assertEquals(capacete_2.getNome(), teste.getEquipado().getCapacete().getNome());
        Assertions.assertEquals(peitoral_2.getNome(), teste.getEquipado().getPeitoral().getNome());
        Assertions.assertEquals(calcas_2.getNome(), teste.getEquipado().getCalcas().getNome());

        for(Map.Entry<Item, Integer> entry : teste.getInventario().entrySet()){
            if(entry.getKey().getNome().equals(capacete_1.getNome())){
                Assertions.assertEquals(2, entry.getValue());
            }
            if(entry.getKey().getNome().equals(peitoral_1.getNome())){
                Assertions.assertEquals(3, entry.getValue());
            }
            if(entry.getKey().getNome().equals(calcas_1.getNome())){
                Assertions.assertEquals(1, entry.getValue());
            }
        }

        for(Map.Entry<Item, Integer> entry : teste.getEquipamentos().entrySet()){
            if(entry.getKey().getNome().equals(capacete_1.getNome())){
                Assertions.assertEquals(2, entry.getValue());
            }
            if(entry.getKey().getNome().equals(peitoral_1.getNome())){
                Assertions.assertEquals(3, entry.getValue());
            }
            if(entry.getKey().getNome().equals(calcas_1.getNome())){
                Assertions.assertEquals(1, entry.getValue());
            }
        }
    }

    @Test
    public void TesteAddDinheiro() throws IOException {
        Inventario teste = new Inventario(inventario, equipamentos, consumiveis, equipado, dinheiro);

        Integer dinheiro_max = 20;
        Integer dinheiro_min = 4;
        Integer exp = 40;

        Item item = new LoaderItem().renderConsumivel("1");

        Map<Item, Integer> itens_drop = new HashMap<>();
        itens_drop.put(item, 80);

        Drop drop = new Drop(dinheiro_max, dinheiro_min, itens_drop, exp);

        InventarioAddDinheiro addDinheiro = new InventarioAddDinheiro(teste, drop);
        addDinheiro.execute();

        Assertions.assertTrue(dinheiro_min <= addDinheiro.getDinheiro() && dinheiro_max >= addDinheiro.getDinheiro());
        Assertions.assertEquals(dinheiro + addDinheiro.getDinheiro(), teste.getDinheiro());
    }

    @Test
    public void TesteDropItens() throws IOException {
        Inventario teste = new Inventario(inventario, equipamentos, consumiveis, equipado, dinheiro);

        Integer dinheiro_max = 20;
        Integer dinheiro_min = 4;
        Integer exp = 40;

        Item item = new LoaderItem().renderConsumivel("1");

        Map<Item, Integer> itens_drop = new HashMap<>();
        itens_drop.put(item, 90);

        Drop drop = new Drop(dinheiro_max, dinheiro_min, itens_drop, exp);

        InventarioDropItens inventarioDropItens = new InventarioDropItens(teste, drop);
        inventarioDropItens.execute();

        if(inventarioDropItens.getItems().isEmpty()){
            Assertions.assertEquals(0, inventarioDropItens.getItems().size());
        }
        else{
            Assertions.assertEquals(item.getNome(), inventarioDropItens.getItems().get(0).getNome());

            for(Map.Entry<Item, Integer> entry : teste.getInventario().entrySet()){
                if(entry.getKey().getNome().equals(item.getNome())){
                    Assertions.assertEquals(6, entry.getValue());
                }
            }

            for(Map.Entry<Item, Integer> entry : teste.getConsumiveis().entrySet()){
                if(entry.getKey().getNome().equals(item.getNome())){
                    Assertions.assertEquals(6, entry.getValue());
                }
            }
        }
    }
}
