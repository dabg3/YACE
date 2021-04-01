package network.thezone.yace.core;

import java.util.Map;

import static network.thezone.yace.core.Square.File.*;

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
            0, 0, 1, 2, 3, 4, 5, 6, 7
    };

    // Big-Endian Files (file A...H -> fileIndex 7...0)
    /* using a Map because File entries order matters, initialization of
     * array indexes at runtime by file.ordinal() would require several LOC:
     * FILE_TO_INDEX[A.ordinal()] = 7
     */
    private static final Map<Square.File, Integer> FILE_TO_INDEX = Map.of(
            A, 7, B, 6, C, 5, D, 4, E, 3, F, 2, G, 1, H, 0
    );

    // LSR bitIndex = 8 * fileIndex + rankIndex
    @Override
    protected int toIndex(Square square) {
        return 8 * FILE_TO_INDEX.get(square.file) + RANK_TO_INDEX[square.rank];
    }

}
