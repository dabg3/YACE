package network.thezone.yace.core;

import java.util.Set;

public abstract class Piece {

    protected PieceType type;

    Piece(PieceType type) {
        this.type = type;
    }

    abstract Move calculateMove(long from, long to, long occupiedSquares);

    abstract Set<Move> calculateAllMoves(long from, long occupiedSquare);


}
