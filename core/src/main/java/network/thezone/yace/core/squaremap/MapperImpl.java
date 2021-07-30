package network.thezone.yace.core.squaremap;

import network.thezone.yace.core.Square;

import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

class MapperImpl implements Mapper {

    private static final int DIAGONALS_NUM_CHESSBOARD = 15;
    private static final int RANKS_FILES_NUM_CHESSBOARD = 8;

    private final int[] fileIndexes;
    private final int[] rankIndexes;
    private final IntBinaryOperator mappingCalculation;
    private final IntUnaryOperator reverseRankCalculation;
    private final IntUnaryOperator reverseFileCalculation;
    private final IntBinaryOperator diagonalCalculation;
    private final IntBinaryOperator antiDiagonalCalculation;

    private final Square[] squares = new Square[Square.values().length];
    //bitboards
    private final long[] files = new long[RANKS_FILES_NUM_CHESSBOARD];
    private final long[] ranks = new long[RANKS_FILES_NUM_CHESSBOARD];
    private final long[] diagonals = new long[DIAGONALS_NUM_CHESSBOARD];
    private final long[] antidiagonals = new long[DIAGONALS_NUM_CHESSBOARD];

    MapperImpl(int[] rankIndexes, int[] fileIndexes, IntBinaryOperator mappingCalculation,
               ReverseMappingCalculations reverseMappingCalculations, DiagonalsCalculations diagonalsCalculations) {
        this.rankIndexes = rankIndexes;
        this.fileIndexes = fileIndexes;
        this.mappingCalculation = mappingCalculation;
        this.reverseRankCalculation = reverseMappingCalculations.getRankReverseCalculation();
        this.reverseFileCalculation = reverseMappingCalculations.getFileReverseCalculation();
        this.diagonalCalculation = diagonalsCalculations.getDiagonalCalculation();
        this.antiDiagonalCalculation = diagonalsCalculations.getAntiDiagonalCalculation();
        initializeInnerState();
    }

    private void initializeInnerState() {
        for (Square square : Square.values()) {
            int squareIndex = toIndex(square);
            int fileIndex = fileAt(square);
            int rankIndex = rankAt(square);
            int diagonalIndex = diagonalCalculation.applyAsInt(rankIndex, fileIndex);
            int antidiagonalIndex = diagonalCalculation.applyAsInt(rankIndex, fileIndex);
            squares[squareIndex] = square;
            files[fileIndex] |= 1L << squareIndex;
            ranks[rankIndex] |= 1L << squareIndex;
            diagonals[diagonalIndex] |= 1L << squareIndex;
            antidiagonals[antidiagonalIndex] |= 1L << squareIndex;
        }
    }

    @Override
    public int toIndex(Square square) {
        int fileIndex = fileIndexes[square.fileNaturalIndex - 1];
        int rankIndex = rankIndexes[square.rankNaturalIndex - 1];
        return mappingCalculation.applyAsInt(fileIndex, rankIndex);
    }

    @Override
    public Square squareAt(int index) {
        if (index < 0 || index >= squares.length)
            throw new IllegalArgumentException(String.format("index %d cannot be mapped", index));
        return squares[index];
    }

    @Override
    public int rankAt(Square square) {
        return rankIndexes[square.rankNaturalIndex - 1];
    }

    @Override
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
        int diagonalIndex = diagonalCalculation.applyAsInt(rankAt(square), fileAt(square));
        return diagonals[diagonalIndex];
    }

    public long getParentAntiDiagonal(Square square) {
        int antidiagonalIndex = antiDiagonalCalculation.applyAsInt(rankAt(square), fileAt(square));
        return antidiagonals[antidiagonalIndex];
    }

    public long getParentRank(Square square) {
        return ranks[rankAt(square)];
    }

    public long getParentFile(Square square) {
        return files[fileAt(square)];
    }
}
