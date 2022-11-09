import java.io.*;
import java.util.*;

public class speeding {
    // Remember to change the name above to the respective file name
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("speeding.in"));
        // Make sure to get the specific path when testing
        // Change back to the file name provided by USACO when submitting(Older versions
        // of tests)
        // Replace "new FileReader("Template.in")" to "new InputStreamReader(System.in)"
        // when submitting (New version of tests using Stdin)
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("speeding.out")));
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken()); // Changes the next token into an Integer. Use "st.nextToken()" by
                                                  // itself to pull a string
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(r.readLine()); // Reads the next line
        int[][] road = new int[n][2];
        int[][] bessie = new int[m][2];

        for (int i = 0; i < n; i++) {
            int length = Integer.parseInt(st.nextToken());
            int limit = Integer.parseInt(st.nextToken());
            road[i][0] = length;
            road[i][1] = limit;
            st = new StringTokenizer(r.readLine());
        }
        for (int i = 0; i < m; i++) {
            int length = Integer.parseInt(st.nextToken());
            int limit = Integer.parseInt(st.nextToken());
            bessie[i][0] = length;
            bessie[i][1] = limit;
            // System.out.println(length + " "+ limit);
            if(i == m-1){
                break;
            }
            else{
                st = new StringTokenizer(r.readLine());

            }
            // st = new StringTokenizer(r.readLine());

            
        }
        int maxSpeedLimitOver = 0;
        int bessDistance = bessie[0][0];
        int roadDistance = road[0][0];
        // System.out.println(Arrays.deepToString(road));
        // System.out.println(Arrays.deepToString(bessie));


        int a = 0;
        int b = 0;
        while(a <= n && b <= m){
            // System.out.println("A to N: " + a + " " + n + " B to M " + b + " " + m);
            if(roadDistance == bessDistance){
                if(bessie[b][1] > road[a][1]){
                    maxSpeedLimitOver = Integer.max(maxSpeedLimitOver, bessie[b][1] - road[a][1]);
                    // System.out.println( bessie[b][1] - road[a][1]);
                }
                a += 1;
                b += 1;
                // System.out.println("If 1 worked: " + maxSpeedLimitOver + " This is a: " + a + " This is b: " + b);
                if(bessDistance == 100 && roadDistance == 100){
                    break;
                }
                else{
                    bessDistance += bessie[b][0];
                    roadDistance += road[a][0];
                }
            }
            else if(roadDistance < bessDistance){
                if(bessie[b][1] > road[a][1]){
                    maxSpeedLimitOver = Integer.max(maxSpeedLimitOver, bessie[b][1] - road[a][1]);
                }
                a += 1;
                // System.out.println("this is a: " + a);
                // System.out.println("If 2 worked: " + maxSpeedLimitOver + " This is a: " + a + " This is b: " + b);
                roadDistance += road[a][0];
                // System.out.println(bessie[b][1] - road[a][1]);



            }
            else{
                if(bessie[b][1] > road[a][1]){
                    maxSpeedLimitOver = Integer.max(maxSpeedLimitOver, bessie[b][1] - road[a][1]);
                }
                // System.out.println(bessie[b][1] - road[a][1]);
                b += 1;
                // System.out.println(b);
                bessDistance += bessie[b][0];
                // System.out.println("If 3 worked: " + maxSpeedLimitOver + " This is a: " + a + " This is b: " + b);

            }
        }
        pw.println(maxSpeedLimitOver);

        // pw.println(<Answer>); How to submit/Change to Sysout to test
        r.close();
        pw.close();
    }
}

/*
 * 
 * Make a while loop(ends when road has no more values to compare)
 * int a = 0
 * int b = 0
 * a --> n
 * b --> m
 * 
 * 40 75
 * 50 35
 * 10 45
 * 
 * 40 76
 * 20 30
 * 40 40
 * 
 * int maxSpeedLimitOver = 0;
 * 
 * int roadDistance (40) a = 0
 * int bessieDistnace (40) b = 0
 * 
 * a = 1, b = 1
 * roadDistance 90
 * bessDistance = 60
 * 
 * 40 20 30 10 --> 60 --> 90
 * 76 35 45 80 35
 * 40 10 30 20 --> 50 --> 80
 * 76 30 40 80 30
 * 5
 * 
 * if(roadDistance == bessDistance){ 40 | 40 --> 90(road) | 60(bessie)
 * if(bessie[b][1] > road[a][1]){
 * maxSpeedLimitOver = Integer.max(maxSpeedLimitOver, bessie[b][1] -
 * road[a][1]); //max = 1
 * }
 * 
 * a += 1;
 * b += 1;
 * roadDistance += road[a][0];
 * bessDistance += bessie[b][0];
 * }
 * 
 * else if(roadDistance < bessDistance){
 * a += 1;
 * roadDistance += road[a][0];
 * }
 * 
 * else { //roadDis > bessDista
 * if(bessie[b][1] > road[a][1]){
 * maxSpeedLimitOver = Integer.max(maxSpeedLimitOver, bessie[b][1] -
 * road[a][1]);
 * 
 * }
 * b += 1;
 * bessDistance += bessie[b][0];
 * 
 * 
 * }
 * 
 * 
 * while( a <= n && b <= m){
 * 
 * }
 * 
 * 
 * 
 * 
 * /
 * 
 * /*
 * System.out.println(n +" "+m);
 * for(int i = 0; i < 3; i++){
 * int length = Integer.parseInt(st.nextToken());
 * int speedlimit = Integer.parseInt(st.nextToken());
 * int temp;
 * int cycle = 0;
 * for(int j = cycle; j < m; j++){
 * if(length )
 * }
 * }
 */