public class Trap extends StationaryObject implements Harmful{

    public Trap(Point2D loc) { super(loc); }

    @Override
    public char appearance() {
        return '@';
    }


    @Override
    public int getDamageAmount() {
        return -25;
    }
}