package de.thdeg.game.Module;

import java.awt.*;

public abstract class GameFigure extends GameObject {
    //Instanzattribute
    private int xpos=0;
    private int ypos=0;

    //Konstruktor
    protected GameFigure(int xpos, int ypos, Color color){
        super(color);
        this.xpos = xpos;
        this.ypos = ypos;
    }

    //Getter
    public int getXpos(){
        return(this.xpos);
    }

    public int getYpos(){
        return(this.ypos);
    }

    //Setter
    private void setXpos(int xpos){
        this.xpos = xpos;
    }

    private void setYpos(int ypos){
        this.ypos = ypos;
    }
}
