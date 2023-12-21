package org.game.rpg_rules.Inimigos;

import org.game.model.battle.battleElements.Individuo;
import org.game.rpg_rules.status.Status;

public abstract class MonsterDecorator implements Individuo{
   private Individuo individuo;

   public MonsterDecorator(Individuo individuo){
       this.individuo = individuo;
   }
    @Override
    public boolean getEstado_batalha(){
        return individuo.getEstado_batalha();
    }

    @Override
    public Character getType(){
       return individuo.getType();
    }
    @Override
    public Status  getStatus(){
       return individuo.getStatus();
    }
    @Override
    public void setEstado_batalha(boolean estado_batalha){
       individuo.setEstado_batalha(estado_batalha);
    }

    @Override
    public void setStatus(Status status){
       this.individuo.setStatus(status);
    }

    public abstract void Assembler();

    public Individuo getIndividuo() {
        return individuo;
    }

    public void setIndividuo(Individuo individuo) {
        this.individuo = individuo;
    }
}
