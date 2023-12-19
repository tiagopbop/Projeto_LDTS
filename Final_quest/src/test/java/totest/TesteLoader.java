package totest;

import org.game.rpg_elements.Inimigos.drop.Drop;
import org.game.rpg_elements.Inimigos.drop.LoaderDrop;
import org.game.rpg_elements.Loader;
import org.game.rpg_elements.dialogue.Dialogue;
import org.game.rpg_elements.dialogue.LoaderDialogo;
import org.game.rpg_elements.itens.Item;
import org.game.rpg_elements.itens.LoaderItem;
import org.game.rpg_elements.itens.inventario.Inventario;
import org.game.rpg_elements.itens.inventario.LoaderInventario;
import org.game.rpg_elements.status.LoaderStatus;
import org.game.rpg_elements.status.Status;
import org.game.rpg_elements.status.ataque.Ataque;
import org.game.rpg_elements.status.ataque.LoaderAtaque;
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

        Assertions.assertArrayEquals(loader.getLines().toArray(), mockLines.toArray());
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

        Assertions.assertEquals(teste.getNome(), nome);
        Assertions.assertEquals(teste.getOrigem(), origem);
        Assertions.assertEquals(teste.getDano(), dano);
        Assertions.assertEquals(teste.getAcerto(), acerto);
        Assertions.assertEquals(teste.getCusto(), custo);
        Assertions.assertEquals(teste.getRequesitos(), requesitos);

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

        Assertions.assertEquals(teste.getAtributos_real().getLevel(), level);
        Assertions.assertEquals(teste.getAtributos_real().getVida(), vida);
        Assertions.assertEquals(teste.getAtributos_real().getMana(), mana);
        Assertions.assertEquals(teste.getAtributos_real().getForca(), forca);
        Assertions.assertEquals(teste.getAtributos_real().getInteligencia(), inteligencia);
        Assertions.assertEquals(teste.getAtributos_real().getVelocidade(), velocidade);

        Assertions.assertEquals(teste.getAtaques().size(), 1);
        Assertions.assertEquals(teste.getAtaques().get(0).getNome(), "Slash");
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

        Assertions.assertEquals(teste.getMax_dinheiro(), dinheiro_max);
        Assertions.assertEquals(teste.getMim_dinheiro(), dinheiro_min);
        Assertions.assertEquals(teste.getExperiencia(), exp);

        Assertions.assertEquals(teste.getItens_droped().get(item), percentual);
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

        Assertions.assertEquals(teste.getNome(), nome);
        Assertions.assertEquals(teste.getType(), tipo);
        Assertions.assertEquals(teste.getEfeitos().get(efeito_str), efeito_int);
        Assertions.assertEquals(teste.getRequirements().get(requesitos_str), requesitos_int);
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

        Assertions.assertEquals(teste.getEquipamentos().get(eq_1), eq_quat_1);
        Assertions.assertEquals(teste.getEquipamentos().get(eq_2), eq_quat_2);
        Assertions.assertEquals(teste.getEquipamentos().get(eq_3), eq_quat_3);

        Assertions.assertEquals(teste.getConsumiveis().get(con_1), con_quat_1);
        Assertions.assertEquals(teste.getConsumiveis().get(con_2), con_quat_2);

        Assertions.assertEquals(teste.getEquipado().getCapacete(), eq_1);
        Assertions.assertEquals(teste.getEquipado().getPeitoral(), eq_2);
        Assertions.assertEquals(teste.getEquipado().getCalcas(), eq_3);

        Assertions.assertEquals(teste.getDinheiro(), dinheiro);
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

        Assertions.assertEquals(teste.size(), num_dialogues);

        Assertions.assertEquals(teste.get(0).getTitle(), titulo_1);
        Assertions.assertEquals(teste.get(0).getMen(), options_1);

        Assertions.assertEquals(teste.get(0).getAll_texto().get(0).get(0), line_1_1);
        Assertions.assertEquals(teste.get(0).getAll_texto().get(0).get(1), line_1_2);
        Assertions.assertEquals(teste.get(0).getAll_texto().get(0).get(2), line_1_3);
        Assertions.assertEquals(teste.get(0).getAll_texto().get(0).get(3), line_1_4);
        Assertions.assertEquals(teste.get(0).getAll_texto().get(1).get(0), line_1_5);
        Assertions.assertEquals(teste.get(0).getAll_texto().get(1).get(1), line_1_6);
        Assertions.assertEquals(teste.get(0).getAll_texto().get(1).get(2), line_1_7);

        Assertions.assertEquals(teste.get(1).getTitle(), titulo_2);
        Assertions.assertEquals(teste.get(1).getMen(), options_2);

        Assertions.assertEquals(teste.get(1).getAll_texto().get(0).get(0), line_2_1);
    }

}
