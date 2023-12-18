package org.game.rpg_elements.status.statusCommands;

import org.game.rpg_elements.itens.Item;
import org.game.rpg_elements.itens.inventario.Equipado;
import org.game.rpg_elements.status.Status;
import org.game.rpg_elements.status.StatusCommander;

import java.io.IOException;
import java.util.Map;

public class Atualizar_Equipado extends StatusCommander {
    private Equipado equipamentos;
    private boolean flag;

    public Atualizar_Equipado(Status status, Equipado equipamentos, boolean flag) throws IOException {
        super(status);
        this.equipamentos = equipamentos;
        this.flag = flag;
    }

    @Override
    public void execute() throws IOException {
        status.setAtributos_atualizados(status.getAtributos_real());

        atualizar_equipamento(equipamentos.getCapacete(), flag);
        atualizar_equipamento(equipamentos.getPeitoral(), flag);
        atualizar_equipamento(equipamentos.getCalcas(), flag);

        if(status.getAtributos_atualizados().getVida() < status.getVida_atual()){
            status.setVida_atual(status.getAtributos_atualizados().getVida());
        }

        if(status.getAtributos_atualizados().getMana() < status.getMana_atual()){
            status.setMana_atual(status.getAtributos_atualizados().getMana());
        }
    }

    private void atualizar_equipamento(Item item, boolean flag){
        Map<String, Integer> efeitos = item.getEfeitos();

        for(Map.Entry<String, Integer> entry : efeitos.entrySet()){
            if(entry.getKey().equals("vida")){
                status.getAtributos_atualizados().add_vida(entry.getValue());
                if(flag){
                    status.setVida_atual(status.getVida_atual() + entry.getValue());
                }
            }
            else if(entry.getKey().equals("mana")){
                status.getAtributos_atualizados().add_mana(entry.getValue());
                if(flag){
                    status.setMana_atual(status.getMana_atual() + entry.getValue());
                }
            }
            else if(entry.getKey().equals("forca")){
                status.getAtributos_atualizados().add_forca(entry.getValue());
            }
            else if(entry.getKey().equals("inteligencia")){
                status.getAtributos_atualizados().add_inteligencia(entry.getValue());
            }
            else if(entry.getKey().equals("velocidade")){
                status.getAtributos_atualizados().add_velocidade(entry.getValue());
            }

        }
    }
}
