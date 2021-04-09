package network.thezone.yace.core.squaremap;

import network.thezone.yace.core.Square;

public class Bitboards {

    private static final SquareMapper MAPPER = new InternalSquareMap();

    public static long parse(Square square) {
        return 1L << MAPPER.toIndex(square);
    }

    public static Square toSquare(long bitboard) {
        if (Long.bitCount(bitboard) > 1)
            throw new UnmappableBitboardException("Too many bits set");
        int bitIndex = Long.numberOfTrailingZeros(bitboard);
        return MAPPER.fromIndex(bitIndex);
    }

}
