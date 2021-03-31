package network.thezone.yace.core;

import network.thezone.yace.core.exceptions.NoSuchSquareException;

import java.util.Iterator;

public abstract class SquareMapper {

    private final Square[] indexToSquare = new Square[Square.values().length];

    protected SquareMapper() {
        for (Square square : Square.values())
            indexToSquare[toIndex(square)] = square;
    }

    abstract int toIndex(Square square);

    Square fromIndex(int index) {
        if (index < 0 || index >= indexToSquare.length)
            throw new NoSuchSquareException(String.format("index %d cannot be mapped", index));
        return indexToSquare[index];
    }

    public Iterator<Square> getSquareIterator() {
        return new SquareIterator();
    }

    private class SquareIterator implements Iterator<Square> {

        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < indexToSquare.length;
        }

        @Override
        public Square next() {
            return indexToSquare[currentIndex++];
        }
    }

}
