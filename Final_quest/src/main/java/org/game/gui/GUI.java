package org.game.gui;

import org.game.model.Position;

import java.io.IOException;

public interface GUI {
    void drawNPC(Position position);

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT};

    ACTION getNextAction() throws IOException;

    void drawHero(Position position);

    void drawWall(Position position);

    void drawText(Position position, String text, String color);


    void drawDoor(Position position);

    void drawStairs(Position position);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;
}


