package de.thdeg.game.Module;


public abstract class GameObject {
    //Instanzattribut
    protected int[] rgbColor;

    //Constructor
    GameObject(int[] rgbColor){
        this.rgbColor = rgbColor;
    }

    //Getter
    public int[] getRgbColor(){
        return(rgbColor);
    }

    //Setter
    private void setColor(int[] rgbColor){
        this.rgbColor = rgbColor;
    }

}
