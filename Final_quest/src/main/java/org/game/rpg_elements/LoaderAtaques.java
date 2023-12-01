package org.game.rpg_elements;
import org.game.model.game.elements.Hero;
import org.game.model.game.elements.Wall;
import org.game.rpg_elements.Ataque;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LoaderAtaques {
    private final  static  String ATAQUE_PATH = "/status/ataques";
    public Ataque LoaderAtaques(String filename) throws IOException {
        List<String> lines;
        Ataque res;

        URL resource = LoaderAtaques.class.getResource("/status/ataques/slash.txt");
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        lines = readLines(br);

        res = new Ataque(lines.get(0), lines.get(1), Integer.valueOf(lines.get(2)), Float.valueOf(lines.get(3)));

        return res;
    }

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);
        return lines;
    }
}
