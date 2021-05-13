package network.thezone.yace.core.squaremap;

public class TestSquareMap extends SquareMapper {

    /*
     * A1 = 0
     * B1 = 1
     * H8 = 63
     *
     * Compass Rose (clockwise)
     * N    +8
     * NE   +9
     * E    +1
     * SE   -7
     * S    -8
     * SW   -9
     * W    -1
     * NW   +7
     */

    TestSquareMap() {
    }



    // Little-Endian Ranks (rank 1...8 -> rankIndex 0...7)
    private static final int[] RANK_TO_INDEX = {
            0, 1, 2, 3, 4, 5, 6, 7
    };

    // Little-Endian Files (rank 1...8 -> rankIndex 0...7)
    private static final int[] FILE_TO_INDEX = {
            0, 1, 2, 3, 4, 5, 6, 7
    };

    // LSF bitIndex = 8 * fileIndex + rankIndex
    @Override
    public int toIndex(Square square) {
        return 8 * RANK_TO_INDEX[square.rankNaturalIndex - 1] + FILE_TO_INDEX[square.fileNaturalIndex - 1];
    }


}
