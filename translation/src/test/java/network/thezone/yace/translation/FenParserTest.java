package network.thezone.yace.translation;

import network.thezone.yace.core.Piece;
import network.thezone.yace.core.Square;
import org.testng.annotations.Test;

import java.util.Map;

import static network.thezone.yace.core.Square.*;
import static network.thezone.yace.core.Piece.*;

public class FenParserTest {

    @Test
    public void fenParser_initialPosition_SquarePiecesMap() {
        String initPos = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
        FenParser parser = new FenParser();

        parser.parsePosition(initPos);
        Map<Square, Piece> initPosMap = parser.getPiecePlacement();

        assert initPosMap.get(A1) == WHITE_ROOK;
        assert initPosMap.get(A2) == WHITE_KNIGHT;
        assert initPosMap.get(A3) == WHITE_BISHOP;
    }
}
