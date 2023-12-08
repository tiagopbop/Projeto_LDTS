package org.game.model.game.battle;

import org.game.model.game.elements.Element;
import org.game.model.game.elements.Hero;
import org.game.rpg_elements.itens.Item;
import org.game.rpg_elements.itens.LoaderItem;
import org.game.rpg_elements.status.Drop;
import org.game.rpg_elements.status.LoaderDrop;
import org.game.rpg_elements.status.ataque.Ataque;
import org.game.rpg_elements.status.ataque.Formula_Dano;
import org.game.rpg_elements.Inimigos.Monster;
import org.game.rpg_elements.Inimigos.Monster_Pool;

import java.io.IOException;
import java.util.*;

public class Battle {
    private Item player_item;
    private Queue<Individuo> vez_ataque;
    private String player_option;
    private Integer int_list;
    private Party party;
    private List<Monster> monster;

    private List<Element> pepe;
    public Battle(Party party, int floor) throws IOException {
        this.party = party;
        this.monster = new Monster_Pool(floor).Generate_Monster();

        this.player_option = "atacar";
        this.int_list = 0;
        this.player_item = new LoaderItem().renderConsumivel("1");
    }

    public void setPlayer_item(Item player_item) {
        this.player_item = player_item;
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

                if(!fainted_hero()){
                    if(all_hero_fainted()){
                        return 0;
                    }
                }
            }
            else{
                Hero_Turn((Hero) vez_ataque.peek(), monster);

                if(!fainted_monster()){
                    if(all_monster_fainted()){
                        return 2;
                    }
                }
            }
            vez_ataque.remove();
        }
        return 1;
    }

    private boolean all_monster_fainted(){
        for(Monster monster1: monster){
            if(monster1.getEstado_batalha()){
                return false;
            }
        }
        return true;
    }

    private boolean all_hero_fainted(){
        for(Hero hero: party.getParty()){
            if(hero.getEstado_batalha()){
                return false;
            }
        }
        return true;
    }

    public boolean generate_loot(Integer dinheiro, Integer xp, List<Item> items) throws IOException {
        List<Drop> drops = new ArrayList<>();
        boolean level_up = false;

        for(Monster monster1: monster){
            Drop drop = new LoaderDrop().renderDrop(monster1.getStatus().getNome());
            level_up = party.getParty().get(0).add_drop(drop, dinheiro, xp, items);
        }
        return level_up;
    }

    private boolean fainted_monster(){
        boolean res = false;
        for(Monster monster1 : monster){
            if(monster1.getStatus().getVida_atual() < 0 && monster1.getEstado_batalha()){
                monster1.setEstado_batalha(false);
            }
            else{
                res = true;
            }
        }
        return res;
    }

    private boolean fainted_hero(){
        boolean res = false;

        for(Hero hero : party.getParty()){
            if((hero.getStatus().getVida_atual() < 0) && hero.getEstado_batalha()){
                hero.setEstado_batalha(false);
            }
            else{
                res = true;
            }
        }
        return res;
    }

    private void createPriorityQueue(){
        List<Individuo> merge = new ArrayList<>();

        List<Hero> t_hero = new ArrayList<>();
        List<Monster> t_monster = new ArrayList<>();

        for(Monster monster1: monster){
            if(monster1.getEstado_batalha()){
                t_monster.add(monster1);
            }
        }
        for(Hero hero: party.getParty()){
            if(hero.getEstado_batalha()){
                t_hero.add(hero);
            }
        }

        merge.addAll(t_hero);
        merge.addAll(t_monster);

        Collections.sort(merge, new Comparator<Individuo>() {
            @Override
            public int compare(Individuo a, Individuo b) {
                return - a.getStatus().getAtributos_atualizados().getVelocidade() + b.getStatus().getAtributos_atualizados().getVelocidade();
            }
        });

        this.vez_ataque = new ArrayDeque<>(merge);
    }

    private void Hero_Turn(Hero hero, List<Monster> monster){
        String player_choice = player_option;
        int int_player_choice = int_list;

        if(player_choice.equals("melee")){
            int num_target = 0;


            Monster target = monster.get(num_target);
            Ataque ataque = hero.getStatus().getAtaques_fisicos().get(int_player_choice);

            Monster new_one = Hero_Attack_Turn(hero, ataque, target);
            monster.set(num_target, new_one);
        }
        else if(player_choice.equals("magic")){
            int num_target = 0;

            Monster target = monster.get(num_target);
            Ataque ataque = hero.getStatus().getAtaques_magicos().get(int_player_choice);

            Monster new_one = Hero_Attack_Turn(hero, ataque, target);
            monster.set(num_target, new_one);

            Hero new_hero = hero;
            new_hero.getStatus().mana_usada(ataque);

            party.remove_hero(hero);
            party.add_hero(new_hero);

        } else if (player_choice.equals("item")) {
            Individuo target;
            hero.getHero_inventario().remove_consumivel(player_item);

            if(player_item.getType().equals("essencio")){
                target = monster.get(0);
            }
            else{
                target = party.getParty().get(0);
            }

            target.getStatus().usar_item(player_item);

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

        if(monster_choice.equals("atacar")){
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

    public void setElements(List<Element> pepe) {
        this.pepe = pepe;
    }


    public Monster getMonster() throws IOException {return this.monster.get(0);}

    public boolean pode_usar_ataque(int int_choice){
        int mana_atual = this.party.getParty().get(0).getStatus().getMana_atual();
        int mana_ataque = this.party.getParty().get(0).getStatus().getAtaques_magicos().get(int_choice).getCusto();

        if((mana_atual - mana_ataque) < 0){
            return false;
        }
        return true;
    }

}

