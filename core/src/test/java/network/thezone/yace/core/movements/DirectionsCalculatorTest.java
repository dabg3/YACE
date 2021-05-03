package network.thezone.yace.core.movements;

import mockit.Injectable;
import network.thezone.yace.core.squaremap.SquareMapper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DirectionsCalculatorTest {

    @Injectable
    private SquareMapper mapper;

    @BeforeClass
    public void mockMapper() {
    }

    @Test
    public void calculation_whiteForward() {
        assert DirectionsCalculator.whiteForward() == 2;
    }
}
