package network.thezone.yace.core;

import java.util.Set;

/*
 * Interface towards the board representation, it should hide the details of the
 * implementation whether it is piece-centric or square-centric or both...
 */

interface Board {

    Piece pieceOn(Square square);
    void move(Square from, Square to);
}
