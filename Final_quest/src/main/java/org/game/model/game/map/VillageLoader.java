package org.game.model.game.map;
import org.game.model.dialogue.Dialogue;
import org.game.model.game.elements.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
public class VillageLoader extends VillageBuilder{
    private final List<String> lines;
    private  static List<Dialogue> signdialogues;
    private static List<Dialogue> npcdialogues;
    private static List<Dialogue> doorsdialogues = new LoaderDoorDialogue().createDialogue();
    private static List<Dialogue> chestsdialogues = new LoaderChestDialogue().createDialogue();
    private static List<Dialogue> stairsdialogues = new LoaderStairsDialogue().createDialogue();

    private static Dialogue walldialogues = new Dialogue("The hero glazes the wall intensely");

    private List<Wall> walls = new ArrayList<Wall>();
    private List<Ground> ground = new ArrayList<Ground>();
    private List<NPC> npcs = new ArrayList<NPC>();
    private List<Door> door = new ArrayList<Door>();
    private List<HouseWall> housewall = new ArrayList<HouseWall>();
    private List<HouseDoor> housedoor = new ArrayList<HouseDoor>();
    private List<RoofC> roofc = new ArrayList<RoofC>();
    private List<RoofL> roofl = new ArrayList<RoofL>();
    private List<RoofR> roofr = new ArrayList<RoofR>();
    private List<Path> path = new ArrayList<Path>();
    private List<Stairs> stairs = new ArrayList<Stairs>();
    private List<DialogueT> dialogues1 = new ArrayList<DialogueT>();
    private List<DialogueT> dialogues2 = new ArrayList<DialogueT>();
    private List<DialogueT> dialogues3 = new ArrayList<DialogueT>();
    private List<DialogueT> dialogues4 = new ArrayList<DialogueT>();
    private List<DialogueT> dialogues5 = new ArrayList<DialogueT>();
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
        List<Ground> ground = new ArrayList<Ground>();
        List<NPC> npcs = new ArrayList<NPC>();
        List<Door> door = new ArrayList<Door>();
        List<HouseWall> housewall = new ArrayList<HouseWall>();
        List<HouseDoor> housedoor = new ArrayList<HouseDoor>();
        List<RoofC> roofc = new ArrayList<RoofC>();
        List<RoofL> roofl = new ArrayList<RoofL>();
        List<RoofR> roofr = new ArrayList<RoofR>();
        List<Path> path = new ArrayList<Path>();
        List<Stairs> stairs = new ArrayList<Stairs>();
        List<DialogueT> dialogues1 = new ArrayList<DialogueT>();
        List<DialogueT> dialogues2 = new ArrayList<DialogueT>();
        List<DialogueT> dialogues3 = new ArrayList<DialogueT>();
        List<DialogueT> dialogues4 = new ArrayList<DialogueT>();
        List<DialogueT> dialogues5 = new ArrayList<DialogueT>();
        List<Chest> chests = new ArrayList<Chest>();
        List<Sign> signs = new ArrayList<Sign>();
        Hero hero = new Hero(0, 0, new Dialogue(), "hero");

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
                        walls.add(new Wall(x, y, walldialogues, "wall"));
                        break;
                    case 'H':
                        ground.add(new Ground(x, y, new Dialogue()));
                        hero = new Hero(x, y, new Dialogue(), "hero");
                        break;
                    case ' ':
                        ground.add(new Ground(x, y, new Dialogue()));
                        break;
                    case 'N', 'M':
                        npcs.add(new NPC(x, y, npcdialogues.get(countNPC), "npc"));
                        countNPC++;
                        break;
                    case 'D':
                        door.add(new Door(x, y, doorsdialogues.get(countDoor), "door"));
                        countDoor++;
                        break;
                    case 'G':
                        housewall.add(new HouseWall(x, y, new Dialogue()));
                        break;
                    case 'F':
                        housedoor.add(new HouseDoor(x, y, new Dialogue()));
                        break;
                    case 'E':
                        roofc.add(new RoofC(x, y, new Dialogue()));
                        break;
                    case 'R':
                        roofl.add(new RoofL(x, y, new Dialogue()));
                        break;
                    case 'Y':
                        roofr.add(new RoofR(x, y, new Dialogue()));
                        break;
                    case '$':
                        path.add(new Path(x, y, new Dialogue()));
                        break;
                    case 'S':
                        stairs.add(new Stairs(x, y, stairsdialogues.get(countStairs), "stairs"));
                        countStairs++;
                        ;
                        break;
                    case '.':
                        dialogues1.add(new DialogueT(x, y, new Dialogue(), "dialogo"));
                        break;
                    case ',':
                        dialogues2.add(new DialogueT(x, y, new Dialogue(), "dialogo"));
                        break;
                    case '-':
                        dialogues3.add(new DialogueT(x, y, new Dialogue(), "dialogo"));
                        break;
                    case '_':
                        dialogues4.add(new DialogueT(x, y, new Dialogue(), "dialogo"));
                        break;
                    case '*':
                        dialogues5.add(new DialogueT(x, y, new Dialogue(), "dialogo"));
                        break;
                    case 'C':
                        chests.add(new Chest(x, y, chestsdialogues.get(countChest), "chest"));
                        countChest++;
                        break;
                    case 'T':
                        signs.add(new Sign(x, y, signdialogues.get(countSign), "sign"));
                        countSign++;
                        break;
                }
            }
        }
        village.setChests(chests);
        village.setDialogue1(dialogues1);
        village.setDialogue2(dialogues2);
        village.setDoors(door);
        village.setDialogue3(dialogues3);
        village.setGround(ground);
        village.setDialogue4(dialogues4);
        village.setDialogue5(dialogues5);
        village.setHero(hero);
        village.setHouseDoor(housedoor);
        village.setHouseWall(housewall);
        village.setNPC(npcs);
        village.setPath(path);
        village.setSigns(signs);
        village.setStairs(stairs);
        village.setWalls(walls);
        village.setRoofC(roofc);
        village.setRoofL(roofl);
        village.setRoofR(roofr);
    }
}