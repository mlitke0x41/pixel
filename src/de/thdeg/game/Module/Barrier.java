package de.thdeg.game.Module;

public class Barrier extends GameFigure{

    private int width;

    public Barrier( int xpos, int ypos, int width){
        super(xpos, ypos, new int[]{0,255,0});
        this.width = width;
    }

    public int getWidth(){
        return width;
    }

    private void setWidth(int width){
        if ( width < 2 ) {
            width = 2;
        }
        this.width = width;
    }
}
