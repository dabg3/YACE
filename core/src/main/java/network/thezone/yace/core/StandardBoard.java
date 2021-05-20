package network.thezone.yace.core;

import java.util.HashMap;
import java.util.Map;

class StandardBoard implements Board {


    //redundant map for performance
    private Map<Square, Piece> pieces;

    private long[] positionsByPiece = new long[Piece.values().length];
    private long[] positionsBySide = new long[Color.values().length];
    private long occupiedSquares;


    private StandardBoard(Map<Square, Piece> piecePositions) {
        this.pieces = piecePositions;
        pieces.forEach(this::initRelated);
    }

    private void initRelated(Square square, Piece piece) {
        long pieceBitboard = 0; //square.toBitboard();
        positionsByPiece[piece.ordinal()] |= pieceBitboard;
        positionsBySide[piece.color.ordinal()] |= pieceBitboard;
        occupiedSquares |= pieceBitboard;
    }

    @Override
    public Piece pieceOn(Square square) {
        return pieces.get(square);
    }

    @Override
    public void move(Square from, Square to) {
        Piece pieceMoving = pieces.get(from);
        Piece targetPiece = pieces.get(to);
        if (targetPiece == null) {
        }
        //makeQuietMove(pieceMoving, from, to);
    }

    @Override
    public void undoMove() {

    }

    @Override
    public void placePiece(Piece piece, Square square) {

    }

    Board instanceEmpty() {
        return new StandardBoard(new HashMap<>());
    }

    Board instancePosition(Map<Square, Piece> piecePositions) {
        return new StandardBoard(piecePositions);
    }
}
