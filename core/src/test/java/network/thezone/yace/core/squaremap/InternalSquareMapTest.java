package network.thezone.yace.core.squaremap;

import network.thezone.yace.core.Square;
import org.testng.annotations.Test;

public class InternalSquareMapTest {

    private static final SquareMapper MAPPER = new InternalSquareMap();

    @Test
    public void mapper_internalMapping_msbA8lsbH1FileRank() {
        int MSB = 63;
        int nextToMSB = 62;
        int LSB = 0;

        assert Square.A8 == MAPPER.fromIndex(MSB);
        assert Square.A7 == MAPPER.fromIndex(nextToMSB);
        assert Square.H1 == MAPPER.fromIndex(LSB);
    }


}
