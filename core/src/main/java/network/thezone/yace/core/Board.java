package network.thezone.yace.core;

/*
 * Interface towards the board representation, it should hide the details of the
 * implementation whether it is piece-centric or square-centric or both...
 */

interface Board {

    PieceID pieceOn(Square square);
    void move(Square from, Square to);
    void undoMove();
    void placePiece(PieceID pieceID, Square square);
}
