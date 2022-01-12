package de.thdeg.game.Module;

public abstract class GameFigure extends GameObject {
    //Instanzattribute
    protected int xpos;
    protected int ypos;

    //Konstruktor
    protected GameFigure(int xpos, int ypos, int[] rgbColor){
        super(rgbColor);
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
