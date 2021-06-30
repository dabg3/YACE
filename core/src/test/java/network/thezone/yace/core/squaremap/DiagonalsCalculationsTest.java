package network.thezone.yace.core.squaremap;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public class DiagonalsCalculationsTest {

    private static final int[] BIG_ENDIAN_ORDERING = {7, 6, 5, 4, 3, 2, 1, 0};
    private static final int[] LITTLE_ENDIAN_ORDERING = {0, 1, 2, 3, 4, 5, 6, 7};

    @Test
    public void diagonalsCalculation_bigEndianAligned() {
        int[] rankIndexes = BIG_ENDIAN_ORDERING;
        int[] fileIndexes = BIG_ENDIAN_ORDERING;

        IntBinaryOperator diagonalCalculation = DiagonalsCalculations.alignedRanksFiles().getDiagonalCalculation();

        printDiagonals(rankIndexes, fileIndexes, diagonalCalculation, "diagonal aligned big endian");
    }

    @Test
    public void diagonalsCalculation_littleEndianAligned() {
        int[] rankIndexes = LITTLE_ENDIAN_ORDERING;
        int[] fileIndexes = LITTLE_ENDIAN_ORDERING;

        IntBinaryOperator diagonalCalculation = DiagonalsCalculations.alignedRanksFiles().getDiagonalCalculation();

        printDiagonals(rankIndexes, fileIndexes, diagonalCalculation, "diagonal aligned little endian");
    }

    @Test
    public void diagonalsCalculation_oppositeBigEndianRanks() {
        int[] rankIndexes = BIG_ENDIAN_ORDERING;
        int[] fileIndexes = LITTLE_ENDIAN_ORDERING;

        IntBinaryOperator diagonalCalculation = DiagonalsCalculations.oppositeRanksFiles().getDiagonalCalculation();

        printDiagonals(rankIndexes, fileIndexes, diagonalCalculation, "diagonal opposite big endian ranks");
    }

    @Test
    public void diagonalsCalculation_oppositeLittleEndianRanks() {
        int[] rankIndexes = LITTLE_ENDIAN_ORDERING;
        int[] fileIndexes = BIG_ENDIAN_ORDERING;

        IntBinaryOperator diagonalCalculation = DiagonalsCalculations.oppositeRanksFiles().getDiagonalCalculation();

        printDiagonals(rankIndexes, fileIndexes, diagonalCalculation, "diagonal opposite little endian ranks");
    }

    @Test
    public void antiDiagonalsCalculation_bigEndianAligned() {
        int[] rankIndexes = BIG_ENDIAN_ORDERING;
        int[] fileIndexes = BIG_ENDIAN_ORDERING;

        IntBinaryOperator antiDiagonalCalculation = DiagonalsCalculations.alignedRanksFiles().getAntiDiagonalCalculation();

        printDiagonals(rankIndexes, fileIndexes, antiDiagonalCalculation, "antidiagonal aligned big endian");
    }

    @Test
    public void antiDiagonalsCalculation_littleEndianAligned() {
        int[] rankIndexes = LITTLE_ENDIAN_ORDERING;
        int[] fileIndexes = LITTLE_ENDIAN_ORDERING;

        IntBinaryOperator antiDiagonalCalculation = DiagonalsCalculations.alignedRanksFiles().getAntiDiagonalCalculation();

        printDiagonals(rankIndexes, fileIndexes, antiDiagonalCalculation, "antidiagonal aligned little endian");
    }

    @Test
    public void antiDiagonalsCalculation_oppositeBigEndianRanks() {
        int[] rankIndexes = BIG_ENDIAN_ORDERING;
        int[] fileIndexes = LITTLE_ENDIAN_ORDERING;

        IntBinaryOperator antiDiagonalCalculation = DiagonalsCalculations.oppositeRanksFiles().getAntiDiagonalCalculation();

        printDiagonals(rankIndexes, fileIndexes, antiDiagonalCalculation, "antidiagonal opposite big endian ranks");
    }

    @Test
    public void antiDiagonalsCalculation_oppositeLittleEndianRanks() {
        int[] rankIndexes = LITTLE_ENDIAN_ORDERING;
        int[] fileIndexes = BIG_ENDIAN_ORDERING;

        IntBinaryOperator antiDiagonalCalculation = DiagonalsCalculations.oppositeRanksFiles().getAntiDiagonalCalculation();

        printDiagonals(rankIndexes, fileIndexes, antiDiagonalCalculation, "antidiagonal opposite little endian ranks");
    }



    private void printDiagonals(int[] rankIndexes, int[] fileIndexes, IntBinaryOperator calculation, String header) {
        System.out.println("--- " + header + " ---");
        System.out.print("rankIndexes: ");
        Arrays.stream(rankIndexes).forEach(System.out::print);
        System.out.println();
        System.out.print("fileIndexes: ");
        Arrays.stream(fileIndexes).forEach(System.out::print);
        System.out.println();
        for(int rix = rankIndexes.length - 1; rix >= 0; rix--) {
            for (int f : fileIndexes) {
                System.out.printf("%4d", calculation.applyAsInt(rankIndexes[rix], f));
            }
            System.out.println();
        }
        System.out.println();
    }
}
