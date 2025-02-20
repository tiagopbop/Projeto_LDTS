package org.game.model.game.map;
import org.game.model.battle.battleElements.Hero;
import org.game.model.game.elements.interactabel.*;
import org.game.model.game.elements.nonInteractabel.Wall;
import org.game.rpg_rules.Loader;
import org.game.rpg_rules.dialogue.Dialogue;
import org.game.rpg_rules.dialogue.LoaderDialogo;
import org.game.rpg_rules.FactoryRPGElements;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
public class MapLoader extends MapBuilder {
    private final List<String> lines;
    private  static List<Dialogue> signdialogues;
    private static List<Dialogue> npcdialogues;
    private static Dialogue doorsdialogues = new Dialogue("Uma porta. Abrir?");
    private static Dialogue chestsdialogues = new Dialogue("An open chest");
    private static Dialogue stairsdialogues = new Dialogue("Umas escadas. Subir?");

    private static Dialogue walldialogues = new Dialogue("The hero glazes the wall intensely");

    private List<Wall> walls = new ArrayList<Wall>();
    private List<NPC> npcs = new ArrayList<NPC>();
    private List<Door> door = new ArrayList<Door>();
    private List<Stairs> stairs = new ArrayList<Stairs>();
    private List<Chest> chests = new ArrayList<Chest>();
    private List<Sign> signs = new ArrayList<Sign>();

    private List<Bossy> bossies = new ArrayList<>();
    private Hero hero;

    public MapLoader(Hero hero, Loader loader, LoaderDialogo loaderDialogoSign, LoaderDialogo loaderDialogoNPC)throws IOException{
        this.hero = hero;
        signdialogues = loaderDialogoSign.renderDialogue("sign");
        npcdialogues = loaderDialogoNPC.renderDialogue("npc");
        lines = loader.getLines();
    }

    public MapLoader(String zone, Hero hero) throws IOException {
        signdialogues = new LoaderDialogo().renderDialogue("sign");
        npcdialogues = new LoaderDialogo().renderDialogue("npc");
        this.hero = hero;

        String file_path = "/maps/CentralVillageMap";

        switch (zone) {
            case "centralVillage":
                break;
            case "castleEntrance":
                file_path = "/maps/CastleEntrance";
                break;
            case "FirstRoom":
                file_path = "/maps/FirstRoom";
                break;
            case "SecondRoom.txt":
                file_path = "/maps/SecondRoom";
                break;
            case "BossRoom.txt":
                file_path = "/maps/BossRoom";
                break;
        }

        Loader loader = new Loader();
        loader.Loader(file_path);

        lines = loader.getLines();
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
    protected void createElements(Map mapa) throws IOException {

        List<Wall> walls = new ArrayList<Wall>();
        List<NPC> npcs = new ArrayList<NPC>();
        List<Door> door = new ArrayList<Door>();
        List<Stairs> stairs = new ArrayList<Stairs>();
        List<Chest> chests = new ArrayList<Chest>();
        List<Sign> signs = new ArrayList<Sign>();
        List<Bossy> bossies = new ArrayList<>();

        int countNPC = 0;
        int countSign = 0;

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {

                switch (line.charAt(x)) {
                    case 'º':
                        bossies.add(new Bossy(x,y,new Dialogue(), "boss", (char)181, "#FFFFFF","#6F6F6F"));
                        break;
                    case '#':
                        walls.add(new Wall(x, y, walldialogues, "tree", (char)144, "#1D1F15", ""));
                        break;
                    case 'H':
                        walls.add(new Wall(x, y, new Dialogue(), "ground", '.', "#0C450D", ""));
                        hero.setHeroElement(x, y, new Dialogue(),"hero", (char)133, "#EE8888", "");
                        mapa.setHero(hero);
                        break;
                    case ' ':
                        walls.add(new Wall(x, y, new Dialogue(), "ground", '.', "#0C450D", ""));
                        break;
                    case 'N':
                        npcs.add(new NPC(x, y, npcdialogues.get(countNPC), "npc", (char)136, "#00BFAF", ""));
                        countNPC++;
                        break;
                    case 'M':
                        npcs.add(new NPC(x, y, npcdialogues.get(countNPC), "npc", (char)137, "#E06800", ""));
                        countNPC++;
                        break;
                    case 'D':
                        door.add(new Door(x, y, doorsdialogues, "door", (char)134, "#241B1B", "#7D7D7D"));
                        break;
                    case 'G':
                        walls.add(new Wall(x, y, new Dialogue(), "housewall", (char)145, "#1D1710", "#5C4E39"));
                        break;
                    case 'F':
                        walls.add(new Wall(x, y, new Dialogue(), "housedoor", (char)146, "#1C1414", "#5C4E39"));
                        break;
                    case 'E':
                        walls.add(new Wall(x, y, new Dialogue(), "roofc", (char)148, "#280202", ""));
                        break;
                    case 'R':
                        walls.add(new Wall(x, y, new Dialogue(), "roofl", (char)147, "#280202", ""));
                        break;
                    case 'Y':
                        walls.add(new Wall(x, y, new Dialogue(), "roofr", (char)149, "#280202", ""));
                        break;
                    case '$':
                        walls.add(new Wall(x, y, new Dialogue(), "path", (char)150, "#8D8D8D", ""));
                        break;
                    case '%':
                        walls.add(new Wall(x, y, new Dialogue(), "path", (char)153, "#8D8D8D", ""));
                        break;
                    case '&':
                        walls.add(new Wall(x, y, new Dialogue(), "path", (char)155, "#8D8D8D", ""));
                        break;
                    case 'S':
                        stairs.add(new Stairs(x, y, stairsdialogues, "stairs", (char) 131, "#FFCBDB", "#6F6F6F"));
                        break;
                    case '.':
                        walls.add(new Wall(x, y, new Dialogue(), "dialogoT", (char)140, "#3A4AD5", "#000000"));
                        break;
                    case ',':
                        walls.add(new Wall(x, y, new Dialogue(), "dialogoL", (char)142, "#3A4AD5", "#000000"));
                        break;
                    case '-':
                        walls.add(new Wall(x, y, new Dialogue(), "dialogoR", (char)143, "#3A4AD5", "#000000"));
                        break;
                    case '_':
                        walls.add(new Wall(x, y, new Dialogue(), "dialogoB", (char)141, "#3A4AD5", "#000000"));
                        break;
                    case '*':
                        walls.add(new Wall(x, y, new Dialogue(), "dialogoC", (char)130, "#3A4AD5", ""));
                        break;
                    case 'C':
                        chests.add(new Chest(x, y, chestsdialogues, "chest", (char) 128, "#908A18", "#6F6F6F"));
                        break;
                    case 'T':
                        signs.add(new Sign(x, y, signdialogues.get(countSign), "sign", (char)135, "#717171", ""));
                        countSign++;
                        break;
                    case '@':
                        walls.add(new Wall(x, y, new Dialogue(), "tree2", (char)154, "#2A241D", ""));
                        break;
                    case 'Q':
                        walls.add(new Wall(x, y, new Dialogue(), "grass", (char)156, "#197F1B", ""));
                        break;
                    case 'W':
                        walls.add(new Wall(x, y, new Dialogue(), "grass", (char)158, "#197F1B", ""));
                        break;
                    case '/':
                        walls.add(new Wall(x, y, new Dialogue(), "water", (char)170, "#147186", "#409CB1"));
                        break;
                    case '[':
                        walls.add(new Wall(x, y, new Dialogue(), "bridge", (char)174, "#655042", ""));
                        break;
                    case ']':
                        walls.add(new Wall(x, y, new Dialogue(), "bridge", (char)177, "#655042", ""));
                        break;
                    case '(':
                        walls.add(new Wall(x, y, new Dialogue(), "bridge", (char)175, "#655042", ""));
                        break;
                    case ')':
                        walls.add(new Wall(x, y, new Dialogue(), "bridge", (char)176, "#655042", ""));
                        break;
                    case '}':
                        walls.add(new Wall(x, y, new Dialogue(), "bridge", (char)173, "#655042", ""));
                        break;
                    case '{':
                        walls.add(new Wall(x, y, new Dialogue(), "bridge", (char)172, "#655042", ""));
                        break;
                    case '=':
                        walls.add(new Wall(x, y, new Dialogue(), "bridge", (char)178, "#409CB1", "#655042"));
                        break;
                    case '!':
                        walls.add(new Wall(x, y, new Dialogue(), "bridgeRail", (char)180, "#4E3E33", "#409CB1"));
                        break;
                    case '?':
                        walls.add(new Wall(x, y, new Dialogue(), "bridgeRail", (char)179, "#4E3E33", "#409CB1"));
                        break;
                    case 'J':
                        walls.add(new Wall(x, y, new Dialogue(), "tree", (char)152, "#5F5555", "#2A322A"));
                        break;
                    case 'K':
                        walls.add(new Wall(x, y, new Dialogue(), "tree", (char)151, "#494747", "#2A322A"));
                        break;
                    case 'L':
                        walls.add(new Wall(x, y, new Dialogue(), "ground", '.', "#2A322A", "#2A322A"));
                        break;
                    case 'O':
                        walls.add(new Wall(x, y, new Dialogue(), "path", (char)162, "#556655", "#2A322A"));
                        break;
                    case '+':
                        walls.add(new Wall(x, y, new Dialogue(), "castleWall", (char)166, "#3F403F", "#7D7D7D"));
                        break;
                    case '|':
                        walls.add(new Wall(x, y, new Dialogue(), "spike", (char)171, "#747474", "#2A322A"));
                        break;
                    case ':':
                        walls.add(new Wall(x, y, new Dialogue(), "castleWindow", (char)167, "#232323", "#575857"));
                        break;
                    case 'X':
                        walls.add(new Wall(x, y, new Dialogue(), "ground", '.', "#345234", "#345234"));
                        break;
                    case 'V':
                        walls.add(new Wall(x, y, new Dialogue(), "path", (char)156, "#4B4B4B", "#2A322A"));
                        break;
                    case '<':
                        walls.add(new Wall(x, y, new Dialogue(), "wall", (char)129, "#7D7D7D", "#C1C1C1"));
                        break;
                    case '>':
                        walls.add(new Wall(x, y, new Dialogue(), "wall", (char)161, "#7D7D7D", "#C1C1C1"));
                        break;
                    case '~':
                        walls.add(new Wall(x, y, new Dialogue(), "wall", (char)160, "#7D7D7D", "#C1C1C1"));
                        break;
                    case '«':
                        walls.add(new Wall(x, y, new Dialogue(), "path", (char)159, "#BBBBBB", "#6F6F6F"));
                        break;
                    case '»':
                        walls.add(new Wall(x, y, new Dialogue(), "candlesticks", (char)157, "#B1A23E", "#6F6F6F"));
                        break;
                    case 'B':
                        walls.add(new Wall(x, y, new Dialogue(), "void", '.', "#000000", "#000000"));
                        break;
                    case '£':
                        walls.add(new Wall(x, y, new Dialogue(), "ground", '.', "#6F6F6F", "#6F6F6F"));
                        break;
                    case '§':
                        walls.add(new Wall(x, y, new Dialogue(), "table", (char)165, "#86423C", "#6F6F6F"));
                        break;

                }
            }
        }
        mapa.setChests(chests);
        mapa.setDoors(door);
        mapa.setNPC(npcs);
        mapa.setSigns(signs);
        mapa.setStairs(stairs);
        mapa.setWalls(walls);
        mapa.setBossy(bossies);
    }
}