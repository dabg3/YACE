package network.thezone.yace.core.squaremap;

import org.testng.annotations.Test;

public class SquareTest {

    /* A8_BITBOARD refers to A8 square index as mapped by InternalSquareMap.
     * Changing mapping could lead tests to fail, gotta work on this
     */
    private static final long A8_BITBOARD =
            0b10000000_00000000_00000000_00000000_00000000_00000000_00000000_00000000L;

    private static final long UNMAPPABLE_BITBOARD = 3L;

    @Test
    public void toBitboard_anySquare() {
        assert A8_BITBOARD == Square.A8.toBitboard();
    }

    @Test
    public void fromBitboard_anyValidBitboard() {
        assert Square.A8 == Square.valueOf(A8_BITBOARD);
    }

    @Test(expectedExceptions = UnmappableBitboardException.class)
    public void fromBitboard_invalidBitboard_exception() {
        Square.valueOf(UNMAPPABLE_BITBOARD);
    }
}
