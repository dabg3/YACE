package network.thezone.yace.core.squaremap;

import network.thezone.yace.core.Square;

import java.util.Iterator;

public abstract class IterableSquareMapper extends SquareMapper {

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
