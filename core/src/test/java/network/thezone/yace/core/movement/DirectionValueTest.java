package network.thezone.yace.core.movement;

import network.thezone.yace.core.Color;
import network.thezone.yace.core.squaremap.Mapper;
import network.thezone.yace.core.squaremap.MappingBuilder;
import org.junit.jupiter.api.Test;

public class DirectionValueTest {

    @Test
    public void movementValuesCalculation_anyMapping_matchMappingCompassRose() {
        Mapper squareMap = new MappingBuilder()
                .littleEndianFiles()
                .littleEndianRanks()
                .leastSignificantFileOrdering()
                .build();
        Direction.Value compassRose = new Direction.Value(squareMap);

        // White movements value
        int whiteForward = compassRose.evaluate(Direction.FORWARD, Color.WHITE);
        int whiteRightForward = compassRose.evaluate(Direction.RIGHT_FORWARD, Color.WHITE);
        // Black movements value
        int blackForward = compassRose.evaluate(Direction.FORWARD, Color.BLACK);
        int blackRightForward = compassRose.evaluate(Direction.RIGHT_FORWARD, Color.BLACK);

        // White asserts
        assert whiteForward == 8;
        assert whiteRightForward == 9;
        //Black asserts
        assert blackForward == -8;
        assert blackRightForward == -9;
    }
}
