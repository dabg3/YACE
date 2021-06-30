package network.thezone.yace.core.squaremap;

import java.util.function.IntBinaryOperator;

class DiagonalsCalculations {

    private static final IntBinaryOperator DIFF_PLUS_7 = (rankIndex, fileIndex) -> rankIndex - fileIndex + 7;
    private static final IntBinaryOperator SUM = (rankIndex, fileIndex) -> rankIndex + fileIndex;

    private final IntBinaryOperator diagonalCalculation;
    private final IntBinaryOperator antiDiagonalCalculation;

    private DiagonalsCalculations(IntBinaryOperator diagonalCalculation, IntBinaryOperator antiDiagonalCalculation) {
        this.diagonalCalculation = diagonalCalculation;
        this.antiDiagonalCalculation = antiDiagonalCalculation;
    }

    static DiagonalsCalculations alignedRanksFiles() {
        return new DiagonalsCalculations(DIFF_PLUS_7, SUM);
    }

    static DiagonalsCalculations oppositeRanksFiles() {
        return new DiagonalsCalculations(SUM, DIFF_PLUS_7);
    }

    IntBinaryOperator getDiagonalCalculation() {
        return diagonalCalculation;
    }

    IntBinaryOperator getAntiDiagonalCalculation() {
        return antiDiagonalCalculation;
    }

}
