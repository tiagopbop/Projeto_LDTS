package org.game.model.battle.battleElements;

import org.game.model.battle.battleElements.Hero;

import java.util.ArrayList;
import java.util.List;

public class Party {
    private List<Hero> party = new ArrayList<>();

    public Party(List<Hero> party){
        this.party.addAll(party);
    }

    public Party(Hero hero){this.party.add(hero);}
    public void add_hero(Hero hero){
        this.party.add(hero);
    }

    public void remove_hero(Hero hero){
        this.party.remove(hero);
    }

    public void set_hero(int position, Hero hero){
        this.party.set(position, hero);
    }

    public List<Hero> getParty() {
        return party;
    }
}
