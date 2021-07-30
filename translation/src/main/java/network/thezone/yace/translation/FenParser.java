package network.thezone.yace.translation;

import network.thezone.yace.core.Color;
import network.thezone.yace.core.PieceID;
import network.thezone.yace.core.Square;
import network.thezone.yace.core.squaremap.Mapper;
import network.thezone.yace.core.squaremap.MappingBuilder;

import java.util.HashMap;
import java.util.Map;

public class FenParser {

    private static final Mapper FEN_MAPPING = new MappingBuilder()
            .littleEndianFiles()
            .bigEndianRanks()
            .leastSignificantFileOrdering()
            .build();

    private static final int PIECE_PLACEMENT = 0;
    private static final int SIDE_TO_MOVE = 1;
    private static final int CASTLING_ABILITY = 2;
    private static final int EN_PASSANT_TARGET_SQUARES = 3;
    private static final int HALFMOVE_CLOCK = 4;
    private static final int FULLMOVE_COUNTER = 5;

    private static final int ASCII_DIGIT_0 = 48;

    public void parsePosition(String fenString) {
        String[] fields = fenString.split(" ");
        parsePiecePlacement(fields[PIECE_PLACEMENT]);
        parseSideToMove(fields[SIDE_TO_MOVE]);
        parseCastlingAbility(fields[CASTLING_ABILITY]);
    }

    private Map<Square, PieceID> parsePiecePlacement(String placement) {
        Map<Square, PieceID> piecePlacement = new HashMap<>();
        String[] rows = placement.split("/");
        int squareIndex = 0;
        for (String row : rows) {
            char[] elements = row.toCharArray();
            for (char element : elements) {
                if (Character.isDigit(element))
                    squareIndex += element - ASCII_DIGIT_0;
                else {
                    Square occupiedSquare = FEN_MAPPING.squareAt(squareIndex++);
                    PieceID placedPiece = toPiece(element);
                    piecePlacement.put(occupiedSquare, placedPiece);
                }
            }
        }
        return piecePlacement;
    }

    private PieceID toPiece(char piece) {
        switch (piece) {
            case 'r':
                return PieceID.BLACK_ROOK;
            case 'n':
                return PieceID.BLACK_KNIGHT;
            case 'b':
                return PieceID.BLACK_BISHOP;
            case 'q':
                return PieceID.BLACK_QUEEN;
            case 'k':
                return PieceID.BLACK_KING;
            case 'p':
                return PieceID.BLACK_PAWN;
            case 'R':
                return PieceID.WHITE_ROOK;
            case 'N':
                return PieceID.WHITE_KNIGHT;
            case 'B':
                return PieceID.WHITE_BISHOP;
            case 'Q':
                return PieceID.WHITE_QUEEN;
            case 'K':
                return PieceID.WHITE_KING;
            case 'P':
                return PieceID.WHITE_PAWN;
            default:
                throw new IllegalArgumentException(String.format("No such piece: %c", piece));
        }
    }

    private Color parseSideToMove(String side) {
        return side.equalsIgnoreCase("w") ? Color.WHITE : Color.BLACK;
    }

    private void parseCastlingAbility(String castling) {

    }

}
