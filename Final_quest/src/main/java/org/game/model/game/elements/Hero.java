package org.game.model.game.elements;

public class Hero extends Element{
    private int hp;

    public Hero(int x, int y){
        super(x, y);
        this.hp = 10;
    }

    public void decreaseEnergy(){
        this.hp--;
    }

    public int getHp(){
        return hp;
    }
}
