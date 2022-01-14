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
    public void move(short[] gamer) throws InterruptedException {
            int thisKey = InternalLedGameThread.getKeyboard();
            gamer[(ypos * 48 + xpos) * 3 + 1656] = 255;
            gamer[(ypos * 48 + xpos) * 3 + 1657] = 255;
            gamer[(ypos * 48 + xpos) * 3 + 1658] = 255;
            if(thisKey !=-1) {
                switch (thisKey) {
                    case 0 -> ypos--;
                    case 1 -> ypos++;
                    case 2 -> xpos--;
                    case 3 -> xpos++;
                }
                gamer[(ypos * 48 + xpos) * 3 + 1656] = getRgbColor(0);
                gamer[(ypos * 48 + xpos) * 3 + 1657] = getRgbColor(1);
                gamer[(ypos * 48 + xpos) * 3 + 1658] = getRgbColor(2);
                InternalLedGameThread.showImage(gamer);
            }
            Thread.sleep(100);
    }

    //Charakter wird in Start-Position zurückversetzt, um neues Spiel zu starten
    protected void toStartPosition(){
        this.xpos = 0;
        this.ypos = 0;
    }

    //Vorerst nur Berücksichtigung der Border
    public boolean isHitten(){
        int position = (ypos * 48 + xpos) * 3 + 1656;
        return position <= 141 || position >= 3312 || position % 144 == 0 || ((position - 141) % 144 == 0);
    }
}
