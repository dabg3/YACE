package network.thezone.yace.util;

import org.testng.annotations.Test;

public class FenParserTest {

    private static final String INITIAL_FEN =
            "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";


    @Test
    private void parse_initialposition() {
        FenParser fenParser = new FenParser();
    }
}
