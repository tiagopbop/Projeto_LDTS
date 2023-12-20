package org.game.rpg_elements.status.statusCommands;

import org.game.rpg_elements.itens.Item;
import org.game.rpg_elements.status.Status;
import org.game.rpg_elements.status.StatusCommander;

import java.io.IOException;
import java.util.Map;

public class Usar_Item extends StatusCommander {
    private Item item;

    public Usar_Item(Status status, Item item) throws IOException {
        super(status);
        this.item = item;
    }

    @Override
    public void execute() throws IOException {
        if(item.getType().equals("pocao cura")){
            usar_pocao_cura(item);
        } else if (item.getType().equals("pocao efeito")) {
            usar_pocao_efeito(item);
        }
        else if(item.getType().equals("essencio")){
            usar_essencio(item);
        } else if(item.getType().equals("bomba")){
            usar_bomba(item);
        }
    }

    private void usar_pocao_efeito(Item item){
        Map<String, Integer> efeitos = item.getEfeitos();

        for(Map.Entry<String, Integer> entry : efeitos.entrySet()){
            if(entry.getKey().equals("vida")){
                status.getAtributos_atualizados().add_vida(entry.getValue());
            }
            else if(entry.getKey().equals("mana")){
                status.getAtributos_atualizados().add_mana(entry.getValue());
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

    private void usar_essencio(Item item){
        Map<String, Integer> efeitos = item.getEfeitos();

        for(Map.Entry<String, Integer> entry : efeitos.entrySet()){
            if(entry.getKey().equals("vida")){
                status.getAtributos_atualizados().remove_vida(entry.getValue());
            }
            else if(entry.getKey().equals("mana")){
                status.getAtributos_atualizados().remove_mana(entry.getValue());
            }
            else if(entry.getKey().equals("forca")){
                status.getAtributos_atualizados().remove_forca(entry.getValue());
            }
            else if(entry.getKey().equals("inteligencia")){
                status.getAtributos_atualizados().remove_inteligencia(entry.getValue());
            }
            else if(entry.getKey().equals("velocidade")){
                status.getAtributos_atualizados().remove_velocidade(entry.getValue());
            }

        }

    }

    private void usar_pocao_cura(Item item){
        Map<String, Integer> efeitos = item.getEfeitos();

        for(Map.Entry<String, Integer> entry : efeitos.entrySet()){
            if(entry.getKey().equals("vida")){
                if(status.getVida_atual() + entry.getValue() <= status.getAtributos_atualizados().getVida()){
                    status.setVida_atual(status.getVida_atual() + entry.getValue());
                }
                else{
                    status.setVida_atual(status.getAtributos_atualizados().getVida());
                }
            }
            else if(entry.getKey().equals("mana")){
                if(status.getMana_atual() + entry.getValue() <= status.getAtributos_atualizados().getMana()){
                    status.setMana_atual(status.getMana_atual() + entry.getValue());
                }
                else{
                    status.setMana_atual(status.getAtributos_atualizados().getMana());
                }
            }
        }
    }

    private void usar_bomba(Item item){
        Map<String, Integer> efeitos = item.getEfeitos();

        for(Map.Entry<String, Integer> entry : efeitos.entrySet()){
            if(entry.getKey().equals("vida")){
                if(status.getVida_atual() - entry.getValue() < 0){
                    status.setVida_atual(0);
                }
                else {
                    status.setVida_atual(status.getVida_atual() - entry.getValue());
                }

            }
            else{
                if(status.getMana_atual() - entry.getValue() < 0){
                    status.setMana_atual(0);
                }
                else {
                    status.setMana_atual(status.getMana_atual() - entry.getValue());
                }

            }
        }
    }

}
