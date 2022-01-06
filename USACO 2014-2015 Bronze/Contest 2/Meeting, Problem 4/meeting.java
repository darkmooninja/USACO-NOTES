//package Meeting; //remove or comment this line when submitting
import java.io.*;
import java.util.*;

public class meeting {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("meeting.in")); // Make sure to get the specific path and
                                                                             // change back when submitting
        // C:/Users/darkm/Usaco/Meeting/meeting.in
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("meeting.out")));
        StringTokenizer st = new StringTokenizer(r.readLine());
        int end = Integer.parseInt(st.nextToken());
        int paths = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(r.readLine());

        HashMap<Integer, HashSet<Integer>> bessie = new HashMap<Integer, HashSet<Integer>>();
        HashMap<Integer, HashSet<Integer>> elsie = new HashMap<Integer, HashSet<Integer>>();
        HashSet<Integer> hs = new HashSet<Integer>();
        hs.add(0);
        bessie.put(1, hs);
        elsie.put(1, hs);

        Map<Integer, ArrayList<int[]>> input = new TreeMap<Integer, ArrayList<int[]>>();

        for (int i = 0; i < paths; i++) {
            int tempStart = Integer.parseInt(st.nextToken());
            int tempEnd = Integer.parseInt(st.nextToken());
            int bessieTime = Integer.parseInt(st.nextToken());
            int elsieTime = Integer.parseInt(st.nextToken());
            int[] arr = new int[] { tempEnd, bessieTime, elsieTime };
            if (!input.containsKey(tempStart)) {
                input.put(tempStart, new ArrayList<>());
            }
            input.get(tempStart).add(arr);

            if (i == paths - 1)
                break;
            st = new StringTokenizer(r.readLine());
        }

        for (int i : input.keySet()) {
            int tempStart = i;
            int listSize = input.get(i).size();
            for (int k = 0; k < listSize; k++) {
                int tempEnd = input.get(i).get(k)[0];
                int bessieTime = input.get(i).get(k)[1];
                int elsieTime = input.get(i).get(k)[2];
                if (bessie.containsKey(tempStart)) {
                    if (!bessie.containsKey(tempEnd)) {
                        HashSet<Integer> tempHS = new HashSet<Integer>();
                        for (int s : bessie.get(tempStart)) {
                            tempHS.add(s + bessieTime);
                        }
                        bessie.put(tempEnd, tempHS);
                    } else {
                        for (int s : bessie.get(tempStart)) {
                            bessie.get(tempEnd).add(s + bessieTime);
                        }
                    }
                }

                if (elsie.containsKey(tempStart)) {
                    if (!elsie.containsKey(tempEnd)) {
                        HashSet<Integer> tempHS = new HashSet<Integer>();
                        for (int s : elsie.get(tempStart)) {
                            tempHS.add(s + elsieTime);
                        }
                        elsie.put(tempEnd, tempHS);

                    } else {
                        for (int s : elsie.get(tempStart)) {
                            elsie.get(tempEnd).add(s + elsieTime);
                        }
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        // System.out.println(end);
        for (int e : elsie.get(end)) {
            // System.out.println(e);
        }
        for (int endPt : bessie.get(end)) {
            if (elsie.get(end).contains(endPt)) {
                min = Math.min(min, endPt);
            }
        }

        if (min == Integer.MAX_VALUE)
            pw.println("IMPOSSIBLE");
        else
            pw.println(min);
        // pw.println(<Answer>); How to submit/Change to Sysout to test
        r.close();
        pw.close();
    }
}