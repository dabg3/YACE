package network.thezone.yace.core.movements;

import mockit.MockUp;
import network.thezone.yace.core.Color;
import network.thezone.yace.core.squaremap.FakeInternalSquareMap;
import network.thezone.yace.core.squaremap.SquareMapper;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DirectionTest {

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


    //this should be on test setup class
    @BeforeSuite
    public void setupMock() {
    }

    @Test
    public void moveDirection() {
        new FakeInternalSquareMap();
        long startingPos = 1;
        long expectedPos = 1 << NORTH_EAST;
        assert Direction.RIGHT_FORWARD.move(startingPos, Color.WHITE) == expectedPos;
    }
}
