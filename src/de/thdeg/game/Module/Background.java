package de.thdeg.game.Module;

import de.thdeg.game.runtime.InternalLedGameThread;
import javax.swing.*;


public class Background extends GameObject{
    //Instanzattribut
    private short[] image;
    private Character gamer;
    private Barrier barriers;
    private int timer = 0;
    private int speed = 17;
    private int acceleration = 0;


    //Konstruktor
    public Background() {
        super(new short[]{255,255,255});
        this.setImage(new short[24*48*3]);
        this.setGamer(Character.getInstance());
    }

    //Getter
    public short[] getImage(){
        return this.image;
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
        image[1656] = gamer.rgbColor[0];
        image[1657] = gamer.rgbColor[1];
        image[1658] = gamer.rgbColor[2];
        Thread.sleep(300);
        InternalLedGameThread.showImage(image);
    }


    //Barrier-Methoden
    private void setBarriers(){
        this.barriers = new Barrier();
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


    /*
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
    }*/

    //Zeigt auf Spielfeld "Loose" an
    public void showLooseMessage() {
        //Spielfeld wird zurückgesetzt
        setBackgroundColor(rgbColor[0],rgbColor[1],rgbColor[2]);
        setBorder(0,0,0);
        InternalLedGameThread.showImage(image);

        //L
        for (int i=0; i<=7; i++) {
            image[1176 + (i*48*3)] = 255;
            image[1177 + (i*48*3)] = 0;
            image[1178 + (i*48*3)] = 0;

            if(i==7){
                for (int j=0; j<=7; j++) {
                    image[1176 + (i * 48 * 3) + (j*3)] = 255;
                    image[1177 + (i * 48 * 3) + (j*3)] = 0;
                    image[1178 + (i * 48 * 3) + (j*3)] = 0;
                }
            }
        }

        //O wird eingeblendet
        for (int i=0; i<=7; i++) {
            image[1200 + (i*48*3)] = 255;
            image[1201 + (i*48*3)] = 0;
            image[1202 + (i*48*3)] = 0;

            if(i==0){
                for (int j=0; j<=7; j++) {
                    image[1200 + (i * 48 * 3) + (j * 3)] = 255;
                    image[1201 + (i * 48 * 3) + (j * 3)] = 0;
                    image[1202 + (i * 48 * 3) + (j * 3)] = 0;
                }
            }

            if(i==7){
                for (int j=0; j<=7; j++) {
                    image[1200 + (i * 48 * 3) + (j*3)] = 255;
                    image[1201 + (i * 48 * 3) + (j*3)] = 0;
                    image[1202 + (i * 48 * 3) + (j*3)] = 0;

                    if(j==7){
                        for(int o=0; o<=7; o++) {
                            image[1200 + (i * 48 * 3) + (j*3) - (o*48*3)] = 255;
                            image[1201 + (i * 48 * 3) + (j*3) - (o*48*3)] = 0;
                            image[1202 + (i * 48 * 3) + (j*3) - (o*48*3)] = 0;
                        }
                    }
                }
            }
        }

        //S wird eingeblendet
        for (int i=0; i<=4; i++) {
            image[1224 + (i*48*3)] = 255;
            image[1225 + (i*48*3)] = 0;
            image[1226 + (i*48*3)] = 0;

            if(i==0){
                for (int j=0; j<=7; j++) {
                    image[1224 + (i * 48 * 3) + (j * 3)] = 255;
                    image[1225 + (i * 48 * 3) + (j * 3)] = 0;
                    image[1226 + (i * 48 * 3) + (j * 3)] = 0;
                }
            }

            if(i==4){
                for (int j=0; j<=7; j++) {
                    image[1224 + (i * 48 * 3) + (j*3)] = 255;
                    image[1225 + (i * 48 * 3) + (j*3)] = 0;
                    image[1226 + (i * 48 * 3) + (j*3)] = 0;

                    if(j==7){
                        for(int o=0; o<=3; o++) {
                            image[1224 + (i * 48 * 3) + (j*3) + (o*48*3)] = 255;
                            image[1225 + (i * 48 * 3) + (j*3) + (o*48*3)] = 0;
                            image[1226 + (i * 48 * 3) + (j*3) + (o*48*3)] = 0;

                            if(o==3){
                                for (int l=0; l<=7; l++) {
                                    image[1224 + (i * 48 * 3) + (j * 3) + (o * 48 * 3) - (l * 3)] = 255;
                                    image[1225 + (i * 48 * 3) + (j * 3) + (o * 48 * 3) - (l * 3)] = 0;
                                    image[1226 + (i * 48 * 3) + (j * 3) + (o * 48 * 3) - (l * 3)] = 0;
                                }
                            }
                        }
                    }
                }
            }
        }

        //T wird eingeblendet
        for (int j=0; j<=7; j++) {
            image[1248 + (j * 3)] = 255;
            image[1249 + (j * 3)] = 0;
            image[1250 + (j * 3)] = 0;

            if(j==3) {
                for (int i=0; i<=7; i++) {
                    image[1248 + (j * 3) + (i * 48 * 3)] = 255;
                    image[1249 + (j * 3) + (i * 48 * 3)] = 0;
                    image[1250 + (j * 3) + (i * 48 * 3)] = 0;
                }
            }

            if(j==4) {
                for (int i=0; i<=7; i++) {
                    image[1248 + (j * 3) + (i * 48 * 3)] = 255;
                    image[1249 + (j * 3) + (i * 48 * 3)] = 0;
                    image[1250 + (j * 3) + (i * 48 * 3)] = 0;
                }
            }
        }
        InternalLedGameThread.showImage(image);
    }

    //Hauptmethode, worüber das Spiel läuft
    public void newGame() throws InterruptedException {
        InternalLedGameThread.run();
        Score score = new Score();
        int lastHighscore;
        int thiskey;
        setBarriers();
        score.setStartTime();
        setBackgroundColor(rgbColor[0], rgbColor[1], rgbColor[2]);
        setBorder(0, 0, 0);
        Thread.sleep(200);
        placeGamer();
        barriers.placeBarrier(image);

        //Schleife läuft bis Anwender über Messagebox beendet
        while(true) {

            if ( score == null){
                score = new Score();
                score.setStartTime();
            }

            if ( barriers == null){
                setBarriers();
                placeGamer();
                barriers.placeBarrier(image);
            }

            if ( barriers.getEndPos() == 21){
                setBarriers();
                setBackgroundColor(rgbColor[0], rgbColor[1], rgbColor[2]);
                setBorder(0, 0, 0);
                barriers.placeBarrier(image);
            }


            InternalLedGameThread.showImage(getImage());

            //Geschwindigkit und Beschleunigung der Barriere
            if (timer > speed) {
                if (acceleration==20 && speed>=7) {
                    speed--;
                    acceleration = 0;
                }

                barriers.moveBarrier(image);
                timer = 0;

                if (speed >= 7) {
                    acceleration++;
                }

            } else timer++;


            thiskey = InternalLedGameThread.getKeyboard();


            if ( gamer.isHitten(barriers.getRgbColor(), image, thiskey)){
                gamer.toStartPosition();


                //Berechnung und Ausgabe des Scores
                score.setEndTime();
                score.printScore();

                //Zur Prüfung, ob es sich um einen neuen Highscore handelt!
                lastHighscore = score.getHighscore();

                //Speicherung und Ausgabe des Highscores
                score.saveHighscore(score.getPoints());
                score.printHighscores();

                setBackgroundColor(rgbColor[0], rgbColor[1], rgbColor[2]);
                setBorder(0, 0, 0);

                //Ausgabe der Todesnachricht mit Option zu Neustart/Beendigung
                //deathMessage(score.getPoints(), score.getHighscore(), lastHighscore);
                barriers = null;
                score = null;
                speed = 17;
                acceleration = 0;
                timer = 0;
                showLooseMessage();
                Thread.sleep(5000);
                setBackgroundColor(rgbColor[0],rgbColor[1],rgbColor[2]);
                setBorder(0,0,0);
            }else {
                gamer.move(image, thiskey);
            }

        }
    }

}
