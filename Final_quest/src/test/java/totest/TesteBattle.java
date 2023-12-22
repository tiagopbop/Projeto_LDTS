package totest;

import org.game.model.battle.battleElements.Battle;
import org.game.model.battle.battleElements.Hero;
import org.game.model.battle.battleElements.Individuo;
import org.game.model.battle.battleElements.Party;
import org.game.model.battle.battleElements.battleCommands.CreatePriorityQueue;
import org.game.model.battle.battleElements.battleCommands.Hero_Turn;
import org.game.model.battle.battleElements.battleCommands.MonsterTurn;
import org.game.rpg_rules.Inimigos.Monster;
import org.game.rpg_rules.Inimigos.drop.Drop;
import org.game.rpg_rules.Inimigos.drop.LoaderDrop;
import org.game.rpg_rules.Inimigos.strategy.NormalStrategy;
import org.game.rpg_rules.Inimigos.strategy.Strategy;
import org.game.rpg_rules.itens.Item;
import org.game.rpg_rules.itens.LoaderItem;
import org.game.rpg_rules.itens.inventario.inventario_commands.InventarioAddDinheiro;
import org.game.rpg_rules.itens.inventario.inventario_commands.InventarioDropItens;
import org.game.rpg_rules.itens.inventario.inventario_commands.itens.InventarioRemoveConsumivel;
import org.game.rpg_rules.status.Atributos;
import org.game.rpg_rules.status.Status;
import org.game.rpg_rules.status.ataque.Ataque;
import org.game.rpg_rules.status.ataque.Formula_Dano;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.*;

public class TesteBattle {
    private Status status_1;
    private Status status_2;
    private List<Ataque> ataquesMock;
    private Party partyMocked;
    private List<Individuo> monstersMocked;

    @BeforeEach
    public void Helper(){
        Integer level = 5;
        Integer vida = 20;
        Integer mana = 10;
        Integer forca = 10;
        Integer inteligencia = 10;
        Integer velocidade = 7;

        Atributos atributos = new Atributos(level, vida, mana, forca, inteligencia, velocidade);

        Ataque ataque1 = new Ataque("1", "fisico", 10, 100, 0);
        Ataque ataque2 = new Ataque("2", "fisico", 0, 100, 11);
        Ataque ataque3 = new Ataque("3", "magico", 10, 100, 0);
        Ataque ataque4 = new Ataque("4", "magico", 0, 100, 11);

        this.ataquesMock = Arrays.asList(ataque1, ataque2, ataque3, ataque4);

        this.status_1 = new Status(atributos, ataquesMock, "hero", "s");
        this.partyMocked = new Party(Hero.getInstance(status_1));

        velocidade = 4;
        atributos = new Atributos(level, vida, mana, forca, inteligencia, velocidade);
        this.status_2 = new Status(atributos, ataquesMock, "monster", "s");

        List<Individuo> individuos = new ArrayList<>();
        individuos.add(new Monster(status_2));

        this.monstersMocked = individuos;

    }

    @Test
    public void TesteBattleConstructor() throws IOException {
        Battle teste = new Battle(partyMocked, monstersMocked);

        Assertions.assertEquals("hero", teste.getParty().getParty().get(0).getStatus().getNome());
        Assertions.assertEquals("monster", teste.getMonster().getStatus().getNome());
    }

    @Test
    public void TesteQueue() throws IOException {
        Battle teste = new Battle(partyMocked, monstersMocked);

        CreatePriorityQueue createPriorityQueue = new CreatePriorityQueue(teste);
        createPriorityQueue.execute();

        Queue<Individuo> queueTeste = teste.getVez_ataque();

        Assertions.assertEquals("hero", queueTeste.peek().getStatus().getNome());
        queueTeste.remove();
        Assertions.assertEquals("monster", queueTeste.peek().getStatus().getNome());

        Hero.getInstance().setStatus(status_2);
        partyMocked = new Party(Hero.getInstance());

        status_1.setNome("monster");
        status_2.setNome("hero");

        teste = new Battle(partyMocked, Arrays.asList(new Monster(status_1)));
        createPriorityQueue = new CreatePriorityQueue(teste);
        createPriorityQueue.execute();


        queueTeste = teste.getVez_ataque();
        Assertions.assertEquals("monster", queueTeste.peek().getStatus().getNome());
        queueTeste.remove();
        Assertions.assertEquals("hero", queueTeste.peek().getStatus().getNome());

    }

    @Test
    public void TesteHeroTurnFisico() throws IOException {
        Battle teste = new Battle(partyMocked, monstersMocked);

        Formula_Dano formulaDanoMock = Mockito.mock(Formula_Dano.class);
        Mockito.when(formulaDanoMock.Dano(Mockito.any(Ataque.class), Mockito.any(Atributos.class), Mockito.anyInt())).thenReturn(20);

        String player_choice = "melee";

        Hero_Turn heroTurn = new Hero_Turn(teste, formulaDanoMock);
        heroTurn.setPlayer_option(player_choice);
        heroTurn.setInt_list(0);

        heroTurn.execute();
        Assertions.assertEquals(0, teste.getMonster().getStatus().getVida_atual());

        teste = new Battle(partyMocked, monstersMocked);

        formulaDanoMock = Mockito.mock(Formula_Dano.class);
        Mockito.when(formulaDanoMock.Dano(Mockito.any(Ataque.class), Mockito.any(Atributos.class), Mockito.anyInt())).thenReturn(0);

        player_choice = "melee";

        heroTurn = new Hero_Turn(teste, formulaDanoMock);
        heroTurn.setPlayer_option(player_choice);
        heroTurn.setInt_list(1);

        heroTurn.execute();
        Assertions.assertEquals(0, teste.getMonster().getStatus().getVida_atual());
    }

    @Test
    public void TesteHeroTurnMagico() throws IOException{
        Battle teste = new Battle(partyMocked, monstersMocked);

        Formula_Dano formulaDanoMock = Mockito.mock(Formula_Dano.class);
        Mockito.when(formulaDanoMock.Dano(Mockito.any(Ataque.class), Mockito.any(Atributos.class), Mockito.anyInt())).thenReturn(20);

        String player_choice = "magic";

        Hero_Turn heroTurn = new Hero_Turn(teste, formulaDanoMock);
        heroTurn.setPlayer_option(player_choice);
        heroTurn.setInt_list(0);

        heroTurn.execute();
        Assertions.assertEquals(0, teste.getMonster().getStatus().getVida_atual());

        teste = new Battle(partyMocked, monstersMocked);

        formulaDanoMock = Mockito.mock(Formula_Dano.class);
        Mockito.when(formulaDanoMock.Dano(Mockito.any(Ataque.class), Mockito.any(Atributos.class), Mockito.anyInt())).thenReturn(0);

        player_choice = "magic";

        heroTurn = new Hero_Turn(teste, formulaDanoMock);
        heroTurn.setPlayer_option(player_choice);
        heroTurn.setInt_list(1);

        heroTurn.execute();
        Assertions.assertEquals(0, teste.getMonster().getStatus().getVida_atual());
    }

    @Test
    public void TesteUsarItem() throws IOException {
        HashMap<String, Integer> efeitos = new HashMap<>();
        efeitos.put("vida", 5);

        Item item_1_mock = new Item("1", "pocao cura", efeitos);
        Item item_2_mock = new Item("2", "bomba", efeitos);

        partyMocked.getParty().get(0).getStatus().setVida_atual(10);

        Battle teste = new Battle(partyMocked, monstersMocked);
        InventarioRemoveConsumivel inventarioRemoveConsumivelMock = Mockito.mock(InventarioRemoveConsumivel.class);

        Hero_Turn heroTurn = new Hero_Turn(teste, inventarioRemoveConsumivelMock);
        heroTurn.setPlayer_item(item_1_mock);
        heroTurn.setInt_list(0);
        heroTurn.setPlayer_option("item");

        heroTurn.execute();

        Assertions.assertEquals(15, teste.getParty().getParty().get(0).getStatus().getVida_atual());

        heroTurn.setPlayer_item(item_2_mock);
        heroTurn.execute();

        Assertions.assertEquals(15, teste.getMonster().getStatus().getVida_atual());

    }

    @Test
    public void TesteMonsterTurn() throws IOException {
        Strategy strategyMock = Mockito.mock(NormalStrategy.class);
        Mockito.when(strategyMock.execute(Mockito.any(Monster.class))).thenReturn(ataquesMock.get(0));

        Formula_Dano formulaDanoMock = Mockito.mock(Formula_Dano.class);
        Mockito.when(formulaDanoMock.Dano(Mockito.any(Ataque.class), Mockito.any(Atributos.class), Mockito.anyInt())).thenReturn(15);

        Battle teste = new Battle(partyMocked, monstersMocked);
        MonsterTurn monsterTurn = new MonsterTurn(teste, strategyMock, formulaDanoMock);
        monsterTurn.execute();

        Assertions.assertEquals(5, teste.getParty().getParty().get(0).getStatus().getVida_atual());
    }

    @Test
    public void TesteDropItens() throws IOException {
        Integer dinheiro_max = 20;
        Integer dinheiro_min = 4;
        Integer exp = 40;

        Item item = new LoaderItem().renderConsumivel("1");

        Map<Item, Integer> itens_drop = new HashMap<>();
        itens_drop.put(item, 100);

        Drop drop = new Drop(dinheiro_max, dinheiro_min, itens_drop, exp);

        LoaderDrop loaderDropMock = Mockito.mock(LoaderDrop.class);
        Mockito.when(loaderDropMock.renderDrop(Mockito.anyString())).thenReturn(drop);

        InventarioAddDinheiro inventarioAddDinheiroMock = Mockito.mock(InventarioAddDinheiro.class);
        InventarioDropItens inventarioDropItensMock = Mockito.mock(InventarioDropItens.class);


    }
}
