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
import org.game.model.Position;
import org.game.model.game.elements.interactabel.*;
import org.game.model.game.elements.nonInteractabel.Hero_Element;
import org.game.model.game.elements.nonInteractabel.Wall;
import org.game.rpg_rules.dialogue.Dialogue;

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

    public Screen getScreen() {
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
        if(keyStroke.getKeyType()==KeyType.Character && keyStroke.getCharacter()=='b')
        {
            return ACTION.BACK;
        }

        if(keyStroke.getKeyType()==KeyType.Character && keyStroke.getCharacter()=='p')
        {
            return ACTION.INVENTORY;
        }
        if(keyStroke.getKeyType()==KeyType.Character && keyStroke.getCharacter()=='k')
        {
            return ACTION.KOMBAT;
        }
        if(keyStroke.getKeyType()==KeyType.Escape)
        {return  ACTION.ESC;}

        return  ACTION.NONE;
    }

    @Override
    public void drawHero(Hero_Element hero_element){drawCharacter(hero_element.getPosition().getX(), hero_element.getPosition().getY(), hero_element.getDesenho(), hero_element.getCor(), hero_element.getBackCor());}

    @Override
    public void drawWall(Wall wall) {drawCharacter(wall.getPosition().getX(), wall.getPosition().getY(), wall.getDesenho(), wall.getCor(), wall.getBackCor());}

    @Override
    public void drawText(Position position, String text, String color){
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text);
    }
    @Override
    public void drawNPC(NPC npcs) {drawCharacter(npcs.getPosition().getX(), npcs.getPosition().getY(), npcs.getDesenho(), npcs.getCor(), npcs.getBackCor());}
    @Override
    public void drawSign(Sign sign){drawCharacter(sign.getPosition().getX(), sign.getPosition().getY(), sign.getDesenho(), sign.getCor(), sign.getBackCor());}

    @Override
    public void drawChest(Chest chest){drawCharacter(chest.getPosition().getX(), chest.getPosition().getY(), chest.getDesenho(), chest.getCor(), chest.getBackCor());}

    @Override
    public void drawDialogueNarrator(Dialogue dialogue){
        drawText(new Position(1, 27), dialogue.getTitle() , "#FFFFFF");
        dialogue.reset_pos();

        for(int i = 0; i < 4; i++){
            if(dialogue.has_line()){
                dialogue.add_pos();
                drawText(new Position(1, 28 + i), dialogue.getTexto().get(i) , "#FFFFFF");
            }
        }
    }
    @Override
    public void drawDoor(Door door){drawCharacter(door.getPosition().getX(), door.getPosition().getY(), door.getDesenho(), door.getCor(), door.getBackCor());}

    @Override
    public void drawStairs(Stairs stairs){drawCharacter(stairs.getPosition().getX(), stairs.getPosition().getY(), stairs.getDesenho(), stairs.getCor(), stairs.getBackCor());}

    private  void drawCharacter(int x, int y, char c, String color, String colorBack){
        if (colorBack == "") {
            TextGraphics tg = screen.newTextGraphics();
            tg.setBackgroundColor(TextColor.Factory.fromString("#0C450D"));
            tg.setForegroundColor(TextColor.Factory.fromString(color));
            tg.putString(x, y + 1, "" + c);
        } else {
            TextGraphics tg = screen.newTextGraphics();
            tg.setBackgroundColor(TextColor.Factory.fromString(colorBack));
            tg.setForegroundColor(TextColor.Factory.fromString(color));
            tg.putString(x, y + 1, "" + c);
        }
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
