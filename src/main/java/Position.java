/**
 * Created by har14 on 05/12/15.
 */
public class Position {
    private int x_coordinate;
    private int y_coordinate;

    public int getX_coordinate() {
        return x_coordinate;
    }

    public int getY_coordinate() {
        return y_coordinate;
    }


    public Position(int x_coordinate, int y_coordinate) {
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;
    }

    public void incrementX(Grid grid) {
        x_coordinate++;

        if (x_coordinate >= grid.getLongitudePartitions()) {
            x_coordinate %= grid.getLongitudePartitions();
        }

        if (grid.obstacleAt(this)) {
            Position obstaclePosition = this.clone();
            decrementX(grid);
            throw new ObstaclePresentException(obstaclePosition);
        }
    }

    public void incrementY(Grid grid) {
        y_coordinate++;

        if (y_coordinate >= grid.getLatitudePartitions()) {
            y_coordinate %= grid.getLatitudePartitions();
        }

        if (grid.obstacleAt(this)) {
            Position obstaclePosition = this.clone();
            decrementY(grid);
            throw new ObstaclePresentException(obstaclePosition);
        }
    }

    public void decrementX(Grid grid) {
        x_coordinate--;


        if (x_coordinate < 0) {
            x_coordinate = grid.getLongitudePartitions() + x_coordinate;
        }

        if (grid.obstacleAt(this)) {
            Position obstaclePosition = this.clone();
            incrementX(grid);
            throw new ObstaclePresentException(obstaclePosition);
        }
    }

    public void decrementY(Grid grid) {
        y_coordinate--;

        if (y_coordinate < 0) {
            y_coordinate = grid.getLatitudePartitions() + y_coordinate;
        }

        if (grid.obstacleAt(this)) {
            Position obstaclePosition = null;
            obstaclePosition = this.clone();
            incrementX(grid);
            throw new ObstaclePresentException(obstaclePosition);
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

    @Override
    public Position clone() {
        return new Position(x_coordinate, y_coordinate);
    }

    @Override
    public String toString() {
        return "Position{" +
                "x_coordinate=" + x_coordinate +
                ", y_coordinate=" + y_coordinate +
                '}';
    }
}
