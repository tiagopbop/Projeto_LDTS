package org.game;

import org.game.model.battle.battleElements.Hero;
import org.game.model.game.elements.interactabel.*;
import org.game.model.game.elements.nonInteractabel.Wall;
import org.game.model.game.map.Map;
import org.game.model.game.map.MapLoader;
import org.game.rpg_rules.Loader;
import org.game.rpg_rules.dialogue.Dialogue;
import org.game.rpg_rules.dialogue.LoaderDialogo;
import org.game.rpg_rules.status.Atributos;
import org.game.rpg_rules.status.ataque.Ataque;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.w3c.dom.ls.LSInput;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class TesteMapLoader {
    private List<Dialogue> dialoguesSign;
    private List<Dialogue> dialoguesNpc;
    private List<String> lines;

    @BeforeEach
    public void Helper(){
        Dialogue dialogue_1 = new Dialogue("npc_1");
        Dialogue dialogue_2 = new Dialogue("npc_2");
        Dialogue dialogue_3 = new Dialogue("sign_1");
        Dialogue dialogue_4 = new Dialogue("sign_2");

        this.dialoguesNpc = Arrays.asList(dialogue_1, dialogue_2);
        this.dialoguesSign = Arrays.asList(dialogue_3, dialogue_4);

        String string_1 = "ºº###H";
        String string_2 = "NNDDSS";
        String string_3 = "CCTT";

        this.lines = Arrays.asList(string_1, string_2, string_3);
    }

    @Test
    public void TesteCreateMap() throws IOException {
        Hero heroMock = Mockito.mock(Hero.class);

        LoaderDialogo loaderDialogoSignMock = Mockito.mock(LoaderDialogo.class);
        Mockito.when(loaderDialogoSignMock.renderDialogue(Mockito.anyString())).thenReturn(dialoguesSign);

        LoaderDialogo loaderDialogoNPCMock = Mockito.mock(LoaderDialogo.class);
        Mockito.when(loaderDialogoNPCMock.renderDialogue(Mockito.anyString())).thenReturn(dialoguesNpc);

        Loader loaderMock = Mockito.mock(Loader.class);
        Mockito.when(loaderMock.getLines()).thenReturn(lines);

        MapLoader mapLoader = new MapLoader(heroMock, loaderMock, loaderDialogoSignMock, loaderDialogoNPCMock);
        Map teste = mapLoader.createMap(heroMock, new Map(6, 3, heroMock));

        List<Bossy> bossies = teste.getBossy();

        Assertions.assertEquals(0, bossies.get(0).getPosition().getX());
        Assertions.assertEquals(0, bossies.get(0).getPosition().getY());
        Assertions.assertEquals(1, bossies.get(1).getPosition().getX());
        Assertions.assertEquals(0, bossies.get(1).getPosition().getY());

        List<Wall> walls = teste.getWalls();

        Assertions.assertEquals(2, walls.get(0).getPosition().getX());
        Assertions.assertEquals(0, walls.get(0).getPosition().getY());
        Assertions.assertEquals(3, walls.get(1).getPosition().getX());
        Assertions.assertEquals(0, walls.get(1).getPosition().getY());
        Assertions.assertEquals(4, walls.get(2).getPosition().getX());
        Assertions.assertEquals(0, walls.get(2).getPosition().getY());
        Assertions.assertEquals("The hero glazes the wall intensely", walls.get(0).getDialogue().getTitle());
        Assertions.assertEquals("The hero glazes the wall intensely", walls.get(1).getDialogue().getTitle());
        Assertions.assertEquals("The hero glazes the wall intensely", walls.get(2).getDialogue().getTitle());

        List<NPC> npcs = teste.getNPC();

        Assertions.assertEquals(0, npcs.get(0).getPosition().getX());
        Assertions.assertEquals(1, npcs.get(0).getPosition().getY());
        Assertions.assertEquals(1, npcs.get(1).getPosition().getX());
        Assertions.assertEquals(1, npcs.get(1).getPosition().getY());
        Assertions.assertEquals("npc_1", npcs.get(0).getDialogue().getTitle());
        Assertions.assertEquals("npc_2", npcs.get(1).getDialogue().getTitle());

        List<Door> doors = teste.getDoors();

        Assertions.assertEquals(2, doors.get(0).getPosition().getX());
        Assertions.assertEquals(1, doors.get(0).getPosition().getY());
        Assertions.assertEquals(3, doors.get(1).getPosition().getX());
        Assertions.assertEquals(1, doors.get(1).getPosition().getY());
        Assertions.assertEquals("Uma porta. Abrir?", doors.get(0).getDialogue().getTitle());
        Assertions.assertEquals("Uma porta. Abrir?", doors.get(1).getDialogue().getTitle());


        List<Stairs> stairs = teste.getStairs();

        Assertions.assertEquals(4, stairs.get(0).getPosition().getX());
        Assertions.assertEquals(1, stairs.get(0).getPosition().getY());
        Assertions.assertEquals(5, stairs.get(1).getPosition().getX());
        Assertions.assertEquals(1, stairs.get(1).getPosition().getY());
        Assertions.assertEquals("Umas escadas. Subir?", stairs.get(0).getDialogue().getTitle());
        Assertions.assertEquals("Umas escadas. Subir?", stairs.get(1).getDialogue().getTitle());

        List<Chest> chests = teste.getChests();

        Assertions.assertEquals(0, chests.get(0).getPosition().getX());
        Assertions.assertEquals(2, chests.get(0).getPosition().getY());
        Assertions.assertEquals(1, chests.get(1).getPosition().getX());
        Assertions.assertEquals(2, chests.get(1).getPosition().getY());
        Assertions.assertEquals("An open chest", chests.get(0).getDialogue().getTitle());
        Assertions.assertEquals("An open chest", chests.get(1).getDialogue().getTitle());

        List<Sign> signs = teste.getSigns();

        Assertions.assertEquals(2, signs.get(0).getPosition().getX());
        Assertions.assertEquals(2, signs.get(0).getPosition().getY());
        Assertions.assertEquals(3, signs.get(1).getPosition().getX());
        Assertions.assertEquals(2, signs.get(1).getPosition().getY());
        Assertions.assertEquals("sign_1", signs.get(0).getDialogue().getTitle());
        Assertions.assertEquals("sign_2", signs.get(1).getDialogue().getTitle());

        verify(loaderMock, times(1)).getLines();
        verify(loaderDialogoSignMock, times(1)).renderDialogue(Mockito.anyString());
        verify(loaderDialogoNPCMock, times(1)).renderDialogue(Mockito.anyString());

    }
}
