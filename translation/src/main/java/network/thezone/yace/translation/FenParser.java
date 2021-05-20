package network.thezone.yace.translation;

import network.thezone.yace.core.Color;
import network.thezone.yace.core.Piece;
import network.thezone.yace.core.Square;
import network.thezone.yace.core.squaremap.Mappable;
import network.thezone.yace.core.squaremap.MappingBuilder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FenParser {

    private static final Mappable FEN_MAPPING = new MappingBuilder()
            .bigEndianFiles()
            .littleEndianRanks()
            .leastSignificantFileOrdering()
            .build();

    private static final int PIECE_PLACEMENT = 0;
    private static final int SIDE_TO_MOVE = 1;
    private static final int CASTLING_ABILITY = 2;
    private static final int EN_PASSANT_TARGET_SQUARES = 3;
    private static final int HALFMOVE_CLOCK = 4;
    private static final int FULLMOVE_COUNTER = 5;

    private Map<Square, Piece> piecePlacement = new HashMap<>();
    private Color sideToMove;
    private boolean[] castlingAbility = new boolean[Color.MAX_ALLOWED];
    private Set<Square> enPassantTargetSquares = new HashSet<>();
    private int halfmoveClock;
    private int fullmoveCounter;

    public void parsePosition(String fenString) {
        String[] fields = fenString.split(" ");
        parsePiecePlacement(fields[PIECE_PLACEMENT]);
        parseSideToMove(fields[SIDE_TO_MOVE]);
    }

    private void parsePiecePlacement(String placement) {

    }

    private void parseSideToMove(String side) {
        if (side.equalsIgnoreCase("w"))
            sideToMove = Color.WHITE;
        else
            sideToMove = Color.BLACK;
    }

    public Map<Square, Piece> getPiecePlacement() {
        return piecePlacement;
    }

    public Color getSideToMove() {
        return sideToMove;
    }

    public boolean[] getCastlingAbility() {
        return castlingAbility;
    }

    public Set<Square> getEnPassantTargetSquares() {
        return enPassantTargetSquares;
    }

    public int getHalfmoveClock() {
        return halfmoveClock;
    }

    public int getFullmoveCounter() {
        return fullmoveCounter;
    }
}
