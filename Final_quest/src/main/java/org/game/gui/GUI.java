package org.game.gui;

import com.googlecode.lanterna.screen.Screen;
import org.game.model.Position;
import org.game.model.game.elements.interactabel.*;
import org.game.model.game.elements.nonInteractabel.Hero_Element;
import org.game.model.game.elements.nonInteractabel.Wall;
import org.game.rpg_rules.dialogue.Dialogue;

import java.io.IOException;

public interface GUI {
    void drawNPC(NPC npcs);

    void drawSign(Sign sign);
    void drawChest(Chest chest);
    void drawBossy(Bossy bossy);


    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT, INTERACT, ESC, BACK, INVENTORY,KOMBAT};

    ACTION getNextAction() throws IOException;

    void drawHero(Hero_Element hero_element);

    void drawWall(Wall wall);

    void drawText(Position position, String text, String color);


    void drawDialogueNarrator(Dialogue dialogue);

    void drawDoor(Door door);

    void drawStairs(Stairs stairs);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;
}


