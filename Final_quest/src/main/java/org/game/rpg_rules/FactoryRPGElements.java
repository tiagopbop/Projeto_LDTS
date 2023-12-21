package org.game.rpg_rules;

import org.game.rpg_rules.dialogue.Dialogue;
import org.game.rpg_rules.itens.Item;
import org.game.rpg_rules.itens.inventario.Inventario;
import org.game.rpg_rules.Inimigos.drop.Drop;
import org.game.rpg_rules.status.Status;
import org.game.rpg_rules.status.ataque.Ataque;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class FactoryRPGElements<T> {
    public Ataque renderAtaque(String filename) throws IOException {
        Loader loader = new Loader();
        List<String> lines;
        String file_path = "/status/ataques/" + filename;

        loader.Loader(file_path);
        lines = loader.getLines();

        Ataque ataque = (Ataque) createRPGelement(lines);

        return ataque;
    }

    public Status renderStatusMonster(String filename) throws IOException {
        Loader loader = new Loader();
        List<String> lines;
        String file_path = "/status/inimigos/" + filename;

        loader.Loader(file_path);
        lines = loader.getLines();

        Status status = (Status) createRPGelement(lines);

        return status;
    }

    public Status renderStatusHero() throws IOException {
        Loader loader = new Loader();
        List<String> lines;
        String file_path = "/status/hero";

        loader.Loader(file_path);
        lines = loader.getLines();

        Status status = (Status) createRPGelement(lines);

        return status;
    }

    public Status renderBoss() throws IOException {
        Loader loader = new Loader();
        List<String> lines;
        String file_path = "/status/boss";

        loader.Loader(file_path);
        lines = loader.getLines();

        Status status = (Status) createRPGelement(lines);

        return status;
    }

    public List<Status> renderMemberBoss() throws IOException {
        Loader loader = new Loader();
        List<String> lines;
        String file_path = "/status/boss_member/";

        List<Status> res = new ArrayList<>();
        Random random = new Random();

        for(int i = 0; i < 2; i++){
            int random_num = random.nextInt(4) + 1;
            file_path += String.valueOf(random_num);

            loader.Loader(file_path);
            lines = loader.getLines();

            Status status = (Status) createRPGelement(lines);

            res.add(status);
        }
        return res;
    }

    public Drop renderDrop(String filename) throws IOException {
        Loader loader = new Loader();
        List<String> lines;
        String file_path = "/status/inimigos/drop/" + filename;

        loader.Loader(file_path);
        lines = loader.getLines();

        Drop drop = (Drop) createRPGelement(lines);

        return drop;
    }

    public Item renderEquipamento(String filename) throws IOException {
        Loader loader = new Loader();
        List<String> lines;
        String file_path = "/itens/equipamento/" + filename;

        loader.Loader(file_path);
        lines = loader.getLines();

        Item item = (Item) createRPGelement(lines);

        return item;
    }

    public Item renderConsumivel(String filename) throws IOException {
        Loader loader = new Loader();
        List<String> lines;
        String file_path = "/itens/consumiveis/" + filename;

        loader.Loader(file_path);
        lines = loader.getLines();

        Item item = (Item) createRPGelement(lines);

        return item;
    }

    public Inventario renderInventario() throws IOException {
        Loader loader = new Loader();
        List<String> lines;
        String file_path = "/itens/inventario";

        loader.Loader(file_path);
        lines = loader.getLines();

        Inventario inventario = (Inventario) createRPGelement(lines);

        return inventario;
    }

    public List<Dialogue> renderDialogue(String filename) throws IOException {
        Loader loader = new Loader();
        List<String> lines;
        String file_path = "/dialogos/" + filename;

        loader.Loader(file_path);
        lines = loader.getLines();

        List<Dialogue> dialogues = (List<Dialogue>) createRPGelement(lines);

        return dialogues;
    }


    public abstract T createRPGelement(List<String> lines) throws IOException;

}
