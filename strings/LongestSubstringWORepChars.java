package Strings;

import java.util.*;

public class LongestSubstringWORepChars {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0, j = 0;j<s.length();j++){
            if(map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);//update i to set start of next string as the next letter after the previously encountered letter

            }
            max = Math.max(max, j-i+1);
            map.put(s.charAt(j), j+1);
        }
        return max;
    }
    public int lengthOfLongestSubstringOPTIMAL(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
    public static void main(String[] args){
        LongestSubstringWORepChars obj = new LongestSubstringWORepChars();
        System.out.println(obj.lengthOfLongestSubstring("pwkkkeyestringxqi"));
    }
}
