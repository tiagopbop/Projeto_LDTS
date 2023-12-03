package org.game.rpg_elements.status;

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
    private Atributos atributos;
    private List<Ataque> ataques_fisicos;

    private List<Ataque> ataques_magicos;

    private List<Ataque> ataques;

    public Status(Atributos atributos, List<Ataque> ataques){
        this.atributos = atributos;
        this.ataques = ataques;

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

        for(Map.Entry<String, Integer> entry : efeitos.entrySet()){
            if(entry.getKey().equals("vida")){
                this.atributos.add_vida(entry.getValue());
            }
            else if(entry.getKey().equals("mana")){
                this.atributos.add_mana(entry.getValue());
            }
            else if(entry.getKey().equals("forca")){
                this.atributos.add_forca(entry.getValue());
            }
            else if(entry.getKey().equals("inteligencia")){
                this.atributos.add_inteligencia(entry.getValue());
            }
            else if(entry.getKey().equals("velocidade")){
                this.atributos.add_velocidade(entry.getValue());
            }

        }

    }

    public Atributos getAtributos() {
        return atributos;
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

}
