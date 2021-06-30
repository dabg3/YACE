package network.thezone.yace.core.squaremap;

import network.thezone.yace.core.Square;

import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

class Mapping implements Mapper {

    private final int[] fileIndexes;
    private final int[] rankIndexes;
    private final IntBinaryOperator mappingCalculation;
    private final IntUnaryOperator reverseRankCalculation;
    private final IntUnaryOperator reverseFileCalculation;
    private final IntBinaryOperator diagonalCalculation;
    private final IntBinaryOperator antiDiagonalCalculation;

    private final Square[] INDEX_TO_SQUARE = new Square[Square.values().length];
    private final long[] FILE_INDEX_TO_FILE = new long[8]; //8 files, 8 ranks on a chess board
    private final long[] RANK_INDEX_TO_RANK = new long[8];
    private final long[] DIAGONAL_INDEX_TO_DIAGONAL = new long[15]; //...and 16 diagonals
    private final long[] ANTIDIAGONAL_INDEX_TO_ANTIDIAGONAL = new long[15];

    Mapping(int[] rankIndexes, int[] fileIndexes, IntBinaryOperator mappingCalculation,
            ReverseMappingCalculations reverseMappingCalculations, DiagonalsCalculations diagonalsCalculations) {
        this.rankIndexes = rankIndexes;
        this.fileIndexes = fileIndexes;
        this.mappingCalculation = mappingCalculation;
        this.reverseRankCalculation = reverseMappingCalculations.getRankReverseCalculation();
        this.reverseFileCalculation = reverseMappingCalculations.getFileReverseCalculation();
        this.diagonalCalculation = diagonalsCalculations.getDiagonalCalculation();
        this.antiDiagonalCalculation = diagonalsCalculations.getAntiDiagonalCalculation();
        bindSquaresToIndexes();
    }

    private void bindSquaresToIndexes() {
        for (Square square : Square.values()) {
            int squareIndex = toIndex(square);
            INDEX_TO_SQUARE[squareIndex] = square;
            FILE_INDEX_TO_FILE[fileIndexes[fileAt(square)]] |= 1L << squareIndex;
            RANK_INDEX_TO_RANK[rankIndexes[rankAt(square)]] |= 1L << squareIndex;
            int diagonalIndex = diagonalCalculation.applyAsInt(rankAt(square), fileAt(square));
            int antiDiagonalIndex = diagonalCalculation.applyAsInt(rankAt(square), fileAt(square));
            DIAGONAL_INDEX_TO_DIAGONAL[diagonalIndex] |= 1L << squareIndex;
            ANTIDIAGONAL_INDEX_TO_ANTIDIAGONAL[antiDiagonalIndex] |= 1L << squareIndex;
        }
        int a = 0;
    }

    @Override
    public int toIndex(Square square) {
        int fileIndex = fileIndexes[square.fileNaturalIndex - 1];
        int rankIndex = rankIndexes[square.rankNaturalIndex - 1];
        return mappingCalculation.applyAsInt(fileIndex, rankIndex);
    }

    @Override
    public Square squareAt(int index) {
        if (index < 0 || index >= INDEX_TO_SQUARE.length)
            throw new IllegalArgumentException(String.format("index %d cannot be mapped", index));
        return INDEX_TO_SQUARE[index];
    }

    public int rankAt(Square square) {
        return rankIndexes[square.rankNaturalIndex - 1];
    }

    public int fileAt(Square square) {
        return fileIndexes[square.fileNaturalIndex - 1];
    }

    @Override
    public int rankAt(int index) {
        return reverseRankCalculation.applyAsInt(index);
    }

    @Override
    public int fileAt(int index) {
        return fileIndexes[squareAt(index).fileNaturalIndex - 1];
    }

    public long getParentDiagonal(Square square) {
        return 0;
    }

    public long getParentAntiDiagonal(Square square) {
        return 0;
    }

    public long getParentRank(Square square) {
        return 0;
    }

    public long getParentFile(Square square) {
        return 0;
    }
}
