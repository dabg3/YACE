package network.thezone.yace.core.squaremap;

import java.util.Objects;
import java.util.function.IntBinaryOperator;

public class MappingBuilder implements Builder {

    private static final int[] BIG_ENDIAN_ORDERING = {7, 6, 5, 4, 3, 2, 1, 0};
    private static final int[] LITTLE_ENDIAN_ORDERING = {0, 1, 2, 3, 4, 5, 6, 7};

    protected int[] rankIndexes = null;
    protected int[] fileIndexes = null;
    protected IntBinaryOperator mappingCalculation = null;
    protected DiagonalsCalculations diagonalsCalculations;
    protected ReverseMappingCalculations reverseMappingCalculations;

    private void inferDiagonalsCalculations() {
        if (fileIndexes == null || rankIndexes == null)
            return;
        if (fileIndexes == rankIndexes)
            diagonalsCalculations = DiagonalsCalculations.alignedRanksFiles();
        else
            diagonalsCalculations = DiagonalsCalculations.oppositeRanksFiles();
    }

    @Override
    public Builder bigEndianRanks() {
        rankIndexes = BIG_ENDIAN_ORDERING;
        inferDiagonalsCalculations();
        return this;
    }

    @Override
    public Builder littleEndianRanks() {
        rankIndexes = LITTLE_ENDIAN_ORDERING;
        inferDiagonalsCalculations();
        return this;
    }

    @Override
    public Builder bigEndianFiles() {
        fileIndexes = BIG_ENDIAN_ORDERING;
        inferDiagonalsCalculations();
        return this;
    }

    @Override
    public Builder littleEndianFiles() {
        fileIndexes = LITTLE_ENDIAN_ORDERING;
        inferDiagonalsCalculations();
        return this;
    }

    @Override
    public Builder leastSignificantRankOrdering() {
        mappingCalculation = (fileIndex, rankIndex) -> 8 * fileIndex + rankIndex;
        reverseMappingCalculations = ReverseMappingCalculations.LSROrdering();
        return this;
    }

    @Override
    public Builder leastSignificantFileOrdering() {
        mappingCalculation = (fileIndex, rankIndex) -> 8 * rankIndex + fileIndex;
        reverseMappingCalculations = ReverseMappingCalculations.LSFOrdering();
        return this;
    }

    @Override
    public Mapper build() {
        Objects.requireNonNull(rankIndexes);
        Objects.requireNonNull(fileIndexes);
        Objects.requireNonNull(mappingCalculation);
        Objects.requireNonNull(reverseMappingCalculations);
        Objects.requireNonNull(diagonalsCalculations);
        return new Mapping(rankIndexes, fileIndexes, mappingCalculation, reverseMappingCalculations, diagonalsCalculations);
    }
}
