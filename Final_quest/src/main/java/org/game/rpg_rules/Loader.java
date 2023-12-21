package org.game.rpg_rules;

import org.game.rpg_rules.status.ataque.LoaderAtaque;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Loader {
    private List<String> lines;
    public void Loader(String filename) throws IOException {
        List<String> lines;

        URL resource = LoaderAtaque.class.getResource( filename +".txt");
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        lines = readLines(br);

        this.lines = lines;
    }

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);
        return lines;
    }

    public List<String> getLines() {
        return lines;
    }
}
