package network.thezone.yace.core;

import network.thezone.yace.core.exceptions.UnmappableBitboardException;

public abstract class BitboardSquareMapper extends SquareMapper {

    long toBitboard(Square square) {
        return 1L << toIndex(square);
    }

    Square fromBitboard(long bitboard) {
        if (Long.bitCount(bitboard) > 1)
            throw new UnmappableBitboardException(String.format("Too many bit set"));
        int bitIndex = Long.numberOfTrailingZeros(bitboard);
        return fromIndex(bitIndex);
    }

}
