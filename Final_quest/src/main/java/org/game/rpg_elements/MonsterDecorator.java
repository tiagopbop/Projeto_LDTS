package org.game.rpg_elements;

import org.game.rpg_elements.Inimigos.Monster;

import java.io.IOException;
import java.util.List;

public abstract class MonsterDecorator extends FactoryRPGElements<Monster> {
    private String monster_name;

    public MonsterDecorator(String monster_name){
        this.monster_name = monster_name;
    }

    public abstract Monster Assembler(Monster m);

    @Override
    public Monster createRPGelement(List<String> lines) throws IOException{
        Monster m = new Monster(monster_name);
        return Assembler(m);
    }
}
