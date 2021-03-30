package network.thezone.yace.core;

public enum PieceType {

    //starting from A file, proceeding rank wise.

    enum Type {
        ROOK(0),
        KNIGHT(1),
        BISHOP(2),
        QUEEN(3),
        KING(4),
        PAWN(5);

        final int index;

        Type(int index) {
            this.index = index;
        }
    }

}
