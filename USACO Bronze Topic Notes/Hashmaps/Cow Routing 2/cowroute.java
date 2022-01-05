
// package Cowroute; //remove or comment this line when submitting
import java.io.*;
import java.util.*;
/*
Input: First 2 values show the 2 cities, the next value shows how many routes there are,
    The next 2 lines show(1st line) the amount needed to pay(1st token) and then how many routes there are(2nd token)

Logic: You can only use ONE route, and you have to see if the starting point(a) is in that route and so is the ending point(b). N is the amount of routes there are
    If there is both the starting point and the ending point in a route, see how much it costs for that one route. Then put it in an integer.
*/

/* input:
1 2 3
3 3
3 2 1
4 4
2 1 4 3
8 5
4 1 7 8 2

*/
public class cowroute {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("cowroute.in")); // Make sure to get the specific path and
                                                                              // change back when submitting
                                                                              // C:/Users/darkm/Usaco/Cowroute/
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowroute.out")));
        StringTokenizer st = new StringTokenizer(r.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int planes = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(r.readLine());
        // System.out.println(start + " " + end + " " + planes);
        int min = Integer.MAX_VALUE;
        int[] ar = new int[501];
        boolean minfound = false;
        HashMap<Integer, Integer> startToN = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> endToN = new HashMap<Integer, Integer>();

        for (int i = 0; i < planes; i++) {

            int tempMoney = 0; // 3
            int tempRoutes = 0; // 3
            tempMoney = Integer.parseInt(st.nextToken());
            tempRoutes = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(r.readLine());
            // System.out.println(i);
            int afterEndPtr = -1;
            int beforeStartPtr = -1;
            for (int j = 0; j < tempRoutes; j++) {
                ar[j] = Integer.parseInt(st.nextToken());
                if (ar[j] == end) {
                    afterEndPtr = j;
                }
                if (ar[j] == start) {
                    beforeStartPtr = j;
                }
            }
            // System.out.println(java.util.Arrays.toString(ar));

            // end to N
            if (afterEndPtr != -1) {
                for (int k = afterEndPtr - 1; k >= 0; k--) {
                    // check HashMap
                    if (!endToN.containsKey(ar[k])) {
                        endToN.put(ar[k], tempMoney);
                    } else {
                        endToN.put(ar[k], Math.min(tempMoney, endToN.get(ar[k])));
                    }

                }
            }

            // N to Start
            if (beforeStartPtr != -1) {
                for (int y = beforeStartPtr + 1; y < tempRoutes; y++) {
                    if (!startToN.containsKey(ar[y])) {
                        startToN.put(ar[y], tempMoney);
                    } else {
                        startToN.put(ar[y], Math.min(tempMoney, startToN.get(ar[y])));
                    }
                }
            }

            // System.out.println(startToN);

            if (i == planes - 1) {
                break;
            }
            st = new StringTokenizer(r.readLine());
        }
        for (Map.Entry<Integer, Integer> entry : startToN.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (endToN.containsKey(key)) {
                min = Math.min(min, endToN.get(key) + value);
                minfound = true;
            }

            // System.out.println(key);
            // System.out.println(key + " " + value);
        }
        //Checks if using only one route is the best way to save money
        if (endToN.containsKey(start) && startToN.containsKey(end)) {
            min = Math.min(min, startToN.get(end));
            minfound = true;
        }
        if (minfound == false) {
            pw.println(-1);
        } else {
            pw.println(min);
        }

        r.close();
        pw.close();
    }
}