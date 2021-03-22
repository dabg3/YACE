package network.thezone.yace.core;

import network.thezone.yace.core.board.Board;
import network.thezone.yace.init.Initializer;

/*
 * encapsulates the behaviour of the game.
 */

public abstract class Game {

    protected GameState gameState;
    protected Board board;

    public Game(Initializer initializer) {
        gameState = initializer.initGameState();
    }

    //how to encode moves? String as placeholder
    public abstract boolean makeMove(String move);

    //public abstract set<Moves> generateAllMoves();
}
