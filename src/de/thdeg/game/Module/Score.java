package de.thdeg.game.Module;

import java.sql.Timestamp;
import java.util.ArrayList;


public class Score {

    private String abbreviation;
    private Timestamp startTime;
    private Timestamp endTime;
    private static ArrayList<Score> highscores = new ArrayList<>();
    private static final int MULTIPLICATION = 10;

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

    private void setStartTime(){
        this.startTime = new Timestamp(System.currentTimeMillis());
    }

    public Timestamp getEndTime(){
        return this.endTime;
    }

    private void setEndTime(){
        this.endTime = new Timestamp(System.currentTimeMillis());
    }

    public void stopTime(){
        this.setEndTime();
    }

    public int getPoints(){
        return (int) ((this.endTime.getTime() - this.startTime.getTime()) / 1000);
    }

    public String printScore(){

        return null;
    }

    public static String printHighscores(){
        
        return null;
    }


}
