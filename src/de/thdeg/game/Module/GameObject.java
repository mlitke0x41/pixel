package de.thdeg.game.Module;

import java.awt.*;
import static java.awt.Color.*;



public abstract class GameObject {
    //Instanzattribut
    private Color color;

    //Constructor
    GameObject(Color color){
        this.color = color;
    }

    //Getter
    public Color getColor(){
        return(color);
    }

    //Setter
    private void setColor(Color color){
        this.color = color;
    }

    //Print-Method

}
