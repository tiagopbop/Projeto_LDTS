package org.game.rpg_elements.status;

public class Atributos {
    private int level;
    private int vida;
    private int mana;
    private int forca;
    private int inteligencia;
    private int velocidade;

    public Atributos(int level, int vida, int mana, int forca, int inteligencia, int velocidade){
        this.level = level;
        this.vida = vida;
        this.mana = mana;
        this.forca = forca;
        this.inteligencia = inteligencia;
        this.velocidade = velocidade;
    }

    public int getLevel() {
        return level;
    }

    public int getVida() {
        return vida;
    }

    public int getMana() {
        return mana;
    }

    public int getForca() {
        return forca;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void add_vida(int n){
        this.vida += n;
    }

    public void add_mana(int n){
        this.mana += n;
    }

    public void add_forca(int n){
        this.forca += n;
    }

    public void add_inteligencia(int n){
        this.inteligencia += n;
    }

    public void add_velocidade(int n){
        this.velocidade += n;
    }

    public void remove_vida(int n){
        if(this.vida - n >= 0){
            this.vida -= n;
        }
        else{
            this.vida = 0;
        }
    }

    public void remove_mana(int n){
        if(this.mana - n >= 0){
            this.mana -= n;
        }
        else{
            this.mana = 0;
        }
    }

    public void remove_forca(int n){
        if(this.forca - n >= 0){
            this.forca -= n;
        }
        else{
            this.forca = 0;
        }
    }

    public void remove_inteligencia(int n){
        if(this.inteligencia - n >= 0){
            this.inteligencia -= n;
        }
        else{
            this.inteligencia = 0;
        }
    }

    public void remove_velocidade(int n){
        if(this.velocidade - n >= 0){
            this.velocidade -= n;
        }
        else{
            this.velocidade = 0;
        }
    }

    public void add_level(int n){
        this.level += n;
    }

    public int exp_level_up(){
        return this.level * 20 + 100;
    }
}
