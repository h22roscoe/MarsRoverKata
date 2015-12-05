import java.util.LinkedList;
import java.util.List;

/**
 * Created by har14 on 05/12/15.
 */
public class MarsRover {
    Position position;
    Direction direction;

    public MarsRover(Direction direction, Position position) {
        this.direction = direction;
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    public void move(String instructions) {
        List<Instruction> instructionList = new LinkedList<>();

        for (char instr : instructions.toCharArray()) {
            if (Instruction.validLabel(instr)) {
                instructionList.add(makeInstruction(instr));
            }
        }

        for (Instruction instr : instructionList) {
            this.direction = instr.apply(direction, position);
        }
    }

    private Instruction makeInstruction(char instr) {
        switch (instr) {
            case 'F':
                return Instruction.FORWARDS;
            case 'B':
                return Instruction.BACKWARDS;
            case 'L':
                return Instruction.LEFT;
            case 'R':
                return Instruction.RIGHT;
            default:
                throw new IllegalArgumentException();
        }
    }
}
