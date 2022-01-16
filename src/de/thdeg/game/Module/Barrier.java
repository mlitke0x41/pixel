package de.thdeg.game.Module;

import de.thdeg.game.runtime.InternalLedGameThread;

import java.util.ArrayList;
import java.util.Random;


public class Barrier extends GameFigure{

    private ArrayList<Short> positionen;
    private int endPos = 0;
    private int lücken;

    public Barrier(){
        super(1, 1, new short[]{255,0,0});
        this.setPositionen(new ArrayList<>());
    }

    public ArrayList<Short> getPositionen(){
        return this.positionen;
    }

    private void setPositionen(ArrayList<Short> positionen){
        this.positionen = positionen;
    }

    public int getEndPos(){
        return endPos;
    }

    public void placeBarrier(short[] barrier) throws InterruptedException {
        lücken = 0;
        for (int i=0; i<=135; i+=3) {


            //Zufallszahl, um Lücken in Barrier zu generieren
            Random random = new Random();
            int value = random.nextInt(7 + 1) + 1;

            if(value != 1 && !(i==135 && lücken==0)) {
                short position = (short) ((ypos * 48 + xpos) * 3 + i);
                positionen.add(position);
                barrier[position + 0] = getRgbColor()[0];
                barrier[position + 1] = getRgbColor()[1];
                barrier[position + 2] = getRgbColor()[2];
            } else lücken++;
        }

        //Thread.sleep(10);
        InternalLedGameThread.showImage(barrier);
    }


    public void moveBarrier(short[] barrier) throws InterruptedException {

        //for(int y=0; y<22; y++) {

        if( endPos < 21) {

            //Verschiebung der Barriere
            for (int i = 0; i < positionen.size(); i++) {
                barrier[positionen.get(i) + 0] = 255;
                barrier[positionen.get(i) + 1] = 255;
                barrier[positionen.get(i) + 2] = 255;


                barrier[positionen.get(i) +(3 * 48) +0] = getRgbColor()[0];
                barrier[positionen.get(i) +(3 * 48) +1] = getRgbColor()[1];
                barrier[positionen.get(i) +(3 * 48) +2] = getRgbColor()[2];

                /*if ( y == 21) {
                    barrier[positionen.get(i) + 0] = 255;
                    barrier[positionen.get(i) + 1] = 255;
                    barrier[positionen.get(i) + 2] = 255;
                }*/

                //Update der Positionen
                short newPosition = (short) (positionen.get(i) +(3 * 48));
                positionen.remove(i);
                positionen.add(i,newPosition);


            }
        //Thread.sleep(200);
        InternalLedGameThread.showImage(barrier);
        }
        endPos++;
    }
}
