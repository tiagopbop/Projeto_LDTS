package org.game.rpg_elements;

public class Atributos {
    private int vida;
    private int mana;
    private int forca;
    private int inteligencia;
    private int velocidade;

    public Atributos(int vida, int mana, int forca, int inteligencia, int velocidade){
        this.vida = vida;
        this.mana = mana;
        this.forca = forca;
        this.inteligencia = inteligencia;
        this.velocidade = velocidade;
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

}
