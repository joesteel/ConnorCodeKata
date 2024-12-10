package com.connor.leeteasy;

public class LongestUncommonSubsequence {
    public static int findLUSlength(String a, String b) {
        String largest = a.length() > b.length() ? a : b;
        String smallest = a.length() <= b.length() ? a : b;

        if(a.length() != b.length()) return largest.length();
        if(a.equals(b)) return -1;

        // ok the lengths are the same but the strings are not the same...
        // I think we iterate until we find the first uncommon character...
        // aaac aaab
        // accc aabb
        // aaca aaba
        // aren't all of these uncommon? can the answer be anything other than the length of the string??

        return a.length();
    }
}
