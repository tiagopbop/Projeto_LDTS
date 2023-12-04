package org.game.model.Dialogue;


import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.virtual.DefaultVirtualTerminal;

import java.io.IOException;

public class Dialogue {
    private String text;
    public Dialogue(){this.text = "The hero stared into the void";}

    public Dialogue(String text)  {
        this.text = text;
    }

    public Dialogue(Dialogue dialogue){
        this.text = dialogue.getText();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
