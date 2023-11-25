package totest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Vector;

public class TestCollision {
    private  Character[][] stub_1;
    private  Character[][] stub_2;
    private  Character[][] stub_3;
    private WorldMap map_1;
    private WorldMap map_2;
    private WorldMap map_3;
    private String hero_last_pos1;
    private String hero_last_pos2;

    @BeforeEach
    public void Helper()
    {
        stub_1 = new Character[][]
        {
                {'X', 'X', 'X', 'X', 'X', 'X', 'X'},
                {'X', ' ', ' ', ' ', ' ', ' ', 'X'},
                {'X', ' ', ' ', ' ', ' ', ' ', 'X'},
                {'X', ' ', ' ', ' ', ' ', ' ', 'X'},
                {'X', ' ', ' ', 'H', ' ', ' ', 'X'},
                {'X', 'X', 'X', 'X', 'X', 'X', 'X'}
        };
        stub_2 = new Character[][]
                {
                        {'X', 'X', 'X', 'X', 'X', 'X', 'X'},
                        {'X', ' ', ' ', ' ', ' ', ' ', 'X'},
                        {'X', ' ', 'S', 'H', ' ', ' ', 'X'},
                        {'X', ' ', ' ', ' ', ' ', ' ', 'X'},
                        {'X', ' ', ' ', ' ', ' ', ' ', 'X'},
                        {'X', 'X', 'X', 'X', 'X', 'X', 'X'}
                };
        stub_3 = new Character[][]
                {
                        {'X', 'X', 'X', 'X', 'X', 'X', 'X'},
                        {'X', ' ', ' ', 'D', ' ', ' ', 'X'},
                        {'X', ' ', ' ', 'H', ' ', ' ', 'X'},
                        {'X', ' ', ' ', ' ', ' ', ' ', 'X'},
                        {'X', ' ', ' ', ' ', ' ', ' ', 'X'},
                        {'X', 'X', 'X', 'X', 'X', 'X', 'X'}
                };


        map_1 = new WorldMap(stub);
        map_2 = new WorldMap(stub);
        map_3 = new WorldMap(stub);
        hero_last_pos1 = "left";
        hero_last_pos2 = "up";
    }

    @Test
    public void TestCollision()
    {
        Assertions.assertEquals(true,map_1.heroCollision("up"));
        Assertions.assertEquals(false,map_1.heroCollision("down"));
        Assertions.assertEquals(true,map_1.heroCollision("left"));
        Assertions.assertEquals(true,map_1.heroCollision("right"));

        Assertions.assertEquals(true,map_2.objectCollision(hero_last_pos1));
        Assertions.assertEquals(false,map_2.objectCollision(hero_last_pos2));

        Assertions.assertEquals(true,map_3.objectCollision(hero_last_pos2));
        Assertions.assertEquals(false,map_3.objectCollision(hero_last_pos1));
    }


}
