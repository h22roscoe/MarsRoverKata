/**
 * Created by har14 on 05/12/15.
 */
public class Position {
    private static final int MAX_GRID_PARTITIONS = 100;
    private int x_coordinate;
    private int y_coordinate;

    public Position(int x_coordinate, int y_coordinate) {
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;
    }

    public void incrementX() {
        x_coordinate++;

        if (x_coordinate >= MAX_GRID_PARTITIONS) {
            x_coordinate %= MAX_GRID_PARTITIONS;
        }
    }

    public void incrementY() {
        y_coordinate++;

        if (y_coordinate >= MAX_GRID_PARTITIONS) {
            y_coordinate %= MAX_GRID_PARTITIONS;
        }
    }

    public void decrementX() {
        x_coordinate--;

        if (x_coordinate < 0) {
            x_coordinate = MAX_GRID_PARTITIONS + x_coordinate;
        }
    }

    public void decrementY() {
        y_coordinate--;

        if (y_coordinate < 0) {
            y_coordinate = MAX_GRID_PARTITIONS + y_coordinate;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Position) {
            Position position = (Position) o;

            return position.x_coordinate == this.x_coordinate &&
                    position.y_coordinate == this.y_coordinate;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return x_coordinate + y_coordinate;
    }
}
