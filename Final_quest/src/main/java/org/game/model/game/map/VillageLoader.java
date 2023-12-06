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
    protected List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '#') walls.add(new Wall(x, y, walldialogues, "wall"));
        }

        return walls;
    }

    @Override
    protected Hero createHero() throws IOException {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'H') return new Hero(x, y, new Dialogue(), "hero");
        }
        return null;
    }
    @Override
    protected List<Ground> createGround() {
        List<Ground> ground = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == ' ' || line.charAt(x) == 'H')
                {
                    ground.add(new Ground(x, y, new Dialogue()));
                }
        }
        return ground;
    }
    @Override
    protected List<NPC> createNPC() {
        List<NPC> npcs = new ArrayList<>();
        int count = 0;

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'N')
                {
                    npcs.add(new NPC(x, y, npcdialogues.get(count), "npc"));
                    count++;
                    npcs.add(new NPC(x, y, npcdialogues.get(0)));
                }
                else if (line.charAt(x) == 'M') {
                    npcs.add(new NPC(x, y, npcdialogues.get(1)));
                }
        }
        return npcs;
    }

    @Override
    protected List<Door> createDoor() {
        int count = 0;
        List<Door> door = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'D'){
                    door.add(new Door(x, y,doorsdialogues.get(count), "door"));
                    count++;
                }
        }
        return door;
    }
    @Override
    protected List<HouseWall> createHouseWall() {

        List<HouseWall> housewall = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'G'){
                    housewall.add(new HouseWall(x, y,new Dialogue()));
                }
        }
        return housewall;
    }
    @Override
    protected List<HouseDoor> createHouseDoor() {

        List<HouseDoor> housedoor = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'F'){
                    housedoor.add(new HouseDoor(x, y,new Dialogue()));
                }
        }
        return housedoor;
    }
    @Override
    protected List<RoofC> createRoofC() {

        List<RoofC> roofc = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'E'){
                    roofc.add(new RoofC(x, y,new Dialogue()));
                }
        }
        return roofc;
    }
    @Override
    protected List<RoofL> createRoofL() {

        List<RoofL> roofl = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'R'){
                    roofl.add(new RoofL(x, y,new Dialogue()));
                }
        }
        return roofl;
    }
    @Override
    protected List<RoofR> createRoofR() {

        List<RoofR> roofr = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'Y'){
                    roofr.add(new RoofR(x, y,new Dialogue()));
                }
        }
        return roofr;
    }
    @Override
    protected List<Path> createPath() {

        List<Path> path = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '$'){
                    path.add(new Path(x, y,new Dialogue()));
                }
        }
        return path;
    }

    @Override
    protected List<Stairs> createStairs() {
        int count = 0;
        List<Stairs> stairs = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'S')
                {
                    stairs.add(new Stairs(x, y, stairsdialogues.get(count), "stairs"));
                    count++;
                }
        }
        return stairs;
    }
    @Override
    protected List<DialogueT> createDialogue1() {
        List<DialogueT> dialogues1 = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '.') dialogues1.add(new DialogueT(x, y, new Dialogue(),"dialogo"));
        }

        return dialogues1;
    }
    @Override
    protected List<DialogueT> createDialogue2() {
        List<DialogueT> dialogues2 = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == ',') dialogues2.add(new DialogueT(x, y, new Dialogue(),"dialogo"));
        }

        return dialogues2;
    }
    @Override
    protected List<DialogueT> createDialogue3() {
        List<DialogueT> dialogues3 = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '-') dialogues3.add(new DialogueT(x, y, new Dialogue(),"dialogo"));
        }

        return dialogues3;
    }
    @Override
    protected List<DialogueT> createDialogue4() {
        List<DialogueT> dialogues4 = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '_') dialogues4.add(new DialogueT(x, y, new Dialogue(),"dialogo"));
        }

        return dialogues4;
    }
    @Override
    protected List<DialogueT> createDialogue5() {
        List<DialogueT> dialogues5 = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '*') dialogues5.add(new DialogueT(x, y, new Dialogue(),"dialogo"));
        }

        return dialogues5;
    }

    @Override
    protected List<Chest> createChests() {
        int count = 0;
        List<Chest> chests = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'C')
                {
                    chests.add(new Chest(x, y, chestsdialogues.get(count), "chest"));
                    count++;
                }
        }

        return chests;
    }

    @Override
    protected List<Sign> createSigns() {
        List<Sign> signs = new ArrayList<>();
        int count = 0;

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'T'){
                    signs.add(new Sign(x, y, signdialogues.get(count),"sign"));
                    count++;
                }
        }

        return signs;
    }
}

