package network.thezone.yace.core.squaremap;

import network.thezone.yace.core.Square;

public interface Mappable {

    int toIndex(Square square);

    Square squareAt(int index);

}
