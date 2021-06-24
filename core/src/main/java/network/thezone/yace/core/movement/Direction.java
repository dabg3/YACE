package network.thezone.yace.core.movement;

import network.thezone.yace.core.Color;
import network.thezone.yace.core.squaremap.Mappable;

import static network.thezone.yace.core.Square.B1;
import static network.thezone.yace.core.Square.B2;
import static network.thezone.yace.core.Square.C1;
import static network.thezone.yace.core.Square.C2;

public enum Direction {

    FORWARD(new Move(B1, B2), new Move(B2, B1)),
    RIGHT_FORWARD(new Move(B1, C2), new Move(C2, B1)),
    RIGHT(new Move(B1, C1), new Move(C1, B1)),
    RIGHT_BACKWARD(new Move(B2, C1), new Move(C1, B2)),
    BACKWARD(new Move(B2, B1), new Move(B1, B2)),
    LEFT_BACKWARD(new Move(C2, B1), new Move(B1, C2)),
    LEFT(new Move(C1, B1), new Move(B1, C1)),
    LEFT_FORWARD(new Move(C1, B2), new Move(B2, C1));

    private Move[] sampleMoves = new Move[Color.MAX_ALLOWED];

    Direction(Move whiteMove, Move blackMove) {
        sampleMoves[Color.WHITE.ordinal()] = whiteMove;
        sampleMoves[Color.BLACK.ordinal()] = blackMove;
    }

    public static class Value {

        private final Mappable mapping;

        public Value(Mappable mapping) {
            this.mapping = mapping;
        }

        public int evaluate(Direction direction, Color color) {
            Move sampleMove = direction.sampleMoves[color.ordinal()];
            return mapping.toIndex(sampleMove.getTo()) - mapping.toIndex(sampleMove.getFrom());
        }
    }

}
