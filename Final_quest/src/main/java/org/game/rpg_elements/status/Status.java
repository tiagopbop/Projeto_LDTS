package org.game.rpg_elements.status;

import org.game.rpg_elements.itens.Item;
import org.game.rpg_elements.itens.inventario.Equipado;
import org.game.rpg_elements.status.ataque.Ataque;
import org.game.rpg_elements.status.ataque.LoaderAtaque;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Status {
    private Atributos atributos_real;

    private Atributos atributos_atualizados;
    private List<Ataque> ataques_fisicos;

    private List<Ataque> ataques_magicos;

    private List<Ataque> ataques;

    private int vida_atual;
    private int mana_atual;

    public Status(Atributos atributos_real, List<Ataque> ataques){
        this.atributos_real = atributos_real;
        this.atributos_atualizados = this.atributos_real;
        this.ataques = ataques;
        this.vida_atual = this.atributos_real.getVida();
        this.mana_atual = this.atributos_real.getMana();

        List<Ataque> fisicos = new ArrayList<>();
        List<Ataque> magicos = new ArrayList<>();

        for(Ataque ataque: ataques){
            if(ataque.getOrigem().equals("fisico")){
                fisicos.add(ataque);
            } else if (ataque.getOrigem().equals("magico")) {
                magicos.add(ataque);
            }
            else{
                magicos.add(ataque);
            }
        }
        this.ataques_fisicos = fisicos;
        this.ataques_magicos = magicos;
    }

    public void atualizar_equipamento(Equipado equipamentos){
        Map<String, Integer> efeitos = equipamentos.getCapacete().getEfeitos();
        atributos_atualizados = atributos_real;

        for(Map.Entry<String, Integer> entry : efeitos.entrySet()){
            if(entry.getKey().equals("vida")){
                this.atributos_atualizados.add_vida(entry.getValue());
            }
            else if(entry.getKey().equals("mana")){
                this.atributos_atualizados.add_mana(entry.getValue());
            }
            else if(entry.getKey().equals("forca")){
                this.atributos_atualizados.add_forca(entry.getValue());
            }
            else if(entry.getKey().equals("inteligencia")){
                this.atributos_atualizados.add_inteligencia(entry.getValue());
            }
            else if(entry.getKey().equals("velocidade")){
                this.atributos_atualizados.add_velocidade(entry.getValue());
            }

        }

    }

    public void usar_item(Item item){
        if(item.getType().equals("pocao cura")){
            usar_pocao_cura(item);
        } else if (item.getType().equals("pocao efeito")) {
            usar_pocao_efeito(item);
        }
        else if(item.getType().equals("essencio")){
            usar_essencio(item);
        }
    }

    private void usar_pocao_efeito(Item item){
        Map<String, Integer> efeitos = item.getEfeitos();

        for(Map.Entry<String, Integer> entry : efeitos.entrySet()){
            if(entry.getKey().equals("vida")){
                this.atributos_atualizados.remove_vida(entry.getValue());
            }
            else if(entry.getKey().equals("mana")){
                this.atributos_atualizados.remove_mana(entry.getValue());
            }
            else if(entry.getKey().equals("forca")){
                this.atributos_atualizados.remove_forca(entry.getValue());
            }
            else if(entry.getKey().equals("inteligencia")){
                this.atributos_atualizados.remove_inteligencia(entry.getValue());
            }
            else if(entry.getKey().equals("velocidade")){
                this.atributos_atualizados.remove_velocidade(entry.getValue());
            }

        }

    }

    private void usar_essencio(Item item){
        Map<String, Integer> efeitos = item.getEfeitos();

        for(Map.Entry<String, Integer> entry : efeitos.entrySet()){
            if(entry.getKey().equals("vida")){
                this.atributos_atualizados.add_vida(entry.getValue());
            }
            else if(entry.getKey().equals("mana")){
                this.atributos_atualizados.add_mana(entry.getValue());
            }
            else if(entry.getKey().equals("forca")){
                this.atributos_atualizados.add_forca(entry.getValue());
            }
            else if(entry.getKey().equals("inteligencia")){
                this.atributos_atualizados.add_inteligencia(entry.getValue());
            }
            else if(entry.getKey().equals("velocidade")){
                this.atributos_atualizados.add_velocidade(entry.getValue());
            }

        }

    }

    private void usar_pocao_cura(Item item){
        Map<String, Integer> efeitos = item.getEfeitos();

        for(Map.Entry<String, Integer> entry : efeitos.entrySet()){
            if(entry.getKey().equals("vida")){
                    if(vida_atual + entry.getValue() <= atributos_atualizados.getVida()){
                        this.vida_atual += entry.getValue();
                    }
                    else{
                        this.vida_atual = atributos_atualizados.getVida();
                    }
            }
            else if(entry.getKey().equals("mana")){
                if(mana_atual + entry.getValue() <= atributos_atualizados.getMana()){
                    this.mana_atual += entry.getValue();
                }
                else{
                    this.mana_atual = atributos_atualizados.getMana();
                }
            }
            else if(entry.getKey().equals("forca")){
                this.atributos_atualizados.add_forca(entry.getValue());
            }
            else if(entry.getKey().equals("inteligencia")){
                this.atributos_atualizados.add_inteligencia(entry.getValue());
            }
            else if(entry.getKey().equals("velocidade")){
                this.atributos_atualizados.add_velocidade(entry.getValue());
            }

        }
    }

    public Atributos getAtributos_real() {
        return atributos_real;
    }

    public Atributos getAtributos_atualizados() {
        return atributos_atualizados;
    }

    public List<Ataque> getAtaques() {
        return ataques;
    }

    public List<Ataque> getAtaques_fisicos() {
        return ataques_fisicos;
    }

    public List<Ataque> getAtaques_magicos(){
        return ataques_magicos;
    }

    public int getVida_atual() {
        return vida_atual;
    }

    public int getMana_atual() {
        return mana_atual;
    }

    public void setVida_atual(int vida_atual) {
        this.vida_atual = vida_atual;
    }

    public void setMana_atual(int mana_atual) {
        this.mana_atual = mana_atual;
    }

    public void dano_recebido(int dano){
        this.vida_atual -= dano;
    }

    public void mana_usada(Ataque ataque){
        this.mana_atual -= ataque.getCusto();
    }

}
