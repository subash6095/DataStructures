package problemSolving.array;

import java.util.HashMap;
import java.util.Map;

class MajorityElement
{
    // Function to return majority element present in given array
    public static int majorityElement(int[] A)
    {
        // create an empty Hash Map
        Map<Integer, Integer> map = new HashMap<>();

        // store each element's frequency in a map
        for (int i: A)
        {
            map.putIfAbsent(i, 0);
            map.put(i, map.get(i) + 1);
        }

        // return the element if its count is more than n/2
        for (Map.Entry<Integer,Integer> entry: map.entrySet())
        {
            if (entry.getValue() > A.length/2) {
                return entry.getKey();
            }
        }

        // no majority element is present
        return -1;
    }

    public static void main (String[] args)
    {
        // Assumption - valid input (majority element is present)
        int arr[] = { 1, 8, 7, 4, 1, 2, 2, 2, 2, 2, 2 };

        int res = majorityElement(arr);
        if (res != -1) {
            System.out.println("Majority element is " + res);
        } else {
            System.out.println("Majority element does not exist");
        }
    }
}