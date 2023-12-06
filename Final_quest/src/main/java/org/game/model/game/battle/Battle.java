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
    private String player_option;
    private Integer int_list;
    private Party party;
    private List<Monster> monster;
    public Battle(Party party, int floor) throws IOException {
        this.party = party;
        this.monster = new Monster_Pool(floor).Generate_Monster();
        this.player_option = "atacar";
        this.int_list = 0;
    }

    public void setPlayer_option(String player_option) {
        this.player_option = player_option;
    }

    public void setInt_list(Integer int_list) {
        this.int_list = int_list;
    }

    public int starTurn(){
        createPriorityQueue();

        while(!vez_ataque.isEmpty()){
            if(vez_ataque.peek().getType() == 'm'){
                Monster_Turn((Monster) vez_ataque.peek(), party);
                if(party.getParty().get(0).getStatus().getVida_atual() == 0){
                    return 1;
                }
            }
            else{
                Hero_Turn((Hero) vez_ataque.peek(), monster);
                if(fainted_monster()){
                    return 2;
                }
            }

            vez_ataque.remove();
        }
        return 0;
    }

    public void generate_loot(){

    }

    private boolean fainted_monster(){
        boolean res = true;
        for(Monster monster1 : monster){
            if(monster1.getStatus().getVida_atual() > 0){
                res = false;
            }
            else{
                monster.remove(monster1);
            }
        }
        return res;
    }

    private boolean fainted_hero(){
        boolean res = true;
        for(Hero hero : party.getParty()){
            if(hero.getStatus().getVida_atual() > 0){
                res = false;
            }
            else{
                party.remove_hero(hero);
            }
        }
        return res;
    }

    private void createPriorityQueue(){
        List<Individuo> merge = new ArrayList<>();

        merge.addAll(this.party.getParty());
        merge.addAll(this.monster);

        Collections.sort(merge, new Comparator<Individuo>() {
            @Override
            public int compare(Individuo a, Individuo b) {
                return a.getStatus().getAtributos_atualizados().getVelocidade() - b.getStatus().getAtributos_atualizados().getVelocidade();
            }
        });

        this.vez_ataque = new ArrayDeque<>(merge);
    }

    private void Hero_Turn(Hero hero, List<Monster> monster){
        String player_choice = player_option;
        int ataque_choice = int_list;

        if(player_choice == "atacar"){
            int num_target = 0;


            Monster target = monster.get(num_target);
            Ataque ataque = hero.getStatus().getAtaques_fisicos().get(ataque_choice);

            Monster new_one = Hero_Attack_Turn(hero, ataque, target);
            monster.set(num_target, new_one);
        }
        else if(player_choice == "magic"){
            int num_target = 0;

            Monster target = monster.get(num_target);
            Ataque ataque = hero.getStatus().getAtaques_magicos().get(ataque_choice);

            Monster new_one = Hero_Attack_Turn(hero, ataque, target);
            monster.set(num_target, new_one);

            Hero new_hero = hero;
            new_hero.getStatus().mana_usada(ataque);

            party.remove_hero(hero);
            party.add_hero(new_hero);

        } else if (player_choice == "item") {


        } else if (player_choice == "run") {


        }
    }

    private Monster Hero_Attack_Turn(Hero hero, Ataque ataque, Monster target){
            int dano = new Formula_Dano().Dano(ataque, hero.getStatus().getAtributos_atualizados(), target.getStatus().getAtributos_atualizados().getVelocidade());
            target.getStatus().dano_recebido(dano);

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
        target.getStatus().dano_recebido(new Formula_Dano().Dano(at, monster.getStatus().getAtributos_atualizados(), target.getStatus().getAtributos_atualizados().getVelocidade()));

        return target;
    }

}
