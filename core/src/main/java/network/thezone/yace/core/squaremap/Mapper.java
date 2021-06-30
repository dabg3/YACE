package network.thezone.yace.core.squaremap;

import network.thezone.yace.core.Square;

public interface Mapper {

    int toIndex(Square square);

    Square squareAt(int index);

    int rankAt(Square square);

    int fileAt(Square square);

    int rankAt(int index);

    int fileAt(int index);

    public long getParentDiagonal(Square square);

    public long getParentAntiDiagonal(Square square);

    public long getParentRank(Square square);

    public long getParentFile(Square square);

}
