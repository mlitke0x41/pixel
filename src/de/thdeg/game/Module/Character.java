package de.thdeg.game.Module;

import de.thdeg.game.runtime.InternalLedGameThread;
import javax.swing.JOptionPane;

public class Character extends GameFigure {
    //Creating the character object
    private static Character character = null;


    //Constructor
    private Character(){
        super(0,0, new int[]{0,255,0});
    }

    //Getter
    public static Character getInstance(){
        if ( character == null){
            character = new Character();
        }
        return character;
    }

    public void move(short[] gamer) throws InterruptedException {
        while(!isHitten()){
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
                gamer[(ypos * 48 + xpos) * 3 + 1656] = 0;
                gamer[(ypos * 48 + xpos) * 3 + 1657] = 255;
                gamer[(ypos * 48 + xpos) * 3 + 1658] = 0;
                InternalLedGameThread.showImage(gamer);
            }
            //noinspection BusyWait
            Thread.sleep(100);
        }
        JOptionPane.showMessageDialog(null,
                "DU HAST DEN SPIELBEREICH VERLASSEN!",
                "VERLOREN!",
                JOptionPane.WARNING_MESSAGE);
        toStartPosition();
    }

    private void toStartPosition(){
        this.xpos = 0;
        this.ypos = 0;
    }

    //Vorerst Berücksichtigung der Umrandung
    private boolean isHitten(){
        int position = (ypos * 48 + xpos) * 3 + 1656;
        return position <= 141 || position >= 3312 || position % 144 == 0 || ((position - 141) % 144 == 0);
    }
}
