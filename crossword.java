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
package Crossword;
import java.io.*;
import java.util.*;

public class crossword {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("/Users/terrybang/Java/Crossword/crossword.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("crossword.out")));
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(r.readLine());

        String [][] twoDArray = new String[n][m]; // n represents rows, m represents columns

        System.out.print(n);
        System.out.print(" ");
        System.out.print(m);
        System.out.println();
        
        //reading and printing the crossword
        for(int i = 0; i < n;i++){
            String temp = st.nextToken().toString(); //st.nexttoken() reads the next token or goes to the next space, .toString() after the nextoken converts the token grabbed into a string
            System.out.println(temp);
            if(i == n-1){// prevents the new StringTokenizer from reading another line when all is read.(prevents a java.lang.NullPointerException)
                break;
            }
            st = new StringTokenizer(r.readLine());
        }







        r.close();
        pw.close();
    }
}
