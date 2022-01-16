package de.thdeg.game.Module;

import de.thdeg.game.runtime.InternalLedGameThread;

public class Character extends GameFigure {
    //Creating the character object
    private static Character character = null;


    //Constructor
    private Character(){
        super(0,0, new short[]{0,255,0});
    }

    //Getter
    public static Character getInstance(){
        if ( character == null){
            character = new Character();
        }
        return character;
    }

    //Bewegung der Spielfigur durch Anwender, solange nicht die Border berührt wird
    public void move(short[] gamer, int key) throws InterruptedException {


            gamer[(ypos * 48 + xpos) * 3 + 1656] = 255;
            gamer[(ypos * 48 + xpos) * 3 + 1657] = 255;
            gamer[(ypos * 48 + xpos) * 3 + 1658] = 255;
            if(key !=-1) {
                switch (key) {
                    case 0 -> ypos--;
                    case 1 -> ypos++;
                    case 2 -> xpos--;
                    case 3 -> xpos++;
                }
                gamer[(ypos * 48 + xpos) * 3 + 1656] = getRgbColor()[0];
                gamer[(ypos * 48 + xpos) * 3 + 1657] = getRgbColor()[1];
                gamer[(ypos * 48 + xpos) * 3 + 1658] = getRgbColor()[2];
                InternalLedGameThread.showImage(gamer);
            }else {

                gamer[(ypos * 48 + xpos) * 3 + 1656] = getRgbColor()[0];
                gamer[(ypos * 48 + xpos) * 3 + 1657] = getRgbColor()[1];
                gamer[(ypos * 48 + xpos) * 3 + 1658] = getRgbColor()[2];
            }
            Thread.sleep(10);
            InternalLedGameThread.showImage(gamer);
    }

    //Charakter wird in Start-Position zurückversetzt, um neues Spiel zu starten
    protected void toStartPosition(){
        this.xpos = 0;
        this.ypos = 0;
    }

    //Vorerst nur Berücksichtigung der Border
    public boolean isHitten(short[] rgbColor, short[] image, int key){

        int bufferYpos = this.ypos;
        int bufferXpos = this.xpos;

        if (key != -1) {
            switch (key) {
                case 0 -> bufferYpos--;
                case 1 -> bufferYpos++;
                case 2 -> bufferXpos--;
                case 3 -> bufferXpos++;
            }
        }

        if ( image[(bufferYpos * 48 + bufferXpos) * 3 + 1656] == rgbColor[0] &&
             image[(bufferYpos * 48 + bufferXpos) * 3 + 1657] == rgbColor[1] &&
             image[(bufferYpos * 48 + bufferXpos) * 3 + 1658] == rgbColor[2]){
            return true;
        }

        int position = (ypos * 48 + xpos) * 3 + 1656;
        return position <= 141 || position >= 3312 || position % 144 == 0 || ((position - 141) % 144 == 0);
    }
}
