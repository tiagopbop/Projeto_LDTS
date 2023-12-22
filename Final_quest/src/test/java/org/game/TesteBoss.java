package org.game;

import org.game.rpg_rules.Inimigos.Boss;
import org.game.rpg_rules.Inimigos.strategy.AgressiveStrategy;
import org.game.rpg_rules.Inimigos.strategy.Strategy;
import org.game.rpg_rules.status.Atributos;
import org.game.rpg_rules.status.LoaderStatus;
import org.game.rpg_rules.status.Status;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class TesteBoss {
    private Status statusMock;
    private List<Status> memberMock;

    @BeforeEach
    public void Helper(){
        this.memberMock = new ArrayList<>();
        Atributos atributos = new Atributos(5, 200, 100, 50, 40, 120);
        statusMock = new Status(atributos, new ArrayList<>(), "boss", "s");

        atributos = new Atributos(5, 100, 0, 0, 0, 0);
        Status status = new Status(atributos, new ArrayList<>(), "v", "s");
        this.memberMock.add(status);

        atributos = new Atributos(5, 0, 0, 100, 0, 0);
        status = new Status(atributos, new ArrayList<>(), "f", "s");
        this.memberMock.add(status);
    }

    @Test
    public void TesteBossConstructor() throws IOException {
        LoaderStatus bossStatusMock = Mockito.mock(LoaderStatus.class);
        Mockito.when(bossStatusMock.renderBoss()).thenReturn(statusMock);

        LoaderStatus memberBossMock = Mockito.mock(LoaderStatus.class);
        Mockito.when(memberBossMock.renderMemberBoss()).thenReturn(memberMock);

        AgressiveStrategy StrategyMock = new AgressiveStrategy();

        Boss teste = new Boss(bossStatusMock, StrategyMock, memberBossMock);

        Assertions.assertEquals("boss v f", teste.getName());

        Assertions.assertEquals(300, teste.getStatus().getAtributos_real().getVida());
        Assertions.assertEquals(100, teste.getStatus().getAtributos_real().getMana());
        Assertions.assertEquals(150, teste.getStatus().getAtributos_real().getForca());
        Assertions.assertEquals(40, teste.getStatus().getAtributos_real().getInteligencia());
        Assertions.assertEquals(120, teste.getStatus().getAtributos_real().getVelocidade());

        Assertions.assertEquals(300, teste.getStatus().getAtributos_atualizados().getVida());
        Assertions.assertEquals(100, teste.getStatus().getAtributos_atualizados().getMana());
        Assertions.assertEquals(150, teste.getStatus().getAtributos_atualizados().getForca());
        Assertions.assertEquals(40, teste.getStatus().getAtributos_atualizados().getInteligencia());
        Assertions.assertEquals(120, teste.getStatus().getAtributos_atualizados().getVelocidade());

        verify(bossStatusMock, times(1)).renderBoss();
        verify(memberBossMock, times(1)).renderMemberBoss();

    }
}
