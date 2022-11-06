import java.io.*;
import java.util.*;

public class Template {
        //Remember to change the name above to the respective file name
public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("Template.in"));
        //Make sure to get the specific path when testing
        //Change back to the file name provided by USACO when submitting(Older versions of tests)
        //Replace "new FileReader("Template.in")" to "new InputStreamReader(System.in)" when submitting (New version of tests using Stdin)
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("Template.out")));
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken()); //Changes the next token into an Integer. Use "st.nextToken()" by itself to pull a string
        st = new StringTokenizer(r.readLine()); //Reads the next line

	    	
//      pw.println(<Answer>);    How to submit/Change to Sysout to test
        r.close();
        pw.close();
    }
}