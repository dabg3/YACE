package network.thezone.yace.core;

import network.thezone.yace.core.exceptions.NoSuchSquareException;
import org.testng.annotations.Test;

import java.util.Iterator;

public class SquareMapperTest {

    @Test
    public void mapper_internalMapping_msbA8lsbH1FileRank() {
        SquareMapper mapper = new InternalSquareMap();
        int MSB = 63;
        int nextToMSB = 62;
        int LSB = 0;

        assert Square.A8 == mapper.fromIndex(MSB);
        assert Square.A7 == mapper.fromIndex(nextToMSB);
        assert Square.H1 == mapper.fromIndex(LSB);
    }

    @Test
    public void iteratorEndCheck() {
        SquareMapper mapper = new InternalSquareMap();
        Iterator<Square> squareIterator = mapper.getSquareIterator();
        Square lastSquare = mapper.fromIndex(63);

        Square iteratorYield = null;
        while (squareIterator.hasNext())
            iteratorYield = squareIterator.next();

        assert iteratorYield == lastSquare;
    }

    @Test(expectedExceptions = NoSuchSquareException.class)
    public void fromIndex_indexGreaterThanNumberOfSquares_exception() {
        int indexOverflowing = Square.values().length + 1;
        SquareMapper mapper = new InternalSquareMap();

        mapper.fromIndex(indexOverflowing);
    }

    @Test(expectedExceptions = NoSuchSquareException.class)
    public void fromIndex_indexLessThan0_exception() {
        SquareMapper mapper = new InternalSquareMap();

        mapper.fromIndex(-1);
    }

}
