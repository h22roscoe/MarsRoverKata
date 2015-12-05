import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by har14 on 05/12/15.
 */
public class MarsRoverTest {

    private final Position givenPosition = new Position(0, 0);
    private final Direction givenDirection = Direction.NORTH;
    private final MarsRover kata =
            new MarsRover(givenDirection, givenPosition);

    @Test
    public void roverStartsAtGivenPosition() {
        assertEquals(kata.getPosition(), givenPosition);
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

        assertNotEquals(kata.getPosition(), givenPosition);
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

        assertEquals(kata.getPosition(), new Position(0, 99));
    }
}
