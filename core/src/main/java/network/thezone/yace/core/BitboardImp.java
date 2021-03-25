package network.thezone.yace.core;

import java.util.Map;
import java.util.Set;

import static network.thezone.yace.core.Square.*;
import static network.thezone.yace.core.Square.File.*;

class BitboardImp implements Board {

    @Override
    public boolean isSquareOccupied(Square square) {
        return false;
    }

    @Override
    public boolean isRangeFree(Square from, Square to) {
        return false;
    }

    @Override
    public Piece getPieceOn(Square square) {
        return null;
    }

    @Override
    public Set<Square> getSquaresOccupiedBy(Side side, Piece piece) {
        return null;
    }

    @Override
    public void place(Side side, Piece piece, Square square) {

    }

    @Override
    public void free(Square square) {

    }

    private static class SquareMapper {

        /*
         * A8 = 63
         * A7 = 62
         * H1 = 0
         *
         * Compass Rose (clockwise)
         * N    +1
         * NE   -7
         * E    -8
         * SE   -9
         * S    -1
         * SW   +7
         * W    +8
         * NW   +9
         */

        private static final Square[] INDEX_TO_SQUARE = {
                H1, H2, H3, H4, H5, H6, H7, H8,
                G1, G2, G3, G4, G5, G6, G7, G8,
                F1, F2, F3, F4, F5, F6, F7, F8,
                E1, E2, E3, E4, E5, E6, E7, E8,
                D1, D2, D3, D4, D5, D6, D7, D8,
                C1, C2, C3, C4, C5, C6, C7, C8,
                B1, B2, B3, B4, B5, B6, B7, B8,
                A1, A2, A3, A4, A5, A6, A7, A8
        };

        // Little-Endian Ranks (rank 1...8 -> rankIndex 0...7)
        private static final int[] RANK_TO_INDEX = {
                0, 0, 1, 2, 3, 4, 5, 6, 7
        };

        // Big-Endian Files (file A...H -> fileIndex 7...0)
        private static final Map<Square.File, Integer> FILE_TO_INDEX = Map.of(
                A, 7, B, 6, C, 5, D, 4, E, 3, F, 2, G, 1, H, 0
        );

        static Square indexToSquare(int index) {
            return INDEX_TO_SQUARE[index];
        }

        // LSR bitIndex = 8 * fileIndex + rankIndex
        static int squareToIndex(Square square) {
            return 8 * FILE_TO_INDEX.get(square.file) + RANK_TO_INDEX[square.rank];
        }
    }


}