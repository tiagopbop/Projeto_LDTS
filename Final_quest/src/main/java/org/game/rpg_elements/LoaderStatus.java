package org.game.rpg_elements;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LoaderStatus {
    public Status createStatus(String filename) throws IOException {
        List<String> lines;
        Status res;

        URL resource = LoaderAtaque.class.getResource("/status/"+ filename + ".txt");
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        lines = readLines(br);

        res = new Status(createAtributos(lines), createAtaques(lines));

        return res;
    }

    private Atributos createAtributos(List<String> lines){
        return new Atributos(Integer.valueOf(lines.get(2)), Integer.valueOf(lines.get(3)), Integer.valueOf(lines.get(4)), Integer.valueOf(lines.get(5)), Integer.valueOf(lines.get(6)));
    }

    private List<Ataque> createAtaques(List<String> lines) throws IOException {
        List<Ataque> res = new ArrayList<>();

        for(int i = 8; i < lines.size(); i++){
            res.add(new LoaderAtaque().createAtaque(lines.get(i)));
        }

        return res;
    }

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);
        return lines;
    }

}
