package network.thezone.yace.init;


import network.thezone.yace.core.MatchState;
import network.thezone.yace.core.board.Board;

public interface MatchInitializer {

    MatchState initState();
    Board initBoard();


}
