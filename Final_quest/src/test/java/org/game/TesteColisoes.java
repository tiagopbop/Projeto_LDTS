/*package totest;


import org.game.model.battle.battleElements.Hero;
import org.game.model.game.elements.interactabel.*;
import org.game.model.game.elements.nonInteractabel.Wall;
import org.game.model.game.map.Map;
import org.game.rpg_rules.dialogue.Dialogue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TesteColisoes {

    private Wall wall1;
    private Wall wall2;

    private Hero hero;

    private List<Wall> walls;
    private List<Sign> signs = new ArrayList<>();
    private  List<Chest> chests = new ArrayList<>();
    private List<NPC> npc = new ArrayList<>();
    private List<Door> doors = new ArrayList<>();
    private List<Stairs> stairs = new ArrayList<>();
    private List<Bossy> bossies = new ArrayList<>();

    @BeforeEach
   public void Helper() throws IOException {
        walls = new ArrayList<>();

        wall1 = new Wall(5,3, new Dialogue(), "", 'b', "", "");
        wall2 = new Wall(6,4, new Dialogue(), "", 'b', "", "");

        walls.add(wall1);
        walls.add(wall2);

        hero = new Hero(6,3, new Dialogue(),'s',"","" );


    }

    @Test
    public void TesteColisoes1() throws IOException {

        Map teste = new Map(7, 7, walls, npc, doors, stairs, signs, chests, bossies);

        Assertions.assertEquals(true, teste.isEmpty(hero.getHeroElement().getPosition().getUp()));
        Assertions.assertEquals(false, teste.isEmpty(hero.getHeroElement().getPosition().getLeft()));
        Assertions.assertEquals(false, teste.isEmpty(hero.getHeroElement().getPosition().getDown()));
        Assertions.assertEquals(true, teste.isEmpty(hero.getHeroElement().getPosition().getRight()));
    }
}
*/