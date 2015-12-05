/**
 * Created by har14 on 05/12/15.
 */
public enum Direction {
    NORTH, EAST, SOUTH, WEST;

    private static Direction[] values = values();

    public Direction next() {
        return values[(this.ordinal() + 1) % values.length];
    }

    public Direction previous() {
        return values[(this.ordinal() - 1) % values.length];
    }
}
