package org.game.model.game.battle;

import org.game.model.game.elements.Hero;
import org.game.rpg_elements.status.ataque.Ataque;
import org.game.rpg_elements.status.ataque.Formula_Dano;
import org.game.rpg_elements.Inimigos.Monster;
import org.game.rpg_elements.Inimigos.Monster_Pool;

import java.io.IOException;
import java.util.*;

public class Battle {
    private Queue<Individuo> vez_ataque;

    private Party party;
    private List<Monster> monster;
    public Battle(Party party, int floor) throws IOException {
        this.party = party;
        this.monster = new Monster_Pool(floor).Generate_Monster();
    }

    public void starTurn(){
        createPriorityQueue();

        while(!vez_ataque.isEmpty()){
            if(vez_ataque.peek().getType() == 'm'){
                Monster_Turn((Monster) vez_ataque.peek(), party);
            }
            else{
                Hero_Turn((Hero) vez_ataque.peek(), monster);
            }

            vez_ataque.remove();
        }
    }

    private void createPriorityQueue(){
        List<Individuo> merge = new ArrayList<>();

        merge.addAll(this.party.getParty());
        merge.addAll(this.monster);

        Collections.sort(merge, new Comparator<Individuo>() {
            @Override
            public int compare(Individuo a, Individuo b) {
                return a.getStatus().getAtributos().getVelocidade() - b.getStatus().getAtributos().getVelocidade();
            }
        });

        this.vez_ataque = new ArrayDeque<>(merge);
    }

    private void Hero_Turn(Hero hero, List<Monster> monster){
        String player_choice = "atacar";

        if(player_choice == "atacar"){
            int num_target = 0;
            int ataque_choice = 0;

            Monster target = monster.get(num_target);
            Ataque ataque = hero.getStatus().getAtaques_fisicos().get(ataque_choice);

            Monster new_one = Hero_Attack_Turn(hero, ataque, target);
            monster.set(num_target, new_one);
        }
        else if(player_choice == "magic"){
            int num_target = 0;
            int ataque_choice = 0;

            Monster target = monster.get(num_target);
            Ataque ataque = hero.getStatus().getAtaques_magicos().get(ataque_choice);

            Monster new_one = Hero_Attack_Turn(hero, ataque, target);
            monster.set(num_target, new_one);

            Hero new_hero = hero;
            new_hero.mana_usada(ataque);

            party.remove_hero(hero);
            party.add_hero(new_hero);

        } else if (player_choice == "item") {


        } else if (player_choice == "run") {


        }
    }

    private Monster Hero_Attack_Turn(Hero hero, Ataque ataque, Monster target){
            int dano = new Formula_Dano().Dano(ataque, hero.getStatus().getAtributos(), target.getStatus().getAtributos().getVelocidade());
            target.dano_recebido(dano);

            return target;
    }

    private void Monster_Turn(Monster monster, Party party){
        int monster_target = 0;
        String monster_choice = "atacar";

        if(monster_choice == "atacar"){
            Hero target = party.getParty().get(monster_target);
            Hero new_one = Monster_Attack_Turn(monster, target);

            party.set_hero(monster_target, new_one);
        }
    }

    private Hero Monster_Attack_Turn(Monster monster, Hero target){
        Random rand = new Random();
        int num_rand = rand.nextInt(monster.getStatus().getAtaques().size());

        Ataque at = monster.getStatus().getAtaques().get(num_rand);
        target.dano_recebido(new Formula_Dano().Dano(at, monster.getStatus().getAtributos(), target.getStatus().getAtributos().getVelocidade()));

        return target;
    }

}
