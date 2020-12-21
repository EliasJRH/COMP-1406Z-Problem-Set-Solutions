public class Prize extends StationaryObject{
    private int value;

    public Prize(Point2D loc, int val) {
        super(loc);
        location = loc;
        value = val;
    }

    // The get/set methods
    public int getValue() { return value; }

    @Override
    public char appearance() {
        return '$';
    }

}