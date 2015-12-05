import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by har14 on 05/12/15.
 */
public class MarsRoverTest {

    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    private final Reporter reporter = context.mock(Reporter.class);

    private final boolean[][] testGridArray =
            {
                    {false, true, false},
                    {false, false, false},
                    {false, false, false}
            };
    private final boolean[][] testGridArray2 =
            {
                    {false, false, false},
                    {false, false, false},
                    {false, false, false}
            };
    private final Grid testGrid2 = new Grid(testGridArray2);
    private final Grid testGrid = new Grid(testGridArray);
    private final Grid grid = new Grid();
    private final Direction givenDirection = Direction.NORTH;
    private final MarsRover testObstacleKata =
            new MarsRover(reporter, testGrid, Direction.NORTH,
                    new Position(0, 0));
    private final MarsRover testObstacleKata2 =
            new MarsRover(new PrintingReporter(), testGrid, Direction.NORTH,
                    new Position(0, 0));
    private final MarsRover testObstacleKata3 =
            new MarsRover(new PrintingReporter(), testGrid2, Direction.NORTH,
                    new Position(0, 0));
    private final MarsRover kata =
            new MarsRover(new PrintingReporter(),
                    grid, givenDirection, new Position(0, 0));

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
        context.checking(new Expectations() {{
            oneOf(reporter).report("Obstacle was found to be present at grid" +
                    " Position{x_coordinate=0, y_coordinate=1}\n");
        }});

        testObstacleKata.move("RFLFLF");

        assertEquals(testObstacleKata.getPosition(), new Position(1, 1));
    }

    @Test
    public void roverCanMoveBackwardsAfterChangingDirection() {
        testObstacleKata2.move("BLBLBLBLF");

        assertEquals(testObstacleKata2.getPosition(), new Position(0, 0));
    }

    @Test
    public void roverCanWrapAroundGridMoreThanOnce() {
        testObstacleKata3.move("FFFFFFFFRBBBBBBBBBRFFFFFFFFFRFFFFFFFFFF");
    }
}
