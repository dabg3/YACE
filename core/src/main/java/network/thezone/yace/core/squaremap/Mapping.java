package network.thezone.yace.core.squaremap;

import network.thezone.yace.core.Square;

import java.util.function.IntBinaryOperator;

class Mapping implements Mappable {

    private final int[] FILE_INDEXES;
    private final int[] RANK_INDEXES;
    private final IntBinaryOperator mappingCalculator;

    private final Square[] INDEX_TO_SQUARE = new Square[Square.values().length];

    Mapping(int[] RANK_INDEXES, int[] FILE_INDEXES, IntBinaryOperator mappingCalculator) {
        this.RANK_INDEXES = RANK_INDEXES;
        this.FILE_INDEXES = FILE_INDEXES;
        this.mappingCalculator = mappingCalculator;
        bindSquareToIndex();
    }

    private void bindSquareToIndex() {
        for (Square square : Square.values())
            INDEX_TO_SQUARE[toIndex(square)] = square;
    }

    @Override
    public int toIndex(Square square) {
        int fileIndex = FILE_INDEXES[square.fileNaturalIndex - 1];
        int rankIndex = RANK_INDEXES[square.rankNaturalIndex - 1];
        return mappingCalculator.applyAsInt(fileIndex, rankIndex);
    }

    @Override
    public Square squareAt(int index) {
        if (index < 0 || index >= INDEX_TO_SQUARE.length)
            throw new IllegalArgumentException(String.format("index %d cannot be mapped", index));
        return INDEX_TO_SQUARE[index];
    }


}
