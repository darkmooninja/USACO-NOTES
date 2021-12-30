package Template; //remove or comment this line when submitting
import java.io.*;
import java.util.*;

public class Template {
public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("Template.in")); //Make sure to get the specific path and change back when submitting
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("Template.out")));
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(r.readLine());

	    	
//      pw.println(<Answer>);    How to submit/Change to Sysout to test
        r.close();
        pw.close();
    }
}
