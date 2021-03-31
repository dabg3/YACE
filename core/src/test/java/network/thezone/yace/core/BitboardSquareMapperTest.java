package network.thezone.yace.core;

import org.testng.annotations.Test;

public class BitboardSquareMapperTest {


    private static long A8_BITBOARD = 0b10000000_00000000_00000000_00000000_00000000_00000000_00000000_00000000L;

    private static final BitboardSquareMapper MAPPER = new InternalSquareMap();

    @Test
    public void toBitboard_anySquare() {
        assert A8_BITBOARD == MAPPER.toBitboard(Square.A8);
    }

    @Test
    public void fromBitboard_anyValidBitboard() {
        assert Square.A8 == MAPPER.fromBitboard(A8_BITBOARD);
    }
}
