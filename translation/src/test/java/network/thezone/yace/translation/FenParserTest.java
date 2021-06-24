package network.thezone.yace.translation;

import network.thezone.yace.core.PieceID;
import network.thezone.yace.core.Square;
import org.testng.annotations.Test;

import java.util.Map;

import static network.thezone.yace.core.Square.*;
import static network.thezone.yace.core.PieceID.*;

public class FenParserTest {

    public void fenParser_initialPosition_SquarePiecesMap() {
        String initPos = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
        FenParser parser = new FenParser();

        parser.parsePosition(initPos);
        /*
        Map<Square, PieceID> initPosMap = parser.getPiecePlacement();

        assert initPosMap.get(A1) == WHITE_ROOK;
        assert initPosMap.get(B1) == WHITE_KNIGHT;
        assert initPosMap.get(C1) == WHITE_BISHOP;
        assert initPosMap.get(D1) == WHITE_QUEEN;
        assert initPosMap.get(E1) == WHITE_KING;
        assert initPosMap.get(F1) == WHITE_BISHOP;
        assert initPosMap.get(G1) == WHITE_KNIGHT;
        assert initPosMap.get(H1) == WHITE_ROOK;

        assert initPosMap.get(A8) == WHITE_ROOK;
        assert initPosMap.get(B8) == WHITE_KNIGHT;
        assert initPosMap.get(C8) == WHITE_BISHOP;
        assert initPosMap.get(D8) == WHITE_QUEEN;
        assert initPosMap.get(E8) == WHITE_KING;
        assert initPosMap.get(F8) == WHITE_BISHOP;
        assert initPosMap.get(G8) == WHITE_KNIGHT;
        assert initPosMap.get(H8) == WHITE_ROOK;
        */
    }
}
