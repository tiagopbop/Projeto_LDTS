package org.game.rpg_elements.status;

import org.game.rpg_elements.status.ataque.Ataque;
import org.game.rpg_elements.status.ataque.LoaderAtaque;
import org.game.rpg_elements.status.Atributos;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LoaderStatus extends Loader{
    public Status createStatus(String filename) throws IOException {
        List<String> lines;
        Status res;

        String file_path = "/status/" + filename;

        lines = Loader(file_path);
        res = new Status(createAtributos(lines), createAtaques(lines));

        return res;
    }

    private Atributos createAtributos(List<String> lines){
        return new Atributos(Integer.valueOf(lines.get(2)), Integer.valueOf(lines.get(3)), Integer.valueOf(lines.get(4)), Integer.valueOf(lines.get(5)), Integer.valueOf(lines.get(6)), Integer.valueOf(lines.get(7)));
    }

    private List<Ataque> createAtaques(List<String> lines) throws IOException {
        List<Ataque> res = new ArrayList<>();

        for(int i = 9; i < lines.size(); i++){
            res.add(new LoaderAtaque().createAtaque(lines.get(i)));
        }

        return res;
    }

}
