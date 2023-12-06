package totest;

import org.game.model.dialogue.Dialogue;
import org.game.model.game.elements.*;
import org.game.model.game.map.Village;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TesteColisoes {

    private Dialogue n = new Dialogue();
    private Wall wall1;
    private Wall wall2;

    private Hero hero;

    private List<Wall> walls;
    private List<Sign> signs = new ArrayList<>();
    private  List<Chest> chests = new ArrayList<>();
    private List<NPC> NPC = new ArrayList<>();
    private List<Door> doors = new ArrayList<>();
    private List<Stairs> stairs = new ArrayList<>();

    @BeforeEach
    public void Helper() throws IOException {
        walls = new ArrayList<>();

        wall1 = new Wall(5,3, n, "", 'b', "", "");
        wall2 = new Wall(6,4, n, "", 'b', "", "");

        walls.add(wall1);
        walls.add(wall2);

        hero = new Hero(6,3, n, "", 'a', "", "");


    }

    @Test
    public void TesteColisoes1() throws IOException {

        Village teste = new Village(7, 7, walls, NPC, doors, stairs, signs, chests);

        Assertions.assertEquals(true, teste.isEmpty(hero.getHeroElement().getPosition().getUp()));
        Assertions.assertEquals(false, teste.isEmpty(hero.getHeroElement().getPosition().getLeft()));
        Assertions.assertEquals(false, teste.isEmpty(hero.getHeroElement().getPosition().getDown()));
        Assertions.assertEquals(true, teste.isEmpty(hero.getHeroElement().getPosition().getRight()));
    }
}
