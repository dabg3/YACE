package network.thezone.yace.core;

import java.util.Set;

/*
 * Interface towards the board representation, it should hide the details of the
 * implementation whether it is piece-centric or square-centric or both...
 */

interface Board {

    boolean isSquareOccupied(Square square);
    boolean isRangeFree(Square from, Square to);
    Piece getPieceOn(Square square);
    Set<Square> getSquaresOccupiedBy(Side side, Piece piece);
    void place(Side side, Piece piece, Square square);
    void free(Square square);
    //public abstract boolean move();


}
