package leetcode.arrays;

import java.util.TreeMap;

public class DivideArray1296 {
    public static void main(String[] args) {
        int[] nums = {3,2,1,1,2,3,4,3,4,5,9,10,11,12,13};
        int k = 3;
        isPossibleDivide(nums, k);
    }

    public static boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length % k != 0) return false;
        TreeMap<Integer,Integer> map = new TreeMap<>();

        for(int x: nums)
            map.put(x,map.getOrDefault(x,0)+1);
        System.out.println("Map : " + map.toString());

        for(int key: map.keySet()){
            int freq = map.get(key);
            System.out.println("key : " + key + " freq : " + freq);

            if(freq == 0) continue;

            for(int i = key; i < k + key; i++){
                if(!map.containsKey(i) || map.get(i) <= 0)
                    return false;
                map.put(i,map.get(i) - freq);
            }
            System.out.println("Map : " + map.toString());
        }

        return true;
    }
}
