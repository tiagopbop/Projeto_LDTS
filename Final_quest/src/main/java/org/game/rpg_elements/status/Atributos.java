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

    public void add_level(int n){
        this.level += n;
    }
}
