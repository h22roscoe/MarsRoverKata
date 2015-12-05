import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by har14 on 05/12/15.
 */
public class MarsRoverTest {

    private final boolean[][] testGridArray =
            {
                    {false, true, false},
                    {false, false, false},
                    {false, false, false}
            };
    private final Grid testGrid = new Grid(testGridArray);
    private final Grid grid = new Grid();
    private final Direction givenDirection = Direction.NORTH;
    private final MarsRover testObstacleKata =
            new MarsRover(testGrid, Direction.NORTH, new Position(0, 0));
    private final MarsRover kata =
            new MarsRover(grid, givenDirection, new Position(0, 0));

    @Test
    public void roverStartsAtGivenPosition() {
        assertEquals(kata.getPosition(), new Position(0, 0));
    }

    @Test
    public void roverStartsFacingGivenDirection() {
        assertEquals(kata.getDirection(), givenDirection);
    }

    @Test
    public void unrecognisedInstructionsAreIgnored() {
        kata.move("AbCDEf");

        roverStartsAtGivenPosition();

        roverStartsFacingGivenDirection();
    }

    @Test
    public void forwardInstructionChangesPosition() {
        kata.move("F");

        // because givenDirection = NORTH
        assertEquals(kata.getPosition(), new Position(0, 1));
    }

    @Test
    public void leftInstructionChangesDirectionButNotPosition() {
        kata.move("L");

        assertNotEquals(kata.getDirection(), givenDirection);

        roverStartsAtGivenPosition();
    }

    @Test
    public void movingOffTheEdgeOfMapWrapsAround() {
        roverStartsAtGivenPosition();

        kata.move("B");

        // because givenDirection = NORTH
        assertEquals(kata.getPosition(), new Position(0, 99));
    }

    @Test
    public void roverCanMoveAfterChangingDirection() {
        kata.move("RFF");

        assertEquals(kata.getPosition(), new Position(2, 0));
    }

    @Test
    public void roverCanMoveInACircleAndEndUpBackAtGivenPosition() {
        kata.move("FFRFFRFFRFFR");

        roverStartsAtGivenPosition();
    }

    @Test
    public void roverStopsAndReportsErrorWhenItRunsIntoObstacle() {
        testObstacleKata.move("RFLFLF");

        assertEquals(testObstacleKata.getPosition(), new Position(1, 1));
    }
}
