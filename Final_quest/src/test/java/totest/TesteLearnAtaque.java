package totest;

import org.game.rpg_rules.status.Atributos;
import org.game.rpg_rules.status.ataque.Ataque;
import org.game.rpg_rules.status.ataque.Learn_Ataque;
import org.game.rpg_rules.status.ataque.LoaderAtaque;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.*;

public class TesteLearnAtaque {
    private List<Ataque> ataques;
    private Atributos atributos_1;
    private Atributos atributos_2;

    @BeforeEach
    public void Helper(){
        Integer level = 5;
        Integer vida = 20;
        Integer mana = 10;
        Integer forca = 10;
        Integer inteligencia = 10;
        Integer velocidade = 7;

        this.atributos_1 = new Atributos(level, vida, mana, forca, inteligencia, velocidade);

        level = 10;
        vida = 20;
        mana = 10;
        forca = 10;
        inteligencia = 20;
        velocidade = 7;

        this.atributos_2 = new Atributos(level, vida, mana, forca, inteligencia, velocidade);

        Map<String, Integer> requesitos = new HashMap<>();
        requesitos.put("level", 5);
        Ataque ataque1 = new Ataque("1", "fisico", 10, 100, 0, requesitos);

        requesitos = new HashMap<>();
        requesitos.put("level", 5);
        requesitos.put("forca", 10);
        Ataque ataque2 = new Ataque("2", "fisico", 20, 100, 0, requesitos);

        requesitos = new HashMap<>();
        requesitos.put("level", 10);
        requesitos.put("forca", 10);
        Ataque ataque3 = new Ataque("3", "fisico", 5, 100, 0, requesitos);

        requesitos = new HashMap<>();
        requesitos.put("level", 5);
        requesitos.put("inteligencia", 10);
        Ataque ataque4 = new Ataque("4", "magico", 10, 100, 0, requesitos);

        requesitos = new HashMap<>();
        requesitos.put("level", 5);
        requesitos.put("inteligencia", 20);
        Ataque ataque5 = new Ataque("5", "magico", 10, 100, 0, requesitos);

        requesitos = new HashMap<>();
        requesitos.put("level", 10);
        requesitos.put("forca", 10);
        requesitos.put("inteligencia", 20);
        Ataque ataque6 = new Ataque("6", "magico", 5, 100, 0, requesitos);

        this.ataques = Arrays.asList(ataque1, ataque2, ataque3, ataque4, ataque5, ataque6);
    }

    @Test
    public void TesteClassLearnClass() throws IOException {
        List<Ataque> mock = new ArrayList<>();
        mock.add(ataques.get(0));

        LoaderAtaque loaderAtaqueMock = Mockito.mock(LoaderAtaque.class);

        Mockito.when(loaderAtaqueMock.renderAtaque("2")).thenReturn(ataques.get(1));
        Mockito.when(loaderAtaqueMock.renderAtaque("1")).thenReturn(ataques.get(0));
        Mockito.when(loaderAtaqueMock.renderAtaque("3")).thenReturn(ataques.get(2));
        Mockito.when(loaderAtaqueMock.renderAtaque("4")).thenReturn(ataques.get(3));
        Mockito.when(loaderAtaqueMock.renderAtaque("5")).thenReturn(ataques.get(4));
        Mockito.when(loaderAtaqueMock.renderAtaque("6")).thenReturn(ataques.get(5));

        List<Ataque> teste = new Learn_Ataque(loaderAtaqueMock).aprender(atributos_1, mock);

        Assertions.assertEquals(2, teste.size());
        Assertions.assertEquals("2", teste.get(0).getNome());
        Assertions.assertEquals("4", teste.get(1).getNome());

        teste = new Learn_Ataque(loaderAtaqueMock).aprender(atributos_2, mock);

        Assertions.assertEquals(5, teste.size());
        Assertions.assertEquals("2", teste.get(0).getNome());
        Assertions.assertEquals("3", teste.get(1).getNome());
        Assertions.assertEquals("4", teste.get(2).getNome());
        Assertions.assertEquals("5", teste.get(3).getNome());
        Assertions.assertEquals("6", teste.get(4).getNome());
    }
}
