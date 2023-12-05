package org.game.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import org.game.model.Dialogue.Dialogue;
import org.game.model.Position;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class LanternaGUI implements GUI{
    private final Screen screen;

    public LanternaGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        AWTTerminalFontConfiguration fontConfig = loadFantasyFont();
        Terminal terminal = createTerminal(width, height, fontConfig);
        this.screen = createScreen(terminal);
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }


    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException{
        TerminalSize terminalSize = new TerminalSize(width, height + 1);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);

        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }

    private AWTTerminalFontConfiguration loadSquareFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/square.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 25);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }

    private AWTTerminalFontConfiguration loadBreatheFireFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/BreatheFire.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 25);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }

    private AWTTerminalFontConfiguration loadFantasyFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/Jogo-Regular.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 30);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }


    public ACTION getNextAction() throws IOException{
        KeyStroke keyStroke = screen.pollInput();

        if(keyStroke == null){
            return ACTION.NONE;
        }
        if(keyStroke.getKeyType() == KeyType.EOF){
            return ACTION.QUIT;
        }
        if(keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q'){
            return ACTION.QUIT;
        }
        if(keyStroke.getKeyType() == KeyType.ArrowUp){
            return  ACTION.UP;
        }
        if(keyStroke.getKeyType() == KeyType.ArrowRight){
            return  ACTION.RIGHT;
        }
        if(keyStroke.getKeyType() == KeyType.ArrowDown){
            return  ACTION.DOWN;
        }
        if(keyStroke.getKeyType() == KeyType.ArrowLeft){
            return  ACTION.LEFT;
        }
        if(keyStroke.getKeyType() == KeyType.Enter){
            return ACTION.SELECT;
        }
        if(keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'z'){
            return ACTION.INTERACT;
        }

        return  ACTION.NONE;
    }

    @Override
    public void drawHero(Position position){
        drawCharacter(position.getX(), position.getY(), (char) 133, "#63E2C6");
    }

    @Override
    public void drawWall(Position position){
        drawCharacter(position.getX(), position.getY(), (char)129, "#808080");
    }

    @Override
    public void drawText(Position position, String text, String color){
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text);
    }
    @Override
    public void drawNPC(Position position){drawCharacter(position.getX(), position.getY(), (char)137, "#F3C98B");}

    @Override
    public void drawSign(Position position){drawCharacter(position.getX(), position.getY(), (char)135, "#F3C98B");}

    @Override
    public void drawChest(Position position){drawCharacter(position.getX(), position.getY(), (char) 128, "#F3C98B");}

    @Override
    public void drawDialogue1(Position position) {
        drawCharacter(position.getX(), position.getY(), (char)140, "#F3C98B");
    }
    @Override
    public void drawDialogue2(Position position) {
        drawCharacter(position.getX(), position.getY(), (char)142, "#F3C98B");
    }
    @Override
    public void drawDialogue3(Position position) {
        drawCharacter(position.getX(), position.getY(), (char)143, "#F3C98B");
    }
    @Override
    public void drawDialogue4(Position position) {
        drawCharacter(position.getX(), position.getY(), (char)141, "#F3C98B");
    }
    @Override
    public void drawDialogue5(Position position) {
        drawCharacter(position.getX(), position.getY(), (char)130, "#F3C98B");
    }

    @Override
    public void drawDialogueNarrator(Dialogue dialogue){
        drawText(new Position(23, 28), dialogue.getText() , "#FFFFFF");
    }

    @Override
    public void drawDoor(Position position){drawCharacter(position.getX(), position.getY(), (char)134, "#FFCBDB");}

    @Override
    public void drawStairs(Position position){drawCharacter(position.getX(), position.getY(), (char) 131, "#FFCBDB");}

    private  void drawCharacter(int x, int y, char c, String color){
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(x, y + 1, "" + c);
    }

    @Override
    public void clear(){
        screen.clear();
    }
    @Override
    public void refresh() throws IOException{
        screen.refresh();
    }

    @Override
    public void close() throws IOException{
        screen.close();
    }
}
