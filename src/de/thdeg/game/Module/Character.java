package de.thdeg.game.Module;

import de.thdeg.game.runtime.InternalLedGameThread;
import javax.swing.JOptionPane;

public class Character extends GameFigure {
    //Creating the character object
    private static Character character = null;
    private int thisKey = 0;


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
            thisKey= InternalLedGameThread.getKeyboard();
            gamer[(ypos * 48 + xpos) * 3 + 1656] = 255;
            gamer[(ypos * 48 + xpos) * 3 + 1657] = 255;
            gamer[(ypos * 48 + xpos) * 3 + 1658] = 255;
            if(thisKey!=-1) {
                switch (thisKey) {
                    case 0:
                        ypos--;
                        break;
                    case 1:
                        ypos++;
                        break;
                    case 2:
                        xpos--;
                        break;
                    case 3:
                        xpos++;
                        break;
                }
                gamer[(ypos * 48 + xpos) * 3 + 1656] = 0;
                gamer[(ypos * 48 + xpos) * 3 + 1657] = 255;
                gamer[(ypos * 48 + xpos) * 3 + 1658] = 0;
                InternalLedGameThread.showImage(gamer);
            }
            Thread.sleep(100);
        }
        JOptionPane.showMessageDialog(null,
                "DU HAST DEN SPIELBEREICH VERLASSEN!",
                "VERLOREN!",
                JOptionPane.WARNING_MESSAGE);
        return;
    }

    //Vorerst Berücksichtigung der Umrandung
    public boolean isHitten(){
        int position = (ypos * 48 + xpos) * 3 + 1656;
        if (position <= 141 || position >= 3312 || position%144==0 || ((position-141)%144==0)){
            return true;
        } else return false;
    }
}
