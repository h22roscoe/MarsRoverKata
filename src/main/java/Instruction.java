/**
 * Created by har14 on 05/12/15.
 */
public enum Instruction {
    FORWARDS {
        @Override
        public Direction apply(Direction direction, Position position) {
            switch (direction) {
                case NORTH:
                    position.incrementY();
                    return Direction.NORTH;
                case EAST:
                    position.incrementX();
                    return Direction.EAST;
                case SOUTH:
                    position.decrementY();
                    return Direction.SOUTH;
                case WEST:
                    position.decrementX();
                    return Direction.WEST;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    },
    BACKWARDS {
        @Override
        public Direction apply(Direction direction, Position position) {
            switch (direction) {
                case NORTH:
                    position.decrementY();
                    return Direction.NORTH;
                case EAST:
                    position.decrementX();
                    return Direction.EAST;
                case SOUTH:
                    position.incrementY();
                    return Direction.SOUTH;
                case WEST:
                    position.incrementX();
                    return Direction.WEST;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    },
    LEFT {
        @Override
        public Direction apply(Direction direction, Position position) {
            return direction.previous();
        }
    },
    RIGHT {
        @Override
        public Direction apply(Direction direction, Position position) {
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

    public abstract Direction apply(Direction direction, Position position);
}
