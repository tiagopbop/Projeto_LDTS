package org.game.model.game.battle;

import org.game.model.Position;
import org.game.model.game.elements.Hero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MagicMenu extends BattleMenu{

    private final List<String> entries;
    private int currentEntry;

    private Hero hero;

    public MagicMenu(Hero hero, Battle battle) {
        super(hero, battle);

        entries = new ArrayList<>();
        for(int i =0; i < hero.getStatus().getAtaques_fisicos().size(); i++)
        {
            this.entries.add(hero.getStatus().getAtaques_magicos().get(i).getNome());

        }
        this.currentEntry = 0;
        this.hero  = hero;
    }





    public String getEntry(int i) {
        return entries.get(i);
    }





    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Hero getHero() {
        return hero;
    }
}
