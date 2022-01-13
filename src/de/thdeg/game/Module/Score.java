package de.thdeg.game.Module;

import java.sql.Timestamp;
import java.util.ArrayList;


public class Score {

    private String abbreviation;
    private Timestamp startTime;
    private Timestamp endTime;
    private static ArrayList<Score> highscores = new ArrayList<>();
    private static final int MULTIPLICATION = 10;
    private int Rundenzahl = 0;

    public Score (){
        this.setAbbreviation();
        this.setEndTime();
    }

    public String getAbbreviation(){
        return this.abbreviation;
    }

    private void setAbbreviation(){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWYXZ";

        StringBuilder sb = new StringBuilder(3);

        for (int i = 0; i < 3; i++){

            // generate a random number between
            // 0 to alphabet variable length
            int index = (int)(alphabet.length() * Math.random());

            // add Character one by one in end of sb
            sb.append(alphabet.charAt(index));

        }

        this.abbreviation = sb.toString();
    }

    public Timestamp getStartTime(){
        return this.startTime;
    }

    protected void setStartTime(){
        this.startTime = new Timestamp(System.currentTimeMillis());
        Rundenzahl++;
    }

    public Timestamp getEndTime(){
        return this.endTime;
    }

    protected void setEndTime(){
        this.endTime = new Timestamp(System.currentTimeMillis());
    }

    public void stopTime(){
        this.setEndTime();
    }

    public int getPoints(){
        return (int) ((this.endTime.getTime() - this.startTime.getTime()) / 1000);
    }

    public void printScore(){
        System.out.println("Punkte der Runde " + Rundenzahl + ": " + getPoints());
    }

    public static String printHighscores(){
        
        return null;
    }


}
