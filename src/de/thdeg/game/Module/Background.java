package de.thdeg.game.Module;

import de.thdeg.game.runtime.InternalLedGameThread;
import java.util.LinkedList;

public class Background extends GameObject{
    //Instanzattribut
    private short[] image;
    private Character gamer;
    private LinkedList<Barrier> barriers;


    //Konstruktor
    public Background() {
        super(new int[]{255,255,255});
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

    private void placeGamer() throws InterruptedException {
        image[1656] = (short) gamer.rgbColor[0];
        image[1657] = (short) gamer.rgbColor[1];
        image[1658] = (short) gamer.rgbColor[2];
        Thread.sleep(300);
        InternalLedGameThread.showImage(image);
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

    public void setBorder(int a, int b, int c){
        for (int i=0; i<image.length; i+=3) {
            if(i <= 144 || i >= 3312 || i%144==0 || ((i-141)%144==0)) {
                image[i] = (short) a;
                image[i + 1] = (short) b;
                image[i + 2] = (short) c;
            }
        }
    }

    public void newGame() throws InterruptedException {
        InternalLedGameThread.run();

        while(true) {
            setBackgroundColor(rgbColor[0], rgbColor[1], rgbColor[2]);
            setBorder(0, 0, 0);
            Thread.sleep(1000);
            InternalLedGameThread.showImage(getImage());
            placeGamer();
            gamer.move(image);
        }
    }

}
