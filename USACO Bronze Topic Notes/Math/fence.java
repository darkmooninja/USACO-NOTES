// package Fence;
import java.io.*;
import java.util.StringTokenizer;

public class fence {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("fence.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("fence.out")));
        StringTokenizer st = new StringTokenizer(r.readLine());

		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(r.readLine());
        
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
        //Time Complexity 1
		int max = Math.max(a, c); // Maximum between the starting points
        int min = Math.min(b, d); // Minimum of the ending points
        int fences = (d-c) + (b-a); //Amount of fence painted
        // System.out.println(fence);
        // System.out.println(fence - Math.max(min - max, 0));
        // else if ()
		/*
		 * Make sure to include the line below, as it
		 * flushes and closes the output stream.
		 */
        System.out.println(fences - Math.max(min - max, 0)); // Subtract the total area by the fences that are painted over. If there are fences painted over
		// then there will be a positive integer greater than 0 subtracting the total amount of fences painted by the amount of fences painted over. If there is 
		// no paint overlapping, the outcome would be 0 or under 0 keeping the total the same
		r.close();
        pw.close();
	}
}