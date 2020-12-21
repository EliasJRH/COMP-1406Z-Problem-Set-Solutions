import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PartImage {
    private boolean[][] pixels;
    private boolean[][] visited;
    private int rows;
    private int cols;

    //Creates a new, blank PartImage with the given rows (r) and columns (c)
    public PartImage(int r, int c) {
        rows = r;
        cols = c;
        visited = new boolean[r][c];
        pixels = new boolean[r][c];
    }

    //Creates a new PartImage containing rw rows and cl columns
    //Initializes the 2D boolean pixel array based on the provided byte data
    //A 0 in the byte data is treated as false, a 1 is treated as true
    public PartImage(int rw, int cl, byte[][] data) {
        this(rw, cl);
        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                if (data[r][c] == 1)
                    pixels[r][c] = true;
                else
                    pixels[r][c] = false;
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public boolean getPixel(int r, int c) {
        return pixels[r][c];
    }

    public void print() {
        //Double for loop prints out any true cells as * and any false cells as -
        for (int rowNum = 0; rowNum < pixels.length; rowNum++){
            for (int columnNum = 0; columnNum < pixels[rowNum].length; columnNum++){
                if (pixels[rowNum][columnNum]) System.out.print("*");
                else System.out.print("-");
            }
            System.out.println();
        }
    }

    public Point2D findStart() {
        //Double for loop finds the first true cell
        for (int rowNum = 0; rowNum < pixels.length; rowNum++){
            for (int columnNum = 0; columnNum < pixels[rowNum].length; columnNum++){
                if (pixels[rowNum][columnNum]) return new Point2D(rowNum, columnNum);
            }
        }
        return null;
    }

    public int partSize() {
        int numOfParts = 0;
        //Double for loop counts all true cells
        for (int rowNum = 0; rowNum < pixels.length; rowNum++){
            for (int columnNum = 0; columnNum < pixels[rowNum].length; columnNum++){
                if (pixels[rowNum][columnNum]) numOfParts++;
            }
        }
        return numOfParts;
    }

    private void expandFrom(int r, int c) {
        //If the current cell is true, set it to false
        if (pixels[r][c]) pixels[r][c] = false;
        else return; //Otherwise, the current cell isn't in the part and the method returns
        if (r-1 >= 0) expandFrom(r - 1, c); //Checks if the cell above the current cell is valid
        if (r+1 < rows) expandFrom(r+1, c); //Checks if the cell beneath the current cell is valid
        if (c-1 >= 0) expandFrom(r, c-1); //Checks if the cell to the left of the current cell is valid
        if (c+1 < cols) expandFrom(r, c+1); //Checks if the cell to the right of the current cell is valid
        //At the end of all these statements, if the cell was valid, then it is checked
    }

    private int perimeterOf(int r, int c) {
        int perimeter = 0; //Initially sets the perimeter of the current cell to 0
        if (visited[r][c] || !pixels[r][c]) return 0; //If the cell has been visited or if the cell is false, return 0
                                                      // as it's not a part of the current part.
        if ((r-1 >= 0 && !pixels[r-1][c]) || r - 1 < 0) perimeter++;
        if ((r + 1 < rows && !pixels[r+1][c]) || r + 1 >= rows) perimeter++;
        if ((c-1 >= 0 && !pixels[r][c-1]) || c - 1 < 0) perimeter++;
        if ((c+1 < cols && !pixels[r][c+1]) || c + 1 >= cols) perimeter++;
        //When checking in any direction, a check is made to ensure that the cell is a valid cell (in the array) and that it's
        // a false cell, or if it's a cell on the edge of the grid. In any case that side of the cell is surrounded by a non-true cell
        // which increases it's perimeter by 1
        visited[r][c] = true;
        //Sets the current cell to visited
        if (r-1 >= 0) perimeter += perimeterOf(r-1, c);
        if (r+1 < rows) perimeter += perimeterOf(r+1, c);
        if (c-1 >= 0) perimeter += perimeterOf(r, c-1);
        if (c+1 < cols) perimeter += perimeterOf(r, c+1);
        //All of these ensure that the neighbouring cell (up, down, left, right) are valid, if so the perimeter of those cells are added
        //Then returned
        return perimeter;
    }

    public boolean isBroken() {
        //The piece would be considered broken if the grid contains more than one piece
        return (countPieces() != 1);
    }

    //Method for general use
    public int perimeter() {
        Point2D p = findStart();
        //finds the start point
        for (int rowNum = 0; rowNum < rows; rowNum++){
            for (int columnNum = 0; columnNum < cols; columnNum++){
                visited[rowNum][columnNum] = false;
            }
        }
        //Sets all cells in the visited array to false
        //Calls helper method with x and y coordinate of start point
        return perimeterOf(p.getX(), p.getY());
    }

    public int countPieces() {
        int pieces = 0;
        Point2D startingPoint = findStart();
        //Finds the first start point
        do{
            expandFrom(startingPoint.getX(), startingPoint.getY());
            //Expands from the starting point
            pieces++;//The piece would now be removed meaning that one more piece exists
            //Program then tries to find the next point, if it does find one then another piece does exist
            startingPoint = findStart();
        }while (startingPoint != null);
        //otherwise, exist the do while loop
        return pieces;
    }

    public static PartImage readFromFile(String fileName) throws InvalidPartImageException{
        int lineCount = 0; //stores num of rows
        int lineLength = 0; //stores num of columns
        byte[][] byteArray = null; //2d array of bytes that will be used to create the part image
        ArrayList<ArrayList<Byte>> bytes = new ArrayList<>(); //array list of arraylist of bytes to use while getting the image
        try{
            //Uses a scanner to read from the file
            File infile = new File(fileName);
            Scanner fileReader = new Scanner(infile);
            while (fileReader.hasNextLine()){  //while there are still lines in the file
                ArrayList<Byte> curLineBytesList = new ArrayList<>(); //array list that stores each item in the line as a byte to be added into the 2d grid
                String[] curLineBytesArr = fileReader.nextLine().split(","); //String array start stores each item
                if (lineCount == 0) lineLength = curLineBytesArr.length; //if this is the first line, store this current lines length as the line length
                //If any other line is not equal, than an InvalidPartImageException is thrown
                else{
                    if (curLineBytesArr.length != lineLength) throw new InvalidPartImageException(fileName);
                }
                for (int i = 0; i < curLineBytesArr.length; i++){ //For loop runs through each item in the current line
                    int curByte = Integer.parseInt(curLineBytesArr[i]); //parses the current string into an int
                    if (curByte != 0 && curByte != 1) throw new InvalidPartImageException(infile.getName()); //checks if it's a valid byte
                    //If not, throw exception
                    curLineBytesList.add((byte)curByte); //Add byte value of int to list
                }
                bytes.add(curLineBytesList); //at the end of for loop add array list of bytes to to 2d array list of bytes
                lineCount++; //increase line count
            }
            //At this point the grid is valid
            byteArray = new byte[lineCount][lineLength]; //create new array of bytes and set each value
            for (int rowNum = 0; rowNum < lineCount; rowNum++){
                for (int columnNum = 0; columnNum < lineLength; columnNum++){
                    byteArray[rowNum][columnNum] = bytes.get(rowNum).get(columnNum);
                }
            } //return new part image
            return new PartImage(lineCount, lineLength, byteArray);
        }catch (FileNotFoundException e){
            System.err.println("File: " + fileName + " was not found.");
        }
        return null;
    }

}