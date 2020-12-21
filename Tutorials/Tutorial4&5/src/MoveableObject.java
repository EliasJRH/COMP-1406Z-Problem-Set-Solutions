public abstract class MoveableObject extends GameObject{

    protected int direction;
    protected int speed;

    public MoveableObject(int d, int s, Point2D initPoint) {
        super(initPoint);
        direction = d;
        speed = s;
    }

    public int getDirection() { return direction; }
    public int getSpeed() { return speed; }

    public void setDirection(int newDirection) { direction = newDirection; }
    public void setSpeed(int newSpeed) { speed = newSpeed; }

    public void update() {
        moveForward();
    }

    public void moveForward() {
        if (speed > 0) {
            location = location.add((int) (Math.cos(Math.toRadians(direction)) * speed),(int) (Math.sin(Math.toRadians(direction)) * speed));
        }
    }

    public String toString(){
        return this.getClass().getName() + " at " + this.getLocation() + " facing " + this.getDirection() + " degress going " + this.getSpeed() + " pixels per second ";
    }

}
