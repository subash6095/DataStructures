package misc;

import java.util.HashMap;
import java.util.Map;

public class DeleteSubstring {
    public static int findCount(String s, String t) {

        if( null == s || "" == s || null == t || "" == t)
            return 0;
        int count =0;
        while(true){
            if(s.contains(t)) {
                count++;
                int i = s.indexOf(t);
                s = s.substring(0, i) + s.substring(i + t.length(), s.length());
                // s = s.replace(t,"");
            }
            else
                break;
        }

        return count;
    }

    public static int removeSubstring(String s, String t) {
        return dfs(s, t, 0);
    }

    private static int dfs(String s, String t, int count) {
        if (!s.contains(t)) {
            return count;
        }

        int maxCount = 0, n=t.length();
        for(int i=0; i<s.length(); i++){
            if(s.substring(i).contains(t)){
                maxCount = Math.max(maxCount, dfs(s.substring(0, i)+s.substring(i+n), t, count+1));
            }
        }
        return maxCount;
    }

    static int  length (String s, String t){
        int i= s.indexOf(t);
        if(i!= -1)
            return length(s.substring(0, i)+ s.substring(i+t.length(), s.length()), t)+1;
        else
            return 0;
    }
    static int deleteSubStrings(String s, String t, Map<String, Integer> dp) {
        if (dp.containsKey(s))
            return dp.get(s);
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.startsWith(t, i)) {
                System.out.println("i = " + i);
                ret = Math.max(ret,
                        1 + deleteSubStrings(s.substring(0, i) + s.substring(i + t.length()), t, dp));
            }
        }
        dp.put(s, ret);
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(deleteSubStrings("\n" +
                "jdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjrojfmhchguchojdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjrojfmhchguchojdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjrojfmhchguchojdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjrojfmhchguchojdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjrojfmhchguchojdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjrojfmhchguchojdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjrojfmhchguchojdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjrojfmhchguchojdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjrojfmhchguchojdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjrojfmhchguchojdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjrojfmhchguchojdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjrojfmhchguchojdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjrojfmhchguchojdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjrojfmhchguchojdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjrojfmhchguchojdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjrojfmhchguchojdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjrojfmhchguchojdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjrojfmhchguchojdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjrojfmhchguchojdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjrojfmhchguchojdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjrojfmhchguchojdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjrojfmhchguchojdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjrojfmhchguchojdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjrojfmhchguchojdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjrojfmhchguchojdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjrojfmhchguchojdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjrojfmhchguchojdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjrojfmhchguchojdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjrojfmhchguchojdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjrojfmhchguchojdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjrojfmhchguchojdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjrojfmhchguchojdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjjdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjjdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjjdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjjdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjjdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjjdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjjdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjjdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjjdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjjdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjjdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjjdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjjdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjjdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjjdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjjdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjjdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjjdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjjdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjjdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjjdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjjdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjjdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjjdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjjdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjjdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjjdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjjdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjjdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjjdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjjdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrj", "jdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrjrojfmhchguchojdpvyfaxzirgntugomhdwtxxditlgazvxbdyjwnlrj", new HashMap<String, Integer>()));
        //System.out.println(deleteSubStrings("aabcbdc", "abc", new HashMap<String, Integer>()));

        //System.out.println(deleteSubStrings("bcbbc", "b", new HashMap<String, Integer>()));
        //System.out.println(deleteSubStrings("aabb", "ab", new HashMap<String, Integer>()));

    }

    /*public static void main(String[] args) {
        System.out.println("Output : " + findCount("bcbbc","b"));
        System.out.println("Output : " + findCount("aabb","ab"));

        System.out.println("Output : " + lengt("bcbbc","b"));
        System.out.println("Output : " + lengt("aabb","ab"));
    }*/
}
