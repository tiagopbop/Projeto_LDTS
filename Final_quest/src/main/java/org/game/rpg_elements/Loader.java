package org.game.rpg_elements;

import org.game.rpg_elements.status.ataque.LoaderAtaque;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Loader {
    public List<String> Loader(String filename) throws IOException {
        List<String> lines;

        URL resource = LoaderAtaque.class.getResource( filename +".txt");
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        lines = readLines(br);

        return lines;
    }

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);
        return lines;
    }
}
