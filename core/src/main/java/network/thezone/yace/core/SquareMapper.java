package network.thezone.yace.core;

import network.thezone.yace.core.exceptions.NoSuchSquareException;
import network.thezone.yace.core.exceptions.UnmappableBitboardException;

public abstract class SquareMapper {

    protected final Square[] indexToSquare = new Square[Square.values().length];

    protected SquareMapper() {
        for (Square square : Square.values())
            indexToSquare[toIndex(square)] = square;
    }

    protected abstract int toIndex(Square square);

    protected Square fromIndex(int index) {
        if (index < 0 || index >= indexToSquare.length)
            throw new NoSuchSquareException(String.format("index %d cannot be mapped", index));
        return indexToSquare[index];
    }

    long toBitboard(Square square) {
        return 1L << toIndex(square);
    }

    Square fromBitboard(long bitboard) {
        if (Long.bitCount(bitboard) > 1)
            throw new UnmappableBitboardException("Too many bit set");
        int bitIndex = Long.numberOfTrailingZeros(bitboard);
        return fromIndex(bitIndex);
    }

}
