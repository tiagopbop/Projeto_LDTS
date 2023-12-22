package org.game.rpg_rules.Inimigos;

import org.game.model.battle.battleElements.Individuo;
import org.game.rpg_rules.Inimigos.variantes.Dracky_Variante;
import org.game.rpg_rules.Inimigos.variantes.Skeleton_Variante;
import org.game.rpg_rules.Inimigos.variantes.Slime_Variante;
import org.game.rpg_rules.Inimigos.variantes.Spider_Variante;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Monster_Pool {
    private  List<String> monster_pool = new ArrayList<>();

    public Monster_Pool(int floor){
        switch (floor){
            case (1):{
                monster_pool.add("1");
                monster_pool.add("2");
                break;
            }
            case (2):{
                monster_pool.add("3");
                monster_pool.add("4");
                break;
            }

        }
    }
    public List<Individuo> Generate_Boss() throws IOException {
        List<Individuo> indi = new ArrayList<>();
        indi.add(new Boss());
        return indi;
    }

    public List<Individuo> Generate_Monster() throws IOException {
        List<Individuo> monsters = new ArrayList<>();

        Random rand_1 = new Random();
        int num_rand = rand_1.nextInt(monster_pool.size());

        Monster monster = new Monster(monster_pool.get(num_rand));

        Random rand_2 = new Random();
        int num_var = rand_2.nextInt(2);

        if(num_var == 1){
            if(monster.getStatus().getNome().equals("slime")){
                MonsterDecorator d = new Slime_Variante(monster);
                d.Assembler();
            } else if (monster.getStatus().getNome().equals("dracky")) {
                MonsterDecorator d = new Dracky_Variante(monster);
                d.Assembler();
            }
            else if (monster.getStatus().getNome().equals("skeleton")) {
                MonsterDecorator d = new Skeleton_Variante(monster);
                d.Assembler();
            }
            else if (monster.getStatus().getNome().equals("spider")) {
                MonsterDecorator d = new Spider_Variante(monster);
                d.Assembler();
            }

        }

        monsters.add(monster);

        return monsters;
    }

    public Boss generateBoss() throws IOException {
        Boss boss = new Boss();
        return boss;
    }

}
