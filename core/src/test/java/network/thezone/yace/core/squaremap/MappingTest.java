package network.thezone.yace.core.squaremap;

import network.thezone.yace.core.Square;
import org.junit.jupiter.api.Test;

public class MappingTest {

    @Test
    public void mapping_BigEndianFilesLittleEndianRanksLSR_matchSquareIndexes() {
        Mapper mapping = new MappingBuilder()
                .bigEndianFiles()
                .littleEndianRanks()
                .leastSignificantRankOrdering()
                .build();

        assert mapping.toIndex(Square.A8) == 63;
        assert mapping.toIndex(Square.A7) == 62;
        assert mapping.toIndex(Square.H1) == 0;
    }
}
