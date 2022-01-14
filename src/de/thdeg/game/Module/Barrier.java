package de.thdeg.game.Module;

import de.thdeg.game.runtime.InternalLedGameThread;

import java.util.ArrayList;
import java.util.Random;


public class Barrier extends GameFigure{

    ArrayList<Short> positionen = new ArrayList<>();

    public Barrier(){
        super(1, 1, new short[]{255,0,0});
    }


    public void placeBarrier(short[] barrier) throws InterruptedException {
        for (int i=0; i<=135; i+=3) {


            //Zufallszahl, um Lücken in Barrier zu generieren
            Random random = new Random();
            int value = random.nextInt(8 + 1) + 1;

            if(value != 1) {
                short position = (short) ((ypos * 48 + xpos) * 3 + i);
                positionen.add(position);
                barrier[position] = getRgbColor(0);
                barrier[position] = getRgbColor(1);
                barrier[position] = getRgbColor(2);
            }
        }
        Thread.sleep(1);
        InternalLedGameThread.showImage(barrier);
    }


    public void moveBarrier(short[] barrier) throws InterruptedException {

        for(int y=0; y<22; y++) {

            Thread.sleep(500);

            //Verschiebung der Barriere
            for (int i = 0; i < positionen.size(); i++) {
                barrier[positionen.get(i)] = 255;
                barrier[positionen.get(i)] = 255;
                barrier[positionen.get(i)] = 255;


                barrier[positionen.get(i) +(3 * 48)] = getRgbColor(0);
                barrier[positionen.get(i) +(3 * 48)] = getRgbColor(1);
                barrier[positionen.get(i) +(3 * 48)] = getRgbColor(2);

                //Update der Positionen
                short newPosition = (short) (positionen.get(i) +(3 * 48));
                positionen.remove(i);
                positionen.add(i,newPosition);

                InternalLedGameThread.showImage(barrier);
            }
        }
    }
}
