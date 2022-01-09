package de.thdeg.game;

import de.thdeg.game.Module.*;
import de.thdeg.game.runtime.InternalLedGameThread;

public class Main {

    public static void main(String[] args) {
	Background game = new Background();
    game.setBackgroundColor(0,255,100);
    game.newGame();
    }
}
