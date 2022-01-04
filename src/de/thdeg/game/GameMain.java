package de.thdeg.game;

import de.thdeg.game.runtime.InternalLedGameThread;

public class GameMain {

    static public void main(String[] passedArgs) throws InterruptedException {
        short[] myImage=new short[24*48*3];
        int xpos=0;
        int ypos=0;
        int thisKey=0;

        // This is initialization, do not change this
        InternalLedGameThread.run();

        // Now we show some introductory message and wait 3s before we switch to purple
        System.out.println("Please wait for three seconds until the LED shows purple color, then you can use the cursor keys in order to move a green dot over the LED display");
        Thread.sleep(3000);
        for(int i=0; i<myImage.length; i+=3){
            myImage[i+0]=(short)255;
            myImage[i+1]=(short)0;
            myImage[i+2]=(short)0;
        }
        System.out.println("Sending to displayThread");
        InternalLedGameThread.showImage(myImage);

        // After 300ms we show the first green dot
        myImage[0] = 128;
        myImage[1] = 255;
        myImage[2] = 0;
        Thread.sleep(300);
        InternalLedGameThread.showImage(myImage);

        // Now we loop with keyboard input to show the movement of the green dot
        while(true){
            thisKey= InternalLedGameThread.getKeyboard();
            myImage[(ypos * 48 + xpos) * 3 + 0] = 255;
            myImage[(ypos * 48 + xpos) * 3 + 1] = 0;
            myImage[(ypos * 48 + xpos) * 3 + 2] = 0;
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
                myImage[(ypos * 48 + xpos) * 3 + 0] = 0;
                myImage[(ypos * 48 + xpos) * 3 + 1] = 255;
                myImage[(ypos * 48 + xpos) * 3 + 2] = 0;
                InternalLedGameThread.showImage(myImage);
            }
            Thread.sleep(100);

        }


    }

}
