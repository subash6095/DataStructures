package problemSolving.array;

import java.util.*;

/*
 Find largest number possible from set of given numbers.
 The numbers should be appended to each other in any order to form the largest number.

 For example,
 Input :  { 10, 68, 75, 7, 21, 12 }
 Output :  77568211210
 */
public class LargestNumberPossible {
    public static void main(String[] args) {
        List<String> numbers = Arrays.asList("10", "68", "97", "9", "21", "12");

        // sort using a custom function object
        Collections.sort(numbers, (a, b) -> (b + a).compareTo(a + b));

        // print the sorted sequence
        numbers.stream().forEach(System.out::print);
    }
}

