package network.thezone.yace.core.squaremap;

import org.testng.annotations.Test;

import java.util.Iterator;

public class IterableSquareMapperTest {

    @Test
    public void iteratorEndCheck() {
        IterableSquareMapper mapper = new IterableSquareMapper() {
            @Override
            protected int toIndex(Square square) {
                return 63;
            }
        };
        Iterator<Square> squareIterator = mapper.getSquareIterator();
        Square lastSquare = mapper.fromIndex(63);

        Square iteratorYield = null;
        while (squareIterator.hasNext())
            iteratorYield = squareIterator.next();

        assert iteratorYield == lastSquare;
    }
}
