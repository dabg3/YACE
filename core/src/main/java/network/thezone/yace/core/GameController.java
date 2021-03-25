package network.thezone.yace.core;

import java.util.Set;

/*
 * Responsibilities
 *  - enforcing rules:
 *      - outcome of captures
 *      - piece moves (i.e bishop cannot jump other pieces, king left in check)
 */

public abstract class GameController {

    protected Board board;
    protected Side sideToMove;
    protected boolean[] castlingRights;
    protected Set<Square> enPassantTargetSquares;
    protected int halfmoveClock;
    protected int fullmoveClock;
    //protected List<Move> pastMoves;

    abstract static class Builder<T extends Builder<T>> {

        Board board;

        abstract GameController build();

        protected abstract T self();
    }

    GameController(Builder<?> builder) {

    }


}
