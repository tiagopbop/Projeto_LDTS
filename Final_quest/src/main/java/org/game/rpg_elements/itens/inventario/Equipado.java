package org.game.rpg_elements.itens.inventario;

import org.game.rpg_elements.itens.Item;

public class Equipado {
    private Item capacete;
    private Item peitoral;
    private Item calcas;

    public Equipado(){
        this.capacete = null;
        this.peitoral = null;
        this.calcas = null;
    }
    public Equipado(Item capacete, Item peitoral, Item calcas){
        this.capacete = capacete;
        this.peitoral = peitoral;
        this.calcas = calcas;
    }

    public Item getCapacete() {
        return capacete;
    }

    public Item getPeitoral() {
        return peitoral;
    }

    public Item getCalcas() {
        return calcas;
    }

    public void setCapacete(Item capacete) {
        this.capacete = capacete;
    }

    public void setPeitoral(Item peitoral) {
        this.peitoral = peitoral;
    }

    public void setCalcas(Item calcas) {
        this.calcas = calcas;
    }
}
