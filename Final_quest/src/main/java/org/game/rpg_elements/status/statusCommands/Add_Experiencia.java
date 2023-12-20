package org.game.rpg_elements.status.statusCommands;

import org.game.rpg_elements.status.Status;
import org.game.rpg_elements.status.StatusCommander;

import java.io.IOException;

public class Add_Experiencia extends StatusCommander {
    private int experiencia;
    private boolean res;

    public Add_Experiencia(Status status, int experiencia) throws IOException {
        super(status);
        this.experiencia = experiencia;
    }

    @Override
    public void execute() throws IOException {
        if(status.getExperiencia() + experiencia >= status.getAtributos_atualizados().exp_level_up()){
            this.status.setExperiencia(status.getExperiencia() + experiencia - status.getAtributos_atualizados().exp_level_up());
            this.res = true;
        }
        else{
            this.status.setExperiencia(status.getExperiencia() + experiencia);
            this.res = false;
        }
    }

    public boolean getRes(){
        return this.res;
    }
}
