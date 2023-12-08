package org.game.rpg_elements.status;

import org.game.rpg_elements.FactoryRPGElements;
import org.game.rpg_elements.status.ataque.Ataque;
import org.game.rpg_elements.status.ataque.LoaderAtaque;
import org.game.rpg_elements.status.Atributos;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LoaderStatus extends FactoryRPGElements<Status>{
    public Status createRPGelement(List<String> lines) throws IOException{
        Status res;
        res = new Status(createAtributos(lines), createAtaques(lines), lines.get(0));

        return res;
    }

    private Atributos createAtributos(List<String> lines){
        return new Atributos(Integer.valueOf(lines.get(2)), Integer.valueOf(lines.get(3)), Integer.valueOf(lines.get(4)), Integer.valueOf(lines.get(5)), Integer.valueOf(lines.get(6)), Integer.valueOf(lines.get(7)));
    }

    private List<Ataque> createAtaques(List<String> lines) throws IOException {
        List<Ataque> res = new ArrayList<>();
        LoaderAtaque factory = new LoaderAtaque();

        for(int i = 9; i < lines.size(); i++){
            res.add(factory.renderAtaque(lines.get(i)));
        }

        return res;
    }

}
