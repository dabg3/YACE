package network.thezone.yace.core.movements;

import network.thezone.yace.core.Color;
import network.thezone.yace.core.squaremap.Square;
import network.thezone.yace.core.squaremap.SquareMapper;


public enum Direction {

    FORWARD(new Square[][]{{Square.A1, Square.A2}, {Square.A2, Square.A1}}),
    RIGHT_FORWARD(new Square[][]{{Square.A1, Square.B2}, {Square.B2, Square.A1}}),
    RIGHT(new Square[][]{{Square.A1, Square.B1}, {Square.B1, Square.A1}}),
    RIGHT_BACKWARD(new Square[][]{{Square.A2, Square.B1}, {Square.B1, Square.A2}}),
    BACKWARD(new Square[][]{{Square.A2, Square.A1}, {Square.A1, Square.A2}}),
    LEFT_BACKWARD(new Square[][]{{Square.B2, Square.A1}, {Square.A1, Square.B2}}),
    LEFT(new Square[][]{{Square.B1, Square.A1}, {Square.A1, Square.B1}}),
    LEFT_FORWARD(new Square[][]{{Square.B1, Square.A2}, {Square.A2, Square.B1}});

    private final int[] directionValues;

    Direction(Square[][] directionMovements) {
        directionValues = new int[Color.MAX_ALLOWED];
        for (int i = 0; i < Color.MAX_ALLOWED; i++) {
            Square[] move = directionMovements[i];
            directionValues[i] = calculateMovementValue(move[0], move[1]);
        }
    }

    private int calculateMovementValue(Square from, Square to) {
        SquareMapper mapper = Square.getMapper();
        return mapper.toIndex(to) - mapper.toIndex(from);
    }

    public long move(Long bitboard, Color color) {
        if (directionValues[color.ordinal()] > 0)
            return bitboard << directionValues[color.ordinal()];
        else
            return bitboard >>> -directionValues[color.ordinal()];
    }
}
