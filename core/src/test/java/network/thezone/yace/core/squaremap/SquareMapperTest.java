package network.thezone.yace.core.squaremap;

import network.thezone.yace.core.Square;
import org.testng.annotations.Test;

public class SquareMapperTest {

    private static final SquareMapper MAPPER = new SquareMapper() {
        @Override
        protected int toIndex(Square square) {
            return 63;
        }
    };


    @Test(expectedExceptions = NoSuchSquareException.class)
    public void fromIndex_indexGreaterThanNumberOfSquares_exception() {
        int indexOverflowing = Square.values().length + 1;

        MAPPER.fromIndex(indexOverflowing);
    }

    @Test(expectedExceptions = NoSuchSquareException.class)
    public void fromIndex_indexLessThan0_exception() {
        MAPPER.fromIndex(-1);
    }


}
