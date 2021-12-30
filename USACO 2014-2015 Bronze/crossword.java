/*
Input:
First token in line 1 represents rows, Second token represents columns

The next N lines of input each describe a row of the grid.  Each
contains M characters, which are either '.' (a clear cell) or '#' (a
blocked cell).

5 3
...
#..
...
..#
.##

*/

/*
123
#..
4..
..#
.##

//Time Complexity
we have to at least look at 3 x 5 = 15 times, or n x m O(nm) times

//Constraints
-Horizontal: Left part of the clue has to be either a blocked cell or not possible, there has to be at least 2 clear cells to the right of the clue.
-Vertical: The cell above the vertical clue has to be blocked or not possible, there has to be at least 2 clear cells downwards of the clue.

1
Initator of the horizontal clue

2
Initiator of the vertical

3
Initiator of the vertical

4

How to start a problem checklist:
- understand problem
- What are the inputs/outputs


*/
//package crossword;

import java.io.*;
import java.util.*;

public class crosswords {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("crosswords.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("crosswords.out")));
        StringTokenizer st = new StringTokenizer(r.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(r.readLine());

        char[][] twoDArray = new char[row][col]; // n represents rows, m represents columns

        // reading and printing the crossword

        // Put everything in a 2d array storage
        // itertes the row

        for (int i = 0; i < row; i++) {
            String tokensEachRow = st.nextToken().toString(); // st.nexttoken() reads the next token or goes to the next
                                                              // space, .toString() after the nextoken converts the
                                                              // token grabbed into a string

            // iterate the col
            for (int j = 0; j < col; j++) {
                // go over the ...'s'
                char token = tokensEachRow.charAt(j); //changed to Char because Char is a primitive data structure while String is an object data structure

                twoDArray[i][j] = token;
            }

            if (i == row - 1) {// prevents the new StringTokenizer from reading another line when all is
                               // read.(prevents a java.lang.NullPointerException)
                break;
            }
            st = new StringTokenizer(r.readLine());
        }

        // Holds the coordinates of each clue
        ArrayList<String> coordinates = new ArrayList<String>();

        // Iterate every index in twoDArray
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // Check if the index is a "." or "#"


                if (twoDArray[i][j] == '.') { // ==
                    // check if this index or clue can be horizontal word
                    if (j == 0) {
                        if(j < col - 2){ 
                            // check if there are 2 "." after
                            if (twoDArray[i][j + 1] == '.' && twoDArray[i][j + 2] == '.') {
                                coordinates.add((i+1) + " " + (j+1));
                                continue;
                            }
                        }
                    }

                    else if (twoDArray[i][j - 1] == '#') {
                        if(j < col - 2){
                            if (twoDArray[i][j + 1] == '.' && twoDArray[i][j + 2] == '.') {
                                coordinates.add((i+1) + " " + (j+1));
                                continue;
                            }
                        }
                    }
                       

                    // check if this index or clue can be a vertical word
                    if (i == 0) {
                        if(i < row - 2){
                            if (twoDArray[i + 1][j] == '.' && twoDArray[i + 2][j] == '.') {
                                coordinates.add((i+1) + " " + (j+1));
                                continue;
                            }
                        } 
                    }else if (twoDArray[i - 1][j] == '#') {
                        if(i < row - 2){
                            if (twoDArray[i + 1][j] == '.' && twoDArray[i + 2][j] == '.') {
                                coordinates.add((i+1) + " " + (j+1));
                                continue;
                            }
                        }
                    }


                } else {
                    continue;
                }

            }
        }

        // returning
        
        pw.println(coordinates.size());
        for (int i = 0; i < coordinates.size(); i++) {
            pw.println(coordinates.get(i));
        }

        r.close();
        pw.close();
    }
}