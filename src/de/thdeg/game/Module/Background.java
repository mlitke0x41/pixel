package de.thdeg.game.Module;

import de.thdeg.game.runtime.InternalLedGameThread;
import java.awt.Color;
import java.util.LinkedList;

public class Background extends GameObject{
    //Instanzattribut
    private short[] image=new short[24*48*3];
    private Character gamer;
    private LinkedList<Barrier> barriers;


    //Konstruktor
    public Background() {
        super(Color.BLACK);
        this.setImage(new short[24*48*3]);
        this.setGamer(Character.getInstance());
        this.setBarriers(new LinkedList<>());

    }

    public short[] getImage(){
        return this.image;
    }

    private void setImage(short[] image) {
        this.image = image;
    }

    public Character getGamer(){
        return this.gamer;
    }

    private void setGamer(Character gamer){
        this.gamer = gamer;
    }

    public LinkedList<Barrier> getBarriers(){
        return this.barriers;
    }

    private void setBarriers(LinkedList<Barrier> barriers){
        this.barriers = barriers;
    }

    public void setBackgroundColor(int a, int b, int c){
        for (int i=0; i<image.length; i+=3) {
            image[i] = (short)a;
            image[i+1] = (short)b;
            image[i+2] = (short)c;
        }
    }

    public void newGame(){
        InternalLedGameThread.run();
        InternalLedGameThread.showImage(getImage());
    }

}
