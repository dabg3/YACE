package network.thezone.yace.core.squaremap;

import mockit.Mock;
import mockit.MockUp;

public class FakeInternalSquareMap extends MockUp<InternalSquareMap> {

    @Mock
    void $clinit() {}

    @Mock
    static SquareMapper instance() {
        return new TestSquareMap();
    }
}
