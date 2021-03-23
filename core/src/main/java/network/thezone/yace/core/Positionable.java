package network.thezone.yace.core;

import network.thezone.yace.core.Piece;
import network.thezone.yace.core.Side;
import network.thezone.yace.core.Square;

import java.util.Set;

public interface Positionable {

    Set<Square> getPiecePlacement(Piece piece, Side side);
    Side getSideToMove();
    boolean getCastlingRight(Side side);
    Set<Square> getEnPassantTargets(Side side);
    int getHalfmoveClock();
    int getFullmoveCounter();

}
