/*
This is the "model" part of the project. This class does not extend any component related to JavaFX, it just stores
the information that the other classes will be using.

For example: this "model" class stores the array of DVDs that is displayed in the view class using a ListView.

Whenever we want to change anything about any of the data in the project, a call to this "model" class is made, whether
that be adding or removing a DVD or getting the number of DVDs.
 */

public class DVDCollection {
    public static final int MAX_DVDS = 100;

    private DVD[] dvds;
    private int dvdCount;

    public DVDCollection() { dvds = new DVD[MAX_DVDS]; }

    public DVD[] getDvds() { return dvds; }

    public DVD[] getDVDList() {
        DVD[] list = new DVD[dvdCount];
        for (int i=0; i<dvdCount; i++)
            list[i] = dvds[i];

        return list;
    }

    public int getDvdCount() { return dvdCount; }
    public String toString() { return ("DVD Collection of size " + dvdCount); }

    public void add(DVD aDvd) {
        if (dvdCount < MAX_DVDS)
            dvds[dvdCount++] = aDvd;
    }
    public boolean remove(String title) {
        for (int i=0; i<dvdCount; i++) {
            DVD d = dvds[i];
            if (dvds[i].getTitle().equals(title)) {
                dvds[i] = dvds[dvdCount-1];
                dvdCount--;
                return true;
            }
        }
        return false;
    }

    public static DVDCollection example1() {
        DVDCollection c = new DVDCollection();
        c.add(new DVD("If I Was a Student", 2007, 65));
        c.add(new DVD("Don't Eat Your Pencil !", 1984, 112));
        c.add(new DVD("The Exam", 2001, 180));
        c.add(new DVD("Tutorial Thoughts", 2003, 128));
        c.add(new DVD("Fried Monitors", 1999, 94));
        return c;
    }
}