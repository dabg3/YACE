package network.thezone.yace.core;

import network.thezone.yace.core.exceptions.NoSuchSquareException;
import org.testng.annotations.Test;

public class SquareMapperTest {

    private static long A8_BITBOARD = 0b10000000_00000000_00000000_00000000_00000000_00000000_00000000_00000000L;

    SquareMapper MAPPER = new InternalSquareMap();

    @Test
    public void mapper_internalMapping_msbA8lsbH1FileRank() {
        int MSB = 63;
        int nextToMSB = 62;
        int LSB = 0;

        assert Square.A8 == MAPPER.fromIndex(MSB);
        assert Square.A7 == MAPPER.fromIndex(nextToMSB);
        assert Square.H1 == MAPPER.fromIndex(LSB);
    }


    @Test(expectedExceptions = NoSuchSquareException.class)
    public void fromIndex_indexGreaterThanNumberOfSquares_exception() {
        int indexOverflowing = Square.values().length + 1;

        MAPPER.fromIndex(indexOverflowing);
    }

    @Test(expectedExceptions = NoSuchSquareException.class)
    public void fromIndex_indexLessThan0_exception() {
        MAPPER.fromIndex(-1);
    }

    @Test
    public void toBitboard_anySquare() {
        assert A8_BITBOARD == MAPPER.toBitboard(Square.A8);
    }

    @Test
    public void fromBitboard_anyValidBitboard() {
        assert Square.A8 == MAPPER.fromBitboard(A8_BITBOARD);
    }

}
