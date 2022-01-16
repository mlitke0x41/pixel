package de.thdeg.game.Module;


public abstract class GameObject {
    //Instanzattribut
    protected short[] rgbColor;

    //Constructor
    GameObject(short[] rgbColor){
        this.rgbColor = rgbColor;
    }

    //Getter
    public short[] getRgbColor(){
        return rgbColor;
    }

    //Setter
    private void setColor(short[] rgbColor){
        this.rgbColor = rgbColor;
    }
}
