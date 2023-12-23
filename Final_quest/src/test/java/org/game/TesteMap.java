package org.game;

import org.game.model.Position;
import org.game.model.battle.battleElements.Hero;
import org.game.model.game.elements.interactabel.*;
import org.game.model.game.elements.nonInteractabel.Wall;
import org.game.model.game.map.Map;
import org.game.rpg_rules.dialogue.Dialogue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TesteMap {
    private Integer width;
    private Integer height;
    private List<Wall> walls;
    private List<Sign> signs;
    private List<NPC> npcs;
    private List<Stairs> stairs;
    private List<Door> doors;
    private List<Chest> chests;
    private List<Bossy> bossies;

    @BeforeEach
    public void Helper(){
        this.width = 30;
        this.height = 40;

        Wall wall_1 = new Wall(5,5, new Dialogue("wall_1"), "#", 'k', "k", "j");
        Wall wall_2 = new Wall(5,6, new Dialogue("wall_2"), "#", 'k', "k", "j");

        walls = Arrays.asList(wall_1, wall_2);

        Sign sign_1 = new Sign(1,1, new Dialogue("sign_1"), "s", 'k', "k", "j");
        Sign sign_2 = new Sign(1,2, new Dialogue("sign_2"), "s", 'k', "k", "j");

        signs = Arrays.asList(sign_1,sign_2);

        NPC npc_1 = new NPC(3,3, new Dialogue("npc_1"), "s", 'k', "k", "j");
        NPC npc_2 = new NPC(3,4, new Dialogue("npc_2"), "s", 'k', "k", "j");

        npcs = Arrays.asList(npc_1, npc_2);

        Stairs stairs_1 = new Stairs(4,4, new Dialogue("stairs_1"), "s", 'k', "k", "j");
        Stairs stairs_2 = new Stairs(4,5, new Dialogue("stairs_2"), "s", 'k', "k", "j");

        stairs = Arrays.asList(stairs_1, stairs_2);

        Door door_1 = new Door(2,2, new Dialogue("door_1"), "s", 'k', "k", "j");
        Door door_2 = new Door(2,3, new Dialogue("door_2"), "s", 'k', "k", "j");

        doors = Arrays.asList(door_1, door_2);

        Chest chest_1 = new Chest(6,6, new Dialogue("chest_1"), "s", 'k', "k", "j");
        Chest chest_2 = new Chest(6,7, new Dialogue("chest_2"), "s", 'k', "k", "j");

        chests = Arrays.asList(chest_1, chest_2);

        Bossy bossy_1 = new Bossy(7,7, new Dialogue("bossy_1"), "s", 'k', "k", "j");
        Bossy bossy_2 = new Bossy(7,8, new Dialogue("bossy_2"), "s", 'k', "k", "j");

        bossies = Arrays.asList(bossy_1, bossy_2);
    }

    @Test
    public void TesteIsEmpty() {
        Hero hero = Mockito.mock(Hero.class);

        Map map = new Map(this.width, this.height,hero);
        map.setWalls(this.walls);
        map.setNPC(npcs);
        map.setStairs(stairs);
        map.setDoors(doors);
        map.setSigns(signs);
        map.setChests(chests);
        map.setBossy(bossies);

        Assertions.assertTrue(map.isEmpty(new Position(6, 5)));
        Assertions.assertTrue(map.isEmpty(new Position(1, 4)));
        Assertions.assertTrue(map.isEmpty(new Position(9, 7)));
        Assertions.assertTrue(map.isEmpty(new Position(3, 2)));

        Assertions.assertFalse(map.isEmpty(new Position(1, 1)));
        Assertions.assertFalse(map.isEmpty(new Position(1, 2)));

        Assertions.assertFalse(map.isEmpty(new Position(2, 2)));
        Assertions.assertFalse(map.isEmpty(new Position(2, 3)));

        Assertions.assertFalse(map.isEmpty(new Position(3, 3)));
        Assertions.assertFalse(map.isEmpty(new Position(3, 4)));

        Assertions.assertFalse(map.isEmpty(new Position(4, 4)));
        Assertions.assertFalse(map.isEmpty(new Position(4, 5)));

        Assertions.assertFalse(map.isEmpty(new Position(5, 5)));
        Assertions.assertFalse(map.isEmpty(new Position(5, 6)));

        Assertions.assertFalse(map.isEmpty(new Position(6, 6)));
        Assertions.assertFalse(map.isEmpty(new Position(6, 7)));

        Assertions.assertFalse(map.isEmpty(new Position(7, 7)));
        Assertions.assertFalse(map.isEmpty(new Position(7, 8)));

    }

    @Test
    public void TestIsInteractable(){
        Hero hero = Mockito.mock(Hero.class);

        Map map = new Map(this.width, this.height,hero);
        map.setWalls(this.walls);
        map.setNPC(npcs);
        map.setStairs(stairs);
        map.setDoors(doors);
        map.setSigns(signs);
        map.setChests(chests);
        map.setBossy(bossies);

        Assertions.assertEquals("sign_1", map.isInteractable(new Position(1,1)).getTitle());
        Assertions.assertEquals("sign_2", map.isInteractable(new Position(1,2)).getTitle());

        Assertions.assertEquals("door_1", map.isInteractable(new Position(2,2)).getTitle());
        Assertions.assertEquals("door_2", map.isInteractable(new Position(2,3)).getTitle());

        Assertions.assertEquals("npc_1", map.isInteractable(new Position(3,3)).getTitle());
        Assertions.assertEquals("npc_2", map.isInteractable(new Position(3,4)).getTitle());

        Assertions.assertEquals("stairs_1", map.isInteractable(new Position(4,4)).getTitle());
        Assertions.assertEquals("stairs_2", map.isInteractable(new Position(4,5)).getTitle());

        Assertions.assertEquals("wall_1", map.isInteractable(new Position(5,5)).getTitle());
        Assertions.assertEquals("wall_2", map.isInteractable(new Position(5,6)).getTitle());

        Assertions.assertEquals("chest_1", map.isInteractable(new Position(6,6)).getTitle());
        Assertions.assertEquals("chest_2", map.isInteractable(new Position(6,7)).getTitle());

        Assertions.assertEquals("bossy_1", map.isInteractable(new Position(7,7)).getTitle());
        Assertions.assertEquals("bossy_2", map.isInteractable(new Position(7,8)).getTitle());

    }

    @Test
    public void TesteIsInteractableChest(){
        Hero hero = Mockito.mock(Hero.class);

        Map map = new Map(this.width, this.height,hero);
        map.setWalls(this.walls);
        map.setNPC(npcs);
        map.setStairs(stairs);
        map.setDoors(doors);
        map.setSigns(signs);
        map.setChests(chests);
        map.setBossy(bossies);

        Assertions.assertFalse(map.isInteractableChest(new Position(7, 7)));
        Assertions.assertFalse(map.isInteractableChest(new Position(1, 1)));
        Assertions.assertFalse(map.isInteractableChest(new Position(3, 3)));
        Assertions.assertFalse(map.isInteractableChest(new Position(4, 4)));

        Assertions.assertTrue(map.isInteractableChest(new Position(6, 6)));
        Assertions.assertTrue(map.isInteractableChest(new Position(6, 7)));
    }


}
