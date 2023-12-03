package org.game.rpg_elements.Inimigos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Monster_Pool {
    private static final List<String> monster_pool = new ArrayList<>();

    public Monster_Pool(int floor){
        switch (floor){
            case (1):{
                monster_pool.add("1");
                monster_pool.add("2");
                break;
            }
        }
    }

    public List<Monster> Generate_Monster() throws IOException {
        List<Monster> monsters = new ArrayList<>();

        Random rand = new Random();
        int num_rand = rand.nextInt(monster_pool.size());

        monsters.add(new Monster(monster_pool.get(num_rand)));

        return monsters;
    }

}
