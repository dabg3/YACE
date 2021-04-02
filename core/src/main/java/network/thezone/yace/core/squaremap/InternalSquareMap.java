package network.thezone.yace.core.squaremap;

import network.thezone.yace.core.Square;

final class InternalSquareMap extends SquareMapper {

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

    // Little-Endian Ranks (rank 1...8 -> rankIndex 0...7)
    private static final int[] RANK_TO_INDEX = {
            0, 1, 2, 3, 4, 5, 6, 7
    };

    // Big-Endian Files (file A...H -> fileIndex 7...0)
    private static final int[] FILE_TO_INDEX = {
            7, 6, 5, 4, 3, 2, 1, 0
    };

    // LSR bitIndex = 8 * fileIndex + rankIndex
    @Override
    protected int toIndex(Square square) {
        return 8 * FILE_TO_INDEX[square.file.naturalIndex - 1] + RANK_TO_INDEX[square.rankNaturalIndex - 1];
    }

}
