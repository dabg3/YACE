package network.thezone.yace.core;

import static network.thezone.yace.core.Piece.Type.*;
import static network.thezone.yace.core.Color.*;

public enum Piece {

    //starting from A file, proceeding rank wise.
    WHITE_ROOK(WHITE, ROOK),
    WHITE_KNIGHT(WHITE, KNIGHT),
    WHITE_BISHOP(WHITE, BISHOP),
    WHITE_QUEEN(WHITE, QUEEN),
    WHITE_KING(WHITE, KING),
    WHITE_PAWN(WHITE, PAWN),
    BLACK_PAWN(BLACK, PAWN),
    BLACK_ROOK(BLACK, ROOK),
    BLACK_KNIGHT(BLACK, KNIGHT),
    BLACK_BISHOP(BLACK, BISHOP),
    BLACK_QUEEN(BLACK, QUEEN),
    BLACK_KING(BLACK, KING);

    final Color color;
    final Type type;

    Piece(Color color, Type type) {
        this.color = color;
        this.type = type;
    }

    enum Type {
        ROOK,
        KNIGHT,
        BISHOP,
        QUEEN,
        KING,
        PAWN;

    }
}


