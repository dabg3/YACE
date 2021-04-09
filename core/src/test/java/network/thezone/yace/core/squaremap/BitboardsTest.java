package network.thezone.yace.core.squaremap;

import network.thezone.yace.core.Square;
import org.testng.annotations.Test;

public class BitboardsTest {

    private static final long A8_BITBOARD = 0b10000000_00000000_00000000_00000000_00000000_00000000_00000000_00000000L;
    private static final long UNMAPPABLE_BITBOARD = 3L;

    @Test
    public void toBitboard_anySquare() {
        assert A8_BITBOARD == Bitboards.parse(Square.A8);
    }

    @Test
    public void fromBitboard_anyValidBitboard() {
        assert Square.A8 == Bitboards.toSquare(A8_BITBOARD);
    }

    @Test(expectedExceptions = UnmappableBitboardException.class)
    public void fromBitboard_invalidBitboard_exception() {
        Bitboards.toSquare(UNMAPPABLE_BITBOARD);
    }
}
