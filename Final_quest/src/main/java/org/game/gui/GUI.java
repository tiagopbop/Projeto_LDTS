package org.game.gui;

import com.googlecode.lanterna.screen.Screen;
import org.game.model.Position;
import org.game.model.dialogue.Dialogue;

import java.io.IOException;

public interface GUI {
    void drawGround(Position position);
    void drawNPC1(Position position);
    void drawNPC2(Position position);

    void drawSign(Position position);
    void drawHouseWall(Position position);
    void drawHouseDoor(Position position);
    void drawRoofL(Position position);
    void drawRoofR(Position position);
    void drawRoofC(Position position);
    void drawPath(Position position);
    void drawChest(Position position);

    void drawDialogue1(Position position);
    void drawDialogue2(Position position);
    void drawDialogue3(Position position);
    void drawDialogue4(Position position);
    void drawDialogue5(Position position);

    Screen getScreen();

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT, INTERACT};

    ACTION getNextAction() throws IOException;

    void drawHero(Position position);

    void drawWall(Position position);

    void drawText(Position position, String text, String color);


    void drawDialogueNarrator(Dialogue dialogue);

    void drawDoor(Position position);

    void drawStairs(Position position);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;
}


