package de.thdeg.game.Module;

import de.thdeg.game.runtime.InternalLedGameThread;
import java.awt.*;

public class Background extends GameObject{
    //Instanzattribut
    short[] myImage=new short[24*48*3];

    //Konstruktor
    public Background() {
        super(Color.BLACK);
    }

    public void newGame(){
        InternalLedGameThread.run();
    }
}
