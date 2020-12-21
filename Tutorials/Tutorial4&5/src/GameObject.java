public abstract class GameObject {

    protected Point2D location;

    public GameObject(Point2D initPoint){
        location = initPoint;
    }

    protected Point2D getLocation(){ return location; };
    protected void setLocation(Point2D newLocation) { location = newLocation; }

    public abstract void update();
    public abstract char appearance();

    public String toString(){
        return this.getClass().getName() + " at " + this.getLocation();
    }

}
