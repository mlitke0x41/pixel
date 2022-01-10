package de.thdeg.game.Module;

import java.awt.Color;

public class Character extends GameFigure {
    //Creating the character object
    private static Character character = null;

    //Constructor
    private Character(){
        super(0,0, new int[]{0,255,0});
    }

    //Getter
    public static Character getInstance(){
        if ( character == null){
            character = new Character();
        }
        return character;
    }
}
