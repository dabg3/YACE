package network.thezone.yace.core.squaremap;

public interface Builder {

    Builder bigEndianRanks();
    Builder littleEndianRanks();
    Builder bigEndianFiles();
    Builder littleEndianFiles();
    Builder leastSignificantRankOrdering();
    Builder leastSignificantFileOrdering();
    Mapper build();

}
