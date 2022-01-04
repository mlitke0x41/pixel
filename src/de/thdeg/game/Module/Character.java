package de.thdeg.game.Module;

import java.awt.*;

public class Character extends GameFigure {
    //Creating the character object
    private static final Character character = new Character();

    //Constructor
    private Character(){
        super(0,0, Color.white);
    }

    //Getter
    public static Character getInstance(){
        return character;
    }
}
