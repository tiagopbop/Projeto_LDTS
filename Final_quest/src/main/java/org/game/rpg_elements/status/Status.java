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
    private String strg;
    private String nome;
    private Integer experiencia;
    private Atributos atributos_real;
    private Atributos atributos_atualizados;
    private List<Ataque> ataques_fisicos;
    private List<Ataque> ataques_magicos;
    private List<Ataque> ataques;
    private int vida_atual;
    private int mana_atual;

    public Status(Atributos atributos_real, List<Ataque> ataques, String nome, String str){
        this.nome = nome;
        this.strg = str;

        this.atributos_real = atributos_real;
        this.atributos_atualizados = new Atributos(atributos_real);

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
        this.experiencia = 0;
    }

    public String getNome() {
        return nome;
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

    public boolean pode_usar_equipamento(Item equipamento){
        Map<String, Integer> requesitos = equipamento.getRequirements();
        boolean res = true;

        for(Map.Entry<String, Integer> entry : requesitos.entrySet()){
            if(entry.getKey().equals("level")){
                if(atributos_real.getLevel() < entry.getValue()){
                    return false;
                }
            }
            if(entry.getKey().equals("vida")){
                if(atributos_real.getVida() < entry.getValue()){
                    return false;
                }
            }
            if(entry.getKey().equals("mana")){
                if(atributos_real.getMana() < entry.getValue()){
                    return false;
                }
            }
            if(entry.getKey().equals("forca")){
                if(atributos_real.getForca() < entry.getValue()){
                    return false;
                }
            }

            if(entry.getKey().equals("inteligencia")){
                if(atributos_real.getInteligencia() < entry.getValue()){
                    return false;
                }
            }

            if(entry.getKey().equals("velocidade")){
                if(atributos_real.getVelocidade() < entry.getValue()){
                    return false;
                }
            }
        }
        return res;
    }
    public Integer getExperiencia() {
        return experiencia;
    }
    public void reset_status() {
        this.vida_atual = atributos_atualizados.getVida();
        this.mana_atual = atributos_atualizados.getMana();
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setAtributos_atualizados(Atributos atributos_atualizados) {
        this.atributos_atualizados = new Atributos(atributos_atualizados);
    }
    public String getStrg() {
        return strg;
    }

    public void setExperiencia(Integer experiencia) {
        this.experiencia = experiencia;
    }



}
