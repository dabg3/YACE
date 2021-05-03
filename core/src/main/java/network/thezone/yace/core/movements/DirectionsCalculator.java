package network.thezone.yace.core.movements;

import network.thezone.yace.core.squaremap.Square;
import network.thezone.yace.core.squaremap.SquareMapper;

class DirectionsCalculator {

    private static final SquareMapper MAPPER = Square.getMapper();

    private DirectionsCalculator(){}

    /* White movements */

    static int whiteForward() {
        return MAPPER.toIndex(Square.A2) - MAPPER.toIndex(Square.A1);
    }

    static int whiteRightForward() {
        return MAPPER.toIndex(Square.B2) - MAPPER.toIndex(Square.A1);
    }

    static int whiteRight() {
        return MAPPER.toIndex(Square.B1) - MAPPER.toIndex(Square.A1);
    }

    static int whiteRightBackward() {
        return MAPPER.toIndex(Square.B1) - MAPPER.toIndex(Square.A2);
    }

    static int whiteBackward() {
        return -whiteForward();
    }

    static int whiteLeftBackward() {
        return -whiteRightForward();
    }

    static int whiteLeft() {
        return -whiteRight();
    }

    static int whiteLeftForward() {
        return -whiteRightBackward();
    }

    /* Black movements */

    static int blackForward() {
        return -whiteForward();
    }

    static int blackRightForward() {
        return -whiteRightForward();
    }

    static int blackRight() {
        return -whiteRight();
    }

    static int blackRightBackward() {
        return -whiteRightBackward();
    }

    static int blackBackward() {
        return -whiteBackward();
    }

    static int blackLeftBackward() {
        return -whiteLeftBackward();
    }

    static int blackLeft() {
        return -whiteLeft();
    }

    static int blackLeftForward() {
        return -whiteLeftForward();
    }
}
