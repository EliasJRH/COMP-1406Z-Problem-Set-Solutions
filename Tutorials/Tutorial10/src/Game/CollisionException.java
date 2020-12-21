package Game;

public class CollisionException extends Exception {

    MovableObject source;

    public CollisionException(MovableObject s) {
        super(s + " collided with a wall!");
        source = s;
    }

}
