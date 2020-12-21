public class DVD implements Comparable {
    private String title;
    private int year;
    private int duration;
    public static final int SORT_BY_TITLE = 0;
    public static final int SORT_BY_YEAR = 1;
    public static final int SORT_BY_LENGTH= 2;
    public static int sortStrategy = SORT_BY_TITLE;

    public DVD () { this ("",0,0); }
    public DVD (String newTitle, int y, int minutes) {
        title = newTitle;
        year = y;
        duration = minutes;
    }

    public int compareTo(Object obj) {
        if (obj instanceof  DVD){
            DVD aDVD = (DVD)obj;
            if (sortStrategy == SORT_BY_TITLE) {
                return title.compareTo(aDVD.title);
            }else if (sortStrategy == SORT_BY_YEAR){
                if (year < aDVD.getYear()){
                    return -1;
                }else if (year == aDVD.getYear()){
                    return 0;
                }else{
                    return 1;
                }
            }else {
               if (duration < aDVD.getDuration()){
                   return -1;
               }else if (duration == aDVD.getDuration()){
                   return 0;
               }else{
                   return 1;
               }
            }
        }

        return 0;
    }

    public String getTitle() { return title; }
    public int getDuration() { return duration; }
    public int getYear() { return year; }
    public void setTitle(String t) { title = t; }
    public void setDuration(int d) { duration = d; }
    public void setYear(int y) { year = y; }

    public String toString() {
        return ("DVD (" + year + "): \"" + title + "\" with length: " + duration + " minutes");
    }
}