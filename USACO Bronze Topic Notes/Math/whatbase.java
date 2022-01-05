// package whatbase; //remove or comment this line when submitting

import java.io.*;
import java.util.*;
/*
Logic: There will always be only 3 digit sequences to find. Use the equation where the first digit of the 3 digit sequence(4) is multiplyed to x^2, the 2nd digit(1) is multiplied
to the same x and the last digit is just added to the rest of the equation(Make a method that will automatically)

*/

/*
Input:
1
419 792
*/

public class whatbase {
    private static int formula(int digit, int digit2, int digit3, int base) {
        int answer = 0;
        answer = (digit * base * base) + (digit2 * base) + digit3;
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("whatbase.in")); // Make sure to get the specific path and change back whensubmitting
        // C:/Users/darkm/Usaco/whatbase/whatbase
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("whatbase.out")));
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(r.readLine());

        char[] first = new char[3];
        char[] second = new char[3];
        int[] firstint = new int[3];
        int[] secondint = new int[3];
        int[][] answer = new int[n][2];
        int baseX = 10;
        int baseY = 10;

        // for (int i = 0; i < n; i++) {
        //     String token = st.nextToken().toString();
        //     String token2 = st.nextToken().toString();
        //     // System.out.println(token);
        //     for (int j = 0; j < 3; j++) {
        //         char temp = token.charAt(j);
        //         char temp2 = token2.charAt(j);
        //         first[j] = temp;
        //         second[j] = temp2;
        //     }
        //     if (i == n - 1) {
        //         break;
        //     } else {
        //         st = new StringTokenizer(r.readLine());
        //     }
        // }

        // System.out.println(java.util.Arrays.toString(firstint));
        // System.out.println(java.util.Arrays.toString(secondint));
        // System.out.println("crash?");

        // System.out.println(formula(firstint[0], firstint[1], firstint[2], 47));

        for (int i = 0; i < n; i++) {
            String token = st.nextToken().toString();
            String token2 = st.nextToken().toString();
            // System.out.println(token);
            for (int j = 0; j < 3; j++) {
                char temp = token.charAt(j);
                char temp2 = token2.charAt(j);
                first[j] = temp;
                second[j] = temp2;
            }
            for (int j = 0; j < 3; j++) {
                firstint[j] = Character.getNumericValue(first[j]);
                secondint[j] = Character.getNumericValue(second[j]);
            }
            while (baseX <= 15000 && baseY <= 15000) {
                if (formula(firstint[0], firstint[1], firstint[2], baseX) > formula(secondint[0], secondint[1],
                        secondint[2], baseY)) {
                    baseY++;
                } else if (formula(firstint[0], firstint[1], firstint[2], baseX) < formula(secondint[0],
                        secondint[1],
                        secondint[2], baseY)) {
                    baseX++;
                } else {
                    // System.out.println(i);
                    answer[i][0] = baseX;
                    answer[i][1] = baseY;
                    baseX = 10;
                    baseY = 10;
                    break;
                }
            }
            if (i == n - 1) {
                break;
            } else {
                st = new StringTokenizer(r.readLine());
            }
        }

        for (int i = 0; i < n; i++) {
            pw.println(answer[i][0] + " " + answer[i][1]);
            // answer[47, 35]
            // answer[36, 42, 58, 73]
        }

        // while(formula(firstint[0], firstint[1], firstint[2], baseX) ==
        // formula(firstint[0], firstint[1], firstint[2], baseY)){
        // if(formula(firstint[0], firstint[1], firstint[2], baseX) >
        // formula(firstint[0], firstint[1], firstint[2], baseY)){
        // baseY++;
        // }
        // if(formula(firstint[0], firstint[1], firstint[2], baseX) <
        // formula(firstint[0], firstint[1], firstint[2], baseY)){
        // baseX++;
        // }
        // }
        // pw.println(<Answer>); How to submit/Change to Sysout to test
        r.close();
        pw.close();
    }
}