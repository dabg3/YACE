package network.thezone.yace.core.movement;

import network.thezone.yace.core.squaremap.Mapper;

import java.util.function.BiFunction;

public class ForwardMover implements BiFunction<Long, Integer, Long> {

    //functional interface signature (direction, value) return position_bitboard
    private static final Direction DIRECTION = Direction.FORWARD;
    private final Direction.Value compassRose;

    public ForwardMover(Mapper mapping) {
        this.compassRose = new Direction.Value(mapping);
    }

    @Override
    public Long apply(Long position, Integer count) {
        return 0L; //BitboardUtil.genShift(position, compassRose.evaluate(DIRECTION, ) * count);
    }
}
