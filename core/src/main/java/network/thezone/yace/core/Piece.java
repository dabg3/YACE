package network.thezone.yace.core;

public enum Piece {

    //starting from A file, proceeding rank wise.
    ROOK,
    KNIGHT,
    BISHOP,
    QUEEN,
    KING,
    PAWN

    /*
     * it would be better to order pieces according to their value?
     * No, it might be misleading given that knight and bishop are equal.
     * Placement is only used for array indexes mapping.
     */
}
