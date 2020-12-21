public class Ball extends MoveableObject implements Harmful{
    private boolean isBeingHeld;

    public Ball(Point2D loc) {
        super(0,0,loc);
        isBeingHeld = false;
    }

    // The get/set methods
    public boolean isBeingHeld() { return isBeingHeld; }
    public void setIsBeingHeld(boolean newHoldStatus) { isBeingHeld = newHoldStatus; }

    public String toString() {
        return "Ball" + " at (" + (int)location.getX() + "," + (int)location.getY() + ") facing " + direction +
                " degrees going " + speed + " pixels per second";
    }

    public void update(){
        moveForward();
        speed--;
    }

    @Override
    public char appearance() {
        return 'o';
    }

    public int getDamageAmount() {
        return -200;
    }
}