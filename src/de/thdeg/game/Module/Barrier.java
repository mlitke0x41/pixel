package de.thdeg.game.Module;

import java.awt.Color;

public class Barrier extends GameFigure{

    private int width;

    public Barrier( int xpos, int ypos, int width){
        super(xpos, ypos, Color.GREEN);
        this.width = width;
    }

    public int getWidth(){
        return width
    }

    private void setWidth(int width){
        if ( width < 2 ) {
            width = 2;
        }
        this.width = width;
    }
}
