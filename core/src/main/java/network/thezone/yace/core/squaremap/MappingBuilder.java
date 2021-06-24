package network.thezone.yace.core.squaremap;

import java.util.Objects;
import java.util.function.IntBinaryOperator;

public class MappingBuilder implements Builder {

    private static final int[] BIG_ENDIAN_ORDERING = {7, 6, 5, 4, 3, 2, 1, 0};
    private static final int[] LITTLE_ENDIAN_ORDERING = {0, 1, 2, 3, 4, 5, 6, 7};

    protected int[] rankIndexes = null;
    protected int[] fileIndexes = null;
    protected IntBinaryOperator mappingCalculation = null;

    @Override
    public Builder bigEndianRanks() {
        rankIndexes = BIG_ENDIAN_ORDERING;
        return this;
    }

    @Override
    public Builder littleEndianRanks() {
        rankIndexes = LITTLE_ENDIAN_ORDERING;
        return this;
    }

    @Override
    public Builder bigEndianFiles() {
        fileIndexes = BIG_ENDIAN_ORDERING;
        return this;
    }

    @Override
    public Builder littleEndianFiles() {
        fileIndexes = LITTLE_ENDIAN_ORDERING;
        return this;
    }

    @Override
    public Builder leastSignificantRankOrdering() {
        mappingCalculation = (fileIndex, rankIndex) -> 8 * fileIndex + rankIndex;
        return this;
    }

    @Override
    public Builder leastSignificantFileOrdering() {
        mappingCalculation = (fileIndex, rankIndex) -> 8 * rankIndex + fileIndex;
        return this;
    }

    @Override
    public Mappable build() {
        Objects.requireNonNull(rankIndexes);
        Objects.requireNonNull(fileIndexes);
        Objects.requireNonNull(mappingCalculation);
        return new Mapping(rankIndexes, fileIndexes, mappingCalculation);
    }
}
