package de.thdeg.game.Module;

import de.thdeg.game.runtime.InternalLedGameThread;
import java.util.LinkedList;
import de.thdeg.game.Module.Score;

import javax.swing.*;

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

    //Getter
    public short[] getImage(){
        return this.image;
    }

    public Character getGamer(){
        return this.gamer;
    }


    //Setter
    private void setImage(short[] image) {
        this.image = image;
    }

    private void setGamer(Character gamer){
        this.gamer = gamer;
    }


    //Platzierung der Spielfigur
    private void placeGamer() throws InterruptedException {
        image[1656] = (short) gamer.rgbColor[0];
        image[1657] = (short) gamer.rgbColor[1];
        image[1658] = (short) gamer.rgbColor[2];
        Thread.sleep(300);
        InternalLedGameThread.showImage(image);
    }


    //Barrier-Methoden
    public LinkedList<Barrier> getBarriers(){
        return this.barriers;
    }

    private void setBarriers(LinkedList<Barrier> barriers){
        this.barriers = barriers;
    }


    //Methoden zur Zeichnung des Spielfeldes
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


    //Implementierung einer Todesnachricht
    public void deathMessage(int score, int highscore, int lastHigh) {
        String[] options = {"Restart", "Leave"};

        //Prüfung, ob Highscore neu ist oder nicht -> Bei true wird "NEW" ausgegeben
        if (score > lastHigh) {
            int result = JOptionPane.showOptionDialog(null,
                    "Score: " + score + "\n" +
                            "NEW Highscore: " + highscore + "\n" +
                            "Wanna play again?",
                    "YOU LOOSE!",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    1);
            if (result == JOptionPane.NO_OPTION) System.exit(0);
        } else if (score <= highscore) {
            int result = JOptionPane.showOptionDialog(null,
                    "Score: " + score + "\n" +
                            "Highscore: " + highscore + "\n" +
                            "Wanna play again?",
                    "YOU LOOSE!",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    1);
            if (result == JOptionPane.NO_OPTION) System.exit(0);
        }
    }

    //Hauptmethode, worüber das Spiel läuft
    public void newGame() throws InterruptedException {
        InternalLedGameThread.run();
        Score score = new Score();
        int lastHighscore = 0;

        //Schleife läuft bis Anwender über Messagebox beendet
        while(true) {
            score.setStartTime();

            //Erschaffung des Spielfeldes
            setBackgroundColor(rgbColor[0], rgbColor[1], rgbColor[2]);
            setBorder(0, 0, 0);
            Thread.sleep(1000);
            InternalLedGameThread.showImage(getImage());
            placeGamer();

            //Die move()-Methode muss eventuell noch freier gestaltet werden, dass die "Zeichnung" des Hintergrundes
            //in er Background-Klasse passiert und nicht in der Character-Klasse.
            //Ansonsten gibt es eventuell ein Problem mit der Zeichnung der Barrier.
            gamer.move(image);

            //Berechnung und Ausgabe des Scores
            score.setEndTime();
            score.printScore();

            //Zur Prüfung, ob es sich um einen neuen Highscore handelt!
            lastHighscore = score.getHighscore();

            //Speicherung und Ausgabe des Highscores
            score.saveHighscore(score.getPoints());
            score.printHighscores();

            //Ausgabe der Todesnachricht mit Option zu Neustart/Beendigung
            deathMessage(score.getPoints(), score.getHighscore(), lastHighscore);
        }
    }

}
