package network.thezone.yace.core;

public class Game {

    private final Board board;

    public Game(Board board) {
        this.board = board;
    }

    public void move(Square from, Square to) {

        logicExecutor.execute(movementValidator)

    }

}
