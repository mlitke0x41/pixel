package de.thdeg.game.Module;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;


public class Score implements Comparable<Score> {

    private String abbreviation;
    private Timestamp startTime;
    private Timestamp endTime;
    private static ArrayList<Score> highscores = new ArrayList<>();
    private static final int MULTIPLICATION = 10;
    private static int rundenzahl = 0;
    private static int Highscore = 0;

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
        rundenzahl++;
    }

    public Timestamp getEndTime(){
        return this.endTime;
    }

    protected void setEndTime(){
        this.endTime = new Timestamp(System.currentTimeMillis());
    }

    public int getPoints(){
        return (int) ((this.endTime.getTime() - this.startTime.getTime()) / 1000);
    }

    public int getHighscore(){return Highscore;}

    @Override
    public int compareTo(Score score){

        if ( this.getPoints() > score.getPoints()) {
            return -1;
        } if ( this.getPoints() < score.getPoints()) {
            return 1;
        } else {
            return 0;
        }

    }

    public void printScore(){
        System.out.println("\nPunkte der Runde " + rundenzahl + "[" + this.getAbbreviation() + "]: \033[0;32m" + getPoints() + "\033[0m");
    }

    public void saveHighscore(int score){
        if (score > Highscore) {
            Highscore = score;
            System.out.println("\033[0;31mYou made a new Highscore!\033[0m");
        }
        highscores.add(this);
    }

    public void printHighscores(){
        StringBuilder sb = new StringBuilder();
        sb.append("Highscore: \n\n");

        Collections.sort(highscores);

        for (int i = 0; i < highscores.size(); i++) {

            if (i > 5) break;
            if (i == 0){
                sb.append("\033[0;31m").append(highscores.get(i).getAbbreviation()).append("  ").append(highscores.get(i).getPoints()).append("\033[0m\n");
            } else {
                sb.append(highscores.get(i).getAbbreviation()).append("  ").append(highscores.get(i).getPoints()).append("\n");
            }
        }
        System.out.println(sb);

    }

}
