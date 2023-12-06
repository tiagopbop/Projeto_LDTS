package org.game.model.game.map;
import org.game.model.dialogue.Dialogue;
import org.game.model.game.elements.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
public class VillageLoader extends VillageBuilder {
    private final List<String> lines;
    private  static List<Dialogue> signdialogues;
    private static List<Dialogue> npcdialogues;
    private static List<Dialogue> doorsdialogues = new LoaderDoorDialogue().createDialogue();
    private static List<Dialogue> chestsdialogues = new LoaderChestDialogue().createDialogue();
    private static List<Dialogue> stairsdialogues = new LoaderStairsDialogue().createDialogue();

    private static Dialogue walldialogues = new Dialogue("The hero glazes the wall intensely");

    private List<Wall> walls = new ArrayList<Wall>();
    private List<NPC> npcs = new ArrayList<NPC>();
    private List<Door> door = new ArrayList<Door>();
    private List<Stairs> stairs = new ArrayList<Stairs>();
    private List<Chest> chests = new ArrayList<Chest>();
    private List<Sign> signs = new ArrayList<Sign>();
    private Hero hero;




    public VillageLoader() throws IOException{
        signdialogues = new LoaderDialogo().createListDialogue("sign");
        npcdialogues = new LoaderDialogo().createListDialogue("npc");
        URL resource = VillageLoader.class.getResource("/maps/VillageMap");
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));


        lines = readLines(br);
    }

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);
        return lines;
    }

    @Override
    protected int getWidth() {
        int width = 0;
        for (String line : lines)
            width = Math.max(width, line.length());
        return width;
    }

    @Override
    protected int getHeight() {
        return lines.size();
    }

    @Override
    protected void createElements(Village village) throws IOException {

        List<Wall> walls = new ArrayList<Wall>();
        List<NPC> npcs = new ArrayList<NPC>();
        List<Door> door = new ArrayList<Door>();
        List<Stairs> stairs = new ArrayList<Stairs>();
        List<Chest> chests = new ArrayList<Chest>();
        List<Sign> signs = new ArrayList<Sign>();
        Hero hero = new Hero(0, 0, new Dialogue(), "hero", (char)133, "#63E2C6", "");

        int countNPC = 0;
        int countStairs = 0;
        int countDoor = 0;
        int countChest = 0;
        int countSign = 0;

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {

                switch (line.charAt(x)) {
                    case '#':
                        walls.add(new Wall(x, y, walldialogues, "wall", (char)144, "#5A4B35", ""));
                        break;
                    case 'H':
                        walls.add(new Wall(x, y, new Dialogue(), "ground", '.', "#00170C", ""));
                        hero = new Hero(x, y, new Dialogue(), "hero", (char)133, "#63E2C6", "");
                        break;
                    case ' ':
                        walls.add(new Wall(x, y, new Dialogue(), "ground", '.', "#00170C", ""));
                        break;
                    case 'N':
                        npcs.add(new NPC(x, y, npcdialogues.get(countNPC), "npc", (char)136, "#04928D", ""));
                        countNPC++;
                        break;
                    case 'M':
                        npcs.add(new NPC(x, y, npcdialogues.get(countNPC), "npc", (char)137, "#824E00", ""));
                        countNPC++;
                        break;
                    case 'D':
                        door.add(new Door(x, y, doorsdialogues.get(countDoor), "door", (char)134, "#FFCBDB", ""));
                        countDoor++;
                        break;
                    case 'G':
                        walls.add(new Wall(x, y, new Dialogue(), "housewall", (char)145, "#313030", "#FD9999"));
                        break;
                    case 'F':
                        walls.add(new Wall(x, y, new Dialogue(), "housedoor", (char)146, "#E07450", "#FD9999"));
                        break;
                    case 'E':
                        walls.add(new Wall(x, y, new Dialogue(), "roofc", (char)148, "#3B1414", ""));
                        break;
                    case 'R':
                        walls.add(new Wall(x, y, new Dialogue(), "roofl", (char)147, "#3B1414", ""));
                        break;
                    case 'Y':
                        walls.add(new Wall(x, y, new Dialogue(), "roofr", (char)149, "#3B1414", ""));
                        break;
                    case '$':
                        walls.add(new Wall(x, y, new Dialogue(), "path", (char)150, "#8D8D8D", ""));
                        break;
                    case 'S':
                        stairs.add(new Stairs(x, y, stairsdialogues.get(countStairs), "stairs", (char) 131, "#FFCBDB", ""));
                        countStairs++;
                        break;
                    case '.':
                        walls.add(new Wall(x, y, new Dialogue(), "dialogoT", (char)140, "#3A4AD5", ""));
                        break;
                    case ',':
                        walls.add(new Wall(x, y, new Dialogue(), "dialogoL", (char)142, "#3A4AD5", ""));
                        break;
                    case '-':
                        walls.add(new Wall(x, y, new Dialogue(), "dialogoR", (char)143, "#3A4AD5", ""));
                        break;
                    case '_':
                        walls.add(new Wall(x, y, new Dialogue(), "dialogoB", (char)141, "#3A4AD5", ""));
                        break;
                    case '*':
                        walls.add(new Wall(x, y, new Dialogue(), "dialogoC", (char)130, "#3A4AD5", ""));
                        break;
                    case 'C':
                        chests.add(new Chest(x, y, chestsdialogues.get(countChest), "chest", (char) 128, "#F3C98B", ""));
                        countChest++;
                        break;
                    case 'T':
                        signs.add(new Sign(x, y, signdialogues.get(countSign), "sign", (char)135, "#686868", ""));
                        countSign++;
                        break;
                }
            }
        }
        village.setChests(chests);
        village.setDoors(door);
        village.setHero(hero);
        village.setNPC(npcs);
        village.setSigns(signs);
        village.setStairs(stairs);
        village.setWalls(walls);
    }
}