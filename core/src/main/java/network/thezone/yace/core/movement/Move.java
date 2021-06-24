package network.thezone.yace.core.movement;

import network.thezone.yace.core.Square;

public class Move {

    private final Square from;
    private final Square to;

    public Move(Square from, Square to) {
        this.from = from;
        this.to = to;
    }

    public Square getFrom() {
        return from;
    }

    public Square getTo() {
        return to;
    }
}
