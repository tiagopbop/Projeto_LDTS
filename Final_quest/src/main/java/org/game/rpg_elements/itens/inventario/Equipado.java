package org.game.rpg_elements.itens.inventario;

import org.game.rpg_elements.itens.Equipamento;

public class Equipado {
    private Equipamento capacete;
    private Equipamento peitoral;
    private Equipamento calcas;

    public Equipado(Equipamento capacete, Equipamento peitoral, Equipamento calcas){
        this.capacete = capacete;
        this.peitoral = peitoral;
        this.calcas = calcas;
    }

    public Equipamento getCapacete() {
        return capacete;
    }

    public Equipamento getPeitoral() {
        return peitoral;
    }

    public Equipamento getCalcas() {
        return calcas;
    }

    public void setCapacete(Equipamento capacete) {
        this.capacete = capacete;
    }

    public void setPeitoral(Equipamento peitoral) {
        this.peitoral = peitoral;
    }

    public void setCalcas(Equipamento calcas) {
        this.calcas = calcas;
    }
}
