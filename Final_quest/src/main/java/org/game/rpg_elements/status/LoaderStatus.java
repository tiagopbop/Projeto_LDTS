package org.game.rpg_elements.status;

import org.game.rpg_elements.FactoryRPGElements;
import org.game.rpg_elements.status.ataque.Ataque;
import org.game.rpg_elements.status.ataque.LoaderAtaque;
import org.game.rpg_elements.status.Atributos;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LoaderStatus extends FactoryRPGElements<Status> {
    private LoaderAtaque factory;

    public LoaderStatus(LoaderAtaque factory){
        this.factory = factory;
    }

    public LoaderStatus(){
        this.factory = new LoaderAtaque();
    }

    public Status createRPGelement(List<String> lines) throws IOException {
        Status res;
        Atributos atributos = new Atributos(Integer.valueOf(lines.get(3)), Integer.valueOf(lines.get(4)), Integer.valueOf(lines.get(5)), Integer.valueOf(lines.get(6)), Integer.valueOf(lines.get(7)), Integer.valueOf(lines.get(8)));

        res = new Status(atributos, createAtaques(lines), lines.get(0), lines.get(1));


        return res;
    }

    public List<Ataque> createAtaques(List<String> lines) throws IOException {
        List<Ataque> res = new ArrayList<>();

        for(int i = 10; i < lines.size(); i++){
            res.add(factory.renderAtaque(lines.get(i)));
        }

        return res;
    }

}
