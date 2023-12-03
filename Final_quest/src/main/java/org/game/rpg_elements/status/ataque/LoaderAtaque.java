package org.game.rpg_elements.status.ataque;

import org.game.rpg_elements.status.Loader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LoaderAtaque extends Loader {
    public Ataque createAtaque(String filename) throws IOException {
        List<String> lines;
        Ataque res;

        String file_path = "/status/ataques/" + filename;
        lines = Loader(file_path);

        res = new Ataque(lines.get(0), lines.get(1), Integer.valueOf(lines.get(2)), Integer.valueOf(lines.get(3)), Integer.valueOf(lines.get(4)));

        return res;
    }

}
