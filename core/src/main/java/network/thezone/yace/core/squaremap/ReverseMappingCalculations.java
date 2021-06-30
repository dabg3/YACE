package network.thezone.yace.core.squaremap;

import java.util.function.IntUnaryOperator;

class ReverseMappingCalculations {

    private static final IntUnaryOperator DIV_8 = squareIndex -> squareIndex >> 3;
    private static final IntUnaryOperator MODULO_8 = squareIndex -> squareIndex & 7;

    private IntUnaryOperator rankReverseCalculation;
    private IntUnaryOperator fileReverseCalculation;

    private ReverseMappingCalculations(IntUnaryOperator rankReverseCalculation, IntUnaryOperator fileReverseCalculation) {
        this.rankReverseCalculation = rankReverseCalculation;
        this.fileReverseCalculation = fileReverseCalculation;
    }

    static ReverseMappingCalculations LSFOrdering() {
        return new ReverseMappingCalculations(DIV_8, MODULO_8);
    }

    static ReverseMappingCalculations LSROrdering() {
        return new ReverseMappingCalculations(MODULO_8, DIV_8);
    }

    IntUnaryOperator getRankReverseCalculation() {
        return rankReverseCalculation;
    }

    IntUnaryOperator getFileReverseCalculation() {
        return fileReverseCalculation;
    }
}
