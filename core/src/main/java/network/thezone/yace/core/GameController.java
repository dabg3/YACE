package network.thezone.yace.core;

import network.thezone.yace.core.board.Board;
import network.thezone.yace.init.MatchInitializer;

/*
 * encapsulates the behaviour of the game.
 */

public abstract class GameController {

    protected MatchState matchState;
    protected Board board;

    public void startNewMatch(MatchInitializer matchInitializer) {
        matchState = matchInitializer.initState();
        board = matchInitializer.initBoard();
    }

    //how to encode moves? String as placeholder
    //However square names (b4,d3..) should be passed, not bitboards which
    //are an implementation detail
    public abstract boolean makeMove(String move);

    //public abstract set<Moves> generateAllMoves();
}
