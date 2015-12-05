/**
 * Created by har14 on 05/12/15.
 */
public class ObstaclePresentException extends RuntimeException {

    private String message;
    private Position position;

    public ObstaclePresentException(Position position) {
        this.message = "";
        this.position = position;
    }

    public ObstaclePresentException(String message, Position position) {
        super(message);
        this.position = position;
    }

    public ObstaclePresentException(String message, Throwable cause,
                                    Position position) {
        super(message, cause);
        this.position = position;
    }

    public ObstaclePresentException(String message, Throwable cause,
                                    boolean enableSuppression,
                                    boolean writableStackTrace,
                                    Position position) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.position = position;
    }

    @Override
    public String getMessage() {
        return "Obstacle was found to be present at grid " +
                position.toString() + "\n" + message;
    }
}
