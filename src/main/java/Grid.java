/**
 * Created by har14 on 05/12/15.
 */
public class Grid {
    private int latitudePartitions;
    private int longitudePartitions;
    private boolean[][] grid;

    public Grid() {
        // Default grid
        this.latitudePartitions = 100;
        this.longitudePartitions = 100;
        this.grid = new boolean[latitudePartitions][longitudePartitions];
    }

    public Grid(boolean[][] grid) {
        this.latitudePartitions = grid.length;
        this.longitudePartitions = grid[0].length;
        this.grid = grid;
    }

    public boolean obstacleAt(Position position) {
        return grid[position.getX_coordinate()][position.getY_coordinate()];
    }

    public int getLongitudePartitions() {
        return longitudePartitions;
    }
    
    public int getLatitudePartitions() {
        return latitudePartitions;
    }
}
