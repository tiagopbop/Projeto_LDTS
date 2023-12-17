package org.game.rpg_elements;

import org.game.rpg_elements.dialogue.Dialogue;
import org.game.rpg_elements.itens.Item;
import org.game.rpg_elements.itens.inventario.Inventario;
import org.game.rpg_elements.Inimigos.drop.Drop;
import org.game.rpg_elements.status.Status;
import org.game.rpg_elements.status.ataque.Ataque;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class FactoryRPGElements<T> {
    public Ataque renderAtaque(String filename) throws IOException {
        List<String> lines;
        String file_path = "/status/ataques/" + filename;

        lines = new Loader().Loader(file_path);
        Ataque ataque = (Ataque) createRPGelement(lines);

        return ataque;
    }

    public Status renderStatusMonster(String filename) throws IOException {
        List<String> lines;
        String file_path = "/status/inimigos/" + filename;

        lines = new Loader().Loader(file_path);
        Status status = (Status) createRPGelement(lines);

        return status;
    }

    public Status renderStatusHero() throws IOException {
        List<String> lines;
        String file_path = "/status/hero";

        lines = new Loader().Loader(file_path);
        Status status = (Status) createRPGelement(lines);

        return status;
    }

    public Status renderBoss() throws IOException {
        List<String> lines;
        String file_path = "/status/boss";

        lines = new Loader().Loader(file_path);
        Status status = (Status) createRPGelement(lines);

        return status;
    }

    public List<Status> renderMemberBoss() throws IOException {
        List<String> lines;
        String file_path = "/status/boss_member/";

        List<Status> res = new ArrayList<>();
        Random random = new Random();

        for(int i = 0; i < 2; i++){
            int random_num = random.nextInt(4) + 1;
            file_path += String.valueOf(random_num);

            lines = new Loader().Loader(file_path);
            Status status = (Status) createRPGelement(lines);

            res.add(status);
        }
        return res;
    }

    public Drop renderDrop(String filename) throws IOException {
        List<String> lines;
        String file_path = "/status/inimigos/drop/" + filename;

        lines = new Loader().Loader(file_path);
        Drop drop = (Drop) createRPGelement(lines);

        return drop;
    }

    public Item renderEquipamento(String filename) throws IOException {
        List<String> lines;
        String file_path = "/itens/equipamento/" + filename;

        lines = new Loader().Loader(file_path);
        Item item = (Item) createRPGelement(lines);

        return item;
    }

    public Item renderConsumivel(String filename) throws IOException {
        List<String> lines;
        String file_path = "/itens/consumiveis/" + filename;

        lines = new Loader().Loader(file_path);
        Item item = (Item) createRPGelement(lines);

        return item;
    }

    public Inventario renderInventario() throws IOException {
        List<String> lines;
        String file_path = "/itens/inventario";

        lines = new Loader().Loader(file_path);
        Inventario inventario = (Inventario) createRPGelement(lines);

        return inventario;
    }

    public List<Dialogue> renderDialogue(String filename) throws IOException {
        List<String> lines;
        String file_path = "/dialogos/" + filename;

        lines = new Loader().Loader(file_path);
        List<Dialogue> dialogues = (List<Dialogue>) createRPGelement(lines);

        return dialogues;
    }


    public abstract T createRPGelement(List<String> lines) throws IOException;

}
