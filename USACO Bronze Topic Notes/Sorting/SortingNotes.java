import java.io.*;
import java.util.*;

public class SortingNotes {
    public static void main(String []args){
        /*Arrays.sort(ar);*/
        //Sorting Integer Array ordering from lowest to highest
        int[] intArray = {5,4,2,3,1};
        System.out.println(Arrays.toString(intArray));

        Arrays.sort(intArray);

        System.out.println(Arrays.toString(intArray));

        //Sorting String Array ordering in alphabetical order
        String[] StringArray = {"d","b","b","c","a"};

        Arrays.sort(StringArray);

        System.out.println(Arrays.toString(StringArray));

        //Collections.sort(list) - for dynamic arrays
        //Sorting Integer ArrayList ordering from lowest to highest
        ArrayList<Integer> IntArrayList = new ArrayList<Integer>();
		IntArrayList.add(5); 
        IntArrayList.add(4); 
        IntArrayList.add(2); 
        IntArrayList.add(3);
        IntArrayList.add(1);

		Collections.sort(IntArrayList);

        System.out.println(IntArrayList);
        
        //Sorting String ArrayList ordering in alphabetical order
        ArrayList<String> StrArrayList = new ArrayList<String>();
        StrArrayList.add("d");
        StrArrayList.add("b");
        StrArrayList.add("b");
        StrArrayList.add("c");
        StrArrayList.add("a");

		Collections.sort(StrArrayList);

        System.out.println(StrArrayList);




    }
}