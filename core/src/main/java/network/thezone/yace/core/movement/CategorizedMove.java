package network.thezone.yace.core.movement;

import network.thezone.yace.core.Square;

public class CategorizedMove extends Move {

    private final Type type;

    public CategorizedMove(Square from, Square to, Type type) {
        super(from, to);
        this.type = type;
    }

    public enum Type {
        QUIET, CAPTURE, EN_PASSANT, CASTLING;
    }


}
