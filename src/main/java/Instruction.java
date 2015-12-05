/**
 * Created by har14 on 05/12/15.
 */
public enum Instruction {
    FORWARDS('F') {
        @Override
        public Direction apply(Direction direction, Position position) {
            switch (direction) {
                case NORTH:
                    return Direction.NORTH;
                case EAST:
                    return Direction.EAST;
                case SOUTH:
                    return Direction.SOUTH;
                case WEST:
                    return Direction.WEST;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    },
    BACKWARDS('B') {
        @Override
        public Direction apply(Direction direction, Position position) {
            switch (direction) {
                case NORTH:
                    return Direction.NORTH;
                case EAST:
                    return Direction.EAST;
                case SOUTH:
                    return Direction.SOUTH;
                case WEST:
                    return Direction.WEST;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    },
    LEFT('L') {
        @Override
        public Direction apply(Direction direction, Position position) {
            return direction.next();
        }
    },
    RIGHT('R') {
        @Override
        public Direction apply(Direction direction, Position position) {
            return direction.previous();
        }
    };

    private final char label;
    private static final char[] validLabels = {'F', 'B', 'L', 'R'};

    Instruction(final char label) {
        this.label = label;
    }

    public char label() {
        return label;
    }

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
