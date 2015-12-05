/**
 * Created by har14 on 05/12/15.
 */
public enum Instruction {
    FORWARDS {
        @Override
        public Direction apply(Grid grid, Direction direction, Position position) {
            switch (direction) {
                case NORTH:
                    position.incrementY(grid);
                    return Direction.NORTH;
                case EAST:
                    position.incrementX(grid);
                    return Direction.EAST;
                case SOUTH:
                    position.decrementY(grid);
                    return Direction.SOUTH;
                case WEST:
                    position.decrementX(grid);
                    return Direction.WEST;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    },
    BACKWARDS {
        @Override
        public Direction apply(Grid grid, Direction direction, Position position) {
            switch (direction) {
                case NORTH:
                    position.decrementY(grid);
                    return Direction.NORTH;
                case EAST:
                    position.decrementX(grid);
                    return Direction.EAST;
                case SOUTH:
                    position.incrementY(grid);
                    return Direction.SOUTH;
                case WEST:
                    position.incrementX(grid);
                    return Direction.WEST;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    },
    LEFT {
        @Override
        public Direction apply(Grid grid, Direction direction, Position position) {
            return direction.previous();
        }
    },
    RIGHT {
        @Override
        public Direction apply(Grid grid, Direction direction, Position position) {
            return direction.next();
        }
    };

    private static final char[] validLabels = {'F', 'B', 'L', 'R'};

    public static boolean validLabel(char label) {
        for (char valid : validLabels) {
            if (label == valid) {
                return true;
            }
        }

        return false;
    }

    public abstract Direction apply(Grid grid, Direction direction, Position position);
}
