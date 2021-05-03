package network.thezone.yace.core.movements;

import mockit.Mock;
import mockit.MockUp;
import mockit.Tested;
import network.thezone.yace.core.squaremap.Square;
import network.thezone.yace.core.squaremap.SquareMapper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static network.thezone.yace.core.movements.DirectionsCalculator.*;

public class DirectionsCalculatorTest {

    // LERF mapping
    private static final int FAKE_A1 = 0;
    private static final int FAKE_A2 = 8;
    private static final int FAKE_B1 = 1;
    private static final int FAKE_B2 = 9;

    // compass rose for LERF
    private static final int NORTH = 8;
    private static final int NORTH_EAST = 9;
    private static final int EAST = 1;
    private static final int SOUTH_EAST = -7;
    private static final int SOUTH = -8;
    private static final int SOUTH_WEST = -9;
    private static final int WEST = -1;
    private static final int NORTH_WEST = 7;

    @BeforeClass
    public <T extends SquareMapper> void mockMapper() {
        new MockUp<T>() {
            @Mock int toIndex(Square square) {
                switch(square) {
                    case A1:
                        return FAKE_A1;
                    case A2:
                        return FAKE_A2;
                    case B1:
                        return FAKE_B1;
                    case B2:
                        return FAKE_B2;
                    default:
                        throw new IllegalArgumentException();
                }
            }
        };
    }

    @Test
    public void calculation_whiteDirections() {
        assert whiteForward() == NORTH;
        assert whiteRightForward() == NORTH_EAST;
        assert whiteRight() == EAST;
        assert whiteRightBackward() == SOUTH_EAST;
        assert whiteBackward() == SOUTH;
        assert whiteLeftBackward() == SOUTH_WEST;
        assert whiteLeft() == WEST;
        assert whiteLeftForward() == NORTH_WEST;
    }

    @Test
    public void calculation_blackDirections() {
        assert blackForward() == SOUTH;
        assert blackRightForward() == SOUTH_WEST;
        assert blackRight() == WEST;
        assert blackRightBackward() == NORTH_WEST;
        assert blackBackward() == NORTH;
        assert blackLeftBackward() == NORTH_EAST;
        assert blackLeft() == EAST;
        assert blackLeftForward() == SOUTH_EAST;
    }

}
