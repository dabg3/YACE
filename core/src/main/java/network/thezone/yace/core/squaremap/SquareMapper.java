package network.thezone.yace.core.squaremap;

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

}
