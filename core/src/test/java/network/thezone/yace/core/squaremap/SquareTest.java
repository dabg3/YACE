package network.thezone.yace.core.squaremap;

import org.testng.annotations.Test;

public class SquareTest {

    private static final long A1_TESTMAP_BITBOARD = 1L;

    private static final long UNMAPPABLE_BITBOARD = 3L;

    @Test
    public void toBitboard_anySquare() {
        new FakeInternalSquareMap();
        assert A1_TESTMAP_BITBOARD == Square.A1.toBitboard();
    }

    @Test
    public void fromBitboard_anyValidBitboard() {
        new FakeInternalSquareMap();
        assert Square.A1 == Square.valueOf(A1_TESTMAP_BITBOARD);
    }

    @Test(expectedExceptions = UnmappableBitboardException.class)
    public void fromBitboard_invalidBitboard_exception() {
        Square.valueOf(UNMAPPABLE_BITBOARD);
    }
}
