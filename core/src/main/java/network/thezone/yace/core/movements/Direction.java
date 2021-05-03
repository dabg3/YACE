package network.thezone.yace.core.movements;

import network.thezone.yace.core.Color;

import java.util.function.Supplier;


public enum Direction {

    FORWARD(DirectionsCalculator::whiteForward, DirectionsCalculator::blackForward),
    RIGHT_FORWARD(DirectionsCalculator::whiteRightForward, DirectionsCalculator::blackRightForward),
    RIGHT(DirectionsCalculator::whiteRight, DirectionsCalculator::blackRight),
    RIGHT_BACKWARD(DirectionsCalculator::whiteRightBackward, DirectionsCalculator::blackRightBackward),
    BACKWARD(DirectionsCalculator::whiteBackward, DirectionsCalculator::blackBackward),
    LEFT_BACKWARD(DirectionsCalculator::whiteLeftBackward, DirectionsCalculator::blackLeftBackward),
    LEFT(DirectionsCalculator::whiteLeft, DirectionsCalculator::blackLeft),
    LEFT_FORWARD(DirectionsCalculator::whiteLeftForward, DirectionsCalculator::blackLeftForward);

    private final int[] directionValues;

    Direction(Supplier<Integer> whiteInitializer, Supplier<Integer> blackInitializer) {
        directionValues = new int[Color.MAX_ALLOWED];
        directionValues[Color.WHITE.ordinal()] = whiteInitializer.get();
        directionValues[Color.BLACK.ordinal()] = blackInitializer.get();
    }

    public Long apply(Long bitboard, Color color) {
        if (directionValues[color.ordinal()] > 0)
            return bitboard << directionValues[color.ordinal()];
        else
            return bitboard >>> -directionValues[color.ordinal()];
    }
}
