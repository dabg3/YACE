package network.thezone.yace.core;

import java.util.HashMap;
import java.util.Map;

class StandardBoard implements Board {


    //redundant map for performance
    private Map<Square, PieceID> pieces;

    private long[] positionsBySide = new long[Color.values().length];
    private long occupiedSquares;


    private StandardBoard(Map<Square, PieceID> piecePositions) {
        this.pieces = piecePositions;
        pieces.forEach(this::initRelated);
    }

    private void initRelated(Square square, PieceID pieceID) {
        long pieceBitboard = 0; //square.toBitboard();
        positionsBySide[pieceID.color.ordinal()] |= pieceBitboard;
        occupiedSquares |= pieceBitboard;
    }

    @Override
    public PieceID pieceOn(Square square) {
        return pieces.get(square);
    }

    @Override
    public void move(Square from, Square to) {
        PieceID pieceMoving = pieces.get(from);
        PieceID targetPiece = pieces.get(to);
        if (targetPiece == null) {
        }
        //makeQuietMove(pieceMoving, from, to);
    }

    @Override
    public void undoMove() {

    }

    @Override
    public void placePiece(PieceID pieceID, Square square) {

    }

    Board instanceEmpty() {
        return new StandardBoard(new HashMap<>());
    }

    Board instancePosition(Map<Square, PieceID> piecePositions) {
        return new StandardBoard(piecePositions);
    }
}
