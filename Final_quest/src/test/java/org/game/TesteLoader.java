package org.game;

import org.game.rpg_rules.Inimigos.drop.Drop;
import org.game.rpg_rules.Inimigos.drop.LoaderDrop;
import org.game.rpg_rules.Loader;
import org.game.rpg_rules.dialogue.Dialogue;
import org.game.rpg_rules.dialogue.LoaderDialogo;
import org.game.rpg_rules.itens.Item;
import org.game.rpg_rules.itens.LoaderItem;
import org.game.rpg_rules.itens.inventario.Inventario;
import org.game.rpg_rules.itens.inventario.LoaderInventario;
import org.game.rpg_rules.status.LoaderStatus;
import org.game.rpg_rules.status.Status;
import org.game.rpg_rules.status.ataque.Ataque;
import org.game.rpg_rules.status.ataque.LoaderAtaque;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.*;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class TesteLoader {
    private List<String> mockLines;

    @Test
    public void Loader() throws IOException {
        mockLines = Arrays.asList("1", "Teste", "2", "Isto", "3", "é", "4", "um", "5", "teste");

        Loader loader = new Loader();
        loader.Loader("/teste");

        Assertions.assertArrayEquals(mockLines.toArray(), loader.getLines().toArray());
    }

    @Test
    public void LoaderAtaque(){
        mockLines = Arrays.asList("Slash", "fisico", "6", "80", "0", "Requesitos", "level", "1", "forca", "10", "#");

        String nome = "Slash";
        String origem = "fisico";
        Integer dano = 6;
        Integer acerto = 80;
        Integer custo = 0;

        Map<String, Integer> requesitos = new HashMap<>();
        requesitos.put("level", 1);
        requesitos.put("forca", 10);

        LoaderAtaque loaderAtaque = new LoaderAtaque();
        Ataque teste = loaderAtaque.createRPGelement(mockLines);

        Assertions.assertEquals(nome, teste.getNome());
        Assertions.assertEquals(origem, teste.getOrigem());
        Assertions.assertEquals(dano, teste.getDano());
        Assertions.assertEquals(acerto, teste.getAcerto());
        Assertions.assertEquals(custo, teste.getCusto());
        Assertions.assertEquals(requesitos, teste.getRequesitos());

    }

    @Test
    public void LoaderStatus() throws IOException {
        Ataque ataque1 = new LoaderAtaque().renderAtaque("1");

        LoaderAtaque loaderAtaqueMock = Mockito.mock(LoaderAtaque.class);
        Mockito.when(loaderAtaqueMock.renderAtaque(anyString())).thenReturn(ataque1);

        mockLines = Arrays.asList("dracky", "n", "Atributos", "3", "20", "10", "11", "0", "7", "Ataques", "1");

        String nome = "dracky";
        String strg = "n";

        Integer level = 3;
        Integer vida = 20;
        Integer mana = 10;
        Integer forca = 11;
        Integer inteligencia = 0;
        Integer velocidade = 7;

        LoaderStatus loaderStatus = new LoaderStatus(loaderAtaqueMock);
        Status teste = loaderStatus.createRPGelement(mockLines);

        verify(loaderAtaqueMock, times(1)).renderAtaque(anyString());

        Assertions.assertEquals(teste.getNome(), nome);
        Assertions.assertEquals(teste.getStrg(), strg);

        Assertions.assertEquals(level,teste.getAtributos_real().getLevel());
        Assertions.assertEquals(vida, teste.getAtributos_real().getVida());
        Assertions.assertEquals(mana, teste.getAtributos_real().getMana());
        Assertions.assertEquals(forca, teste.getAtributos_real().getForca());
        Assertions.assertEquals(inteligencia, teste.getAtributos_real().getInteligencia());
        Assertions.assertEquals(velocidade, teste.getAtributos_real().getVelocidade());

        Assertions.assertEquals(1, teste.getAtaques().size());
        Assertions.assertEquals("Slash", teste.getAtaques().get(0).getNome());
    }

    @Test
    public void LoadDrop() throws IOException {
        Item item = new LoaderItem().renderConsumivel("1");

        LoaderItem loaderItemMock = Mockito.mock(LoaderItem.class);
        Mockito.when(loaderItemMock.renderConsumivel(anyString())).thenReturn(item);

        mockLines = Arrays.asList("Dinheiro", "20", "4", "Itens", "1", "30", "Experiência", "40");

        Integer dinheiro_max = 20;
        Integer dinheiro_min = 4;
        Integer exp = 40;
        Integer percentual = 30;

        Drop teste = new LoaderDrop(loaderItemMock).createRPGelement(mockLines);
        verify(loaderItemMock, times(1)).renderConsumivel(anyString());

        Assertions.assertEquals(dinheiro_max, teste.getMax_dinheiro());
        Assertions.assertEquals(dinheiro_min, teste.getMim_dinheiro());
        Assertions.assertEquals(exp, teste.getExperiencia());

        Assertions.assertEquals(percentual, teste.getItens_droped().get(item));
    }

    @Test
    public void LoaderItem() throws IOException {
        mockLines = Arrays.asList("Capacete Básico", "capacete", "Efeitos", "vida", "5", "Requesitos", "level", "1");

        String nome = "Capacete Básico";
        String tipo = "capacete";
        String efeito_str = "vida";
        Integer efeito_int = 5;
        String requesitos_str = "level";
        Integer requesitos_int = 1;

        Item teste = new LoaderItem().createRPGelement(mockLines);

        Assertions.assertEquals(nome, teste.getNome());
        Assertions.assertEquals(tipo, teste.getType());
        Assertions.assertEquals(efeito_int, teste.getEfeitos().get(efeito_str));
        Assertions.assertEquals(requesitos_int, teste.getRequirements().get(requesitos_str));
    }

    @Test
    public void LoaderInventario() throws IOException {
        mockLines = Arrays.asList("equipamento", "1", "1", "2", "2", "3", "3", "consumiveis", "1", "10", "2", "20", "equipado", "1", "2", "3", "dinheiro", "200");

        Item eq_1 = new LoaderItem().renderEquipamento("1");
        Item eq_2 = new LoaderItem().renderEquipamento("2");
        Item eq_3 = new LoaderItem().renderEquipamento("3");

        Integer eq_quat_1 = 1;
        Integer eq_quat_2 = 2;
        Integer eq_quat_3 = 3;

        Item con_1 = new LoaderItem().renderConsumivel("1");
        Item con_2 = new LoaderItem().renderConsumivel("2");

        Integer con_quat_1 = 10;
        Integer con_quat_2 = 20;

        Integer dinheiro = 200;

        LoaderItem loaderItemMock = Mockito.mock(LoaderItem.class);

        Mockito.when(loaderItemMock.renderEquipamento("1")).thenReturn(eq_1);
        Mockito.when(loaderItemMock.renderEquipamento("2")).thenReturn(eq_2);
        Mockito.when(loaderItemMock.renderEquipamento("3")).thenReturn(eq_3);

        Mockito.when(loaderItemMock.renderConsumivel("1")).thenReturn(con_1);
        Mockito.when(loaderItemMock.renderConsumivel("2")).thenReturn(con_2);

        Inventario teste = new LoaderInventario(loaderItemMock).createRPGelement(mockLines);
        verify(loaderItemMock, times(2)).renderConsumivel(anyString());
        verify(loaderItemMock, times(6)).renderEquipamento(anyString());

        Assertions.assertEquals(eq_quat_1, teste.getEquipamentos().get(eq_1));
        Assertions.assertEquals(eq_quat_2, teste.getEquipamentos().get(eq_2));
        Assertions.assertEquals(eq_quat_3, teste.getEquipamentos().get(eq_3));

        Assertions.assertEquals(con_quat_1, teste.getConsumiveis().get(con_1));
        Assertions.assertEquals(con_quat_2, teste.getConsumiveis().get(con_2));

        Assertions.assertEquals(eq_1, teste.getEquipado().getCapacete());
        Assertions.assertEquals(eq_2, teste.getEquipado().getPeitoral());
        Assertions.assertEquals(eq_3, teste.getEquipado().getCalcas());

        Assertions.assertEquals(dinheiro, teste.getDinheiro());
    }

    @Test
    public void LoaderDialogo() throws IOException {
        mockLines = Arrays.asList("#", "NPC 1", "1", "Num passado muito distante", "havia couves nesta vila", "mas o maldito mclaren roubou", "as todas", "?",
                "vai enfrentar o terrivel", "vilao no seu castelo", "crianca", "?", "#", "NPC 2", "2", "Desejas comprar alguma coisa", "?", "#");

        Integer num_dialogues = 2;

        String titulo_1 = "NPC 1";
        Integer options_1 = 1;

        String line_1_1 = "Num passado muito distante";
        String line_1_2 = "havia couves nesta vila";
        String line_1_3 = "mas o maldito mclaren roubou";
        String line_1_4 = "as todas";
        String line_1_5 = "vai enfrentar o terrivel";
        String line_1_6 = "vilao no seu castelo";
        String line_1_7 = "crianca";

        String titulo_2 = "NPC 2";
        Integer options_2 = 2;

        String line_2_1 = "Desejas comprar alguma coisa";

        List<Dialogue> teste = new LoaderDialogo().createRPGelement(mockLines);

        Assertions.assertEquals(num_dialogues, teste.size());

        Assertions.assertEquals(titulo_1, teste.get(0).getTitle());
        Assertions.assertEquals(options_1, teste.get(0).getMen());

        Assertions.assertEquals(line_1_1, teste.get(0).getAll_texto().get(0).get(0));
        Assertions.assertEquals(line_1_2, teste.get(0).getAll_texto().get(0).get(1));
        Assertions.assertEquals(line_1_3, teste.get(0).getAll_texto().get(0).get(2));
        Assertions.assertEquals(line_1_4, teste.get(0).getAll_texto().get(0).get(3));
        Assertions.assertEquals(line_1_5, teste.get(0).getAll_texto().get(1).get(0));
        Assertions.assertEquals(line_1_6, teste.get(0).getAll_texto().get(1).get(1));
        Assertions.assertEquals(line_1_7, teste.get(0).getAll_texto().get(1).get(2));

        Assertions.assertEquals(titulo_2, teste.get(1).getTitle());
        Assertions.assertEquals(options_2, teste.get(1).getMen());

        Assertions.assertEquals(line_2_1, teste.get(1).getAll_texto().get(0).get(0));
    }

}
