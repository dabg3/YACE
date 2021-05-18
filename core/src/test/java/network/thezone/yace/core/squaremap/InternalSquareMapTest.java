package network.thezone.yace.core.squaremap;

import org.testng.annotations.Test;

public class InternalSquareMapTest {


    @Test
    public void mapper_internalMapping_msbA8lsbH1FileRank() {
        SquareMapper mapper = InternalSquareMap.instance();
        int MSB = 63;
        int nextToMSB = 62;
        int LSB = 0;

        assert Square.A8 == mapper.fromIndex(MSB);
        assert Square.A7 == mapper.fromIndex(nextToMSB);
        assert Square.H1 == mapper.fromIndex(LSB);
    }


}
