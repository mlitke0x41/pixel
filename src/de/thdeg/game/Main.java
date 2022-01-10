package de.thdeg.game;

import de.thdeg.game.Module.*;
import de.thdeg.game.runtime.InternalLedGameThread;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	Background game = new Background();
    InternalLedGameThread.run();
    game.setBackgroundColor(0,255,100);
    Thread.sleep(1000);
    InternalLedGameThread.showImage(game.getImage());
    }
}
